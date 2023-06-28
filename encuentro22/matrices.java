import java.util.Arrays;        // Se importó porque se uso solamente toString()

public class matrices{
    public static void main(String[] args) {
        // int[] array1 = new int[7];          // Creé un arreglo de 1 fila y 7 columnas
        int[]   array2 = {4, 3, 2, 0, 0};
        int[][] matriz2 = new int[4][8];
        int[][] matriz = {{6,8,3,5,9},
                        {34,12,65,90,0},  
                        array2,   
                        {5,3,65,0,30}};

        // el Arrays.toString(X) -> convierte X en string donde x es un array
        System.out.println(Arrays.toString(array2));
        System.out.println();           // Reralizo un salto de líneaw

        for (int i = 0; i < matriz.length; i++) {
            System.out.println(Arrays.toString(matriz[i]));
        }

        System.out.println();
        
        // Se reactualizan los valores de la matriz de ingresos
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random()*(10)+0);
            }
        }
        
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(Arrays.toString(matriz[i]));
        }

        System.out.println();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                int valor = matriz[i][j];
                // Ejemplo de uso de continue
                if (valor != 0 && valor % 2 == 0) {
                continue; 
                // Salta a la siguiente iteración sin ejecutar el código restante dentro del bucle interno

                }
                // Ejemplo de uso de break
                if (valor == 0) {
                System.out.println("Se encontró el número 0 se detiene el bucle que recorre la fila i="+i);

                break; 
                // Sale del bucle interno y continúa con la siguiente iteración del bucle externo

                }
                System.out.println("posición: ["+i+","+j+"] Valor: "+valor);


            }
        }

        
        // for (int i = 0; i < matriz.length; i++) {
        //     System.out.println(Arrays.toString(matriz[i]));
        // }
    }
}