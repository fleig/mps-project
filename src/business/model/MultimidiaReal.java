package business.model;

/**
 * Created by lucas on 22/11/16.
 */
public class MultimidiaReal implements Multimidia {
    String fileName;

    public MultimidiaReal(String fileName) {
        this.fileName = fileName;
        this.carregarImagem();
    }

    @Override
    public void display() {
        System.out.println("Exibir Multimidia: " + fileName);
    }

    private void carregarImagem(){
        System.out.println("Carregando Multimidia: " + fileName);
    }
}
