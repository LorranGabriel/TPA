/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvores.lib;

/**
 *
 * @author victoriocarvalho
 */
public class No<T> {
    private T valor;
    private No<T> filhoEsquerda;
    private No<T> filhoDireita;
    private int altura; // Nova propriedade para armazenar a altura do nó.

    public No(T valor) {
        this.valor = valor;
        this.filhoEsquerda = null;
        this.filhoDireita = null;
        this.altura = 1; // Inicializa a altura como 1, já que é um nó folha.
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getFilhoEsquerda() {
        return filhoEsquerda;
    }

    public void setFilhoEsquerda(No<T> filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    public No<T> getFilhoDireita() {
        return filhoDireita;
    }

    public void setFilhoDireita(No<T> filhoDireita) {
        this.filhoDireita = filhoDireita;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}