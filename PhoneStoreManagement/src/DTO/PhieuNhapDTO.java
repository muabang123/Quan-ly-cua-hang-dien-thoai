package DTO;

import java.sql.Timestamp;

/**
 * DTO cho bảng Phiếu Nhập
 */
public class PhieuNhapDTO {
    private int MaPhieuNhap;
    private int MaNhanVien;
    private int MaNhaCungCap;
    private Timestamp NgayNhap;
    private long TongTien;

    public PhieuNhapDTO() {
    }

    public PhieuNhapDTO(int MaPhieuNhap, int MaNhanVien, int MaNhaCungCap, Timestamp NgayNhap, long TongTien) {
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaNhanVien = MaNhanVien;
        this.MaNhaCungCap = MaNhaCungCap;
        this.NgayNhap = NgayNhap;
        this.TongTien = TongTien;
    }

    public int getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(int maPhieuNhap) {
        this.MaPhieuNhap = maPhieuNhap;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.MaNhanVien = maNhanVien;
    }

    public int getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(int maNhaCungCap) {
        this.MaNhaCungCap = maNhaCungCap;
    }

    public Timestamp getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Timestamp ngayNhap) {
        this.NgayNhap = ngayNhap;
    }

    public long getTongTien() {
        return TongTien;
    }

    public void setTongTien(long tongTien) {
        this.TongTien = tongTien;
    }

    @Override
    public String toString() {
        return "PhieuNhapDTO{" +
                "maPhieuNhap=" + MaPhieuNhap +
                ", maNhanVien=" + MaNhanVien +
                ", maNhaCungCap=" + MaNhaCungCap +
                ", ngayNhap=" + NgayNhap +
                ", tongTien=" + TongTien +
                '}';
    }
}
