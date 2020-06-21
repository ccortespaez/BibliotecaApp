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
public class AutorDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Autor a = new Autor();
    
    public List listar(){
        List<Autor> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from autor");
            rs = ps.executeQuery();
            while (rs.next()) {                
                Autor a = new Autor();
                a.setNombre(rs.getString(1));
                a.setId(rs.getInt(2));
                a.setApellidoPaterno(rs.getString(3));
                a.setApellidoMaterno(rs.getString(4));
                datos.add(a);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    
    public int agregar(Autor au){
        int r = 0;
        String sql = "insert into autor(Nombre_autor, Id_autor, Apellido_paterno, Apellido_materno) values(?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, au.getNombre());
            ps.setInt(2, au.getId());
            ps.setString(3, au.getApellidoPaterno());
            ps.setString(4, au.getApellidoMaterno());
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
    
    public int actualizar(Autor au){
        int r = 0;
        con = conectar.getConnection();
        PreparedStatement ps = null;
        String sql = "update autor set Nombre_autor=?, Apellido_paterno=?, Apellido_materno=? where Id_autor=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,au.getNombre());
            ps.setString(2,au.getApellidoPaterno());
            ps.setString(3,au.getApellidoMaterno());
            ps.setInt(4,au.getId());
            r = ps.executeUpdate();
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
    
    public int eliminar(int id){
        int r = 0;
        String sql = "delete from autor where Id_autor="+id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return r;
        
    }
}
