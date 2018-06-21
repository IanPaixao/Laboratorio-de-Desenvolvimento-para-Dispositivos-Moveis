package br.pucminas.computacao.tp;

import java.util.ArrayList;
import java.util.Map;

public class Tree{
    private Node root; // raiz da estrutura
    private static ArrayList<Object> estados = new ArrayList<>();
    private static ArrayList<Object> cidades = new ArrayList<>();

    public Tree(Object[] estados, Object[] cidades){
        this.root = new Node(); // inicialização da raiz como nó cabeça
        inserirEstado(estados); // inserindo todos os estados na árvore
        inserirCidade(cidades,estados); // inserindo todas as cidades na árvore
    }// End Arvore()


    public Tree(){
        this.root = new Node(); // inicialização da raiz como nó cabeça
    }// End Arvore()


    private void inserirEstado(Object[] estados){
        assert estados != null;
        for(Object estado : estados){
            this.root.filho.put(estado,new Node(estado));
        }// End for
    }// End inserir()


    private void inserirCidade(Object[] cidades,Object[] estados){
        int i = 0;
        for(Object cidade : cidades){
            this.root.filho.get(estados[i]).filho.put(cidade,new Node(cidade)); i++;
        }// End for
    }// End inserirCidade()


    public boolean removerEstado(Object uf){
        return this.root.filho.remove(uf) != null ? true : false;
    }// End  removerEstado()


    public boolean removerCidade(Object uf, Object cidade){
        return this.root.filho.get(uf).filho.remove(uf) != null ? true : false;
    }// End removerCidade()

    /**
     *
     */
    public void mostrar(){
        Node node = this.root;
        int i,j;
        i = j = 1;

        for(Map.Entry<Object,Node> entry : node.filho.entrySet()){
            if(entry != null && entry.getKey() != null && entry.getValue() != null){
                System.out.println("    " + i + "° State: " + entry.getValue().object + " / Key State: " + entry.getKey() + "\n");
                for(Map.Entry<Object,Node> map_entry : node.filho.get(entry.getKey()).filho.entrySet()){
                    if(map_entry != null && map_entry.getKey() != null && map_entry.getValue() != null){
                        System.out.println("    \t" + j + "° City: " + map_entry.getValue().object + " Key City: " + map_entry.getKey()); j++;
                    }// End if
                }// End for
            }// End if
        }// End for

    }// End mostrar()


    public Object[] getEstados(){
        return estados.toArray();
    }// End getEstados()


    public Object[] getCidades(){
        Node node = this.root;
        for(Map.Entry<Object,Node> entry : node.filho.entrySet()){
            if(entry != null && entry.getKey() != null && entry.getValue() != null){
                estados.add(entry.getKey());
                for(Map.Entry<Object,Node> map_entry : node.filho.get(entry.getKey()).filho.entrySet()){
                    if(map_entry != null && map_entry.getKey() != null && map_entry.getValue() != null){
                        cidades.add(map_entry.getKey());
                    }// End if
                }// End for
            }// End if
        }// End for
        return cidades.toArray();
    }// End getCidades()
}// End class Arvore

