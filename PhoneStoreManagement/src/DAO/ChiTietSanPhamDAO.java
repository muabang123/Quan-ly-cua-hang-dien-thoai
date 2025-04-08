package DAO;

import DTO.ChiTietSanPhamDTO;
import config.JDBCUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietSanPhamDAO implements DAOinterface<ChiTietSanPhamDTO> {

    public static ChiTietSanPhamDAO getInstance() {
        return new ChiTietSanPhamDAO();
    }

    @Override
    public int insert(ChiTietSanPhamDTO t) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO chitietsanpham (MaSanPham, MaHang, Chip, Ram, Rom, Inch, DungLuongPin, MauSac) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaSanPham());
            pst.setInt(2, t.getMaHang());
            pst.setString(3, t.getChip());
            pst.setString(4, t.getRam());
            pst.setString(5, t.getRom());
            pst.setString(6, t.getInch());
            pst.setString(7, t.getDungLuongPin());
            pst.setString(8, t.getMauSac());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(ChiTietSanPhamDTO t) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE chitietsanpham SET MaHang=?, Chip=?, Ram=?, Rom=?, Inch=?, DungLuongPin=?, MauSac=? WHERE MaSanPham=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaHang());
            pst.setString(2, t.getChip());
            pst.setString(3, t.getRam());
            pst.setString(4, t.getRom());
            pst.setString(5, t.getInch());
            pst.setString(6, t.getDungLuongPin());
            pst.setString(7, t.getMauSac());
            pst.setInt(8, t.getMaSanPham());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(String t) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM chitietsanpham WHERE MaSanPham = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<ChiTietSanPhamDTO> selectAll() {
        ArrayList<ChiTietSanPhamDTO> result = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitietsanpham ORDER BY MaSanPham ASC";  // Sắp xếp theo MaSanPham ASC
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maSanPham = rs.getInt("MaSanPham");
                int maHang = rs.getInt("MaHang");
                String chip = rs.getString("Chip");
                String ram = rs.getString("Ram");
                String rom = rs.getString("Rom");
                String inch = rs.getString("Inch");
                String dungLuongPin = rs.getString("DungLuongPin");
                String mauSac = rs.getString("MauSac");
                ChiTietSanPhamDTO chiTietSanPham = new ChiTietSanPhamDTO(maSanPham, maHang, chip, ram, rom, inch, dungLuongPin, mauSac);
                result.add(chiTietSanPham);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ChiTietSanPhamDTO selectById(String t) {
        ChiTietSanPhamDTO result = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitietsanpham WHERE MaSanPham=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int maSanPham = rs.getInt("MaSanPham");
                int maHang = rs.getInt("MaHang");
                String chip = rs.getString("Chip");
                String ram = rs.getString("Ram");
                String rom = rs.getString("Rom");
                String inch = rs.getString("Inch");
                String dungLuongPin = rs.getString("DungLuongPin");
                String mauSac = rs.getString("MauSac");
                result = new ChiTietSanPhamDTO(maSanPham, maHang, chip, ram, rom, inch, dungLuongPin, mauSac);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static ChiTietSanPhamDTO selectByMaSP(String t) {
        ChiTietSanPhamDTO result = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitietsanpham WHERE MaSanPham=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int maSanPham = rs.getInt("MaSanPham");
                int maHang = rs.getInt("MaHang");
                String chip = rs.getString("Chip");
                String ram = rs.getString("Ram");
                String rom = rs.getString("Rom");
                String inch = rs.getString("Inch");
                String dungLuongPin = rs.getString("DungLuongPin");
                String mauSac = rs.getString("MauSac");
                result = new ChiTietSanPhamDTO(maSanPham, maHang, chip, ram, rom, inch, dungLuongPin, mauSac);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'quanlikhohang' AND TABLE_NAME = 'chitietsanpham'";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getInt("AUTO_INCREMENT");
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public ArrayList<ChiTietSanPhamDTO> selectAllByMaSanPham(int masp) {
        ArrayList<ChiTietSanPhamDTO> result = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitietsanpham WHERE MaSanPham=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, masp);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maSanPham = rs.getInt("MaSanPham");
                int maHang = rs.getInt("MaHang");
                String chip = rs.getString("Chip");
                String ram = rs.getString("Ram");
                String rom = rs.getString("Rom");
                String inch = rs.getString("Inch");
                String dungLuongPin = rs.getString("DungLuongPin");
                String mauSac = rs.getString("MauSac");
                ChiTietSanPhamDTO chiTietSanPham = new ChiTietSanPhamDTO(maSanPham, maHang, chip, ram, rom, inch, dungLuongPin, mauSac);
                result.add(chiTietSanPham);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public ArrayList<ChiTietSanPhamDTO> selectAllByMaPhieuNhap(int maphieunhap) {
    ArrayList<ChiTietSanPhamDTO> result = new ArrayList<>();
    String sql = "SELECT * FROM chitietsanpham WHERE MaPhieuNhap = ?";
    
    try (Connection con = JDBCUtil.getConnection(); 
         PreparedStatement pst = con.prepareStatement(sql)) {
         
        // Set parameter
        pst.setInt(1, maphieunhap);
        
        // Execute query
        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                // Extract fields from result set
                int maSanPham = rs.getInt("MaSanPham");
                int maHang = rs.getInt("MaHang");
                String chip = rs.getString("Chip");
                String ram = rs.getString("Ram");
                String rom = rs.getString("Rom");
                String inch = rs.getString("Inch");
                String dungLuongPin = rs.getString("DungLuongPin");
                String mauSac = rs.getString("MauSac");
                
                // Create DTO object and add to result list
                ChiTietSanPhamDTO ct = new ChiTietSanPhamDTO(maSanPham, maHang, chip, ram, rom, inch, dungLuongPin, mauSac);
                result.add(ct);
            }
        }
    } catch (SQLException e) {
        Logger.getLogger(ChiTietSanPhamDAO.class.getName()).log(Level.SEVERE, "Error selecting by MaPhieuNhap", e);
    }
    
    return result;
}

public ArrayList<ChiTietSanPhamDTO> selectAllByMaPhieuXuat(int maphieuxuat) {
    ArrayList<ChiTietSanPhamDTO> result = new ArrayList<>();
    String sql = "SELECT * FROM chitietsanpham WHERE MaHoaDon = ?";
    
    try (Connection con = JDBCUtil.getConnection(); 
         PreparedStatement pst = con.prepareStatement(sql)) {
         
        // Set parameter
        pst.setInt(1, maphieuxuat);
        
        // Execute query
        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                // Extract fields from result set
                int maSanPham = rs.getInt("MaSanPham");
                int maHang = rs.getInt("MaHang");
                String chip = rs.getString("Chip");
                String ram = rs.getString("Ram");
                String rom = rs.getString("Rom");
                String inch = rs.getString("Inch");
                String dungLuongPin = rs.getString("DungLuongPin");
                String mauSac = rs.getString("MauSac");
                
                // Create DTO object and add to result list
                ChiTietSanPhamDTO ct = new ChiTietSanPhamDTO(maSanPham, maHang, chip, ram, rom, inch, dungLuongPin, mauSac);
                result.add(ct);
            }
        }
    } catch (SQLException e) {
        Logger.getLogger(ChiTietSanPhamDAO.class.getName()).log(Level.SEVERE, "Error selecting by MaPhieuXuat", e);
    }
    
    return result;
}
    public ChiTietSanPhamDTO selectByRamRomMauSac(int maSanPham, String ram, String rom, String mauSac) {
    ChiTietSanPhamDTO result = null;
    try {
        Connection con = JDBCUtil.getConnection();
        // Tìm kiếm dựa trên Ram, Rom và MauSac
        String sql = "SELECT * FROM chitietsanpham WHERE Ram = ? AND Rom = ? AND MauSac = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, ram);   // Tìm theo ram
        pst.setString(2, rom);   // Tìm theo rom
        pst.setString(3, mauSac); // Tìm theo mauSac

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int maSanPhamInt = rs.getInt("MaSanPham");  // Lấy MaSanPham của bản ghi thỏa mãn điều kiện
            String ramStr = rs.getString("Ram");
            String romStr = rs.getString("Rom");
            String mauSacStr = rs.getString("MauSac");
            result = new ChiTietSanPhamDTO(maSanPhamInt, 0, "", ramStr, romStr, "", "", mauSacStr);
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(ChiTietSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
}




}
