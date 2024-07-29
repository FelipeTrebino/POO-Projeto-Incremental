import java.util.ArrayList;

public class Filme extends Midia{
    public Filme(String titulo, int duracaoEmMinutos, String sinopse, String diretor, String elenco, int anoDeLancamento, String classificacaoIndicativa, String nacionalidade) {
        this.setTitulo(titulo);
        this.setDuracaoEmMinutos(duracaoEmMinutos);
        this.setSinopse(sinopse);
        this.setDiretor(diretor);
        this.setElenco(elenco);
        this.setAnoDeLancamento(anoDeLancamento);
        this.setClassificacaoIndicativa(classificacaoIndicativa);
        this.setNacionalidade(nacionalidade);
    }
}
