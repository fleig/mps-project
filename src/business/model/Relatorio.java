package business.model;

/**
 * Created by lucas on 17/10/16.
 */
public class Relatorio {
    private String conteudo;

    public Relatorio() {
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void gerarRelatorio(IRelatorioStrategy relatorioStrategy){
        this.conteudo = relatorioStrategy.gerarRelatorio();
    }
}
