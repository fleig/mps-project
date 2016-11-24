package business.model;

import business.state.State;
import business.state.StateRascunho;

import java.util.ArrayList;

/**
 * Created by UFPB-CIA-03 on 09/11/2016.
 */
public class Receita {

    State state;
    String titulo;

    public Receita(String titulo){

        this.state=new StateRascunho();
        this.titulo=titulo;
    }

    public String getTitulo(){
        System.out.println(this.titulo);
        return this.titulo;
    }


    public void setState(State state){
        this.state=state;
    }

    public String getState(){
        System.out.println(this.state.toString());
        return this.state.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Receita)){
            return false;
        }
        if(((Receita) obj).getTitulo() == this.titulo){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hashCode = titulo.hashCode();
        hashCode = 31 * hashCode + titulo.hashCode();
        return hashCode;
    }
}
