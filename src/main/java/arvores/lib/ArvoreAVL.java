package arvores.lib;

import java.util.Comparator;

public class ArvoreAVL<T> extends ArvoreBinaria<T> {

    public ArvoreAVL(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void adicionar(T novoValor) {
        super.adicionar(novoValor);
        balancear();
    }

    private int altura(No<T> no) {
        return (no == null) ? 0 : no.getAltura();
    }

    private int fatorBalanceamento(No<T> no) {
        return altura(no.getFilhoEsquerda()) - altura(no.getFilhoDireita());
    }

    private void atualizarAltura(No<T> no) {
        if (no != null) {
            no.setAltura(1 + Math.max(altura(no.getFilhoEsquerda()), altura(no.getFilhoDireita())));
        }
    }

    private No<T> rotacaoDireita(No<T> y) {
        No<T> x = y.getFilhoEsquerda();
        No<T> T2 = x.getFilhoDireita();

        x.setFilhoDireita(y);
        y.setFilhoEsquerda(T2);

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    private No<T> rotacaoEsquerda(No<T> x) {
        No<T> y = x.getFilhoDireita();
        No<T> T2 = y.getFilhoEsquerda();

        y.setFilhoEsquerda(x);
        x.setFilhoDireita(T2);

        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }

    private void balancear() {
        if (raiz != null) {
            raiz = balancear(raiz);
        }
    }

    private No<T> balancear(No<T> no) {
        atualizarAltura(no);

        int fator = fatorBalanceamento(no);

        if (fator > 1) {
            if (altura(no.getFilhoEsquerda().getFilhoEsquerda()) >= altura(no.getFilhoEsquerda().getFilhoDireita())) {
                return rotacaoDireita(no);
            } else {
                no.setFilhoEsquerda(rotacaoEsquerda(no.getFilhoEsquerda()));
                return rotacaoDireita(no);
            }
        }

        if (fator < -1) {
            if (altura(no.getFilhoDireita().getFilhoDireita()) >= altura(no.getFilhoDireita().getFilhoEsquerda())) {
                return rotacaoEsquerda(no);
            } else {
                no.setFilhoDireita(rotacaoDireita(no.getFilhoDireita()));
                return rotacaoEsquerda(no);
            }
        }

        return no;
    }
}
