package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class JDBCUtil {

    public static Connection getConnection() {
        Connection result = null;
        try {
            // Đăng ký MySQL Driver với DriverManager
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            // Các thông số kết nối
            String url = "jdbc:mysql://localhost:3306/quanlybanhang?useSSL=false&serverTimezone=UTC";
            String userName = "root";
            String password = "";
            
            // Tạo kết nối
            result = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối CSDL: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    public static void closeConnection(Connection c) {
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng kết nối: " + e.getMessage(), "Lỗi", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
