-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Mar 28, 2025 at 03:58 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlybanhang`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietctkm_hd`
--

CREATE TABLE `chitietctkm_hd` (
  `MaChuongTrinhKM` int(11) NOT NULL,
  `SoTienHoaDon` decimal(20,2) DEFAULT NULL,
  `PhanTramGiamGia` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietctkm_hd`
--

INSERT INTO `chitietctkm_hd` (`MaChuongTrinhKM`, `SoTienHoaDon`, `PhanTramGiamGia`) VALUES
(1, 20000000.00, 3.00),
(2, 35000000.00, 5.00);

-- --------------------------------------------------------

--
-- Table structure for table `chitietctkm_sp`
--

CREATE TABLE `chitietctkm_sp` (
  `MaChuongTrinhKM` int(11) NOT NULL,
  `MaSanPham` int(11) NOT NULL,
  `PhanTramGiamGia` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietctkm_sp`
--

INSERT INTO `chitietctkm_sp` (`MaChuongTrinhKM`, `MaSanPham`, `PhanTramGiamGia`) VALUES
(1, 2, 5.00),
(2, 4, 10.00);

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHoaDon` int(11) NOT NULL,
  `MaSanPham` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `Ram` varchar(50) DEFAULT NULL,
  `Rom` varchar(50) DEFAULT NULL,
  `MauSac` varchar(50) DEFAULT NULL,
  `DonGia` decimal(20,2) NOT NULL,
  `ThanhTien` decimal(20,2) DEFAULT NULL,
  `TienGiamGiaConLai` decimal(20,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MaHoaDon`, `MaSanPham`, `SoLuong`, `Ram`, `Rom`, `MauSac`, `DonGia`, `ThanhTien`, `TienGiamGiaConLai`) VALUES
(1, 2, 1, '12GB', '256GB', 'Đen', 21990000.00, 21990000.00, 20990000.00),
(2, 4, 1, '32GB', '1TB', 'Đỏ', 39990000.00, 39990000.00, 37990000.00);

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MaPhieuNhap` int(11) NOT NULL,
  `MaSanPham` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `Ram` varchar(50) DEFAULT NULL,
  `Rom` varchar(50) DEFAULT NULL,
  `MauSac` varchar(50) DEFAULT NULL,
  `DonGia` decimal(20,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`MaPhieuNhap`, `MaSanPham`, `SoLuong`, `Ram`, `Rom`, `MauSac`, `DonGia`) VALUES
(1, 1, 10, '8GB', '256GB', 'Xanh', 29990000.00),
(1, 2, 5, '12GB', '256GB', 'Đen', 21990000.00),
(2, 3, 3, '16GB', '512GB', 'Bạc', 59990000.00),
(2, 4, 2, '32GB', '1TB', 'Đỏ', 39990000.00);

-- --------------------------------------------------------

--
-- Table structure for table `chitietsanpham`
--

CREATE TABLE `chitietsanpham` (
  `MaSanPham` int(11) NOT NULL,
  `MaHang` int(11) NOT NULL,
  `Chip` varchar(100) DEFAULT NULL,
  `Ram` varchar(50) DEFAULT NULL,
  `Rom` varchar(50) DEFAULT NULL,
  `INCH` varchar(10) DEFAULT NULL,
  `DungLuongPin` varchar(50) DEFAULT NULL,
  `MauSac` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietsanpham`
--

INSERT INTO `chitietsanpham` (`MaSanPham`, `MaHang`, `Chip`, `Ram`, `Rom`, `INCH`, `DungLuongPin`, `MauSac`) VALUES
(1, 1, 'A17 Bionic', '8GB', '256GB', '6.1\"', '3200mAh', 'Xanh'),
(2, 2, 'Snapdragon 8 Gen 2', '12GB', '256GB', '6.5\"', '4500mAh', 'Đen'),
(3, 1, 'M2 Pro', '16GB', '512GB', '16\"', '100Wh', 'Bạc'),
(4, 4, 'Ryzen 9', '32GB', '1TB', '15.6\"', '90Wh', 'Đỏ');

-- --------------------------------------------------------

--
-- Table structure for table `chuongtrinhkm`
--

CREATE TABLE `chuongtrinhkm` (
  `MaChuongTrinhKM` int(11) NOT NULL,
  `NgayBatDau` date NOT NULL,
  `NgayKetThuc` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chuongtrinhkm`
--

INSERT INTO `chuongtrinhkm` (`MaChuongTrinhKM`, `NgayBatDau`, `NgayKetThuc`) VALUES
(1, '2024-03-01', '2024-03-31'),
(2, '2024-04-01', '2024-04-30');

-- --------------------------------------------------------

--
-- Table structure for table `hang`
--

CREATE TABLE `hang` (
  `MaHang` int(11) NOT NULL,
  `TenHang` varchar(255) NOT NULL,
  `QuocGia` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hang`
--

INSERT INTO `hang` (`MaHang`, `TenHang`, `QuocGia`) VALUES
(1, 'Apple', 'Mỹ'),
(2, 'Samsung', 'Hàn Quốc'),
(3, 'Dell', 'Mỹ'),
(4, 'Asus', 'Đài Loan');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHoaDon` int(11) NOT NULL,
  `NgayLapHoaDon` date NOT NULL,
  `MaNhanVien` int(11) DEFAULT NULL,
  `MaKhachHang` int(11) DEFAULT NULL,
  `TongTien` decimal(20,2) DEFAULT NULL,
  `TongTienPhaiTra` decimal(20,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MaHoaDon`, `NgayLapHoaDon`, `MaNhanVien`, `MaKhachHang`, `TongTien`, `TongTienPhaiTra`) VALUES
(1, '2024-03-22', 2, 1, 21990000.00, 20990000.00),
(2, '2024-03-23', 3, 2, 39990000.00, 37990000.00);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKhachHang` int(11) NOT NULL,
  `HoTenKhachHang` varchar(255) NOT NULL,
  `DiaChi` text DEFAULT NULL,
  `SoDienThoai` varchar(20) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKhachHang`, `HoTenKhachHang`, `DiaChi`, `SoDienThoai`, `Email`) VALUES
(1, 'Phạm Thị D', 'Hà Nội', '0912345678', 'phamthid@gmail.com'),
(2, 'Ngô Văn E', 'TPHCM', '0976543210', 'ngovane@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loaisanpham`
--

INSERT INTO `loaisanpham` (`MaLoai`, `TenLoai`) VALUES
(1, 'Điện thoại'),
(2, 'Laptop'),
(3, 'Máy tính bảng');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNhaCungCap` int(11) NOT NULL,
  `TenNhaCungCap` varchar(255) NOT NULL,
  `DiaChi` text DEFAULT NULL,
  `SoDienThoai` varchar(20) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `DiaChi`, `SoDienThoai`, `Email`) VALUES
(1, 'Công ty Apple Việt Nam', 'Hà Nội', '0123456789', 'applevn@gmail.com'),
(2, 'Samsung Việt Nam', 'TPHCM', '0987654321', 'samsungvn@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNhanVien` int(11) NOT NULL,
  `HoTen` varchar(255) NOT NULL,
  `ChucVu` varchar(100) DEFAULT NULL,
  `NgayVaoLam` date DEFAULT NULL,
  `Luong` decimal(20,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNhanVien`, `HoTen`, `ChucVu`, `NgayVaoLam`, `Luong`) VALUES
(1, 'Nguyễn Văn A', 'Quản lý', '2020-05-10', 30000000.00),
(2, 'Trần Thị B', 'Nhân viên bán hàng', '2021-07-15', 15000000.00),
(3, 'Lê Văn C', 'Nhân viên kho', '2019-12-01', 12000000.00);

-- --------------------------------------------------------

--
-- Table structure for table `nhomquyen`
--

CREATE TABLE `nhomquyen` (
  `MaNhomQuyen` int(11) NOT NULL,
  `TenQuyen` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhomquyen`
--

INSERT INTO `nhomquyen` (`MaNhomQuyen`, `TenQuyen`) VALUES
(1, 'Admin'),
(2, 'NhanVienQuanLy');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPhieuNhap` int(11) NOT NULL,
  `MaNhanVien` int(11) DEFAULT NULL,
  `MaNhaCungCap` int(11) DEFAULT NULL,
  `NgayNhap` date DEFAULT NULL,
  `TongTien` decimal(20,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`MaPhieuNhap`, `MaNhanVien`, `MaNhaCungCap`, `NgayNhap`, `TongTien`) VALUES
(1, 1, 1, '2024-03-20', 500000000.00),
(2, 2, 2, '2024-03-21', 300000000.00);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSanPham` int(11) NOT NULL,
  `TenSanPham` varchar(255) NOT NULL,
  `SoLuong` int(11) DEFAULT 0,
  `DonGia` decimal(20,2) NOT NULL,
  `DonViTinh` varchar(50) DEFAULT NULL,
  `HinhAnh` varchar(255) DEFAULT NULL,
  `MaLoai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MaSanPham`, `TenSanPham`, `SoLuong`, `DonGia`, `DonViTinh`, `HinhAnh`, `MaLoai`) VALUES
(1, 'iPhone 15 Pro', 50, 29990000.00, 'Cái', 'iphone15pro.jpg', 1),
(2, 'Samsung Galaxy S23', 40, 21990000.00, 'Cái', 'samsungs23.jpg', 1),
(3, 'MacBook Pro 16', 20, 59990000.00, 'Cái', 'macbookpro16.jpg', 2),
(4, 'Asus ROG Zephyrus', 15, 39990000.00, 'Cái', 'asusrog.jpg', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `MaUser` int(11) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `PasswordHash` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `HoTen` varchar(255) NOT NULL,
  `NgayTao` timestamp NOT NULL DEFAULT current_timestamp(),
  `MaNhomQuyen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`MaUser`, `Username`, `PasswordHash`, `Email`, `HoTen`, `NgayTao`, `MaNhomQuyen`) VALUES
(1, 'admin', 'hashed_password_here', 'admin@example.com', 'Administrator', '2025-03-28 02:57:48', 1),
(2, 'manager1', 'hashed_password_here', 'manager1@example.com', 'Nguyen Van A', '2025-03-28 02:57:48', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietctkm_hd`
--
ALTER TABLE `chitietctkm_hd`
  ADD PRIMARY KEY (`MaChuongTrinhKM`);

--
-- Indexes for table `chitietctkm_sp`
--
ALTER TABLE `chitietctkm_sp`
  ADD PRIMARY KEY (`MaChuongTrinhKM`,`MaSanPham`),
  ADD KEY `MaSanPham` (`MaSanPham`);

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`MaHoaDon`,`MaSanPham`),
  ADD KEY `MaSanPham` (`MaSanPham`);

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`MaPhieuNhap`,`MaSanPham`),
  ADD KEY `MaSanPham` (`MaSanPham`);

--
-- Indexes for table `chitietsanpham`
--
ALTER TABLE `chitietsanpham`
  ADD PRIMARY KEY (`MaSanPham`,`MaHang`),
  ADD KEY `MaHang` (`MaHang`);

--
-- Indexes for table `chuongtrinhkm`
--
ALTER TABLE `chuongtrinhkm`
  ADD PRIMARY KEY (`MaChuongTrinhKM`);

--
-- Indexes for table `hang`
--
ALTER TABLE `hang`
  ADD PRIMARY KEY (`MaHang`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHoaDon`),
  ADD KEY `MaNhanVien` (`MaNhanVien`),
  ADD KEY `MaKhachHang` (`MaKhachHang`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKhachHang`);

--
-- Indexes for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNhaCungCap`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNhanVien`);

--
-- Indexes for table `nhomquyen`
--
ALTER TABLE `nhomquyen`
  ADD PRIMARY KEY (`MaNhomQuyen`),
  ADD UNIQUE KEY `TenQuyen` (`TenQuyen`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPhieuNhap`),
  ADD KEY `MaNhanVien` (`MaNhanVien`),
  ADD KEY `MaNhaCungCap` (`MaNhaCungCap`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSanPham`),
  ADD KEY `MaLoai` (`MaLoai`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`MaUser`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD KEY `MaNhomQuyen` (`MaNhomQuyen`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chuongtrinhkm`
--
ALTER TABLE `chuongtrinhkm`
  MODIFY `MaChuongTrinhKM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `hang`
--
ALTER TABLE `hang`
  MODIFY `MaHang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MaHoaDon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MaKhachHang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `MaLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `MaNhaCungCap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MaNhanVien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `nhomquyen`
--
ALTER TABLE `nhomquyen`
  MODIFY `MaNhomQuyen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `MaPhieuNhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MaSanPham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `MaUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietctkm_hd`
--
ALTER TABLE `chitietctkm_hd`
  ADD CONSTRAINT `chitietctkm_hd_ibfk_1` FOREIGN KEY (`MaChuongTrinhKM`) REFERENCES `chuongtrinhkm` (`MaChuongTrinhKM`) ON DELETE CASCADE;

--
-- Constraints for table `chitietctkm_sp`
--
ALTER TABLE `chitietctkm_sp`
  ADD CONSTRAINT `chitietctkm_sp_ibfk_1` FOREIGN KEY (`MaChuongTrinhKM`) REFERENCES `chuongtrinhkm` (`MaChuongTrinhKM`) ON DELETE CASCADE,
  ADD CONSTRAINT `chitietctkm_sp_ibfk_2` FOREIGN KEY (`MaSanPham`) REFERENCES `sanpham` (`MaSanPham`) ON DELETE CASCADE;

--
-- Constraints for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`MaHoaDon`) REFERENCES `hoadon` (`MaHoaDon`) ON DELETE CASCADE,
  ADD CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`MaSanPham`) REFERENCES `sanpham` (`MaSanPham`) ON DELETE CASCADE;

--
-- Constraints for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`MaPhieuNhap`) REFERENCES `phieunhap` (`MaPhieuNhap`) ON DELETE CASCADE,
  ADD CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`MaSanPham`) REFERENCES `sanpham` (`MaSanPham`) ON DELETE CASCADE;

--
-- Constraints for table `chitietsanpham`
--
ALTER TABLE `chitietsanpham`
  ADD CONSTRAINT `chitietsanpham_ibfk_1` FOREIGN KEY (`MaSanPham`) REFERENCES `sanpham` (`MaSanPham`) ON DELETE CASCADE,
  ADD CONSTRAINT `chitietsanpham_ibfk_2` FOREIGN KEY (`MaHang`) REFERENCES `hang` (`MaHang`) ON DELETE CASCADE;

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`) ON DELETE SET NULL,
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MaKhachHang`) REFERENCES `khachhang` (`MaKhachHang`) ON DELETE SET NULL;

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`) ON DELETE SET NULL,
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MaNhaCungCap`) REFERENCES `nhacungcap` (`MaNhaCungCap`) ON DELETE SET NULL;

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `loaisanpham` (`MaLoai`) ON DELETE SET NULL;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`MaNhomQuyen`) REFERENCES `nhomquyen` (`MaNhomQuyen`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
