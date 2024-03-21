package org.exercicio2;

import java.util.Scanner;

public class Questao2 {

    public int vert;
    public int ares;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Questao2 grafo = new Questao2();

        boolean contem= false;
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


        System.out.println("Existe um vertice que se conecta com todos os outros: ");
        //Matriz de adjacência
        for (int i = 0; i < matrizincidencia.length; i++) {
            int count = 0;
            // Para cada linha, percorra todas as colunas
            for (int j = 0; j < matrizincidencia[i].length; j++) {
                // Se encontrar uma conexão (valor diferente de zero)
                if (matrizincidencia[i][j] != 0) {
                    // Encontre os vértices conectados e atualize a matriz de adjacência
                    for (int k = 0; k < matrizincidencia.length; k++) {
                        if (k != i && matrizincidencia[k][j] != 0) {
                            count++;
                        }
                    } if(count == (grafo.vert) - 1){
                        System.out.println("O vertece "+ (i +1));
                        contem = true;
                    }
                }

            }
        }
        if (!contem){
            System.out.println("Não existe nenhum elemento!");
        }

    }

    public void setVer(int vert) {
        this.vert = vert;
    }

    public void setAres(int ares) {
        this.ares = ares;
    }
}