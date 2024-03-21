package org.exercicio2;

import java.util.Arrays;
import java.util.Scanner;

public class Question3 {

        private final int[][] adjacencyMatrix;
        private final int numVertices;

        public Question3(int numVertices) {
            this.numVertices = numVertices;
            adjacencyMatrix = new int[numVertices][numVertices];
        }

        public void addEdge(int startVertex, int endVertex, int weight) {
            // Grafo direcionado
            adjacencyMatrix[startVertex][endVertex] = weight;
            // Para grafo não-direcionado, adicione a linha abaixo:
            // adjacencyMatrix[endVertex][startVertex] = weight;
        }

        public void printAdjacencyMatrix() {
            System.out.println("Matriz de Adjacência:");
            for (int[] row : adjacencyMatrix) {
                System.out.println(Arrays.toString(row));
            }
        }

        public void dijkstra(int src) {
            int[] dist = new int[numVertices];
            boolean[] sptSet = new boolean[numVertices];

            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            for (int count = 0; count < numVertices - 1; count++) {
                int u = minDistance(dist, sptSet);
                sptSet[u] = true;

                for (int v = 0; v < numVertices; v++) {
                    if (!sptSet[v] && adjacencyMatrix[u][v] != 0 &&
                            dist[u] != Integer.MAX_VALUE &&
                            dist[u] + adjacencyMatrix[u][v] < dist[v]) {
                        dist[v] = dist[u] + adjacencyMatrix[u][v];
                    }
                }
            }

            printSolution(src, dist);
        }

        private int minDistance(int[] dist, boolean[] sptSet) {
            int min = Integer.MAX_VALUE, minIndex = -1;

            for (int v = 0; v < numVertices; v++) {
                if (!sptSet[v] && dist[v] <= min) {
                    min = dist[v];
                    minIndex = v;
                }
            }
            return minIndex;
        }

        private void printSolution(int src, int[] dist) {
            System.out.println("Distância do vértice " + src + " para todos os outros vértices:");
            for (int i = 0; i < numVertices; i++) {
                System.out.println(src + " -> " + i + " = " + dist[i]);
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o número de vértices:");
            int numVertices = scanner.nextInt();

            Question3 graph = new Question3(numVertices);

            System.out.println("Digite o número de arestas:");
            int numEdges = scanner.nextInt();

            System.out.println("Digite as arestas no formato <origem> <destino> <peso>:");
            for (int i = 0; i < numEdges; i++) {
                int startVertex = scanner.nextInt();
                int endVertex = scanner.nextInt();
                int weight = scanner.nextInt();

                graph.addEdge(startVertex, endVertex, weight);
            }

            graph.printAdjacencyMatrix();

            System.out.println("Digite o vértice de origem para calcular a distância:");
            int src = scanner.nextInt();

            graph.dijkstra(src);
        }
    }
