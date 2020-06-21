/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.bilbiotecaApp.controlador;

import cl.inacap.bibliotecaApp.modelo.Libro;
import cl.inacap.bibliotecaApp.modelo.LibroDAO;
import cl.inacap.bibliotecaApp.vista.LibroVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cristobal
 */
public class ControladorLibro implements ActionListener{
    LibroDAO dao = new LibroDAO();
    Libro l = new Libro();
    LibroVista libroVista = new LibroVista();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorLibro(LibroVista l){
        this.libroVista = l;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
   
    
}
