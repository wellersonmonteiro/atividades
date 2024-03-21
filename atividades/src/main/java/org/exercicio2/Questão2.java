package org.exercicio2;

import java.util.Scanner;

public class Questão2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        org.example.Question1 grafo = new org.example.Question1();

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Me informe a quantidade de vertices:");
        int valor = input.nextInt();
        grafo.setVer(valor);


        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Me informe a quantidade de arestas:");
        valor = input.nextInt();
        grafo.setAres(valor);

        int[][] matrizincidencia = new int[grafo.vert][grafo.ares];
        System.out.println("---------------------------------------------------------------------------");

        for (int i = 0; i < grafo.vert; i++) {
            System.out.println("O vertice " + (i + 1) + " possui arrestas? Digite 1 para verdadeiro  0 " +
                    "para falso.");
            valor = input.nextInt();

            if (valor == 0) {
                for (int j = 0; j < grafo.ares; j++) {
                    matrizincidencia[i][j] = 0;
                }

            } else {
                System.out.println("---------------------------------------------------------------------------");
                System.out.println("Quantas arestas possui o vertice  " + (i + 1) + ":");
                int valorAr = input.nextInt();

                for (int j = 0; j < valorAr; j++) {
                    System.out.println("Me informe o número da " + (j + 1) + "º aresta(no formato numérico) do vertice " + (i + 1) + ":");
                    int valortemp = input.nextInt();
                    matrizincidencia[i][valortemp - 1] = 1;

                }
            }
        }

    }

}
