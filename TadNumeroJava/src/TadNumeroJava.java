
import java.util.Scanner;

/**
 *
 * @author prof. Marcio Porto Feitosa
 */
public class TadNumeroJava {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        Numero numero = new Numero();

        while (true) {
            System.out.println("===================================================");
            System.out.println("            Estudo do TAD Numero");
            System.out.println("===================================================");
            System.out.println("0 - encerrar");
            System.out.println("1 - ler valor");
            System.out.println("2 - atribuir valor");

            System.out.print("Qual sua opção? ");

            int opc = scn.nextInt();

            if (opc == 0) {
                break;
            } else if (opc == 1) {
                System.out.println("\n\n" + numero.getValor() + "\n\n");
            } else if (opc == 2) {
                System.out.print("Forneça o novo valor: ");
                float v = scn.nextFloat();
                numero.setValor(v);
            }

        }
        System.out.println("--- FIM ---");
        System.out.println("Até a próxima.");

    }

}
