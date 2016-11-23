package business.observer;

/**
 * Created by UFPB-CIA-03 on 22/11/2016.
 */
public class TabelaObserver extends DadosObserver {

    public TabelaObserver(DadosSubject dados) {
        super(dados);
    }

    @Override
    public void update() {
//        System.out.println("Receita Adicionada:"
//                + dados.getState().getTitulos());
    }
}
