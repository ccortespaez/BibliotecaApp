
package cl.inacap.bibliotecaApp.modelo;

public class Distribuidor {
    private int rutDistribuidor;
    private String nombreEmpresa;
    private String direccion;
    private int telefono;
    private int anioVenta;

    public Distribuidor() {
    }

    public Distribuidor(int rutDistribuidor, String nombreEmpresa, String direccion, int telefono, int anioVenta) {
        this.rutDistribuidor = rutDistribuidor;
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.anioVenta = anioVenta;
    }
    
    public int getRutDistribuidor() {
        return rutDistribuidor;
    }

    public void setRutDistribuidor(int rutDistribuidor) {
        this.rutDistribuidor = rutDistribuidor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getAnioVenta() {
        return anioVenta;
    }

    public void setAnioVenta(int anioVenta) {
        this.anioVenta = anioVenta;
    }
    
    @Override
    public String toString() {
        return nombreEmpresa;
    }
}
