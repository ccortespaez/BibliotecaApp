/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.bilbiotecaApp.controlador;


import cl.inacap.bibliotecaApp.modelo.Editorial;
import cl.inacap.bibliotecaApp.modelo.EditorialDAO;
import cl.inacap.bibliotecaApp.vista.EditorialVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cristobal
 */
public class ControladorEditorial implements ActionListener {
    EditorialDAO dao = new EditorialDAO();
    Editorial e = new Editorial();
    EditorialVista editorialVista = new EditorialVista();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public ControladorEditorial(EditorialVista e){
        this.editorialVista = e;
        this.editorialVista.btnListar.addActionListener(this);
        this.editorialVista.btnAgregar.addActionListener(this);
        this.editorialVista.btnEditar.addActionListener(this);
        this.editorialVista.btnEliminar.addActionListener(this);
        this.editorialVista.btnActualizar.addActionListener(this);
        this.editorialVista.btnNuevo.addActionListener(this);

    }
      public void actionPerformed(ActionEvent e) {
          if (e.getSource() == editorialVista.btnListar) {
            limpiarTabla();
            listar(editorialVista.tabla);
            nuevo();
        }
          
        if (e.getSource() == editorialVista.btnAgregar) {
            agregar();
            listar(editorialVista.tabla);
            nuevo();
        }
        
        if (e.getSource() == editorialVista.btnEditar) {
            int fila = editorialVista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(editorialVista, "Debe seleccionar una fila");
           }else{
                JOptionPane.showMessageDialog(editorialVista, "Modifica el dato y haz click en Actualizar");
                String editorialTxt = (String) editorialVista.tabla.getValueAt(fila, 1);
                int id = Integer.parseInt((String) editorialVista.tabla.getValueAt(fila, 0).toString());
                editorialVista.txtEditorial.setText(editorialTxt);
                editorialVista.txtId.setText(""+id);
            }
        }
         if (e.getSource() == editorialVista.btnEliminar) {  
            eliminar();
            listar(editorialVista.tabla);
            nuevo();
        }
          if (e.getSource() == editorialVista.btnNuevo) {
            nuevo();
        }
        if (e.getSource() == editorialVista.btnActualizar) {
            actualizar();
            listar(editorialVista.tabla);
            nuevo();
        }
      }
    public void listar(JTable tabla) {
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Editorial> lista = dao.listar();
        Object[] objeto = new Object[2];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getIdEditorial();
            objeto[1] = lista.get(i).getNombreEditorial();
            modelo.addRow(objeto);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);

    }
    public void agregar(){
        String editorialTxt = editorialVista.txtEditorial.getText();
        e.setNombreEditorial(editorialTxt);
        int r = dao.agregar(e);
        if (r == 1) {
            JOptionPane.showMessageDialog(editorialVista, "Editorial agregada");
        }else{
            JOptionPane.showMessageDialog(editorialVista, "Error al agregar");
        }
        limpiarTabla();
    }
    public void actualizar(){
        if (editorialVista.txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(editorialVista, "No se identifica el id");
        }else{
            int id = Integer.parseInt(editorialVista.txtId.getText());
            String editorialTxt = editorialVista.txtEditorial.getText();
            e.setNombreEditorial(editorialTxt);
            e.setIdEditorial(id);
            int  r = dao.actualizar(e);
            if (r == 1) {
                JOptionPane.showMessageDialog(editorialVista, "La categoria se ha actualizado");
            }else{
                JOptionPane.showMessageDialog(editorialVista, "Error al actualizar");
            }
        }
        limpiarTabla();
    }
    public void eliminar(){
        int fila = editorialVista.tabla.getSelectedRow();
        String editorial = (String) editorialVista.tabla.getValueAt(fila,1);
        try {
            if (fila == -1) {
            JOptionPane.showMessageDialog(editorialVista, "Debe seleccionar una fila");
        }else{
            JOptionPane.showMessageDialog(editorialVista, "La editorial "+editorial+" fue eliminada");
            int id = Integer.parseInt((String) editorialVista.tabla.getValueAt(fila, 0).toString());
            dao.eliminar(id); 
        }
        } catch (Exception e) {
            System.out.println(e);            
        }
        
        limpiarTabla();
    }
    
    
    void nuevo() {
        editorialVista.txtEditorial.setText("");
        editorialVista.txtId.setText("");
        editorialVista.requestFocus();
    }  
    void limpiarTabla() {
        for (int i = 0; i < editorialVista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    } 
    void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < editorialVista.tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }
}
