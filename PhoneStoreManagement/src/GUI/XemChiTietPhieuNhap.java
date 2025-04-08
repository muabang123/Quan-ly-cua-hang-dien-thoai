/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import BUS.SanPhamBUS;
import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import DTO.SanPhamDTO;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author minhminh
 */
public class XemChiTietPhieuNhap extends javax.swing.JFrame {

    /**
     * Creates new form XemChiTietPhieuNhap
     */
    public XemChiTietPhieuNhap() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    public void setPhieuNhapInfo(String maPhieu, String tenNV, String tenNCC, String ngayNhap) {
    jTextField1.setText(maPhieu);
    jTextField2.setText(tenNV);
    jTextField3.setText(tenNCC);

    try {
        // Chuyển từ String thành Date
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy/MM/dd");  // Định dạng chuỗi ngày từ cơ sở dữ liệu
        Date parsedDate = originalFormat.parse(ngayNhap);

        // Định dạng lại Date để chỉ hiển thị ngày (không có giờ)
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = sdf.format(parsedDate);

        // Hiển thị lên jTextField4
        jTextField4.setText(formattedDate);
    } catch (ParseException e) {
        jTextField4.setText("");  // Xử lý lỗi nếu ngày không hợp lệ
    }
}




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Thông Tin Phiếu Nhập");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(382, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(385, 385, 385))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Mã Phiếu");

        jTextField1.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Nhân Viên Nhập");

        jTextField2.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Nhà Cung Cấp");

        jTextField3.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Thời Gian Tạo");

        jTextField4.setEditable(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số lượng", "RAM", "ROM", "Màu Sắc", "Đơn Giá"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Xuất File PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(438, 438, 438)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    try {
        Document document = new Document();
        String maPhieuNhap = jTextField1.getText().trim();
        String fileName = "PhieuNhap_" + maPhieuNhap + ".pdf";

        FileOutputStream fos = new FileOutputStream(fileName);
        PdfWriter writer = PdfWriter.getInstance(document, fos);
        document.open();
        String fontPath = "lib\\TimesNewRoman\\SVN-Times New Roman.ttf";  
        BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font timesNewRomanFont = new Font(baseFont, 12);
        Paragraph title = new Paragraph("Hệ thống quản lý điện thoại\n", new Font(baseFont, 16, Font.BOLD));
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String currentDate = sdf.format(new Date());
        Paragraph dateParagraph = new Paragraph("Thời gian in phiếu: " + currentDate, new Font(baseFont, 12));
        dateParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(dateParagraph);
        Paragraph infoTitle = new Paragraph("THÔNG TIN PHIẾU NHẬP", new Font(baseFont, 14, Font.BOLD));
        infoTitle.setSpacingBefore(10);
        document.add(infoTitle);
        document.add(new Paragraph("Mã phiếu: " + jTextField1.getText(), timesNewRomanFont));
        document.add(new Paragraph("Nhà cung cấp: " + jTextField3.getText(), timesNewRomanFont));
        document.add(new Paragraph("Người thực hiện: " + jTextField2.getText(), timesNewRomanFont));
        document.add(new Paragraph("Thời gian nhập: " + jTextField4.getText(), timesNewRomanFont));
        document.add(new Paragraph("\n"));
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100);
        table.addCell(new Phrase("STT", timesNewRomanFont));
        table.addCell(new Phrase("Mã SP", timesNewRomanFont));
        table.addCell(new Phrase("Tên SP", timesNewRomanFont));
        table.addCell(new Phrase("RAM", timesNewRomanFont));
        table.addCell(new Phrase("ROM", timesNewRomanFont));
        table.addCell(new Phrase("Màu sắc", timesNewRomanFont));
        table.addCell(new Phrase("Đơn giá", timesNewRomanFont));
        table.addCell(new Phrase("Số lượng", timesNewRomanFont));
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            table.addCell(new Phrase(String.valueOf(i + 1), timesNewRomanFont)); // STT
            table.addCell(new Phrase(model.getValueAt(i, 1).toString(), timesNewRomanFont)); // Mã SP
            table.addCell(new Phrase(model.getValueAt(i, 2).toString(), timesNewRomanFont)); // Tên SP
            table.addCell(new Phrase(model.getValueAt(i, 3).toString(), timesNewRomanFont)); // RAM
            table.addCell(new Phrase(model.getValueAt(i, 4).toString(), timesNewRomanFont)); // ROM
            table.addCell(new Phrase(model.getValueAt(i, 5).toString(), timesNewRomanFont)); // Màu sắc
            table.addCell(new Phrase(model.getValueAt(i, 6).toString(), timesNewRomanFont)); // Đơn giá
            table.addCell(new Phrase(model.getValueAt(i, 7).toString(), timesNewRomanFont)); // Số lượng
        }

        document.add(table);
        Paragraph signParagraph = new Paragraph("\n\nNgười lập phiếu                              Nhân viên nhận                              Nhà cung cấp\n" +
        "         (Ký và ghi rõ họ tên)                       (Ký và ghi rõ họ tên)                     (Ký và ghi rõ họ tên)", timesNewRomanFont);
        signParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(signParagraph);
        document.close();
        JOptionPane.showMessageDialog(this, "Xuất file PDF thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    } catch (DocumentException | HeadlessException | IOException e) {
        JOptionPane.showMessageDialog(this, "Có lỗi khi xuất file PDF.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField4ActionPerformed
    
    public void loadChiTietPhieuNhap(String maPhieuNhap) {
    ChiTietPhieuNhapDAO dao = ChiTietPhieuNhapDAO.getInstance();
    SanPhamBUS sanPhamBUS = new SanPhamBUS();
    DecimalFormat df = new DecimalFormat("#,##0");

    ArrayList<ChiTietPhieuNhapDTO> list = dao.selectAll(maPhieuNhap);
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // clear bảng

    int stt = 1;
    for (ChiTietPhieuNhapDTO ct : list) {
        String tenSP = "";
        SanPhamDTO sp = sanPhamBUS.getByMaSP(ct.getMaSanPham());
        if (sp != null) {
            tenSP = sp.getTenSanPham();
        }

        String donGiaFormatted = df.format(ct.getDonGia());

        model.addRow(new Object[]{
            stt++,
            ct.getMaSanPham(),
            tenSP,
            ct.getRam(),
            ct.getRom(),
            ct.getMauSac(),
            donGiaFormatted,
            ct.getSoLuong()
        });
    }
    jTable1.setDefaultEditor(Object.class, null);
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(XemChiTietPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XemChiTietPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XemChiTietPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XemChiTietPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XemChiTietPhieuNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
