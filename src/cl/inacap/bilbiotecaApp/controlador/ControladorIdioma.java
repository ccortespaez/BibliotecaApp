/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.bilbiotecaApp.controlador;

import cl.inacap.bibliotecaApp.modelo.Idioma;
import cl.inacap.bibliotecaApp.modelo.IdiomaDAO;
import cl.inacap.bibliotecaApp.vista.IdiomaVista;
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
public class ControladorIdioma implements ActionListener {
    IdiomaDAO dao = new IdiomaDAO();
    Idioma i = new Idioma();
    IdiomaVista idiomaVista = new IdiomaVista();
    DefaultTableModel modelo = new DefaultTableModel();

     public ControladorIdioma(IdiomaVista i){
        this.idiomaVista = i;
        this.idiomaVista.btnListar.addActionListener(this);
        this.idiomaVista.btnAgregar.addActionListener(this);
        this.idiomaVista.btnEditar.addActionListener(this);
        this.idiomaVista.btnActualizar.addActionListener(this);
        this.idiomaVista.btnEliminar.addActionListener(this);
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == idiomaVista.btnListar) {
            limpiarTabla();
            listar(idiomaVista.tabla);
            nuevo();
        }
       
        if (e.getSource() == idiomaVista.btnAgregar) {
            agregar();
            listar(idiomaVista.tabla);
            nuevo();
        }
        if (e.getSource() == idiomaVista.btnEditar) {
            int fila = idiomaVista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(idiomaVista, "Debe seleccionar una fila");
           }else{
                JOptionPane.showMessageDialog(idiomaVista, "Modifica el dato y haz click en Actualizar");
                String idiomaTxt = (String) idiomaVista.tabla.getValueAt(fila, 1);
                int id = Integer.parseInt((String) idiomaVista.tabla.getValueAt(fila, 0).toString());
                idiomaVista.txtIdioma.setText(idiomaTxt);
                idiomaVista.txtId.setText(""+id);
            }
        }
         if (e.getSource() == idiomaVista.btnActualizar) {
            actualizar();
            listar(idiomaVista.tabla);
            nuevo();
        }
         if (e.getSource() == idiomaVista.btnEliminar) {  
            eliminar();
            listar(idiomaVista.tabla);
            nuevo();
        }
  }
    public void listar(JTable tabla){
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Idioma> lista = dao.listar();
        Object[] objeto = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
        objeto[0] = lista.get(i).getIdIdioma();
        objeto[1] = lista.get(i).getNombreIdioma();
        modelo.addRow(objeto);
        
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);
        
    }
    public void agregar(){
        String idiomaTxt = idiomaVista.txtIdioma.getText();
        i.setNombreIdioma(idiomaTxt);
        int r = dao.agregar(i);
        if (r == 1) {
            JOptionPane.showMessageDialog(idiomaVista, "Idioma agregado");
        }else{
            JOptionPane.showMessageDialog(idiomaVista, "Error al agregar");
        }
        limpiarTabla();
    }
    public void actualizar(){
        if (idiomaVista.txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(idiomaVista, "No se identifica el id");
        }else{
            int id = Integer.parseInt(idiomaVista.txtId.getText());
            String idiomaTxt = idiomaVista.txtIdioma.getText();
            i.setNombreIdioma(idiomaTxt);
            i.setIdIdioma(id);
            int  r = dao.actualizar(i);
            if (r == 1) {
                JOptionPane.showMessageDialog(idiomaVista, "La categoria se ha actualizado");
            }else{
                JOptionPane.showMessageDialog(idiomaVista, "Error al actualizar");
            }
        }
        limpiarTabla();
    }
     public void eliminar(){
        int fila = idiomaVista.tabla.getSelectedRow();
        String idioma = (String) idiomaVista.tabla.getValueAt(fila,1);
        try {
            if (fila == -1) {
            JOptionPane.showMessageDialog(idiomaVista, "Debe seleccionar una fila");
        }else{
            JOptionPane.showMessageDialog(idiomaVista, "El Idioma "+idioma+" fue eliminado");
            int id = Integer.parseInt((String) idiomaVista.tabla.getValueAt(fila, 0).toString());
            dao.eliminar(id); 
        }
        } catch (Exception e) {
            System.out.println(e);            
        }
        
        limpiarTabla();
    }
     
    void nuevo() {
        idiomaVista.txtIdioma.setText("");
        idiomaVista.txtId.setText("");
        idiomaVista.requestFocus();
    }
    void limpiarTabla() {
        for (int i = 0; i < idiomaVista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < idiomaVista.tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }
    
    
 
}
