package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Sessao {
    private Sala sala;
    private Midia midia;
    private LocalDate data;
    private LocalTime horario;
    private ArrayList<Poltrona> poltronas;

    public Sessao(Sala sala, Midia midia, LocalDate data, LocalTime horario) {
        this.sala = sala;
        this.midia = midia;
        this.data = data;
        this.horario = horario;
        this.poltronas = new ArrayList<Poltrona>();
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Midia getMidia() {
        return midia;
    }

    public void setMidia(Midia midia) {
        this.midia = midia;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return midia.getTitulo() + ", " +
                "\n Data: " + data + ", " +
                "\n Horário: " + horario;
    }

}