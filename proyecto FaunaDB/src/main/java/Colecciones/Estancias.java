package Colecciones;

public class Estancias {
    private int codEstancia;
    private String codDNIoNIE;
    private int codHabitacion;
    private String fechaInicio;
    private String fechaFin;
    private int ocupantes;
    private int preciosetsancia;
    private int pagado;

    public Estancias() {
    }

    public Estancias(int codEstancia, String codDNIoNIE, int codHabitacion, String fechaInicio, String fechaFin, int ocupantes, int preciosetsancia, int pagado) {
        this.codEstancia = codEstancia;
        this.codDNIoNIE = codDNIoNIE;
        this.codHabitacion = codHabitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ocupantes = ocupantes;
        this.preciosetsancia = preciosetsancia;
        this.pagado = pagado;
    }

    public int getCodEstancia() {
        return codEstancia;
    }

    public void setCodEstancia(int codEstancia) {
        this.codEstancia = codEstancia;
    }

    public String getCodDNIoNIE() {
        return codDNIoNIE;
    }

    public void setCodDNIoNIE(String codDNIoNIE) {
        this.codDNIoNIE = codDNIoNIE;
    }

    public int getCodHabitacion() {
        return codHabitacion;
    }

    public void setCodHabitacion(int codHabitacion) {
        this.codHabitacion = codHabitacion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getOcupantea() {
        return ocupantes;
    }

    public void setOcupantea(int ocupantes) {
        this.ocupantes = ocupantes;
    }

    public int getPreciosetsancia() {
        return preciosetsancia;
    }

    public void setPreciosetsancia(int preciosetsancia) {
        this.preciosetsancia = preciosetsancia;
    }

    public int getPagado() {
        return pagado;
    }

    public void setPagado(int pagado) {
        this.pagado = pagado;
    }

    @Override
    public String toString() {
        return "Estancias{" +
                "codEstancia=" + codEstancia +
                ", codDNIoNIE='" + codDNIoNIE + '\'' +
                ", codHabitacion=" + codHabitacion +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", ocupantes=" + ocupantes +
                ", preciosetsancia=" + preciosetsancia +
                ", pagado=" + pagado +
                '}';
    }
}
