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
public class CategoriaDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Categoria c = new Categoria();
    
    public int agregar(Categoria cate){
        int r=0;
        String sql ="insert into categoria(Nombre_categoria,Id_categoria) values(?,?)";
        try{
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cate.getNombreCategoria());
            ps.setInt(2, cate.getIdCategoria());
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
        List<Categoria> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from categoria");
            rs = ps.executeQuery();
            while(rs.next()){
                Categoria c = new Categoria();
                c.setNombreCategoria(rs.getString(1));
                c.setIdCategoria(rs.getInt(2));
                datos.add(c);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    
    public int actualizar(Categoria cate){
        int r =0;
        con = conectar.getConnection();
        PreparedStatement ps = null;
        String sql = "update categoria set Nombre_categoria=? where Id_categoria=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cate.getNombreCategoria());
            ps.setInt(2, cate.getIdCategoria());
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
    
    public int eliminar(int idCategoria){
        int r =0;
        String sql = "delete from categoria where Id_categoria="+idCategoria;
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
