package BUS;

import DAO.ChiTietSanPhamDAO;
import DTO.ChiTietSanPhamDTO;
import java.util.ArrayList;
import java.util.HashMap;

public class ChiTietSanPhamBUS {

    private final ChiTietSanPhamDAO ctspDAO = new ChiTietSanPhamDAO();
    public ArrayList<ChiTietSanPhamDTO> listctsp = new ArrayList<>();

    public ChiTietSanPhamBUS() {
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
            if (result.get(i.getMaSanPham()) == null) {
                result.put(i.getMaSanPham(), new ArrayList<>());
            }
        }
        for (ChiTietSanPhamDTO i : chitietsp) {
            result.get(i.getMaSanPham()).add(i);
        }
        return result;
    }

    // Lấy chi tiết sản phẩm từ mã phiếu xuất
    public HashMap<Integer, ArrayList<ChiTietSanPhamDTO>> getChiTietSanPhamFromMaPX(int maphieuxuat) {
        ArrayList<ChiTietSanPhamDTO> chitietsp = ctspDAO.selectAllByMaPhieuXuat(maphieuxuat);
        HashMap<Integer, ArrayList<ChiTietSanPhamDTO>> result = new HashMap<>();
        for (ChiTietSanPhamDTO i : chitietsp) {
            if (result.get(i.getMaSanPham()) == null) {
                result.put(i.getMaSanPham(), new ArrayList<>());
            }
        }
        for (ChiTietSanPhamDTO i : chitietsp) {
            result.get(i.getMaSanPham()).add(i);
        }
        return result;
    }

    // Hiển thị thông tin chi tiết sản phẩm
    public void Show(ArrayList<ChiTietSanPhamDTO> x) {
        for (ChiTietSanPhamDTO a : x) {
            System.out.println("Mã sản phẩm: " + a.getMaSanPham() + ", Chip: " + a.getChip() +
                               ", Ram: " + a.getRam() + ", Rom: " + a.getRom() +
                               ", Inch: " + a.getInch() + ", Dung Lượng Pin: " + a.getDungLuongPin() +
                               ", Màu Sắc: " + a.getMauSac());
        }
    }

    // Cập nhật thông tin chi tiết sản phẩm khi xuất hàng
//    public void updateXuat(ArrayList<ChiTietSanPhamDTO> ct) {
//        for (ChiTietSanPhamDTO chiTietSanPhamDTO : ct) {
//            ctspDAO.updateXuat(chiTietSanPhamDTO);
//        }
//    }

    // Lấy tất cả chi tiết sản phẩm từ mã phiếu xuất
    public ArrayList<ChiTietSanPhamDTO> selectAllByMaPhieuXuat(int maphieu) {
        return ctspDAO.selectAllByMaPhieuXuat(maphieu);
    }

    // Bộ lọc theo chip, ram và các thông tin khác
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
}
