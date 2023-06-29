/*
 * Batalla Naval:
 * El objetivo del siguiente ejercicio es poner en práctica tus 
 * habilidades de programación mientras te enfrentas a la tarea 
 * de hundir los barcos enemigos. Deberás crear un programa que 
 * simule el emocionante juego de la Batalla Naval contra la computadora.
 * 
 * 
 * Autor: Mario Stefano Papetti Funes
 * F: 28/06/2023
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BatallaDeNavios {
        
    //      Matrices para el desarrillo del juego
    public static char[][] matrizComputadora;
    public static char[][] matrizJugador; 
    public static char[][] matrizQueVeElJugador; 
    public static char[][] matrizAprendizaje; 

    //      Banderas para determinar continuidad y finalización del jeugo y quien ganó
    public static boolean enJuego = true;
    public static boolean ganoLaIA = false;

    //     Constantes para el uso meramente grafico
    public static final char CELDA_VACIA = '~';
    public static final char CELDA_BARCO = '=';
    public static final char CELDA_ATACADA = 'A';
    public static final char CELDA_FALLADA = 'X';
    
    //      Atributos para poder definir luego las dimensiones de las matrices
    public static int cantidadDeFilas = 0;
    public static int cantidadDeColumnas = 0;

    //      Cantidad de turnos transcurridos
    public static int cantidadDeTurnos = 0;

    //      Instanciación del objeto myScanner para la toma de datos por consola
    Scanner myScanner = new Scanner(System.in);

    public void inicializacionDeMatrices() {

        System.out.println("Ingrese el número de FILAS de los tableros:");
        cantidadDeFilas = myScanner.nextInt();
        System.out.println("Ingrese el número de COLUMNAS de los tableros:");
        cantidadDeColumnas = myScanner.nextInt();

        matrizJugador = new char[cantidadDeFilas][cantidadDeColumnas];
        matrizQueVeElJugador = new char[cantidadDeFilas][cantidadDeColumnas];
        matrizComputadora = new char[cantidadDeFilas][cantidadDeColumnas];
        matrizAprendizaje = new char[cantidadDeFilas][cantidadDeColumnas];

        for (int index = 0; index < 4; index++) {            
            char[][] matrizParaLlenar = new char[4][4];
            if (index == 0){
                matrizParaLlenar = matrizComputadora;
            } else if (index == 1) {
                matrizParaLlenar = matrizJugador;
            } else if (index == 2){
                matrizParaLlenar = matrizQueVeElJugador;                
            } else if (index == 3){
                matrizParaLlenar = matrizAprendizaje;                
            }
            for (int i = 0; i < matrizParaLlenar.length; i++) {
                for (int j = 0; j < matrizParaLlenar[i].length; j++) {
                    matrizParaLlenar[i][j] = CELDA_VACIA;
                }
            }
        }
        
        int contadorDeBarcos, barcosTotales;
        System.out.print("Ingrese la cantidad de Barcos con la que desea jugar: ");
        barcosTotales = myScanner.nextInt();
        contadorDeBarcos = barcosTotales;
        for (int k = 0; k < 2; k++) {
            char[][] matrizParaLlenar = new char[cantidadDeFilas][cantidadDeColumnas];
            if (k == 0){
                matrizParaLlenar = matrizComputadora;
            } else {
                matrizParaLlenar = matrizJugador;
            }            
            while (contadorDeBarcos > 0){
                for (int i = 0; i < matrizParaLlenar.length; i++) {
                    int filasRandom = (int) (Math.random()*(10)/3);
                    for (int j = 0; j < matrizParaLlenar[i].length; j++) {
                        int ColumnasRandom = (int) (Math.random()*(10)/3);
                        char celda = matrizParaLlenar[filasRandom][ColumnasRandom];
                        if (contadorDeBarcos == 0){
                            break;
                        } else if ((celda != CELDA_BARCO ) && (((int) (Math.random()*(10)+1)) < 5)){
                            matrizParaLlenar[i][j] = CELDA_BARCO; 
                            contadorDeBarcos--;
                        }                
                    }
                    if (contadorDeBarcos == 0){
                        break;
                    }
                }
            }
            contadorDeBarcos = barcosTotales;
        }
    }

    public void mostrarMatriz(char[][] imrpimirEstaMatriz) {
        String nombreDeMatriz = "";
        if (imrpimirEstaMatriz == matrizComputadora){
            nombreDeMatriz = "Matriz de la Computadora";
        } else if (imrpimirEstaMatriz == matrizJugador){            
            nombreDeMatriz = "Matriz del Jugador";
        } else {            
            nombreDeMatriz = "Matriz que vé el jugador";
        }
        System.out.print("\nMatriz: " + nombreDeMatriz + "\n");
        for (int i = 0; i < imrpimirEstaMatriz.length; i++) {
            System.out.println(Arrays.toString(imrpimirEstaMatriz[i]));
        }
    }

    public void mostrarMatrizJugador() {
        System.out.print("\nMatriz del JUGADOR \tMatriz de la COMPUTADORA\n");
        for (int i = 0; i < matrizJugador.length; i++) {
            System.out.println(
                Arrays.toString(matrizJugador[i]) +
                "\t\t" +
                Arrays.toString(matrizQueVeElJugador[i]) 
            );
        }
        System.out.println("******  FIN DEL TURNO DEL JUGADOR ******\n");
    }

    public void verificar(String coordenadaString, char[][] matrizSeleccionada, String turno) {
        //  Método para ferificar si es agua o barco y realizar la sustitución
        String filaString;
        String columnaString;
        String[] auxiliar = coordenadaString.split("-");

        filaString = auxiliar[0];
        columnaString = auxiliar[1];
        int fila = 0;
        int columna = 0; 

        switch (filaString.toUpperCase()) {
            case "A":
                fila = 0;
                break;
            case "B":
                fila = 1;
                break;
            case "C":
                fila = 2;
                break;
            case "D":
                fila = 3;
                break;        
            default:
                break;
        }        
        switch (columnaString) {
            case "1":
                columna = 0;
                break;
            case "2":
                columna = 1;
                break;
            case "3":
                columna = 2;
                break;
            case "4":
                columna = 3;
                break;        
            default:
                break;
        }

        //el jugador juega -> actualiza matrizquelejugadorve
        // para ello esa matriz compararse con matriz de computadora
        if (matrizSeleccionada[fila][columna] == CELDA_BARCO){
            // marcar barco undido.
            matrizSeleccionada[fila][columna] = CELDA_ATACADA;
        } else if (matrizSeleccionada[fila][columna] == CELDA_VACIA){
            matrizSeleccionada[fila][columna] = CELDA_FALLADA;
        }

        if (turno.equals("jugador")){
            // mostrarMatriz(matrizJugador);
            for (int i = 0; i < matrizQueVeElJugador.length; i++) {
                for (int j = 0; j < matrizQueVeElJugador[i].length; j++) {
                    char celda = matrizComputadora[i][j];
                    switch (celda) {
                        case CELDA_VACIA:
                            // Nada
                            break;
                        case CELDA_BARCO:
                            // Nada
                            break;
                        case CELDA_ATACADA:
                            matrizQueVeElJugador[i][j] = matrizComputadora[i][j];
                            break;  
                        case CELDA_FALLADA:
                            matrizQueVeElJugador[i][j] = matrizComputadora[i][j];
                            break;                  
                        default:
                            // se feliz kpo
                            break;
                    }
                }
            }
            // mostrarMatriz(matrizQueVeElJugador);
            // System.out.println("Fue el turno de: " + turno);
            mostrarMatrizJugador();
        } else if (turno.equals("computadora")){
            for (int i = 0; i < matrizAprendizaje.length; i++) {
                for (int j = 0; j < matrizAprendizaje[i].length; j++) {
                    char celda = matrizJugador[i][j];
                    switch (celda) {
                        case CELDA_VACIA:
                            // Nada
                            break;
                        case CELDA_BARCO:
                            // Nada
                            break;
                        case CELDA_ATACADA:
                            matrizAprendizaje[i][j] = matrizJugador[i][j];
                            break;  
                        case CELDA_FALLADA:
                            matrizAprendizaje[i][j] = matrizJugador[i][j];
                            break;                  
                        default:
                            // se feliz kpo
                            break;
                    }
                }
            }
            mostrarMatriz(matrizJugador);
            // System.out.println("Fue el turno de: " + turno);
        System.out.println("******  FIN DEL TURNO 0011 0100 1011 ******\n");
        }
    } 

    public boolean hayBarcosEnJuego(char[][] matrizQueQuieroEvaluar) {
        for (int i = 0; i < matrizQueQuieroEvaluar.length; i++) {
            for (int j = 0; j < matrizQueQuieroEvaluar[i].length; j++) {
                if (matrizQueQuieroEvaluar[i][j] == CELDA_BARCO) return true;
            }
        }
        return false;
    }

    public void jugadaDeLaComputadora() {  
        boolean noSeJugoLaCelda = true; 
        Integer filaRandom, columnaRandom = 0;
        String coordenadas = "";
        do {
            columnaRandom = (int) (Math.random()*(3-0+1)+0);
            filaRandom = (int) (Math.random()*(3-0+1)+0); 
            // System.out.println(filaRandom + ";" + columnaRandom);
            if (matrizAprendizaje[filaRandom][columnaRandom] == CELDA_VACIA) {
                noSeJugoLaCelda = true;
                // System.out.println(matrizAprendizaje[filaRandom][columnaRandom]);
            } else {
                noSeJugoLaCelda = false;
            } 
        } while (!noSeJugoLaCelda);
        columnaRandom++;
        // System.out.println(columnaRandom);
        String filaString = "";           
        switch (filaRandom) {
            case 0:
                filaString = "a";
                break;
            case 1:
                filaString = "b";
                break;
            case 2:
                filaString = "c";
                break;
            case 3:
                filaString = "d";
                break;        
            default:
                break;
        }
        coordenadas = filaString + "-" + columnaRandom.toString();
        System.out.println("Las coordenadas de Skynet: " + coordenadas);
        verificar(coordenadas, matrizJugador, "computadora");
    }

    public static void clearTerminal() {
        String os = System.getProperty("os.name").toLowerCase();

        try {
            if (os.contains("win")) {
                // Limpiar la terminal en Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else if (os.contains("mac") || os.contains("nix") || os.contains("nux") || os.contains("bsd")) {
                // Limpiar la terminal en macOS, Linux y otros sistemas basados en Unix
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Manejar cualquier excepción
            e.printStackTrace();
        }
    }
    
    public void jugar() {    
        // Formato letras -> fila y columnas -> números
        // Ejemplo a-4
        String coordenadas;
        System.out.println("Bienvenidos a la batalla Naval ndeeeahh..");
        System.out.println("Formato letras -> fila y columnas -> números\n\tDel tipo a-3 cómo ejemplo.");
        myScanner = new Scanner(System.in);
        do {
            // Realizar la jugada el jugador
            // System.out.println("Ingrese coordenadas para el ataque:");
            // coordenadas = myScanner.nextLine();
            // clearTerminal();
            boolean coordenadasIncorrectas = true;
            do {
                System.out.println("Ingrese coordenadas para el ataque:");
                coordenadas = myScanner.nextLine();
                clearTerminal();
                try {
                    // Eliminar caracteres no deseados y ajustar separadores
                    String cleanedInput = coordenadas.replaceAll("[^a-zA-Z0-9.]", "").replace('.', '-');

                    // Obtener la letra y el número utilizando expresiones regulares
                    Pattern pattern = Pattern.compile("([a-zA-Z])([0-9])");
                    Matcher matcher = pattern.matcher(cleanedInput);
                    
                    if (matcher.find()) {
                        String letter = matcher.group(1).toUpperCase();
                        int number = Integer.parseInt(matcher.group(2));

                        // Verificar y ajustar la letra si es mayor a 'D'
                        if (letter.charAt(0) > 'D') {
                            letter = "D";
                        }

                        // Verificar y ajustar el número si es mayor a 4
                        if (number > cantidadDeColumnas) {
                            number = cantidadDeColumnas;
                        }
                        coordenadas = letter + "-" + number;
                    }
                    verificar(coordenadas, matrizComputadora, "jugador");  
                    coordenadasIncorrectas = false;
                } catch (ArrayIndexOutOfBoundsException ArrayException){
                    System.out.println("Se lanzó la excepción: " + ArrayException);
                    System.out.println("El valor de coordenadas ingresada no es valido, para el Array coordenadas");
                    break;
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("Se lanzó la excepción: " + e);
                    System.out.println("El valor de coordenadas ingresada no es valido.");
                    break;
                }
            } while (coordenadasIncorrectas); 

            if (!hayBarcosEnJuego(matrizComputadora)) {
                ganoLaIA = false;
                enJuego = false;
            }
            // Realizar la jugada la computadora
            jugadaDeLaComputadora();
            if (!hayBarcosEnJuego(matrizJugador)){
                ganoLaIA = true;
                enJuego = false;
            }
            cantidadDeTurnos++;
        } while (enJuego);
        String ganador;
        if (ganoLaIA){
            ganador = "Skynet";
        } else {
            ganador = "vos kpo";
        }
        System.out.println("El ganador es: " + ganador + "\n\tEn " + cantidadDeTurnos + " cantidad de turnos.");
        System.out.println("GAME OVER!");
    }

    public static void main(String[] args) {

        BatallaDeNavios batalla = new BatallaDeNavios();

        batalla.inicializacionDeMatrices();

        // batalla.mostrarMatriz(matrizComputadora);
        batalla.mostrarMatriz(matrizJugador);        
        // batalla.mostrarMatriz(matrizAprendizaje);

        batalla.jugar();
    }
}