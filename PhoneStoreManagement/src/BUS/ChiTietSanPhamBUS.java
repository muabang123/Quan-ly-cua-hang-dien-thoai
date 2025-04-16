package BUS;

import DAO.ChiTietSanPhamDAO;
import DTO.ChiTietSanPhamDTO;
import java.util.ArrayList;
import java.util.HashMap;

public class ChiTietSanPhamBUS {

    public final ChiTietSanPhamDAO ctspDAO = new ChiTietSanPhamDAO();
    public ArrayList<ChiTietSanPhamDTO> listctsp = new ArrayList<>();

    public ChiTietSanPhamBUS() {
        listctsp = ctspDAO.selectAll(); // load dữ liệu ngay khi khởi tạo
    }

    public boolean deleteByMaSanPham(int maSanPham) {
        return ctspDAO.delete(String.valueOf(maSanPham)) > 0;
}
    
    // Thêm chi tiết sản phẩm
    public boolean add(ChiTietSanPhamDTO ctsp) {
        int result = ctspDAO.insert(ctsp);
        if (result > 0) {
            listctsp.add(ctsp); // cập nhật danh sách tạm
            return true;
        }
        return false;
    }
    
    public boolean update(ChiTietSanPhamDTO ctsp) {
    return ctspDAO.update(ctsp) > 0;
}

    // Lấy tất cả chi tiết sản phẩm
    public ArrayList<ChiTietSanPhamDTO> getAll() {
        return this.listctsp;
    }

    // Lấy chi tiết sản phẩm theo chỉ số index trong danh sách
    public ChiTietSanPhamDTO getByIndex(int index) {
        return this.listctsp.get(index);
    }

    // Lấy tất cả chi tiết sản phẩm theo mã sản phẩm
    public ArrayList<ChiTietSanPhamDTO> getAllCTSPbyMasp(int masp) {
        return ctspDAO.selectAllByMaSanPham(masp);
    }

    // Lấy chi tiết sản phẩm từ mã phiếu nhập
    public HashMap<Integer, ArrayList<ChiTietSanPhamDTO>> getChiTietSanPhamFromMaPN(int maphieunhap) {
        ArrayList<ChiTietSanPhamDTO> chitietsp = ctspDAO.selectAllByMaPhieuNhap(maphieunhap);
        HashMap<Integer, ArrayList<ChiTietSanPhamDTO>> result = new HashMap<>();
        for (ChiTietSanPhamDTO i : chitietsp) {
            result.computeIfAbsent(i.getMaSanPham(), k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    // Lấy chi tiết sản phẩm từ mã phiếu xuất
    public HashMap<Integer, ArrayList<ChiTietSanPhamDTO>> getChiTietSanPhamFromMaPX(int maphieuxuat) {
        ArrayList<ChiTietSanPhamDTO> chitietsp = ctspDAO.selectAllByMaPhieuXuat(maphieuxuat);
        HashMap<Integer, ArrayList<ChiTietSanPhamDTO>> result = new HashMap<>();
        for (ChiTietSanPhamDTO i : chitietsp) {
            result.computeIfAbsent(i.getMaSanPham(), k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    // Hiển thị thông tin chi tiết sản phẩm (console debug)
    public void Show(ArrayList<ChiTietSanPhamDTO> x) {
        for (ChiTietSanPhamDTO a : x) {
            System.out.println("Mã sản phẩm: " + a.getMaSanPham() + ", Chip: " + a.getChip() +
                               ", Ram: " + a.getRam() + ", Rom: " + a.getRom() +
                               ", Inch: " + a.getInch() + ", Dung Lượng Pin: " + a.getDungLuongPin() +
                               ", Màu Sắc: " + a.getMauSac());
        }
    }

    // Lọc chi tiết sản phẩm theo chip, ram, rom
    public ArrayList<ChiTietSanPhamDTO> FilterAll(String text, int masp, String chip, String ram, String rom) {
        ArrayList<ChiTietSanPhamDTO> list = this.getAllCTSPbyMasp(masp);
        ArrayList<ChiTietSanPhamDTO> result = new ArrayList<>();
        for (ChiTietSanPhamDTO i : list) {
            if (i.getChip().contains(chip) && i.getRam().contains(ram) && i.getRom().contains(rom)) {
                result.add(i);
            }
        }
        return result;
    }

    // Lấy chi tiết sản phẩm từ mã phiếu xuất
    public ArrayList<ChiTietSanPhamDTO> selectAllByMaPhieuXuat(int maphieu) {
        return ctspDAO.selectAllByMaPhieuXuat(maphieu);
    }
}
