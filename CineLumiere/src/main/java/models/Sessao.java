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
    private static final int quantidadePoltronas = 50;
    private static final int quantidadePoltronasAcessiveis = 5;


    // Construtor com quantidade personalizada de poltronas
    public Sessao(Sala sala, Midia midia, LocalDate data, LocalTime horario, int quantidadePoltronas, int quantidadePoltronasAcessiveis) {
        this.sala = sala;
        this.midia = midia;
        this.data = data;
        this.horario = horario;
        this.poltronas = new ArrayList<Poltrona>();
        
        // Lógica para criar as poltronas de cada sessão
        
        for(int i = 0; i < quantidadePoltronas; i++){
            this.poltronas.add(new Poltrona(String.valueOf(i + 1), true, false));
        }
        for(int i = 0; i < quantidadePoltronasAcessiveis; i++){
            this.poltronas.add(new Poltrona(String.valueOf(quantidadePoltronas + i + 1), true, true));
        }
    }

    // Construtor com quantidade padrão de poltronas
    public Sessao(Sala sala, Midia midia, LocalDate data, LocalTime horario) {
        this.sala = sala;
        this.midia = midia;
        this.data = data;
        this.horario = horario;
        this.poltronas = new ArrayList<Poltrona>();
        
        // Lógica para criar as poltronas de cada sessão
        
        for(int i = 0; i < Sessao.quantidadePoltronas; i++){
            this.poltronas.add(new Poltrona(String.valueOf(i + 1), true, false));
        }
        for(int i = 0; i < Sessao.quantidadePoltronasAcessiveis; i++){
            this.poltronas.add(new Poltrona(String.valueOf(Sessao.quantidadePoltronas + i + 1), true, true));
        }
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

    public ArrayList<Poltrona> getPoltronas() {
        return poltronas;
    }

    public void exibirPoltronas() {
    int colunas = 10; // Número de poltronas por fila
    char rowLabel = 'A';
    
    for (int i = 0; i < poltronas.size(); i++) {
        if (i % colunas == 0 && i != 0) {
            System.out.println(); // Quebra de linha para nova fila
            rowLabel++;
        }
        Poltrona poltrona = poltronas.get(i);
        String status = poltrona.isDisponivel() ? "( )" : "(X)";
        if (poltrona.isAcessivel()) {
            status = poltrona.isDisponivel() ? "(A)" : "(X)";
        }
        System.out.print(poltrona.getCodigo() + status + " ");
    }
    System.out.println(); // Quebra de linha final
}

    
    @Override
    public String toString() {
        return midia.getTitulo() + ", " +
                "\n Data: " + data + ", " +
                "\n Horário: " + horario;
    }

}