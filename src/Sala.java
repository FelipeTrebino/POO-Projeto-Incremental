

public class Sala {
    private Cinema cinema;
    private int numero;

    public Sala(Cinema cinema, int numero) {
        this.cinema = cinema;
        this.numero = numero;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "sala : " + numero;
    }
}