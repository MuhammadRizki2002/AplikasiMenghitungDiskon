
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus0
 */
public class PerhitunganDiskonFrame extends javax.swing.JFrame {

    /**
     * Creates new form AplikasiPerhitunganDiskon
     */
    public PerhitunganDiskonFrame() {
        initComponents();
        diskonComboBox.addItem("10%");
        diskonComboBox.addItem("20%");
        diskonComboBox.addItem("30%");
        diskonComboBox.addItem("40%");
        diskonComboBox.addItem("50%");
         diskonSlider.addChangeListener(e -> {
        int diskonPersen = diskonSlider.getValue();
        diskonLabel.setText("Diskon: " + diskonPersen + "%");
    });
          diskonComboBox.addItemListener(e -> {
        if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            String diskonText = (String) diskonComboBox.getSelectedItem();
            int diskonPersen = Integer.parseInt(diskonText.replace("%", ""));
            diskonSlider.setValue(diskonPersen); // Sinkronisasi JSlider dengan ComboBox
            calculateDiscount(); // Panggil metode perhitungan diskon otomatis
        }
    });

    // Tambahkan ChangeListener untuk JSlider
    diskonSlider.addChangeListener(e -> {
        int diskonPersen = diskonSlider.getValue();
        diskonLabel.setText("Diskon: " + diskonPersen + "%"); // Perbarui label diskon
        diskonComboBox.setSelectedItem(diskonPersen + "%"); // Sinkronisasi ComboBox dengan JSlider
        calculateDiscount(); // Panggil metode perhitungan diskon otomatis
    });
    }
    
    private void calculateDiscount() {
    try {
        // Ambil nilai harga asli dari JTextField
        double hargaAsli = Double.parseDouble(hargaAsliField.getText());

        // Ambil persentase diskon dari JSlider (atau ComboBox jika diperlukan)
        int diskonPersen = diskonSlider.getValue();

        // Hitung harga setelah diskon pertama
        double jumlahDiskonPertama = hargaAsli * diskonPersen / 100;
        double hargaSetelahDiskonPertama = hargaAsli - jumlahDiskonPertama;

        // Periksa apakah ada kode voucher tambahan
        String kodeKupon = kodeKuponField.getText();
        double jumlahDiskonKedua = 0;
        double hargaSetelahDiskonKedua = hargaSetelahDiskonPertama;

        // Terapkan diskon tambahan jika kode voucher valid
        if (kodeKupon.equalsIgnoreCase("DISKON10")) {
            int diskonVoucherPersen = 10; // Misalnya, kode voucher memberikan diskon 10%
            jumlahDiskonKedua = hargaSetelahDiskonPertama * diskonVoucherPersen / 100;
            hargaSetelahDiskonKedua = hargaSetelahDiskonPertama - jumlahDiskonKedua;
        }

        // Tampilkan hasil di JLabel
        hasilLabel.setText("Harga Akhir: Rp " + hargaSetelahDiskonKedua);
        penghematanLabel.setText("Penghematan: Rp " + (jumlahDiskonPertama + jumlahDiskonKedua));

        // Tambahkan hasil perhitungan ke riwayatTextArea
        riwayatTextArea.append("Harga Asli: Rp " + hargaAsli +
                               ", Diskon: " + diskonPersen + "%" +
                               ", Diskon Kupon: " + (kodeKupon.equalsIgnoreCase("DISKON10") ? "10%" : "0%") +
                               ", Harga Akhir: Rp " + hargaSetelahDiskonKedua +
                               ", Penghematan: Rp " + (jumlahDiskonPertama + jumlahDiskonKedua) + "\n");

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Masukkan harga asli yang valid", "Error", JOptionPane.ERROR_MESSAGE);
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
        diskonLabel = new javax.swing.JLabel();
        hargaAsliField = new javax.swing.JTextField();
        diskonComboBox = new javax.swing.JComboBox<>();
        hitungButton = new javax.swing.JButton();
        hasilLabel = new javax.swing.JLabel();
        penghematanLabel = new javax.swing.JLabel();
        diskonSlider = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        riwayatTextArea = new javax.swing.JTextArea();
        kodeKuponField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aplikasi Mehitung Diskon", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 36))); // NOI18N

        jLabel1.setText("Harga Asli");

        diskonLabel.setText("Harga Diskon");

        diskonComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Diskon" }));
        diskonComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                diskonComboBoxItemStateChanged(evt);
            }
        });
        diskonComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                diskonComboBoxPropertyChange(evt);
            }
        });

        hitungButton.setBackground(java.awt.SystemColor.activeCaption);
        hitungButton.setText("Hitung");
        hitungButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungButtonActionPerformed(evt);
            }
        });

        hasilLabel.setText("Hasil");

        penghematanLabel.setText("Hemat");

        diskonSlider.setMajorTickSpacing(10);
        diskonSlider.setMaximum(50);
        diskonSlider.setPaintLabels(true);
        diskonSlider.setPaintTicks(true);

        riwayatTextArea.setBackground(new java.awt.Color(153, 0, 0));
        riwayatTextArea.setColumns(20);
        riwayatTextArea.setRows(5);
        jScrollPane1.setViewportView(riwayatTextArea);

        kodeKuponField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeKuponFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Masukan Kode Kupon");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(penghematanLabel)
                        .addGap(51, 51, 51)
                        .addComponent(hasilLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diskonLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(32, 32, 32)
                                        .addComponent(hargaAsliField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(diskonSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hitungButton)
                                        .addGap(71, 71, 71)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kodeKuponField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(diskonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hitungButton)
                            .addComponent(diskonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(hargaAsliField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kodeKuponField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(19, 19, 19)
                        .addComponent(diskonSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diskonLabel)
                    .addComponent(penghematanLabel)
                    .addComponent(hasilLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hitungButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungButtonActionPerformed
         try {
        // Ambil nilai harga asli dari JTextField
        double hargaAsli = Double.parseDouble(hargaAsliField.getText());

        // Ambil persentase diskon dari JSlider atau JComboBox
        int diskonPersen = diskonSlider.getValue(); // Atau dari diskonComboBox jika Anda menggunakan ComboBox

        // Hitung harga setelah diskon pertama
        double jumlahDiskonPertama = hargaAsli * diskonPersen / 100;
        double hargaSetelahDiskonPertama = hargaAsli - jumlahDiskonPertama;

        // Periksa apakah ada kode voucher tambahan
        String kodeKupon = kodeKuponField.getText();
        double jumlahDiskonKedua = 0;
        double hargaSetelahDiskonKedua = hargaSetelahDiskonPertama;

        // Terapkan diskon tambahan jika kode voucher valid
        if (kodeKupon.equalsIgnoreCase("DISKON10")) {
            int diskonVoucherPersen = 10; // Misalnya, kode voucher memberikan diskon 10%
            jumlahDiskonKedua = hargaSetelahDiskonPertama * diskonVoucherPersen / 100;
            hargaSetelahDiskonKedua = hargaSetelahDiskonPertama - jumlahDiskonKedua;
        }

        // Tampilkan hasil di JLabel
        hasilLabel.setText("Harga Akhir: Rp " + hargaSetelahDiskonKedua);
        penghematanLabel.setText("Penghematan: Rp " + (jumlahDiskonPertama + jumlahDiskonKedua));

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Masukkan harga asli yang valid", "Error", JOptionPane.ERROR_MESSAGE);
    }

        
    }//GEN-LAST:event_hitungButtonActionPerformed

    private void kodeKuponFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeKuponFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeKuponFieldActionPerformed

    private void diskonComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_diskonComboBoxPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_diskonComboBoxPropertyChange

    private void diskonComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_diskonComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_diskonComboBoxItemStateChanged

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
            java.util.logging.Logger.getLogger(PerhitunganDiskonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerhitunganDiskonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerhitunganDiskonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerhitunganDiskonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerhitunganDiskonFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> diskonComboBox;
    private javax.swing.JLabel diskonLabel;
    private javax.swing.JSlider diskonSlider;
    private javax.swing.JTextField hargaAsliField;
    private javax.swing.JLabel hasilLabel;
    private javax.swing.JButton hitungButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kodeKuponField;
    private javax.swing.JLabel penghematanLabel;
    private javax.swing.JTextArea riwayatTextArea;
    // End of variables declaration//GEN-END:variables
}