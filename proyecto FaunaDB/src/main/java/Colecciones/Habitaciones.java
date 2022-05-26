package Colecciones;

public class Habitaciones {
    private int codHabitacion;
    private String codHotel;
    private String numHabitacion;
    private int capacidad;
    private int preciodia;
    private int activa;

    public Habitaciones() {
    }

    public Habitaciones(int codHabitacion, String codHotel, String numHabitacion, int capacidad, int preciodia, int activa) {
        this.codHabitacion = codHabitacion;
        this.codHotel = codHotel;
        this.numHabitacion = numHabitacion;
        this.capacidad = capacidad;
        this.preciodia = preciodia;
        this.activa = activa;
    }

    public int getCodHabitacion() {
        return codHabitacion;
    }

    public void setCodHabitacion(int codHabitacion) {
        this.codHabitacion = codHabitacion;
    }

    public String getCodHotel() {
        return codHotel;
    }

    public void setCodHotel(String codHotel) {
        this.codHotel = codHotel;
    }

    public String getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(String numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getPreciodia() {
        return preciodia;
    }

    public void setPreciodia(int preciodia) {
        this.preciodia = preciodia;
    }

    public int getActiva() {
        return activa;
    }

    public void setActiva(int activa) {
        this.activa = activa;
    }

    @Override
    public String toString() {
        return "Habitaciones{" +
                "codHabitacion=" + codHabitacion +
                ", codHotel='" + codHotel + '\'' +
                ", numHabitacion='" + numHabitacion + '\'' +
                ", capacidad=" + capacidad +
                ", preciodia=" + preciodia +
                ", activa=" + activa +
                '}';
    }
}
