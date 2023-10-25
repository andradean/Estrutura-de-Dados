
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marcio Porto Feitosa - 02/10/2022 - 18:16
 */
public class TadPilhaJavaExerc2 {

    static TadPilha pilha1, pilha2, pilha3;
    static int tam, qtd;

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------");
        System.out.println("          J O G O   D A S   T R E S   P I L H A S");
        System.out.println("       (inspirado no quebra-cabecas 'Torres de Hanoi')");
        System.out.println("           Idealizado pelo prof. Marcio Feitosa");
        System.out.println("-----------------------------------------------------------");

        while (true) {
            System.out.println("");
            System.out.print("Informe o tamanho das pilhas (min 5 e max. 100): ");
            tam = scn.nextInt();
            if (tam < 5 || tam > 100) {
                System.out.println("ERRO: tamanho invalido.");
                continue;
            }
            System.out.print("Informe a quantidade inicial de números nas pilhas 1 e 2 (min 3. e max. " + tam + "): ");
            qtd = scn.nextInt();
            if (qtd < 3 || qtd > tam) {
                System.out.println(
                        "ERRO: quantidade de numeros nao pode ser menor que 3 nem maior que o tamanho da pilha.");
                continue;
            }
            break;
        }

        // === instanciar as 3 pilha
        pilha1 = new TadPilha(tam);
        pilha2 = new TadPilha(tam);
        pilha3 = new TadPilha(tam);

        // === preencher pilha1 e pilha2 com nuneros aleatorios
        // vamos adotar que a faixa de numeros possiveis ira' de 0 ate' 5X a quantidade
        // inicial de numeros nas pilhas
        Random seed = new Random();
        for (int i = 0; i < qtd; i++) {
            pilha1.push(seed.nextInt(5 * qtd));
            pilha2.push(seed.nextInt(5 * qtd));
        }

        while (true) {

            System.out.println("\n\n\n===============================================================");

            imprimirPilhas();

            System.out.println("\n\n===============================================================");
            System.out.println("");
            System.out.println("0 - encerrar");
            System.out.println("1 - mover");
            System.out.println("");
            System.out.print("Opcao: ");
            int opc = scn.nextByte();

            if (opc == 0) {
                System.out.print("Deseja encerrar? (1 = sim; 2 = nao -> ");
                int opc0 = scn.nextByte();
                if (opc0 == 1) {
                    break;
                }
            } else if (opc == 1) {

                System.out.print("Pop na pilha... ");
                int pop = scn.nextByte();
                System.out.print("Push na pilha... ");
                int push = scn.nextByte();

                // ==============================================================
                // verificacao de consistencia entre as pilhas
                //
                if (pop < 1 || pop > 3 || push < 1 || push > 3) {
                    System.out.println("ERRO: pilha de numero invalido.");
                    continue;
                }
                if (pop == push) {
                    System.out.println("ERRO: trata-se da mesma pilha");
                    continue;
                }
                // --------------------------------------------------------------

                // ==============================================================
                // Estabelecer ponteiros para as pilhas de pop e de push
                //
                TadPilha pilhaPop = null;
                TadPilha pilhaPush = null;

                switch (pop) {
                    case 1:
                        pilhaPop = pilha1;
                        break;
                    case 2:
                        pilhaPop = pilha2;
                        break;
                    case 3:
                        pilhaPop = pilha3;
                        break;
                }

                switch (push) {
                    case 1:
                        pilhaPush = pilha1;
                        break;
                    case 2:
                        pilhaPush = pilha2;
                        break;
                    case 3:
                        pilhaPush = pilha3;
                        break;
                }

                if (pilhaPop == null || pilhaPush == null) {
                    System.out.println("ERRO FATAL! Pelo menos uma das pilhas nao foi inicializada.");
                    break;
                }
                // --------------------------------------------------------------

                // ==============================================================
                // verificacao de pilha vazia para pop e pilha cheia para push
                //
                if (pilhaPop.empty()) {
                    System.out.println("ERRO: nao e' possivel fazer o pop na PILHA" + pop + ". Pilha vazia.");
                    continue;
                }
                if (pilhaPush.full()) {
                    System.out.println("ERRO: nao e' possivel fazer o push na PILHA" + push + ". Pilha cheia");
                    continue;
                }
                // --------------------------------------------------------------

                // EXECUTAR pop e push
                pilhaPop.pop();
                pilhaPush.push(pilhaPop.getRetorno());

                if (fimDeJogo()) {
                    System.out.println("\n\nPARABENS!!! Jogo concluido.\n\n");
                    break;
                }

            }

        }

        System.out.println("\n\nObrigado e ate' a proxima!!\n\n");
        scn.close();

    }

    /**
     * Formatar um numero com 4 posicoes (espacos a esquerda)
     * <br>
     * (este e' um metodo mais <i>raiz</i>; nao utiliza nenhum recurso de
     * formatacao disponivel)
     *
     * @param nr
     * @return
     */
    private static String formataNumero(int nr) {
        String nrS = String.valueOf(nr);
        while (nrS.length() < 4) {
            nrS = " " + nrS;
        }
        return nrS;
    }

    private static void imprimirPilhas() {

        // imprimir pilha1 =================================================
        System.out.print("\nPILHA 1 - ");
        for (int i = 0; i < pilha1.qtd(); i++) {
            System.out.print(formataNumero(pilha1.read(i)) + " ");
        }
        System.out.print(" | (" + (tam - pilha1.qtd()) + " vagas)");
        // ------------------------------------------------------------------

        // imprimir pilha2 =================================================
        System.out.print("\n\nPILHA 2 - ");
        for (int i = 0; i < pilha2.qtd(); i++) {
            System.out.print(formataNumero(pilha2.read(i)) + " ");
        }
        System.out.print(" | (" + (tam - pilha2.qtd()) + " vagas)");
        // ------------------------------------------------------------------

        // imprimir pilha3 =================================================
        System.out.print("\n\nPILHA 3 - ");
        for (int i = 0; i < pilha3.qtd(); i++) {
            System.out.print(formataNumero(pilha3.read(i)) + " ");
        }
        System.out.print(" | (" + (tam - pilha3.qtd()) + " vagas)");
        // ------------------------------------------------------------------
        
    }

    private static boolean fimDeJogo() {

        // PILHA1 e PILHA2 tem que ter 'qtd' elementos; PILHA3 tem que estar vazia
        if (pilha1.qtd() != qtd || pilha2.qtd() != qtd || pilha3.qtd() > 0) {
            return false;
        }
        // verificar se PILHA1 esta' ordenado do fundo para o topo
        for (int i = 0; i < pilha1.qtd() - 1; i++) {
            if (pilha1.read(i) > pilha1.read(i + 1)) {
                return false;
            }
        }
        // verificar se a PILHA2 esta' ordenada do topo para o fundo
        for (int i = pilha2.qtd() - 1; i > 0; i--) {
            if (pilha2.read(i) > pilha2.read(i - 1)) {
                return false;
            }
        }

        return true;
    }


}
