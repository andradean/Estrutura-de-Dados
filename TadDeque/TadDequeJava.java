


import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @class TadDequeJava
 * @author Marcio Porto Feitosa - 08/12/2022 - 22:27:06
 */
public class TadDequeJava {

    static Deque<Integer> deque;
    static Scanner scn;
    static int maxTam;

    public static void main(String[] args) {

//        deque = new ArrayDeque<>(3);
        deque = new LinkedBlockingDeque<>(3);

        scn = new Scanner(System.in);

        System.out.print("Tamanho maximo do Deque -> ");
        maxTam = scn.nextInt();
        if (maxTam <= 0){
            System.out.println("Tamanhos permitidos >= 1");
            return;
        }

        while (true) {

            System.out.println("\n\n================================================");
            System.out.println("            ESTUDO DO TAD DEQUE");
            System.out.println("================================================");
            System.out.println("0 - sair");
            System.out.println("1 - Inserir elemento no inicio");
            System.out.println("2 - Inserir elemento no final");
            System.out.println("3 - Remover elemento do inicio");
            System.out.println("4 - Remover elemento do final");
            System.out.println("5 - Ler elemento de uma determinada posicao");
            System.out.println("6 - Imprimir elementos do Deque");

            System.out.print("\n\nOpcao -> ");
            int opc = scn.nextInt();

            if (opc == 0) {
                break;
            } else if (opc == 1) {
                if (cheio()) {
                    continue;
                }
                int v = getValor();
                deque.addFirst(v);
            } else if (opc == 2) {
                if (cheio()) {
                    continue;
                }
                int v = getValor();
                deque.addLast(v);
            } else if (opc == 3) {
                if (vazio()) {
                    continue;
                }
                int v = deque.removeFirst();
                System.out.println("Elemento removido do inicio -> " + v);
            } else if (opc == 4) {
                if (vazio()) {
                    continue;
                }
                int v = deque.removeLast();
                System.out.println("Elemento removido do final -> " + v);
            } else if (opc == 5) {

                int posDesejada = getValor();
                if (posDesejada > deque.size() || posDesejada <= 0) {
                    System.out.println("Nao ha' elemento nesta posicao (" + posDesejada + ")");
                    continue;
                }
                Iterator<Integer> it = deque.iterator();
                int posAtual = 0;
                boolean loc = false;
                while (it.hasNext()) {
                    posAtual++;
                    if (posAtual == posDesejada) {
                        System.out.println("O elemento da posicao " + posDesejada + " e' -> " + it.next());
                        loc = true;
                        break;
                    }
                    it.next();
                }
                if (!loc) {
                    System.out.println("Elemento nao localizado.");
                }

            } else if (opc == 6) {

//                System.out.println(deque);
                Iterator<Integer> it = deque.iterator();
                while (it.hasNext()) {
                    System.out.print(it.next() + ", ");
                }

            }
            else if (opc == 99){
                
                int v = getValor();
                deque.add(v);
                
            }

        }

    }

    private static boolean vazio() {
        if (deque.isEmpty()) {
            System.out.println("O Deque esta' vazio.");
            return true;
        }
        return false;
    }

    private static boolean cheio() {
        if (deque.size() == maxTam) {
            System.out.println("O Deque esta' cheio.");
            return true;
        }
        return false;
    }

    private static int getValor() {
        System.out.print("Informe o valor do elemento -> ");
        int v = scn.nextInt();
        return v;
    }

}
