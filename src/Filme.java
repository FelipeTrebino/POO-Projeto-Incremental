import java.util.ArrayList;

public class Filme extends Midia{
     private String elenco;
    
     public Filme(String titulo, int duracaoEmMinutos, String sinopse, String diretor, String elenco, int anoDeLancamento, String classificacaoIndicativa, String nacionalidade) {
        this.setTitulo(titulo);
        this.setDuracaoEmMinutos(duracaoEmMinutos);
        this.setSinopse(sinopse);
        this.setDiretor(diretor);
        this.elenco = elenco;
        this.setAnoDeLancamento(anoDeLancamento);
        this.setClassificacaoIndicativa(classificacaoIndicativa);
        this.setNacionalidade(nacionalidade);
    }

    public void exibirDetalhes() {
        System.out.println(getTitulo() +
                "\nDe " + getDiretor() + ". " +
                "Com " + elenco + ". " +
                getNacionalidade() + ". " + getAnoDeLancamento() +
                ". " + getSinopse() + " " + getDuracaoEmMinutos() + " min. " +
                getClassificacaoIndicativa() + ".");

    }
}
