/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.bilbiotecaApp.controlador;

import cl.inacap.bibliotecaApp.modelo.Autor;
import cl.inacap.bibliotecaApp.modelo.AutorDAO;
import cl.inacap.bibliotecaApp.vista.AutorVista;
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
public class ControladorAutor implements ActionListener {
    AutorDAO dao = new AutorDAO();
    Autor a = new Autor();
    AutorVista autorVista = new AutorVista();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public ControladorAutor(AutorVista a){
        this.autorVista = a;
        this.autorVista.btnListar.addActionListener(this);
        this.autorVista.btnAgregar.addActionListener(this);
        this.autorVista.btnNuevo.addActionListener(this);
        this.autorVista.btnEditar.addActionListener(this);
        this.autorVista.btnActualizar.addActionListener(this);
        this.autorVista.btnEliminar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == autorVista.btnListar) {
            limpiarTabla();
            listar(autorVista.tabla);
            nuevo();
        }
        if (e.getSource() == autorVista.btnNuevo) {
            nuevo();
        }
        if (e.getSource() == autorVista.btnAgregar) {
            agregar();
            listar(autorVista.tabla);
            nuevo();
        }
        if (e.getSource() == autorVista.btnEditar) {
            int fila = autorVista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(autorVista, "Debe seleccionar una fila");
           }else{
                JOptionPane.showMessageDialog(autorVista, "Modifica el dato y haz click en Actualizar");
                int id = Integer.parseInt((String) autorVista.tabla.getValueAt(fila, 0).toString());
                String nombre = (String) autorVista.tabla.getValueAt(fila, 1);
                String apellidoPaterno = (String) autorVista.tabla.getValueAt(fila,2);
                String apellidoMaterno = (String) autorVista.tabla.getValueAt(fila,3);
                autorVista.txtNombre.setText(nombre);
                autorVista.txtApellidoPaterno.setText(apellidoPaterno);
                autorVista.txtApellidoMaterno.setText(apellidoMaterno);
                autorVista.txtId.setText(""+id);
            }
        }
         if (e.getSource() == autorVista.btnActualizar) {
            actualizar();
            listar(autorVista.tabla);
            nuevo();
        }
        if (e.getSource() == autorVista.btnEliminar) {
            eliminar();
            listar(autorVista.tabla);
            nuevo();
        }
    }
    
    public void listar(JTable tabla){
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Autor> lista = dao.listar();
        Object[] objeto = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
        objeto[0] = lista.get(i).getId();
        objeto[1] = lista.get(i).getNombre();
        objeto[2] = lista.get(i).getApellidoPaterno();
        objeto[3] = lista.get(i).getApellidoMaterno();
        modelo.addRow(objeto);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);
        
    }
    
    public void agregar(){
        String nombre = autorVista.txtNombre.getText();
        String apellidoPaterno = autorVista.txtApellidoPaterno.getText();
        String apellidoMaterno = autorVista.txtApellidoMaterno.getText();
        a.setNombre(nombre);
        a.setApellidoPaterno(apellidoPaterno);
        a.setApellidoMaterno(apellidoMaterno);
        int r = dao.agregar(a);
        if (r == 1) {
            JOptionPane.showMessageDialog(autorVista, "Autor agregado");
        }else{
            JOptionPane.showMessageDialog(autorVista, "Error al agregar");
        }
        limpiarTabla();
    }
    
    public void actualizar(){
        if (autorVista.txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(autorVista, "No se identifica el id");
        }else{
            int id = Integer.parseInt(autorVista.txtId.getText());
            String nombre = autorVista.txtNombre.getText();
            String apellidoPaterno = autorVista.txtApellidoPaterno.getText();
            String apellidoMaterno = autorVista.txtApellidoMaterno.getText();
            a.setNombre(nombre);
            a.setId(id);
            a.setApellidoPaterno(apellidoPaterno);
            a.setApellidoMaterno(apellidoMaterno);
            int r = dao.actualizar(a);
            if (r == 1) {
                JOptionPane.showMessageDialog(autorVista, "El autor se ha actualizado");
            }else{
                JOptionPane.showMessageDialog(autorVista, "Error al actualizar");
            }
        }
        limpiarTabla();
    }
   
    public void eliminar(){
        int fila = autorVista.tabla.getSelectedRow();
        try {
            if (fila == -1) {
                JOptionPane.showMessageDialog(autorVista, "Debe seleccionar una fila");
            }else{
            JOptionPane.showMessageDialog(autorVista, "Categoria Eliminada");
            int id = Integer.parseInt((String) autorVista.tabla.getValueAt(fila, 0).toString());
            dao.eliminar(id); 
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        limpiarTabla();
    }
     void nuevo() {
        autorVista.txtNombre.setText("");
        autorVista.txtApellidoPaterno.setText("");
        autorVista.txtApellidoMaterno.setText("");
        autorVista.txtId.setText("");
        autorVista.requestFocus();
    }
     void limpiarTabla() {
        for (int i = 0; i < autorVista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
     void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < autorVista.tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }
}
