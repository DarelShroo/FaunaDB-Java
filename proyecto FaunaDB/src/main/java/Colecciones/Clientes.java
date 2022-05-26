package Colecciones;

public class Clientes {
    private String codDNIoNIE;
    private String nombre;
    private String nacionalidad;

    public Clientes() {
    }

    public Clientes(String codDNIoNIE, String nombre, String nacionalidad) {
        this.codDNIoNIE = codDNIoNIE;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String getCodDNIoNIE() {
        return codDNIoNIE;
    }

    public void setCodDNIoNIE(String codDNIoNIE) {
        this.codDNIoNIE = codDNIoNIE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codDNIoNIE='" + codDNIoNIE + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}
