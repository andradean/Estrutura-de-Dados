
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @class TadFilaJava_Ex2c
 * @author Marcio Porto Feitosa - 21/11/2022 - 22:50:57
 */
public class TadFilaJava_Ex2c {

    static TadFila fila;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner scn1 = new Scanner(System.in);
        Scanner scn2 = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");
        System.out.println(" SIMULACAO DE TAMANHO DE FILA DE JOBS A SEREM PROCESSADOS");
        System.out.println("----------------------------------------------------------");
        System.out.println("");
        System.out.print("Tamanho máximo da fila -> ");
        int tam = scn1.nextInt();
        System.out.println("");

        fila = new TadFila(tam);

        System.out.print("Quantidade de ciclos de simulacao -----> ");
        int ciclos = scn2.nextInt();

        System.out.print("Maximo de jobs gerados por ciclo ------> ");
        int maxJobs = scn2.nextInt();

        System.out.print("Quantidade de processadores paralelos -> ");
        int procs = scn2.nextInt();

        int vezesExcedeu = 0;  // quantidade de vezes que a fila excedeu o tamanho maximo possivel
        int jobsGerados = 0;
        int jobsPerdidos = 0;

        for (int i = 1; i <= ciclos; i++) {

            int jobs = geraRand(maxJobs);
            jobsGerados += jobs;
            int variacao = jobs - procs;

            if (variacao > 0) {
                for (int j = 0; j < variacao; j++) {
                    if (fila.isFull()) {
                        vezesExcedeu++;
                        jobsPerdidos += variacao - j;
                        break;
                    }
                    fila.enqueue(geraRand(1000));
                }
            }
            if (variacao < 0) {
                variacao *= -1;
                for (int j = 0; j < variacao; j++) {
                    if (fila.isEmpty()) {
                        break;
                    }
                    fila.dequeue();
                }
            }

        }

        System.out.println("--------------------------------------------------");
        System.out.println("Rodou " + ciclos + " ciclos.");
        System.out.println("Jobs gerados -> " + jobsGerados);
        System.out.println("Excedeu " + vezesExcedeu + " vezes (" + 100 * vezesExcedeu / ciclos + "%)");
        System.out.println("Jobs perdidos -> " + jobsPerdidos + "(" + 100 * (double) jobsPerdidos / jobsGerados + " %)");

    }

    static int geraRand(int max) {

        Random seed = new Random();

        return Math.round(seed.nextInt(max + 1));

    }

}
