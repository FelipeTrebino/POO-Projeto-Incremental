import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        Filme filme1 = new Filme("A Mosca",96,"O excêntrico cientista Seth Brundle completa seu dispositivo de teletransporte e decide testar a eficácia do experimento em si próprio. Sem que ele perceba, uma mosca cai no aparelho durante o processo e provoca uma fusão dele com o inseto. Contudo, ele pensa que o experimento foi um sucesso, até que começa a notar que as células da mosca estão tomando conta de seu corpo, e ele acaba se transformando em uma criatura monstruosa.", "David Cronenberg","Jeff Goldblum, Geena Davis", 1986,"14 anos", "EUA");
        filme1.exibirDetalhes();

        Documentario documentario1 = new Documentario("Paris is Burning",78,"Uma crônica da cena drag queen nova-iorquina dos anos 1980, focando nos bailes, dança vogue, ambições e sonhos daqueles que proporcionaram calor e vitalidade para uma era.","Jennie Livingston", 1990,"18 anos", "EUA");
        documentario1.exibirDetalhes();

        Cinema cinema1 = new Cinema("Cine Lumière - Salvador Shopping", "Av. Tancredo Neves, 3133 - Caminho das Árvores, Salvador");
        Sala sala1 = new Sala(cinema1, 01);
        Sala sala2 = new Sala(cinema1, 02);
        cinema1.adicionarSala(sala1);
        cinema1.adicionarSala(sala2);
        cinema1.exibirDetalhes();

        Sessao sessao1 = new Sessao(sala1,filme1, LocalDate.of(2024,07,31), LocalTime.of(16,40));
        sala1.adicionarSessao(sessao1);
        sala1.exibirDetalhes();







    }
}