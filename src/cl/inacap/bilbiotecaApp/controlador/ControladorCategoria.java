/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.bilbiotecaApp.controlador;

import cl.inacap.bibliotecaApp.modelo.Categoria;
import cl.inacap.bibliotecaApp.modelo.CategoriaDAO;

import cl.inacap.bibliotecaApp.vista.CategoriaVista;
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
public class ControladorCategoria implements ActionListener {
    CategoriaDAO dao = new CategoriaDAO();
    Categoria c = new Categoria();
    CategoriaVista categoriaVista = new CategoriaVista();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public ControladorCategoria(CategoriaVista c){
        this.categoriaVista = c;
        this.categoriaVista.btnListar.addActionListener(this);
        this.categoriaVista.btnAgregar.addActionListener(this);
        this.categoriaVista.btnEditar.addActionListener(this);
        this.categoriaVista.btnEliminar.addActionListener(this);
        this.categoriaVista.btnActualizar.addActionListener(this);
        this.categoriaVista.btnNuevo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == categoriaVista.btnListar) {
            limpiarTabla();
            listar(categoriaVista.tabla);
            nuevo();
            
        }
        if (e.getSource() == categoriaVista.btnAgregar) {
            agregar();
            listar(categoriaVista.tabla);
            nuevo();
        }
        if (e.getSource() == categoriaVista.btnEditar) {
            int fila = categoriaVista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(categoriaVista, "Debe seleccionar una fila");
           }else{
                JOptionPane.showMessageDialog(categoriaVista, "Modifica el dato y haz click en Actualizar");
                String categoriaTxt = (String) categoriaVista.tabla.getValueAt(fila, 0);
                int id = Integer.parseInt((String) categoriaVista.tabla.getValueAt(fila, 1).toString());
                categoriaVista.txtCategoria.setText(categoriaTxt);
                categoriaVista.txtId.setText(""+id);
            }
        }
        if (e.getSource() == categoriaVista.btnEliminar) {  
            eliminar();
            listar(categoriaVista.tabla);
            nuevo();
        }
        if (e.getSource() == categoriaVista.btnNuevo) {
            nuevo();
        }
        if (e.getSource() == categoriaVista.btnActualizar) {
            actualizar();
            listar(categoriaVista.tabla);
            nuevo();
        }
       
    }
    
     void nuevo() {
        categoriaVista.txtCategoria.setText("");
        categoriaVista.txtId.setText("");
        categoriaVista.requestFocus();
    }
     
    public void agregar(){
        String categoriaTxt = categoriaVista.txtCategoria.getText();
        c.setNombreCategoria(categoriaTxt);
        int r = dao.agregar(c);
        if (r == 1) {
            JOptionPane.showMessageDialog(categoriaVista, "Categoria agregada");
        }else{
            JOptionPane.showMessageDialog(categoriaVista, "Error al agregar");
        }
        limpiarTabla();
    }
    
    public void actualizar(){
        if (categoriaVista.txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(categoriaVista, "No se identifica el id");
        }else{
            int id = Integer.parseInt(categoriaVista.txtId.getText());
            String categoriaTxt = categoriaVista.txtCategoria.getText();
            c.setNombreCategoria(categoriaTxt);
            c.setIdCategoria(id);
            int  r = dao.actualizar(c);
            if (r == 1) {
                JOptionPane.showMessageDialog(categoriaVista, "La categoria se ha actualizado");
            }else{
                JOptionPane.showMessageDialog(categoriaVista, "Error al actualizar");
            }
        }
        limpiarTabla();
    }
    
    public void listar(JTable tabla) {
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Categoria> lista = dao.listar();
        Object[] objeto = new Object[2];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getNombreCategoria();
            objeto[1] = lista.get(i).getIdCategoria();
            modelo.addRow(objeto);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);

    }
    
    public void eliminar(){
        int fila = categoriaVista.tabla.getSelectedRow();
        try {
            if (fila == -1) {
            JOptionPane.showMessageDialog(categoriaVista, "Debe seleccionar una fila");
        }else{
            JOptionPane.showMessageDialog(categoriaVista, "Categoria Eliminada");
            int id = Integer.parseInt((String) categoriaVista.tabla.getValueAt(fila, 1).toString());
            dao.eliminar(id); 
        }
        } catch (Exception e) {
            System.out.println(e);            
        }
        
        limpiarTabla();
    }
    
    void limpiarTabla() {
        for (int i = 0; i < categoriaVista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
     
    void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < categoriaVista.tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }
      
    
}
