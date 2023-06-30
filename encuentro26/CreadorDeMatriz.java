import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

// Crear matriz cuadrada aleatoria
public class CreadorDeMatriz {

    // Defino mi variable global de matriz
    public static int[][] matrizGenerada;

    public static void main(String[] args) {
        //  Estoy creando las variables locales que pediré al usuario
        int filasYColumnas = 0;
        int valorMaximo = 0;
        int valorMinimo = 0;
        boolean condicionInvalida = false; 

        do {            
            // Solicito valores al usuario
            try {            
                Scanner ingresos = new Scanner(System.in);
                System.out.println("Ingrese el tamaño de la matriz cuadrada");
                filasYColumnas = ingresos.nextInt();
                System.out.println("ingrese el valor Máximo");
                valorMaximo = ingresos.nextInt();
                System.out.println("ingrese el valor Mínimo");
                valorMinimo = ingresos.nextInt();
                while (valorMinimo > valorMaximo) {
                    System.out.println("Error: El valor mínimo no puede ser mayor que el valor máximo.");
                    System.out.print("Ingrese el valor mínimo permitido para los elementos: ");
                    valorMinimo = ingresos.nextInt();
                }
                ingresos.close();

                //  Correr el método para crear matriz aleatoria random
                condicionInvalida = 
                crearMatrizRandom(filasYColumnas, valorMaximo, valorMinimo);;

            } catch (InputMismatchException e) {
                // TODO: handle exception
                condicionInvalida = true;
                System.out.println("Se ingresó un valor invalido.");
            }
        } while (condicionInvalida);
        System.out.println("se finalizó el programa");
    }

    public static boolean crearMatrizRandom(int tamanioMatriz, int valorMaximo, int valorMinimo) {
        int valorRandom = 0;
        try {   
            matrizGenerada = new int[tamanioMatriz][tamanioMatriz];
            mostrarMatriz(matrizGenerada); 
            for (int i = 0; i < matrizGenerada.length; i++) {
                for (int j = 0; j < matrizGenerada[i].length; j++) {
                    valorRandom = (int) (Math.random()*(valorMaximo-valorMinimo+1)+valorMinimo);                    
                    matrizGenerada[i][j] = valorRandom;
                }
            }
            System.out.println("La matriz generada es la siguiente:");
            mostrarMatriz(matrizGenerada, "vista copada"); 
            mostrarMatriz(matrizGenerada, "la otra vista"); 
            return !true;
        } catch (NullPointerException e) {
            // TODO: handle exception
            System.out.println("se produjo una exepción, " + e);
            return !false;
        }
    }

    public static void mostrarMatriz(int[][] matrizParaMostrar) {
        System.out.println();
        for (int i = 0; i < matrizParaMostrar.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrizParaMostrar[i].length; j++) {
                System.out.print("(" + matrizParaMostrar[i][j] + ")");
            }
            System.out.println("]");
        }
    }

    public static void mostrarMatriz(int[][] matrizParaMostrar, String tipoString){
        System.out.println();
        if (tipoString.equals("vista copada")){
            for (int i = 0; i < matrizParaMostrar.length; i++) {
                System.out.println(Arrays.toString(matrizParaMostrar[i]));
            }
        } else if (tipoString.equals("la otra vista")){
            for (int i = 0; i < matrizParaMostrar.length; i++) {
                System.out.print("[");
                for (int j = 0; j < matrizParaMostrar[i].length; j++) {
                    System.out.print(matrizParaMostrar[i][j]);
                    if (j < matrizParaMostrar[i].length -1){
                        System.out.print("-/-");
                    }
                }
                System.out.println("]");
            }
        } else {
            mostrarMatriz(matrizParaMostrar);
        }

    }


}
