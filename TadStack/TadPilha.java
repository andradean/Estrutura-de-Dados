
/**
 * Classe representativa da estrutura de dados PILHA.
 * <br>Funcionalidades minimalistas - vide javadoc.
 *
 * @author Marcio Porto Feitosa - 23/09/2022 - 10:45:23
 */
public class TadPilha {

    public TadPilha(int tam) {
        this.tamanho = tam;
        this.topo = -1;
        this.pilha = new int[tam];
    }

    private final int tamanho;
    private int topo;
    private int[] pilha;

    private int retorno;

    public int getRetorno() {
        return retorno;
    }

    /**
     * Informa se a pilha esta' com a capacidade máxima ocupada.
     *
     * @return verdadeiro/falso
     */
    public boolean full() {
        return this.topo == this.tamanho - 1;
    }

    /**
     * Informa a quantidade de elementos na pilha.
     *
     * @return numerico
     */
    public int qtd() {
        return this.topo + 1;
    }

    /**
     * Informa se a pilha esta' vazia.
     *
     * @return verdadeiro/falso
     */
    public boolean empty() {
        return this.qtd() == 0;
    }

    /**
     * Insere um elemento na pilha.
     *
     * @param valor
     * @return true = operacao bem sucedida; false = operacao falhou (pilha
     * cheia)
     */
    public boolean push(int valor) {
        if (!this.full()) {
            this.topo += 1;
            this.pilha[this.topo] = valor;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retira um elemento da pilha.
     *
     * @return true = retirada bem sucedida; elemento disponivel via metodo
     * getRetorno()
     * <br>false = retirada falhou (pilha vazia?)
     * @see #getRetorno()
     */
    public boolean pop() {
        if (this.empty()) {
            return false;
        }
        this.retorno = this.pilha[this.topo];
        this.topo--;
        return true;
    }

    /**
     * Imprime o conteudo da pilha em uma string.
     *
     * @return
     */
    public String print() {
        String ret = "";
        if (this.empty()) {
            return "A pilha esta' vazia";
        }
        ret += "A pilha tem " + this.qtd() + " elementos.\n";
        for (int i = 0; i <= this.topo; i++) {
            ret += this.pilha[i] + " ";
        }
        return ret;
    }

    /**
     * Ler uma posicao da pilha.
     *
     * @param indice
     * @return
     */
    public int read(int indice) {
        if (indice > this.topo) {
            return -1;
        }
        return pilha[indice];
    }

}
