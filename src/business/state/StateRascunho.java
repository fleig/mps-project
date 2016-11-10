package business.state;

import business.model.Receita;

/**
 * Created by UFPB-CIA-03 on 09/11/2016.
 */
public class StateRascunho extends State{

    public void setState(Receita receita){
        System.out.print("Receita no estado rascunho");
        receita.setState(this);

    }

    public String toString(){
        return "Rascunho State";
    }
}