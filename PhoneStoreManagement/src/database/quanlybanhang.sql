-- Tạo database 
CREATE DATABASE IF NOT EXISTS QuanLyBanHang;
USE QuanLyBanHang;

-- Tạo bảng Loại Sản Phẩm
CREATE TABLE LoaiSanPham (
    MaLoai INT PRIMARY KEY AUTO_INCREMENT,
    TenLoai VARCHAR(255) NOT NULL
);

-- Tạo bảng Hãng
CREATE TABLE Hang (
    MaHang INT PRIMARY KEY AUTO_INCREMENT,
    TenHang VARCHAR(255) NOT NULL,
    QuocGia VARCHAR(100)
);

-- Tạo bảng Sản Phẩm
CREATE TABLE SanPham (
    MaSanPham INT PRIMARY KEY AUTO_INCREMENT,
    TenSanPham VARCHAR(255) NOT NULL,
    SoLuong INT DEFAULT 0,
    DonGia DECIMAL(20,2) NOT NULL,
    DonViTinh VARCHAR(50),
    HinhAnh VARCHAR(255),
    MaLoai INT,
    FOREIGN KEY (MaLoai) REFERENCES LoaiSanPham(MaLoai) ON DELETE SET NULL
);

CREATE TABLE ChiTietSanPham (
    MaSanPham INT,
    MaHang INT,
    Chip VARCHAR(100),
    Ram VARCHAR(50),
    Rom VARCHAR(50),
    INCH VARCHAR(10),
    DungLuongPin VARCHAR(50),
    MauSac VARCHAR(50),
    PRIMARY KEY (MaSanPham, Ram, Rom, MauSac),  -- Đặt khóa chính là sự kết hợp của MaSanPham, Ram, Rom, MauSac
    FOREIGN KEY (MaSanPham) REFERENCES SanPham(MaSanPham) ON DELETE CASCADE,
    FOREIGN KEY (MaHang) REFERENCES Hang(MaHang) ON DELETE SET NULL
);


-- Tạo bảng Nhân Viên
CREATE TABLE NhanVien (
    MaNhanVien INT PRIMARY KEY AUTO_INCREMENT,
    HoTen VARCHAR(255) NOT NULL,
    ChucVu VARCHAR(100),
    NgayVaoLam DATE,
    Luong DECIMAL(20,2)
);

-- Tạo bảng Nhà Cung Cấp
CREATE TABLE NhaCungCap (
    MaNhaCungCap INT PRIMARY KEY AUTO_INCREMENT,
    TenNhaCungCap VARCHAR(255) NOT NULL,
    DiaChi TEXT,
    SoDienThoai VARCHAR(20),
    Email VARCHAR(255)
);

-- Tạo bảng Phiếu Nhập
CREATE TABLE PhieuNhap (
    MaPhieuNhap INT PRIMARY KEY AUTO_INCREMENT,
    MaNhanVien INT,
    MaNhaCungCap INT,
    NgayNhap DATE,
    TongTien DECIMAL(20,2),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien) ON DELETE SET NULL,
    FOREIGN KEY (MaNhaCungCap) REFERENCES NhaCungCap(MaNhaCungCap) ON DELETE SET NULL
);

-- Tạo bảng Chi Tiết Phiếu Nhập
CREATE TABLE ChiTietPhieuNhap (
    MaPhieuNhap INT,
    MaSanPham INT,
    SoLuong INT NOT NULL,
    Ram VARCHAR(50),
    Rom VARCHAR(50),
    MauSac VARCHAR(50),
    DonGia DECIMAL(20,2) NOT NULL,
    PRIMARY KEY (MaPhieuNhap, MaSanPham, Ram, Rom, MauSac),  -- 5 khóa chính
    FOREIGN KEY (MaPhieuNhap) REFERENCES PhieuNhap(MaPhieuNhap) ON DELETE CASCADE,
    FOREIGN KEY (MaSanPham) REFERENCES SanPham(MaSanPham) ON DELETE CASCADE
);

-- Tạo bảng Khách Hàng
CREATE TABLE KhachHang (
    MaKhachHang INT PRIMARY KEY AUTO_INCREMENT,
    HoTenKhachHang VARCHAR(255) NOT NULL,
    DiaChi TEXT,
    SoDienThoai VARCHAR(20),
    Email VARCHAR(255)
);

-- Tạo bảng Hóa Đơn
CREATE TABLE HoaDon (
    MaHoaDon INT PRIMARY KEY AUTO_INCREMENT,
    NgayLapHoaDon DATE NOT NULL,
    MaNhanVien INT,
    MaKhachHang INT,
    TongTien DECIMAL(20,2),
    TongTienPhaiTra DECIMAL(20,2),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien) ON DELETE SET NULL,
    FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang) ON DELETE SET NULL
);

-- Tạo bảng Chi Tiết Hóa Đơn
CREATE TABLE ChiTietHoaDon (
    MaHoaDon INT,
    MaSanPham INT,
    SoLuong INT NOT NULL,
    Ram VARCHAR(50),
    Rom VARCHAR(50),
    MauSac VARCHAR(50),
    DonGia DECIMAL(20,2) NOT NULL,
    ThanhTien DECIMAL(20,2),
    SoTienConLai DECIMAL(20,2),
    PRIMARY KEY (MaHoaDon, MaSanPham, Ram, Rom, MauSac),  -- 5 khóa chính
    FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon) ON DELETE CASCADE,
    FOREIGN KEY (MaSanPham) REFERENCES SanPham(MaSanPham) ON DELETE CASCADE
);


-- Tạo bảng Chương Trình Khuyến Mãi
CREATE TABLE ChuongTrinhKM (
    MaChuongTrinhKM INT PRIMARY KEY AUTO_INCREMENT,
    NgayBatDau DATE NOT NULL,
    NgayKetThuc DATE NOT NULL
);

-- Tạo bảng Chi Tiết Chương Trình Khuyến Mãi Sản Phẩm
CREATE TABLE ChiTietCTKM_SP (
    MaChuongTrinhKM INT,
    MaSanPham INT,
    PhanTramGiamGia DECIMAL(10,2),
    PRIMARY KEY (MaChuongTrinhKM, MaSanPham),
    FOREIGN KEY (MaChuongTrinhKM) REFERENCES ChuongTrinhKM(MaChuongTrinhKM) ON DELETE CASCADE,
    FOREIGN KEY (MaSanPham) REFERENCES SanPham(MaSanPham) ON DELETE CASCADE
);

-- Tạo bảng Chi Tiết Chương Trình Khuyến Mãi Hóa Đơn
CREATE TABLE ChiTietCTKM_HD (
    MaChuongTrinhKM INT PRIMARY KEY,
    SoTienHoaDon DECIMAL(20,2),
    PhanTramGiamGia DECIMAL(10,2),
    FOREIGN KEY (MaChuongTrinhKM) REFERENCES ChuongTrinhKM(MaChuongTrinhKM) ON DELETE CASCADE
);

-- Tạo bảng Nhóm Quyền
CREATE TABLE NhomQuyen (
    MaNhomQuyen INT PRIMARY KEY AUTO_INCREMENT,
    TenQuyen VARCHAR(50) NOT NULL UNIQUE
);

-- Thêm dữ liệu cho bảng Nhóm Quyền
INSERT INTO NhomQuyen (MaNhomQuyen, TenQuyen) VALUES 
(1, 'Admin'),
(2, 'NhanVienQuanLy');

-- Tạo bảng User
CREATE TABLE User (
    MaUser INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(255) UNIQUE NOT NULL,
    PasswordHash VARCHAR(255) NOT NULL, -- Lưu mật khẩu đã mã hóa
    Email VARCHAR(255) UNIQUE NOT NULL,
    HoTen VARCHAR(255) NOT NULL,
    NgayTao TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Ngày tạo tài khoản
    MaNhomQuyen INT NOT NULL, -- Liên kết với nhóm quyền
    FOREIGN KEY (MaNhomQuyen) REFERENCES NhomQuyen(MaNhomQuyen) ON DELETE CASCADE
);
INSERT INTO User (Username, PasswordHash, Email, HoTen, MaNhomQuyen)
VALUES 
('admin', 'hashed_password_here', 'admin@example.com', 'Administrator', 1),
('manager1', 'hashed_password_here', 'manager1@example.com', 'Nguyen Van A', 2);

-- 1. Các bảng độc lập hoàn toàn
INSERT INTO `loaisanpham` (`MaLoai`, `TenLoai`) VALUES
(1, 'Điện thoại'),
(2, 'Laptop'),
(3, 'Máy tính bảng');

INSERT INTO `hang` (`MaHang`, `TenHang`, `QuocGia`) VALUES
(1, 'Apple', 'Mỹ'),
(2, 'Samsung', 'Hàn Quốc'),
(3, 'Dell', 'Mỹ'),
(4, 'Asus', 'Đài Loan');

INSERT INTO `nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `DiaChi`, `SoDienThoai`, `Email`) VALUES
(1, 'Công ty Apple Việt Nam', 'Hà Nội', '0123456789', 'applevn@gmail.com'),
(2, 'Samsung Việt Nam', 'TPHCM', '0987654321', 'samsungvn@gmail.com');

INSERT INTO `nhanvien` (`MaNhanVien`, `HoTen`, `ChucVu`, `NgayVaoLam`, `Luong`) VALUES
(1, 'Nguyễn Văn A', 'Quản lý', '2020-05-10', 30000000.00),
(2, 'Trần Thị B', 'Nhân viên bán hàng', '2021-07-15', 15000000.00),
(3, 'Lê Văn C', 'Nhân viên kho', '2019-12-01', 12000000.00);

INSERT INTO `khachhang` (`MaKhachHang`, `HoTenKhachHang`, `DiaChi`, `SoDienThoai`, `Email`) VALUES
(1, 'Phạm Thị D', 'Hà Nội', '0912345678', 'phamthid@gmail.com'),
(2, 'Ngô Văn E', 'TPHCM', '0976543210', 'ngovane@gmail.com');

-- 2. Sản phẩm (phụ thuộc loaisanpham)
INSERT INTO `sanpham` (`MaSanPham`, `TenSanPham`, `SoLuong`, `DonGia`, `DonViTinh`, `HinhAnh`, `MaLoai`) VALUES
(1, 'iPhone 15 Pro', 202, 29990000.00, 'Cái', 'iphone15pro.jpg', 1),
(2, 'Samsung Galaxy S23', 164, 21990000.00, 'Cái', 'samsungs23.jpg', 1),
(3, 'MacBook Pro 16', 40, 59990000.00, 'Cái', 'macbookpro16.jpg', 2),
(4, 'Asus ROG Zephyrus', 60, 39990000.00, 'Cái', 'asusrog.jpg', 2);

-- 3. chi tiết sản phẩm (phụ thuộc sanpham, hang)
INSERT INTO `chitietsanpham` (`MaSanPham`, `MaHang`, `Chip`, `Ram`, `Rom`, `INCH`, `DungLuongPin`, `MauSac`) VALUES
(1, 1, 'A17 Bionic', '8GB', '256GB', '6.1\"', '3200mAh', 'Xanh'),
(2, 2, 'Snapdragon 8 Gen 2', '12GB', '256GB', '6.5\"', '4500mAh', 'Đen'),
(3, 1, 'M2 Pro', '16GB', '512GB', '16\"', '100Wh', 'Bạc'),
(4, 4, 'Ryzen 9', '32GB', '1TB', '15.6\"', '90Wh', 'Đỏ');

-- 4. Chương trình khuyến mãi
INSERT INTO `chuongtrinhkm` (`MaChuongTrinhKM`, `NgayBatDau`, `NgayKetThuc`) VALUES
(1, '2024-03-01', '2024-03-31'),
(2, '2024-04-01', '2024-04-30');

-- 5. Phiếu nhập (phụ thuộc nhân viên và nhà cung cấp)
INSERT INTO `phieunhap` (`MaPhieuNhap`, `MaNhanVien`, `MaNhaCungCap`, `NgayNhap`, `TongTien`) VALUES
(1, 1, 1, '2024-03-20', 500000000.00),
(2, 2, 2, '2024-03-21', 300000000.00),
(12, 1, 1, '2025-04-07', 2379100000.00),
(13, 1, 1, '2025-04-07', 1479450000.00),
(14, 1, 1, '2025-04-07', 2099350000.00),
(15, 1, 1, '2025-04-07', 2699300000.00),
(16, 1, 1, '2025-04-07', 1479450000.00),
(17, 1, 1, '2025-04-07', 2999000000.00),
(18, 1, 1, '2025-04-07', 59980000.00),
(19, 2, 1, '2025-04-07', 43980000.00),
(20, 1, 1, '2025-04-07', 1199700000.00),
(21, 2, 1, '2025-04-07', 1803180000.00);

-- 6. Chi tiết phiếu nhập (phụ thuộc phiếu nhập, sản phẩm)
INSERT INTO `chitietphieunhap` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `Ram`, `Rom`, `MauSac`, `DonGia`) VALUES
(1, 1, 10, '8GB', '256GB', 'Xanh', 29990000.00),
(1, 2, 5, '12GB', '256GB', 'Đen', 21990000.00),
(2, 4, 15, '32GB', '1TB', 'Đỏ', 39990000.00),
(13, 2, 40, '12GB', '256GB', 'Đen', 21990000.00),
(13, 4, 15, '32GB', '1TB', 'Đỏ', 39990000.00),
(14, 1, 50, '8GB', '256GB', 'Xanh', 29990000.00),
(14, 4, 15, '32GB', '1TB', 'Đỏ', 39990000.00),
(15, 1, 50, '8GB', '256GB', 'Xanh', 29990000.00),
(15, 3, 20, '16GB', '512GB', 'Xanh', 59990000.00),
(16, 2, 40, '12GB', '256GB', 'Đen', 21990000.00),
(16, 4, 15, '32GB', '1TB', 'Đỏ', 39990000.00),
(17, 1, 100, '2GB', '32GB', 'Đỏ', 29990000.00),
(18, 1, 2, '4GB', '64GB', 'Đen', 29990000.00),
(19, 2, 2, '2GB', '32GB', 'Đỏ', 21990000.00),
(20, 4, 30, '32GB', '64GB', 'Vàng', 39990000.00),
(21, 2, 82, '12GB', '256GB', 'Đen', 21990000.00);

-- 7. Hóa đơn (phụ thuộc nhân viên và khách hàng)
INSERT INTO `hoadon` (`MaHoaDon`, `NgayLapHoaDon`, `MaNhanVien`, `MaKhachHang`, `TongTien`, `TongTienPhaiTra`) VALUES
(1, '2024-03-22', 2, 1, 21990000.00, 20990000.00),
(2, '2024-03-23', 3, 2, 39990000.00, 37990000.00);

-- 8. Chi tiết hóa đơn (phụ thuộc hóa đơn và sản phẩm)
INSERT INTO `chitiethoadon` (`MaHoaDon`, `MaSanPham`, `SoLuong`, `Ram`, `Rom`, `MauSac`, `DonGia`, `ThanhTien`, `SoTienConLai`) VALUES
(1, 2, 1, '12GB', '256GB', 'Đen', 21990000.00, 21990000.00, 20990000.00),
(2, 4, 1, '32GB', '1TB', 'Đỏ', 39990000.00, 39990000.00, 37990000.00);

-- 9. Chi tiết chương trình khuyến mãi (phụ thuộc vào sản phẩm hoặc hóa đơn + chương trình khuyến mãi)
INSERT INTO `chitietctkm_hd` (`MaChuongTrinhKM`, `SoTienHoaDon`, `PhanTramGiamGia`) VALUES
(1, 20000000.00, 3.00),
(2, 35000000.00, 5.00);

INSERT INTO `chitietctkm_sp` (`MaChuongTrinhKM`, `MaSanPham`, `PhanTramGiamGia`) VALUES
(1, 2, 5.00),
(2, 4, 10.00);
