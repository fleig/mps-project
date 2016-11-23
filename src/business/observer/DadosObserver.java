package business.observer;

/**
 * Created by UFPB-CIA-03 on 22/11/2016.
 */
public abstract class DadosObserver {

    protected DadosSubject dados;

    public DadosObserver(DadosSubject dados) {
        this.dados = dados;
    }

    public abstract void update();
}