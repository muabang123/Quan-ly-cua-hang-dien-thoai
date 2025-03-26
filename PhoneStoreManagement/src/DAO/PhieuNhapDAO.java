package DAO;

import DTO.PhieuNhapDTO;
import config.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuNhapDAO {

    public static PhieuNhapDAO getInstance() {
        return new PhieuNhapDAO();
    }

    public int insert(PhieuNhapDTO t) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO PhieuNhap (MaPhieuNhap, MaNhanVien, MaNhaCungCap, NgayNhap, TongTien) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaPhieuNhap());
            pst.setInt(2, t.getMaNhanVien());
            pst.setInt(3, t.getMaNhaCungCap());
            pst.setTimestamp(4, t.getNgayNhap());
            pst.setLong(5, t.getTongTien());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int update(PhieuNhapDTO t) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE PhieuNhap SET MaNhanVien=?, MaNhaCungCap=?, NgayNhap=?, TongTien=? WHERE MaPhieuNhap=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaNhanVien());
            pst.setInt(2, t.getMaNhaCungCap());
            pst.setTimestamp(3, t.getNgayNhap());
            pst.setLong(4, t.getTongTien());
            pst.setInt(5, t.getMaPhieuNhap());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int delete(int maPhieuNhap) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM PhieuNhap WHERE MaPhieuNhap = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, maPhieuNhap);
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList<PhieuNhapDTO> selectAll() {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM PhieuNhap ORDER BY MaPhieuNhap DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                PhieuNhapDTO pn = new PhieuNhapDTO(
                    rs.getInt("MaPhieuNhap"),
                    rs.getInt("MaNhanVien"),
                    rs.getInt("MaNhaCungCap"),
                    rs.getTimestamp("NgayNhap"),
                    rs.getLong("TongTien")
                );
                result.add(pn);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public PhieuNhapDTO selectById(int id) {
        PhieuNhapDTO result = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM PhieuNhap WHERE MaPhieuNhap = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = new PhieuNhapDTO(
                    rs.getInt("MaPhieuNhap"),
                    rs.getInt("MaNhanVien"),
                    rs.getInt("MaNhaCungCap"),
                    rs.getTimestamp("NgayNhap"),
                    rs.getLong("TongTien")
                );
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'quanlibanhang' AND TABLE_NAME = 'PhieuNhap'";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getInt("AUTO_INCREMENT");
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
