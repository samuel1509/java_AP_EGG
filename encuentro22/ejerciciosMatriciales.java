/*
1. Matriz de elementos: Crea una matriz de 3x3 con enteros 
y muestra su contenido por consola en formato de matriz. Luego,
 muestra el mismo contenido en formato de arreglo. 
*/

import java.util.Arrays;

public class ejerciciosMatriciales {
    public static void main(String[] args) {
        int[][] matriz1 = {
            {1, 2, 5},
            {8, 0, 3},
            {12, 5, 5}
        };

        // Arrays arrayObjeto = {3,4,5};
        // Integer celda = 4;      // Objeto Variable
        // celda.toString();       // "4"
        // int celdaInt = 4;       // Variable

        for (int i = 0; i < matriz1.length; i++) {
            System.out.println(Arrays.toString(matriz1[i]));
        }

        System.out.print("\n");

        for (int i = 0; i < matriz1.length; i++) {

            for (int j = 0; j < matriz1[i].length; j++) {
                int celda = matriz1[i][j];
                System.out.print("[" + celda + "]" ); 
            }

            System.out.println();
        }

        // for (int i = 0; i < matriz1.length; i++){
        //     for (int j=0; j< matriz1[i].length; j++){
        //         System.out.println(String.toString(matriz1[i][j]));
        //     }
        //     System.out.println();
        // }
        
    }
}
