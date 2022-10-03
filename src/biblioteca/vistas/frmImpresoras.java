package biblioteca.vistas;

import biblioteca.modelo.administracion.conexion;
import biblioteca.modelo.administracion.controllerImpresora;
import biblioteca.modelo.entidades.Area;
import biblioteca.modelo.entidades.Impresora;
import biblioteca.modelo.entidades.Marca;
import biblioteca.modelo.entidades.TipoImpresora;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmImpresoras extends javax.swing.JFrame {

    DefaultTableModel modelo;
    controllerImpresora cImpresora;

    public frmImpresoras() {
        initComponents();
        cImpresora = new controllerImpresora();
        modelo = (DefaultTableModel) tblimpresora.getModel();
        listar();
        
        Marca marca = new Marca();
        DefaultComboBoxModel modeloMarca = new DefaultComboBoxModel(marca.mostrarMarca());
        cbomarca.setModel(modeloMarca);
        
        Area area = new Area();
        DefaultComboBoxModel modeloArea = new DefaultComboBoxModel(area.mostrarArea());
        cboarea.setModel(modeloArea);
        
        TipoImpresora tipo = new TipoImpresora();
        DefaultComboBoxModel modeloTipo = new DefaultComboBoxModel(tipo.mostrarTipo());
        cbotipoimpresora.setModel(modeloTipo);
        
      
        

    }

    public void listar() {
        ArrayList<Impresora> listaImpresora = new ArrayList<>();
        listaImpresora = cImpresora.consulta();
        System.out.println("tamanio lista: "+listaImpresora.size());
        Object ob[] = new Object[7];
        for (int i = 0; i < listaImpresora.size(); i++) {
           
                ob[0] = listaImpresora.get(i).getId_impresora();
                ob[1] = listaImpresora.get(i).getNumero_serie();
                ob[2] = listaImpresora.get(i).getId_marca_impresora();
                ob[3] = listaImpresora.get(i).getId_area();
                ob[4] = listaImpresora.get(i).getId_tipo_impresora();
                ob[5] = listaImpresora.get(i).getBandera();
                ob[6] = listaImpresora.get(i).getDescripcion_imp();
                //ob[4] = listaImpresora.get(i).getDescripcion_imp();
                modelo.addRow(ob);
            

        }

    }

    //LIMPIAR TABLA
    public void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) { //siempre va a eliminar la fila cero
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtserie = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        cbomarca = new javax.swing.JComboBox<>();
        cboarea = new javax.swing.JComboBox<>();
        cbotipoimpresora = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btninsertar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblimpresora = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Impresora"));

        jLabel5.setText("Area:");

        jLabel6.setText("Serie:");

        jLabel8.setText("Marca:");

        jLabel7.setText("ID:");

        lblid.setText("NULL");

        jLabel3.setText("Tipo Impresora:");

        jLabel10.setText("Descripcion:");

        cbomarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbomarcaActionPerformed(evt);
            }
        });

        cboarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboareaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbotipoimpresora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtserie, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbomarca, 0, 124, Short.MAX_VALUE)
                            .addComponent(cboarea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbomarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbotipoimpresora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("IMPRESORAS");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btninsertar.setText("Insertar");
        btninsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertarActionPerformed(evt);
            }
        });

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(btnmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(btninsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btninsertar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnmodificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btneliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnlimpiar.setText("Limpiar campos");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        tblimpresora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Serie", "Marca", "Area", "Tipo Imp", "Tipo Impre", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblimpresora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblimpresoraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblimpresora);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addComponent(jLabel4))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Datos Impresora");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btninsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertarActionPerformed
        Marca marca=(Marca) cbomarca.getSelectedItem();
        Area area=(Area) cboarea.getSelectedItem();
        TipoImpresora tipo=(TipoImpresora) cbotipoimpresora.getSelectedItem();
        
        String serie = txtserie.getText();
        String marcacb = String.valueOf(marca.getId_marca_impresora()); 
        String areacb = String.valueOf(area.getId_area());
        String tipoimp= String.valueOf(tipo.getId_tipo_impresora());
        //String bandera= txttipoimpre.getText();
        String descripcion = txtdescripcion.getText();
        
        System.out.println("llego aqui_1");
        Impresora imp = new Impresora();
        imp.setNumero_serie(serie);
        imp.setId_marca_impresora(marcacb);
        imp.setId_area(areacb);
        imp.setId_tipo_impresora(tipoimp);
        //imp.setBandera(bandera);
        imp.setDescripcion_imp(descripcion);
        cImpresora.insertar(imp);
        System.out.println("llego aqui_2");
        limpiarTabla();
        listar();

    }//GEN-LAST:event_btninsertarActionPerformed


    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
       Marca marca=(Marca) cbomarca.getSelectedItem();
        System.out.println("marca id: "+marca.getId_marca_impresora());
        
        /* int idimpresora = Integer.parseInt(lblid.getText().toString());
        String serie = txtserie.getText();
        String marca =txtmarca.getText(); 
        String area =txtarea.getText();
        String tipoimp=txttipoimp.getText();
        //String bandera=txttipoimpre.getText();
        String descripcion = txtdescripcion.getText();

        Impresora imp = new Impresora();
        imp.setNumero_serie(serie);
        imp.setId_marca_impresora(marca);
        imp.setId_area(area);
        imp.setId_tipo_impresora(tipoimp);
        //imp.setBandera(bandera);
        imp.setDescripcion_imp(descripcion);
        imp.setId_impresora(idimpresora);
        
        System.out.println("id impresora: "+idimpresora);
        cImpresora.actualizar(imp);
        
        
        limpiarTabla();
        listar();*/
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        int id=Integer.parseInt(lblid.getText().toString());
        cImpresora.eliminar(id);
        limpiarTabla();
        listar();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed

        lblid.setText("NULL");
        txtserie.setText("");
        /*txtarea.setText("");
        txtmarca.setText("");
        txttipoimp.setText("");
        txttipoimpre.setText("");*/
        txtdescripcion.setText("");
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void tblimpresoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblimpresoraMouseClicked
        Marca marca=(Marca) cbomarca.getSelectedItem();
        Area area=(Area) cboarea.getSelectedItem();
        TipoImpresora tipo=(TipoImpresora) cbotipoimpresora.getSelectedItem();
        
        int fila = tblimpresora.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        } else {
            int idimpresora = Integer.parseInt(tblimpresora.getValueAt(fila, 0).toString());
            String serie = tblimpresora.getValueAt(fila, 1).toString();
            String marcas = tblimpresora.getValueAt(fila, 2).toString();
            String areas = tblimpresora.getValueAt(fila, 3).toString();
            String tipoimp = tblimpresora.getValueAt(fila, 4).toString();
            String bandera = tblimpresora.getValueAt(fila, 5).toString();
            String descripcion = tblimpresora.getValueAt(fila, 6).toString();
            
        lblid.setText(String.valueOf(idimpresora).toString());
        txtserie.setText(serie);
        
        if(marcas.equals("epson")){
            cbomarca.setSelectedIndex(1);
        }else{
           cbomarca.setSelectedIndex(2); 
        }
        
        if(areas.equals("recursos humanos")){
            cboarea.setSelectedIndex(1);
        
        }
        if(("laser - color").equals(tipoimp+" - "+bandera)){
            cbotipoimpresora.setSelectedIndex(1);
        }else{
            cbotipoimpresora.setSelectedIndex(2);
        }
        
        cboarea.setSelectedItem(areas);
        cbotipoimpresora.setSelectedItem(tipoimp+" - "+bandera);
        /*txtmarca.setText(marca);
        txtarea.setText(area);
        txttipoimp.setText(tipoimp);
        txttipoimpre.setText(bandera);*/
        txtdescripcion.setText(descripcion);
          

        }
    }//GEN-LAST:event_tblimpresoraMouseClicked

    private void cbomarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbomarcaActionPerformed
            
    }//GEN-LAST:event_cbomarcaActionPerformed

    private void cboareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboareaActionPerformed

   

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
            java.util.logging.Logger.getLogger(frmImpresoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmImpresoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmImpresoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmImpresoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmImpresoras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btninsertar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JComboBox<String> cboarea;
    private javax.swing.JComboBox<String> cbomarca;
    private javax.swing.JComboBox<String> cbotipoimpresora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblid;
    private javax.swing.JTable tblimpresora;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtserie;
    // End of variables declaration//GEN-END:variables
}
