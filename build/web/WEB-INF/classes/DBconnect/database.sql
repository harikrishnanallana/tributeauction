USE master;
GO

-- Kill active sessions using AuctionDB database
DECLARE @kill_sessions VARCHAR(MAX) = '';

SELECT @kill_sessions = @kill_sessions + 'KILL ' + CAST(session_id AS VARCHAR) + ';' 
FROM sys.dm_exec_sessions
WHERE DB_Name(database_id) = 'AuctionDB';

EXEC(@kill_sessions);
GO

-- Drop the database if it already exists
IF DB_ID('AuctionDB') IS NOT NULL
BEGIN
    ALTER DATABASE AuctionDB SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE AuctionDB;
END
GO

-- Create the database
CREATE DATABASE AuctionDB;
GO

-- Switch to the AuctionDB database
USE AuctionDB;
GO

-- Create the Users table
CREATE TABLE Users (
    UserID INT IDENTITY(1,1) PRIMARY KEY,
    Username VARCHAR(50),
    FullName VARCHAR(50),
    Password VARCHAR(50),
    Email VARCHAR(50),
    Role VARCHAR(10)
);
GO

-- Insert sample data into the Users table
INSERT INTO Users (Username, FullName, Password, Email, Role)
VALUES
    ('client', 'SuperClient One', 'client123', 'client1@example.com', 'client1'),
    ('client2', 'SuperClient Two', 'password2', 'client2@example.com', 'client2'),
    ('admin', 'Admin One', 'admin123', 'admin@example.com', 'admin');
GO

-- Create the Auctions table with auto-increment primary key
CREATE TABLE Auctions (
    AuctionID INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT,
    Title VARCHAR(100),
    Description VARCHAR(200),
    StartDate DATETIME,
    EndDate DATETIME,
    Status VARCHAR(20),
    FOREIGN KEY (UserID) REFERENCES Users (UserID)
);
GO

-- Insert sample data into the Auctions table
INSERT INTO Auctions (UserID, Title, Description, StartDate, EndDate, Status)
VALUES
    (1, 'Auction 1', 'Description for Auction 1', '2023-07-08 12:00:00', '2023-07-10 12:00:00', 'Ongoing'),
    (2, 'Auction 2', 'Description for Auction 2', '2023-07-09 12:00:00', '2023-07-11 12:00:00', 'Upcoming'),
    (3, 'Auction 3', 'Description for Auction 3', '2023-07-06 12:00:00', '2023-07-07 12:00:00', 'Completed');
GO

-- Create the Bids table with auto-increment primary key
CREATE TABLE Bids (
    BidID INT IDENTITY(1,1) PRIMARY KEY,
    AuctionID INT,
    UserID INT,
    Amount DECIMAL(10, 2),
    BidTime DATETIME,
    FOREIGN KEY (AuctionID) REFERENCES Auctions (AuctionID),
    FOREIGN KEY (UserID) REFERENCES Users (UserID)
);
GO

-- Insert sample data into the Bids table
INSERT INTO Bids (AuctionID, UserID, Amount, BidTime)
VALUES
    (1, 1, 100.00, '2023-07-08 12:05:00'),
    (1, 2, 120.00, '2023-07-08 12:07:00'),
    (2, 1, 200.00, '2023-07-09 12:10:00');
GO

-- Create the Items table with auto-increment primary key
CREATE TABLE Items (
    ItemID INT IDENTITY(1,1) PRIMARY KEY,
    AuctionID INT,
    ItemName VARCHAR(100),
    Description VARCHAR(200),
    CurrentBid DECIMAL(10, 2),
    FOREIGN KEY (AuctionID) REFERENCES Auctions (AuctionID)
);
GO

-- Insert sample data into the Items table
INSERT INTO Items (AuctionID, ItemName, Description, CurrentBid)
VALUES
    (1, 'Item 1', 'Description for Item 1', 120.00),
    (2, 'Item 2', 'Description for Item 2', 200.00),
    (3, 'Item 3', 'Description for Item 3', 150.00);
GO
