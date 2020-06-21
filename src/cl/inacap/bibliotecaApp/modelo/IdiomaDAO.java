/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.bibliotecaApp.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristobal
 */
public class IdiomaDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Idioma i = new Idioma();
    
     public List listar(){
        List<Idioma> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from idioma");
            rs = ps.executeQuery();
            while (rs.next()) {                
                Idioma i = new Idioma();
                i.setNombreIdioma(rs.getString(1));
                i.setIdIdioma(rs.getInt(2));
                datos.add(i);
            }
        } catch (Exception e) {
        }
        return datos;
    }
     public int agregar(Idioma idi){
        int r = 0;
        String sql = "insert into idioma(Nombre_idioma, Id_idioma) values(?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, idi.getNombreIdioma());
            ps.setInt(2, idi.getIdIdioma());
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            }else{
                return 2;
            }
        } catch (Exception e) {
        }
        return r;
    }
     public int actualizar(Idioma idi){
        int r =0;
        con = conectar.getConnection();
        PreparedStatement ps = null;
        String sql = "update idioma set Nombre_idioma=? where Id_idioma=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, idi.getNombreIdioma());
            ps.setInt(2, idi.getIdIdioma());
            r=ps.executeUpdate();
            if (r==1) {
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return r;
    }
     public int eliminar(int idIdioma){
        int r =0;
        String sql = "delete from idioma where Id_idioma="+idIdioma;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error");
        }
        return r;
    }
     
}
