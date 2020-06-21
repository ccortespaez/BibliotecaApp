package cl.inacap.bibliotecaApp.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DistribuidorDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Distribuidor p = new Distribuidor();

    public List listar() {
        List<Distribuidor> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from distribuidor");
            rs = ps.executeQuery();
            while (rs.next()) {
                Distribuidor d = new Distribuidor();
                d.setNombreEmpresa(rs.getString(1));
                d.setDireccion(rs.getString(2));
                d.setTelefono(rs.getInt(3));
                d.setRutDistribuidor(rs.getInt(4));
                d.setAnioVenta(rs.getInt(5));
                datos.add(d);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    public int agregar(Distribuidor dis) {  
        int r=0;
        
        String sql="insert into distribuidor(Nombre_empresa,Direccion_dist,Telefono,Rut_distribuidor,Anio_venta)values(?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);   
            ps.setString(1,dis.getNombreEmpresa());
            ps.setString(2,dis.getDireccion());
            ps.setInt(3,dis.getTelefono());
            ps.setInt(4,dis.getRutDistribuidor());
            ps.setInt(5,dis.getAnioVenta());
            
         
            r=ps.executeUpdate();    
            if(r==1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (Exception e) {
        }  
        return r;
    }
    public int Actualizar(Distribuidor dis) {  
        int r=0;
         con = conectar.getConnection();
        PreparedStatement ps = null;
        String sql="update distribuidor set Nombre_empresa=?,Direccion_dist=?,Telefono=?,Anio_venta=? where Rut_distribuidor=?";        
        try {
            
            ps = con.prepareStatement(sql);            
            ps.setString(1,dis.getNombreEmpresa());
            ps.setString(2,dis.getDireccion());
            ps.setInt(3,dis.getTelefono());
            ps.setInt(4,dis.getAnioVenta());
            ps.setInt(5,dis.getRutDistribuidor());
            r=ps.executeUpdate();    
            if(r==1){
                return 1;
               
            }
            else{
                return 0;
            }
        } catch (SQLException e) {
             System.err.println(e);
             System.out.println("error");
        }  
        return r;
    }
    public int Delete(int rutDistribuidor){
        int r=0;
        String sql="delete from distribuidor where Rut_distribuidor="+rutDistribuidor;
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
