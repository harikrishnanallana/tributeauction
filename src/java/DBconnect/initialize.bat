@echo off

REM Lấy tham số username và password từ command line
SET username=%1
SET password=%2

REM Kiểm tra tồn tại của cơ sở dữ liệu
sqlcmd -S localhost -d master -U %username% -P %password% -Q "IF DB_ID('AuctionDB') IS NOT NULL (EXIT /B 1) ELSE (EXIT /B 0)"

IF %ERRORLEVEL% EQU 0 (
    REM Xóa cơ sở dữ liệu nếu đã tồn tại
    sqlcmd -S localhost -d master -U %username% -P %password% -Q "ALTER DATABASE AuctionDB SET SINGLE_USER WITH ROLLBACK IMMEDIATE; DROP DATABASE AuctionDB;"
)

REM Tạo cơ sở dữ liệu
sqlcmd -S localhost -d master -U %username% -P %password% -Q "CREATE DATABASE AuctionDB;"

REM Chạy tệp SQL để tạo bảng và dữ liệu
sqlcmd -S localhost -d AuctionDB -U %username% -P %password% -i "%~dp0\database.sql"
