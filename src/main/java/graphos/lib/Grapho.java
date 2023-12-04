/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphos.lib;

/**
 *
 * @author neo
 */
import java.util.*;

public class Grapho<T> {
    private final Map<T, List<T>> adjacencias;

    public Grapho() {
        this.adjacencias = new HashMap<>();
    }

    public void adicionarVertice(T vertice) {
        adjacencias.put(vertice, new ArrayList<>());
    }

    public void adicionarAresta(T origem, T destino) {
        adjacencias.get(origem).add(destino);
    }

    public boolean contemCiclo() {
        Set<T> visitados = new HashSet<>();
        Set<T> pilhaRecursao = new HashSet<>();

        for (T vertice : adjacencias.keySet()) {
            if (contemCicloUtil(vertice, visitados, pilhaRecursao)) {
                return true;
            }
        }

        return false;
    }

    private boolean contemCicloUtil(T vertice, Set<T> visitados, Set<T> pilhaRecursao) {
        if (pilhaRecursao.contains(vertice)) {
            return true;
        }

        if (visitados.contains(vertice)) {
            return false;
        }

        visitados.add(vertice);
        pilhaRecursao.add(vertice);

        List<T> vizinhos = adjacencias.get(vertice);
        for (T vizinho : vizinhos) {
            if (contemCicloUtil(vizinho, visitados, pilhaRecursao)) {
                return true;
            }
        }

        pilhaRecursao.remove(vertice);
        return false;
    }

    public Grapho<T>ordenacaoTopologica() {
        Stack<T> pilha = new Stack<>();
        Set<T> visitados = new HashSet<>();

        for (T vertice : adjacencias.keySet()) {
            if (!visitados.contains(vertice)) {
                ordenacaoTopologicaUtil(vertice, visitados, pilha);
            }
        }
       
        Grapho<T> graphoOrdenado = new Grapho<>();
        while (!pilha.isEmpty()) {
            T vertice = pilha.pop();
            graphoOrdenado.adicionarVertice(vertice);

            for (T vizinho : adjacencias.get(vertice)) {
                graphoOrdenado.adicionarAresta(vertice, vizinho);
            }
        }

        return graphoOrdenado;
    }

    private void ordenacaoTopologicaUtil(T vertice, Set<T> visitados, Stack<T> pilha) {
        visitados.add(vertice);

        List<T> vizinhos = adjacencias.get(vertice);
        for (T vizinho : vizinhos) {
            if (!visitados.contains(vizinho)) {
                ordenacaoTopologicaUtil(vizinho, visitados, pilha);
            }
        }

        pilha.push(vertice);
    }
    
    public String populaVizualizacao() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<T, List<T>> entry : adjacencias.entrySet()) {
            String vertice = (String) entry.getKey();
            List<String> vizinhos = (List<String>) entry.getValue();

            sb.append(vertice).append(" -> ").append(String.join(", ", vizinhos)).append("\n");
        }
        return sb.toString();
    }
    
    
    public Map<T, List<T>> getAdjacencias() {
        return adjacencias;
    }
}
