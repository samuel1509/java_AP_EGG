/*
 * 2. Suma de los elementos de una matriz: Calcula e imprime la suma de todos 
 * los elementos de la matriz.
 */

import java.util.Arrays;

public class ejercicio2Matrices {
    
    public static void main(String[] args) {
        int[][] matriz1 = {
            {1, 2, 5},
            {8, 0, 3},
            {12, 5, 5}
        };

        // Imprimo cada uno de los arrays de la matriz
        for (int i = 0; i < matriz1.length; i++) {
            System.out.println(Arrays.toString(matriz1[i]));
        }

        System.out.print("\n");

        // Sumar todos los valores de la matriz
        int valorMatriz = 0;
        for (int i = 0; i < matriz1.length; i++) {       
            int celda = 0;     
            for (int j = 0; j < matriz1[i].length; j++) {                
                celda = celda + matriz1[i][j];               
            }
            // Imprime el valor de la suma de cada una de los elementos de la fila
            System.out.println("El valor de la fila "+i+" es: " + celda);
            valorMatriz = valorMatriz + celda;
        }

        System.out.println("El valor de la sumatoria de todas las celdas es: " + valorMatriz);
        
    }
}
