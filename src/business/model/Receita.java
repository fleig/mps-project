package business.model;

import business.state.State;
import business.state.StateRascunho;

import java.util.ArrayList;

/**
 * Created by UFPB-CIA-03 on 09/11/2016.
 */
public class Receita {
    State state;
    ArrayList<Comentario> comentarios = new ArrayList<>();
    ArrayList<Multimidia> multimidias = new ArrayList<>();

    public Receita(){
       this.state=new StateRascunho();
    }

    public void setState(State state){
        this.state=state;
    }

    public String getState() {
        System.out.println(this.state.toString());
        return this.state.toString();
    }

    public void addComentario(Comentario comentario){
        this.comentarios.add(comentario);
    }

    public void responderComentario(Comentario comentario, Comentario resposta){
        comentario.addResposta(resposta);
    }

    public ArrayList<Comentario> getComentarios(){
        return this.comentarios;
    }

    public ArrayList<Multimidia> getListMultimidia() {
        return multimidias;
    }

    public void addMultimidia(Multimidia multimidia){
        this.multimidias.add(multimidia);
    }

    public void getMultimidia(int index){
        this.multimidias.get(index);
    }
}
