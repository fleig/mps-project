package business.observer;

/**
 * Created by UFPB-CIA-03 on 22/11/2016.
 */
public class PorcentoObserver extends DadosObserver {

    public PorcentoObserver(DadosSubject dados) {
        super(dados);
    }

    @Override
    public void update() {
//        int somaDosValores = dados.getState().valorA + dados.getState().valorB
//                + dados.getState().valorC;
//        DecimalFormat formatador = new DecimalFormat("#.##");
//        String porcentagemA = formatador.format((double) dados.getState().valorA
//                / somaDosValores);
//        String porcentagemB = formatador.format((double) dados.getState().valorB
//                / somaDosValores);
//        String porcentagemC = formatador.format((double) dados.getState().valorC
//                / somaDosValores);
//        System.out.println("Porcentagem:\nValor A: " + porcentagemA
//                + "%\nValor B: " + porcentagemB + "%\nValor C: " + porcentagemC
//                + "%");
    }

}
