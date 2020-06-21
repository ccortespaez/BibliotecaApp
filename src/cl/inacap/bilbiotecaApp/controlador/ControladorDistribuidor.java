package cl.inacap.bilbiotecaApp.controlador;

import cl.inacap.bibliotecaApp.modelo.Distribuidor;
import cl.inacap.bibliotecaApp.modelo.DistribuidorDAO;
import cl.inacap.bibliotecaApp.vista.DistribuidorVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ControladorDistribuidor implements ActionListener {

    DistribuidorDAO dao = new DistribuidorDAO();
    Distribuidor d = new Distribuidor();
    DistribuidorVista distribuidorVista = new DistribuidorVista();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorDistribuidor(DistribuidorVista d) {
        this.distribuidorVista = d;
        this.distribuidorVista.btnListar.addActionListener(this);
        this.distribuidorVista.btnAgregar.addActionListener(this);
        this.distribuidorVista.btnEditar.addActionListener(this);
        this.distribuidorVista.btnDelete.addActionListener(this);
        this.distribuidorVista.btnActualizar.addActionListener(this);
        this.distribuidorVista.btnNuevo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == distribuidorVista.btnListar) {
            limpiarTabla();
            listar(distribuidorVista.tabla);
            nuevo();
        }
        if (e.getSource() == distribuidorVista.btnAgregar) {
            add();
            listar(distribuidorVista.tabla);
            nuevo();
        }
        if (e.getSource() == distribuidorVista.btnEditar) {
            int fila = distribuidorVista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(distribuidorVista, "Debe seleccionar una fila");
            } else {
                
                String nombre = (String) distribuidorVista.tabla.getValueAt(fila, 0);
                String direccion = (String) distribuidorVista.tabla.getValueAt(fila, 1);
                int tel = Integer.parseInt((String) distribuidorVista.tabla.getValueAt(fila, 2).toString());
                int rut = Integer.parseInt((String) distribuidorVista.tabla.getValueAt(fila, 3).toString());
                int anioVenta = Integer.parseInt((String)distribuidorVista.tabla.getValueAt(fila, 4).toString());
                distribuidorVista.txtNom.setText(nombre);
                distribuidorVista.txtDireccion.setText(direccion);
                distribuidorVista.txtTel.setText(""+tel);
                distribuidorVista.txtRut.setText(""+rut);
                distribuidorVista.txtAnio.setText(""+anioVenta);
            }
        }
        if (e.getSource() == distribuidorVista.btnActualizar) {
            actualizar();
            listar(distribuidorVista.tabla);
            nuevo();

        }
        if (e.getSource() == distribuidorVista.btnDelete) {
            delete();
            listar(distribuidorVista.tabla);
            nuevo();
        }
        if (e.getSource() == distribuidorVista.btnNuevo) {
            nuevo();
        }

    }

    void nuevo() {
        distribuidorVista.txtRut.setText("");
        distribuidorVista.txtNom.setText("");
        distribuidorVista.txtTel.setText("");
        distribuidorVista.txtDireccion.setText("");
        distribuidorVista.txtAnio.setText("");
        distribuidorVista.txtNom.requestFocus();
    }

    public void delete() {
        int fila = distribuidorVista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(distribuidorVista, "Debe seleccionar una fila");
        } else {
            int rut = Integer.parseInt((String) distribuidorVista.tabla.getValueAt(fila, 3).toString());
            dao.Delete(rut);
            System.out.println("El rut es" + rut);
            JOptionPane.showMessageDialog(distribuidorVista, "El distribuidor ha sido eliminado!!!");
        }
        limpiarTabla();
    }

    public void add() {
        String nombre = distribuidorVista.txtNom.getText().trim();
        String direccion = distribuidorVista.txtDireccion.getText().trim();
        int tel = Integer.parseInt(distribuidorVista.txtTel.getText().toString().trim());
        int rut = Integer.parseInt(distribuidorVista.txtRut.getText().toString().trim());
        int anioVenta = Integer.parseInt(distribuidorVista.txtAnio.getText().toString().trim());
        
        d.setNombreEmpresa(nombre);
        d.setDireccion(direccion);
        d.setTelefono(tel);
        d.setRutDistribuidor(rut);
        d.setAnioVenta(anioVenta);
       
        int r = dao.agregar(d);
        if (r == 1) {
            JOptionPane.showMessageDialog(distribuidorVista, "Distribuidor agregado");
        } else {
            JOptionPane.showMessageDialog(distribuidorVista, "Error al agregar");
        }
        limpiarTabla();
    }

    public void actualizar() {
        if (distribuidorVista.txtRut.getText().equals("")) {
            JOptionPane.showMessageDialog(distribuidorVista, "No se Identifica el rut debe selecionar la opcion Editar");
        } else {
            int rut = Integer.parseInt(distribuidorVista.txtRut.getText());
            String nombre = distribuidorVista.txtNom.getText();
            String direccion = distribuidorVista.txtDireccion.getText();
            int tel = Integer.parseInt(distribuidorVista.txtTel.getText());
            int anioVenta = Integer.parseInt(distribuidorVista.txtAnio.getText());
            
            d.setNombreEmpresa(nombre);
            d.setDireccion(direccion);
            d.setTelefono(tel);
            d.setRutDistribuidor(rut);  
            d.setAnioVenta(anioVenta);
            int r = dao.Actualizar(d);
            if (r == 1) {
                JOptionPane.showMessageDialog(distribuidorVista, "El distribuidor se ha actualizado");
            } else {
                JOptionPane.showMessageDialog(distribuidorVista, "Error al actualizar");
            }
        }
        limpiarTabla();
    }

    public void listar(JTable tabla) {
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Distribuidor> lista = dao.listar();
        Object[] objeto = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getNombreEmpresa();
            objeto[1] = lista.get(i).getDireccion();
            objeto[2] = lista.get(i).getTelefono(); 
            objeto[3] = lista.get(i).getRutDistribuidor();
            objeto[4] = lista.get(i).getAnioVenta();
            modelo.addRow(objeto);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);

    }

    void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < distribuidorVista.tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    void limpiarTabla() {
        for (int i = 0; i < distribuidorVista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
}
