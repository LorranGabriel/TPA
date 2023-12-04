/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvores.lib;
 
import java.util.ArrayList;
import java.util.Comparator;
import tpa.app.Aluno;

/**
 *
 * @author victoriocarvalho
 */
public class ArvoreBinaria<T> implements IArvoreBinaria<T> {
    private int folhas;
    
    protected No<T> raiz = null;
    protected Comparator<T> comparador; 
    
    protected No<T> atual = null;
    private ArrayList<No<T>> pilhaNavegacao = null;

    public ArvoreBinaria(Comparator<T> comp) {
        comparador = comp;
        folhas = 0;
        raiz = null;
    }
    

    @Override
    public void adicionar(T novoValor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public No getRaiz(){
        return this.raiz;
    }
    
    @Override
    public T pesquisar(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        
        return calcularAltura(this.raiz);
    }
    
    private int calcularAltura(No<T> no) {
        if (no == null) {
            return 0;
        } else {
            int alturaEsquerda = calcularAltura(no.getFilhoEsquerda());
            int alturaDireita = calcularAltura(no.getFilhoDireita());

            // Retorna a altura do lado mais longo mais 1 (contando o próprio nó)
            return 1 + Math.max(alturaEsquerda, alturaDireita);
        }
    }
    
    @Override
    public int quantidadeNos() {
     return contarNos(this.raiz);
    }

    private int contarNos(No<T> no) {
        if (no == null) {
            return 0;
        } else {
            // Conta o próprio nó e os nós nos filhos
            return 1 + contarNos(no.getFilhoEsquerda()) + contarNos(no.getFilhoDireita());
        }
    }
    @Override
    public String caminharEmNivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
    
    @Override
    public String caminharEmOrdem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
    
    @Override
    public T obterProximo(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void reiniciarNavegacao(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    @Override
    public String imprimirArvore() {
        return populaVizualizacao(this.raiz, 0);
    }

    private String populaVizualizacao(No<T> no, int nivel) {
        if (no != null) {
            String line = populaVizualizacao(no.getFilhoDireita(), nivel + 1);

            for (int i = 0; i < nivel; i++) {
                line = line.concat("   ");
            }
            Aluno aluno = (Aluno) no.getValor();

            line = line.concat(String.valueOf(aluno.getMatricula()));
            line = line.concat("\n");
            return line.concat(populaVizualizacao(no.getFilhoEsquerda(), nivel + 1));
        }
        return "";
    }

}