package config;

import java.sql.Connection;
import java.sql.DriverManager;
<<<<<<< HEAD
=======
import java.sql.SQLException;
>>>>>>> huuloc
import javax.swing.JOptionPane;

public class JDBCUtil {

    public static Connection getConnection() {
        Connection result = null;
        try {
<<<<<<< HEAD
            // Dang ky MySQL Driver voi DriverManager
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Cac thong so
            String url = "jdbc:mySQL://localhost:3307/quanlybanhang";
            String userName = "root";
            String password = "";
            //Tao ket noi 
            result = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến cơ sở dữ liệu !", "Lỗi", JOptionPane.ERROR_MESSAGE);
=======
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
>>>>>>> huuloc
        }
        return result;
    }

    public static void closeConnection(Connection c) {
<<<<<<< HEAD
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
=======
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng kết nối: " + e.getMessage(), "Lỗi", JOptionPane.WARNING_MESSAGE);
            }
>>>>>>> huuloc
        }
    }
}
