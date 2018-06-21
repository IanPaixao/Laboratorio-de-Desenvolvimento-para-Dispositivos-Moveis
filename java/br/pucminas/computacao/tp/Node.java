package br.pucminas.computacao.tp;
import java.util.HashMap;
import java.util.Map;


public class Node {
    Object object;
    Map<Object,Node> filho;

    /**
     *
     */
    public Node(Object object){
        this.object = object;
        filho = new HashMap<>();
    }// End Node()

    /**
     *
     */
    public Node(){
        this.object = null;
        filho = new HashMap<>();
    }// End Node()
}// End class Node

