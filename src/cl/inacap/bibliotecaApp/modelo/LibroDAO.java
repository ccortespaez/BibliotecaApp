/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.bibliotecaApp.modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristobal
 */
public class LibroDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    
    
    public void buscarCategoria(JList listCategoria){
        DefaultListModel lm = new DefaultListModel();
        String sql = "select nombre_categoria from categoria";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                lm.addElement(rs.getString("nombre_categoria"));
            }
            //ArrayList<Autor> lista = con.ge
        } catch (Exception e) {
        }
        listCategoria.setModel(lm);
    }
      public void buscarIdioma(JList listIdioma){
        DefaultListModel lm = new DefaultListModel();
        String sql = "select Nombre_idioma from idioma";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                lm.addElement(rs.getString("Nombre_idioma"));
            }
            //ArrayList<Autor> lista = con.ge
        } catch (Exception e) {
        }
        listIdioma.setModel(lm);
    }
    
    
    public void buscarEditorial(JComboBox cbxEditorial){
        String sql = "select Nombre_editorial from editorial order by Nombre_editorial ASC";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            cbxEditorial.removeAllItems();
            cbxEditorial.addItem("Selecciona una opcion");
            while(rs.next()){
                cbxEditorial.addItem(rs.getString("nombre_editorial"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
    
    
    public void buscarEstado(JComboBox cbxEstado){
        String sql = "select Nombre_estado from estado";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            cbxEstado.removeAllItems();
            cbxEstado.addItem("Selecciona una opcion");
            while(rs.next()){
                cbxEstado.addItem(rs.getString("Nombre_estado"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
    public void buscarAutor(JList listAutor){
        DefaultListModel lm = new DefaultListModel();
        String sql = "select * from autor";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                lm.addElement(rs.getString("apellido_paterno"));
                
            }
            //ArrayList<Autor> lista = con.ge
        } catch (Exception e) {
        }
        listAutor.setModel(lm);
    }
 }
    
    

