
/**
 * classe ListaLigada
 * teste
 *
 * @author Marcio Porto Feitosa - 22/12/2022 - 17:31:28
 */
public class ListaLigada {

    private Elemento inicio;
    private Elemento ultimo;  // Ex1 - atributo "ultimo" incluido (nao usei o nome "fim" porque ja' tem essa referencia no codigo)
    private int qtd;  // Ex1 - quantidade de elementos na lista

    public boolean enqueue(Elemento e) {

        try {
            if (isEmpty()) {
                inicio = e;
            } else {
                Elemento fim = getUltimo();
                fim.setProximo(e);
            }
            ultimo = e;  // Ex1 - agora precisa trabalhar tambem com o ponteiro "ultimo".
            qtd++;  // Ex1
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    public Elemento dequeue() {

        if (inicio == null) {
            return null;
        }

        Elemento e = inicio;
        inicio = e.getProximo();
        if (isEmpty()) {  // Ex1
            ultimo = null;
        }
        e.setProximo(null);
        qtd--;  // Ex1
        return e;

    }

    /**
     * Retorna o primeiro elemento.
     *
     * @return
     */
    public Elemento getInicio() {
        return inicio;
    }

    /**
     * Ex1 - retorna o ultimo elemento.
     *
     * @return
     */
    public Elemento getUltimo() {
        return ultimo;
    }

    /**
     * Retorna o ultimo elemento
     *
     * @return
     */
    /* 
    -----------------------------------------
    Ex1 - este metodo nao e' mais necessario.
    -----------------------------------------
    public Elemento getFim() {

        if (isEmpty()) {
            return inicio;
        }
        Elemento e = inicio;
        while (e.getProximo() != null) {
            e = e.getProximo();
        }
        return e;
    }
     */
    public boolean isEmpty() {
        return inicio == null;
    }

    /**
     * Ex1 - retorna a quantidade de elementos na lista.
     *
     * @return
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * Ex1 - metodo para retornar (sem remover) o elemento de determinada
     * posicao.
     *
     * @param pos
     * @return
     */
    public Elemento getPos(int pos) {
        if (pos <= 0 || isEmpty() || pos > this.qtd) {
            return null;
        }
        if (pos == 1) {
            return inicio;
        }
        Elemento e = this.getInicio();
        int posAtual = 1;
        while (posAtual < pos) {
            e = e.getProximo();
            posAtual++;
        }
        return e;
    }

    /**
     * Ex1 - insere um elemento em determinada posicao na fila.
     *
     * @param pos Posicao desejada (pos >= 0)
     * @param e Elemento a ser inserido (e != null)
     * @return
     */
    public boolean enqueuePos(int pos, Elemento e) {

        if (pos > this.getQtd() + 1 || pos <= 0 || e == null) {
            return false;
        }
        if (this.isEmpty() || pos == this.getQtd() + 1) {
            return this.enqueue(e);
        } else if (pos == 1) {
            e.setProximo(inicio);
            inicio = e;
        } else {
            //= e' necessario encontrar o elemento da posicao anterior a que se deseja inserir o novo elemento
            Elemento eAnt = this.getPos(pos - 1);
            e.setProximo(eAnt.getProximo());
            eAnt.setProximo(e);
        }
        this.qtd++;
        return true;
    }

}  // class >
