/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.bibliotecaApp.modelo;

/**
 *
 * @author Cristobal
 */
public class Editorial {
    private String nombreEditorial;
    private int idEditorial;

    public Editorial() {
        this.nombreEditorial = nombreEditorial;
        this.idEditorial = idEditorial;
    }
    
    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }
    @Override
    public String toString() {
        return nombreEditorial;
    }
}
