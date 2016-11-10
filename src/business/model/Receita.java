package business.model;

import business.state.State;
import business.state.StateRascunho;

/**
 * Created by UFPB-CIA-03 on 09/11/2016.
 */
public class Receita {

    State state;

    public Receita(){
       this.state=new StateRascunho();
    }

    public void setState(State state){
        this.state=state;
    }

    public String getState(){
        System.out.println(this.state.toString());
        return this.state.toString();
    }


}
