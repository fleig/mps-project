package business.model;

/**
 * Created by lucas on 22/11/16.
 */
public class MultimidiaProxy implements Multimidia {
    private MultimidiaReal multimediaReal;
    private String fileName;

    public MultimidiaProxy(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(multimediaReal == null){
            multimediaReal = new MultimidiaReal(fileName);
        }
        multimediaReal.display();
    }
}
