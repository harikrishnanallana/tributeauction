/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBconnect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nkhan
 */
public class DBconnector {

    private String hostName = "localhost";
    private String instance = "";

    private String dbName = "PRJDB";
    private String username = "niran";
    private String password = "niran@123456";
    private String portNumber = "1433";

    public Connection conn;

    public DBconnector() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectorURL = "jdbc:sqlserver://" + hostName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
            if (instance == null || instance.trim().isEmpty()) {
                connectorURL = "jdbc:sqlserver://" + hostName + ":" + portNumber + ";databaseName=" + dbName;
            }

            conn = DriverManager.getConnection(connectorURL, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBconnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        DBconnector dbConnector = new DBconnector();

        // Kiểm tra kết nối thành công
        if (dbConnector.conn != null) {
            System.out.println("Kết nối thành công!");

            try {
                // Đường dẫn đến tệp .bat nằm ở thư mục bên ngoài
                String batFilePath = System.getProperty("user.dir") + "\\src\\java\\DBconnect\\initialize.bat";


                // Thực thi lệnh để chạy tệp .bat
                ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", batFilePath);
                processBuilder.redirectErrorStream(true); // Để hợp nhất stdout và stderr
                Process process = processBuilder.start();

                // Đọc dữ liệu đầu ra từ quá trình
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                // Đợi quá trình hoàn thành
                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    System.out.println("Cơ sở dữ liệu đã được khởi tạo hoặc cập nhật thành công.");
                } else {
                    System.out.println("Khởi tạo cơ sở dữ liệu thất bại. Mã thoát: " + exitCode);
                }

                reader.close();
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Kết nối thất bại!");
        }

        dbConnector.close();
    }

}
