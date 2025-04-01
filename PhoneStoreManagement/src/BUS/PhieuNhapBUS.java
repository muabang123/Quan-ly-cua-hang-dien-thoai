package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PhieuNhapBUS {

    private final PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO();
    private ArrayList<PhieuNhapDTO> listPhieuNhap;

    public PhieuNhapBUS() {
        listPhieuNhap = new ArrayList<>();
    }

    public ArrayList<PhieuNhapDTO> getAll() {
        this.listPhieuNhap = phieuNhapDAO.selectAll();
        return this.listPhieuNhap;
    }

    public ArrayList<PhieuNhapDTO> getAllList() {
        return this.listPhieuNhap;
    }

    public boolean add(PhieuNhapDTO phieu) {
        return phieuNhapDAO.insert(phieu) != 0;
    }

    public boolean update(PhieuNhapDTO phieu) {
        return phieuNhapDAO.update(phieu) != 0;
    }

    public boolean delete(String maPhieuNhap) {
        return phieuNhapDAO.delete(maPhieuNhap) != 0;
    }

    public PhieuNhapDTO getById(String maPhieuNhap) {
        return phieuNhapDAO.selectById(maPhieuNhap);
    }

    public int getNextId() {
        return phieuNhapDAO.getAutoIncrement();
    }

    public ArrayList<PhieuNhapDTO> filterPhieuNhap(int maNhaCungCap, int maNhanVien, Date startDate, Date endDate, String minPrice, String maxPrice) {
        long min = !minPrice.isEmpty() ? Long.parseLong(minPrice) : 0L;
        long max = !maxPrice.isEmpty() ? Long.parseLong(maxPrice) : Long.MAX_VALUE;

        Timestamp start = new Timestamp(startDate.getTime());

        Calendar cal = Calendar.getInstance();
        cal.setTime(endDate);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Timestamp end = new Timestamp(cal.getTimeInMillis());

        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        for (PhieuNhapDTO phieu : getAllList()) {
            boolean match =
                    (maNhanVien == 0 || phieu.getMaNhanVien() == maNhanVien) &&
                    (maNhaCungCap == 0 || phieu.getMaNhaCungCap() == maNhaCungCap) &&
                    (phieu.getNgayNhap().compareTo(start) >= 0) &&
                    (phieu.getNgayNhap().compareTo(end) <= 0) &&
                    (phieu.getTongTien() >= min && phieu.getTongTien() <= max);

            if (match) {
                result.add(phieu);
            }
        }
        return result;
    }
}
