package models;

public class Documentario extends Midia {
    public Documentario(String titulo, int duracaoEmMinutos, String sinopse, String diretor, int anoDeLancamento, String classificacaoIndicativa, String nacionalidade) {
        this.setTitulo(titulo);
        this.setDuracaoEmMinutos(duracaoEmMinutos);
        this.setSinopse(sinopse);
        this.setDiretor(diretor);
        this.setAnoDeLancamento(anoDeLancamento);
        this.setClassificacaoIndicativa(classificacaoIndicativa);
        this.setNacionalidade(nacionalidade);
    }
}
