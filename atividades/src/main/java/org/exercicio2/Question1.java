package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Question1 {

    public int vert;
    public int ares;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Question1 grafo = new Question1();

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Me informe a quantidade de vertices:");
        int valor = input.nextInt();
        grafo.setVer(valor);

        int[][] matrizAdjacencia = new int[grafo.vert][grafo.vert];

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

        //Matriz de incidência
        for (int i = 0; i < grafo.vert; i++) {
            for (int j = 0; j < grafo.ares; j++) {
                System.out.printf("%d ", matrizincidencia[i][j]);
            }
            System.out.println();
        }

        //Matriz de adjacência
        for (int i = 0; i < matrizincidencia.length; i++) {
            // Para cada linha, percorra todas as colunas
            for (int j = 0; j < matrizincidencia[i].length; j++) {
                // Se encontrar uma conexão (valor diferente de zero)
                if (matrizincidencia[i][j] != 0) {
                    // Encontre os vértices conectados e atualize a matriz de adjacência
                    for (int k = 0; k < matrizincidencia.length; k++) {
                        if (k != i && matrizincidencia[k][j] != 0) {
                            matrizAdjacencia[i][k] = 1; // Atualize a matriz de adjacência
                            matrizAdjacencia[k][i] = 1; // Como a matriz é simétrica para grafos não direcionados
                        }
                    }
                }
            }
        }
        System.out.println("Matriz de adjacência:");
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = 0; j < matrizincidencia.length; j++) {
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setVer(int vert) {
        this.vert = vert;
    }

    public void setAres(int ares) {
        this.ares = ares;
    }
}