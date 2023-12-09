package tpa.app;

import assets.lib.Livro;
import java.util.Comparator;

public class ComparadorLivrosPorNome implements Comparator<Livro> {
    @Override
    public int compare(Livro o1, Livro o2) {
        return o1.getTitulo().compareTo(o2.getTitulo());
    }
}