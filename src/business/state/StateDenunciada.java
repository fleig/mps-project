package business.state;

import business.model.Receita;

/**
 * Created by UFPB-CIA-03 on 09/11/2016.
 */
public class StateDenunciada extends State{

    public void setState(Receita receita){
        System.out.print("Receita no estado denunciada");
        receita.setState(this);

    }

    public String toString(){
        return "Denuncuada State";
    }
}
