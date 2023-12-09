/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvores.lib;
 
import assets.lib.Livro;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
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
        No<T> novo = new No<T>(novoValor);
        No<T> noatual = this.getRaiz();
        boolean parar = false;

        if(noatual == null){
            this.raiz = novo;
            this.folhas += 1;
        }
        else{
            while(!parar){
                if(comparador.compare(novo.getValor(),noatual.getValor()) < 0){
                    //noatual = noatual.getEsq();
                    if(noatual.getFilhoEsquerda() == null){
                        noatual.setFilhoEsquerda(novo);
                        parar = true;
                        this.folhas += 1;
                    }else{
                        noatual = noatual.getFilhoEsquerda();
                    }
                } else if (comparador.compare(novo.getValor(),noatual.getValor()) > 0) {
                    //noatual = noatual.getEsq();
                    if(noatual.getFilhoDireita() == null){
                        noatual.setFilhoDireita(novo);
                        parar = true;
                        this.folhas += 1;
                    }else{
                        noatual = noatual.getFilhoDireita();
                    }
                }
                else{
                    System.out.printf("Valor %s ja existe na arvore.", noatual.getValor().toString()
                    );
                }
            }
        }
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
        return caminharEmNivel(this.raiz);
    }

    private String caminharEmNivel(No<T> no) {
        StringBuilder result = new StringBuilder();
        if (no != null) {
            // Utiliza uma fila para percorrer em nível
            Queue<No<T>> fila = new LinkedList<>();
            fila.add(no);

            while (!fila.isEmpty()) {
                No<T> temp = fila.poll();
                result.append(temp.getValor()).append(" ");

                if (temp.getFilhoEsquerda() != null) {
                    fila.add(temp.getFilhoEsquerda());
                }

                if (temp.getFilhoDireita() != null) {
                    fila.add(temp.getFilhoDireita());
                }
            }
        }
        return result.toString();
    }
    
    @Override
    public String caminharEmOrdem() {
        return caminharEmOrdem(this.raiz);
    }

    private String caminharEmOrdem(No<T> no) {
        StringBuilder result = new StringBuilder();
        if (no != null) {
            result.append(caminharEmOrdem(no.getFilhoEsquerda()));
            result.append(no.getValor()).append(" ");
            result.append(caminharEmOrdem(no.getFilhoDireita()));
        }
        return result.toString();
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
            Livro livro = (Livro) no.getValor();
                
            line = line.concat(livro.getTitulo());
            line = line.concat("\n");
            System.out.printf(line);

            return line.concat(populaVizualizacao(no.getFilhoEsquerda(), nivel + 1));
        }
        return "";
    }
   
    @Override
    public void popularJTextAreaImages(JEditorPane textArea, List<Livro> listaDeLivros) {
        StringBuilder htmlBuilder = new StringBuilder("<html>");

        for (Livro livro : listaDeLivros) {
            htmlBuilder.append("<p><b>").append(livro.getTitulo()).append("</b></p>");
            htmlBuilder.append("<img src='").append(livro.getImagemBase64()).append("'/>");
            htmlBuilder.append("<br>");
        }

        htmlBuilder.append("</html>");

        textArea.setContentType("text/html");
        textArea.setEditable(false);
        textArea.setText(htmlBuilder.toString());
    }
}