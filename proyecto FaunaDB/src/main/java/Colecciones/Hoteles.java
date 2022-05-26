package Colecciones;

public class Hoteles {
    private String codHotel;
    private String nomHotel;

    public Hoteles() {
    }

    public Hoteles(String codHotel, String nomHotel) {
        this.codHotel = codHotel;
        this.nomHotel = nomHotel;
    }

    public String getCodHotel() {
        return codHotel;
    }

    public void setCodHotel(String codHotel) {
        this.codHotel = codHotel;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    @Override
    public String toString() {
        return "Hoteles{" +
                "codHotel='" + codHotel + '\'' +
                ", nomHotel='" + nomHotel + '\'' +
                '}';
    }
}
