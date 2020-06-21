package cl.inacap.bibliotecaApp.vista;
import cl.inacap.bilbiotecaApp.controlador.ControladorDistribuidor;
import javax.swing.JOptionPane;

public class Factura extends javax.swing.JFrame{
    public Factura() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtDistribuidor = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnNuevo = new javax.swing.JButton();
        btnBack = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        txtFechaCompra = new javax.swing.JTextField();
        txtHoraCompra = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtMetodoPago = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        txtPrecioNeto = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtPrecioIva = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        txtFolioFactura = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD - JAVA - PATRON DE DISEÑO MVC");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(11, 0, 32));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDistribuidor.setBackground(new java.awt.Color(11, 0, 32));
        txtDistribuidor.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtDistribuidor.setForeground(new java.awt.Color(255, 255, 255));
        txtDistribuidor.setBorder(null);
        jPanel4.add(txtDistribuidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 320, 30));

        jLabel18.setBackground(new java.awt.Color(102, 102, 102));
        jLabel18.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Fecha de compra");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 160, 20));

        jLabel20.setBackground(new java.awt.Color(102, 102, 102));
        jLabel20.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Distribuidor");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        jLabel11.setBackground(new java.awt.Color(11, 0, 32));
        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Factura");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jLabel13.setBackground(new java.awt.Color(102, 102, 102));
        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ingrese los datos perteneciente al libro");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 640, 120, -1));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 320, 10));

        btnNuevo.setText("Limpiar textos");
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
        });
        jPanel4.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, 120, -1));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });
        jPanel4.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel24.setBackground(new java.awt.Color(102, 102, 102));
        jLabel24.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Folio");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        txtIva.setBackground(new java.awt.Color(11, 0, 32));
        txtIva.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtIva.setForeground(new java.awt.Color(255, 255, 255));
        txtIva.setBorder(null);
        jPanel4.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 150, 30));
        jPanel4.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 150, 10));

        jLabel26.setBackground(new java.awt.Color(102, 102, 102));
        jLabel26.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Costo IVA");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));
        jPanel4.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 150, 10));

        txtFechaCompra.setBackground(new java.awt.Color(11, 0, 32));
        txtFechaCompra.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtFechaCompra.setForeground(new java.awt.Color(255, 255, 255));
        txtFechaCompra.setBorder(null);
        jPanel4.add(txtFechaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 150, 30));

        txtHoraCompra.setBackground(new java.awt.Color(11, 0, 32));
        txtHoraCompra.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtHoraCompra.setForeground(new java.awt.Color(255, 255, 255));
        txtHoraCompra.setBorder(null);
        jPanel4.add(txtHoraCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 150, 30));
        jPanel4.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 150, 10));

        jLabel27.setBackground(new java.awt.Color(102, 102, 102));
        jLabel27.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Hora de compra");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, -1, -1));

        jLabel29.setBackground(new java.awt.Color(102, 102, 102));
        jLabel29.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Metodo de pago");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 170, 20));

        txtMetodoPago.setBackground(new java.awt.Color(11, 0, 32));
        txtMetodoPago.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtMetodoPago.setForeground(new java.awt.Color(255, 255, 255));
        txtMetodoPago.setBorder(null);
        jPanel4.add(txtMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 150, 30));
        jPanel4.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, 150, 10));

        txtPrecioNeto.setBackground(new java.awt.Color(11, 0, 32));
        txtPrecioNeto.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtPrecioNeto.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecioNeto.setBorder(null);
        jPanel4.add(txtPrecioNeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 150, 30));

        jLabel28.setBackground(new java.awt.Color(102, 102, 102));
        jLabel28.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Precio neto");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        jLabel17.setBackground(new java.awt.Color(102, 102, 102));
        jLabel17.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Precio con IVA");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        txtPrecioIva.setBackground(new java.awt.Color(11, 0, 32));
        txtPrecioIva.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtPrecioIva.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecioIva.setBorder(null);
        jPanel4.add(txtPrecioIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 150, 30));
        jPanel4.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 150, 10));
        jPanel4.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 150, 10));
        jPanel4.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 320, 10));

        txtFolioFactura.setBackground(new java.awt.Color(11, 0, 32));
        txtFolioFactura.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtFolioFactura.setForeground(new java.awt.Color(255, 255, 255));
        txtFolioFactura.setBorder(null);
        jPanel4.add(txtFolioFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 320, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 730));

        btnDelete.setText("Eliminar");
        jPanel3.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 320, 40));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel3.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 150, 100, 40));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 100, 40));

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });
        jPanel3.add(btnListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 100, 40));

        tabla = new javax.swing.JTable(){
            public boolean isCellEditable(int fila,int col){
                return false;
            }
        };
        tabla.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FOLIO", "PRECIO NETO", "PRECIO CON IVA", "COSTO IVA", "FECHA", "HORA", "DISTRIBUIDOR", "METODO DE PAGO"
            }
        ));
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabla.setFocusable(false);
        tabla.setRowMargin(4);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tabla);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 720, 213));

        jLabel21.setBackground(new java.awt.Color(11, 0, 32));
        jLabel21.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(11, 0, 32));
        jLabel21.setText("Tabla de factura");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtDistribuidor.getText().isEmpty() || txtFechaCompra.getText().isEmpty() || txtFolioFactura.getText().isEmpty() || txtIva.getText().isEmpty() || txtMetodoPago.getText().isEmpty() ||
                txtPrecioIva.getText().isEmpty() || txtPrecioNeto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Los campos no deben estar vacios");
        };
    }//GEN-LAST:event_btnAgregarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnAgregar;
    private javax.swing.JLabel btnBack;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnListar;
    public javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    public javax.swing.JTable tabla;
    public javax.swing.JTextField txtDistribuidor;
    public javax.swing.JTextField txtFechaCompra;
    public javax.swing.JTextField txtFolioFactura;
    public javax.swing.JTextField txtHoraCompra;
    public javax.swing.JTextField txtIva;
    public javax.swing.JTextField txtMetodoPago;
    public javax.swing.JTextField txtPrecioIva;
    public javax.swing.JTextField txtPrecioNeto;
    // End of variables declaration//GEN-END:variables
}
