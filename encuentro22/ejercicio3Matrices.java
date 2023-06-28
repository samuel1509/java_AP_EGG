/*
 * 3. Encontrar el número más grande y más pequeño en una matriz: Encuentra y muestra el número más grande y más pequeño en una matriz.
 */

import java.util.Arrays;

public class ejercicio3Matrices {
    public static void main(String[] args) {
        int[][] matriz1 = {
            {1, 23, 2}, 
            {85, 6, 4}, 
            {12, 53, 5}
        };

        // Imprimo cada uno de los arrays de la matriz
        for (int i = 0; i < matriz1.length; i++) {
            System.out.println(Arrays.toString(matriz1[i]));
        }

        System.out.print("\n");

        // Sumar todos los valores de la matriz
        int valorMenor = 0;
        int valorMayor = 0;
        int mayorAbsoluto = 0;
        int menorAbsoluto = 0;
        for (int i = 0; i < matriz1.length; i++) {  
            for (int j = 0; j < matriz1[i].length; j++) {
                int valorNuevo = matriz1[i][j];
                if (j != 0) {
                    if (valorNuevo < valorMenor){
                        valorMenor = valorNuevo;
                    } else if (valorNuevo > valorMayor){
                        valorMayor = valorNuevo;
                    }
                } else {
                    valorMayor = valorNuevo;
                    valorMenor = valorNuevo;
                }                     
            }
            // Imprime los valores menores y mayores de cada fila
            System.out.println("Fila "+i+"\n\t ValorMayor: " + valorMayor + "\n\t ValorMenor: " + valorMenor );
            if (i!= 0){
                if (valorMayor > mayorAbsoluto) mayorAbsoluto = valorMayor;
                if (valorMenor < menorAbsoluto) menorAbsoluto = valorMenor;
            } else {
                menorAbsoluto = valorMenor;
                mayorAbsoluto = valorMayor;
            }
        }

        System.out.print(
            "\nLos valores absolutos son:\n\tMayor: " +
            mayorAbsoluto +
            "\n\tMenor: " +
            menorAbsoluto
        );
       
    }
}
