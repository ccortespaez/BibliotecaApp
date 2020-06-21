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
public class EditorialDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Editorial e = new Editorial();
    
    public int agregar(Editorial edi){
        int r=0;
        String sql ="insert into editorial(Nombre_editorial,Id_editorial) values(?,?)";
        try{
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, edi.getNombreEditorial());
            ps.setInt(2, edi.getIdEditorial());
            r = ps.executeUpdate();
            if (r==1) {
                return 1;
            }else{
                return 0;
            }
        }catch(Exception e){
        }
         return r;
    }
    public List listar() {
        List<Editorial> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from editorial");
            rs = ps.executeQuery();
            while(rs.next()){
                Editorial e = new Editorial();
                e.setNombreEditorial(rs.getString(1));
                e.setIdEditorial(rs.getInt(2));
                datos.add(e);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    public int actualizar(Editorial edi){
        int r =0;
        con = conectar.getConnection();
        PreparedStatement ps = null;
        String sql = "update editorial set Nombre_editorial=? where Id_editorial=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, edi.getNombreEditorial());
            ps.setInt(2, edi.getIdEditorial());
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
    public int eliminar(int idEditorial){
        int r =0;
        String sql = "delete from editorial where Id_editorial="+idEditorial;
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
