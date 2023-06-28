/*
 * Batalla Naval
El objetivo del siguiente ejercicio es poner en práctica tus 
habilidades de programación mientras te enfrentas a la tarea 
de hundir los barcos enemigos. Deberás crear un programa que 
simule el emocionante juego de la Batalla Naval contra la computadora.
 */

import java.util.Arrays;
import java.util.Scanner;

public class BatallaDeNavios {
        
    public static char[][] matrizComputadora = new char[4][4];
    public static char[][] matrizJugador = new char[4][4]; 
    public static char[][] matrizQueVeElJugador = new char[4][4]; 

    public static boolean enJuego = true;
    public static boolean ganoLaIA = false;

    Scanner myScanner = new Scanner(System.in);

    public void inicializacionDeMatrices() {
        char vacio = '~';
        
        for (int index = 0; index < 3; index++) {            
            char[][] matrizParaLlenar = new char[4][4];
            if (index == 0){
                matrizParaLlenar = matrizComputadora;
            } else if (index == 1) {
                matrizParaLlenar = matrizJugador;
            } else if (index == 2){
                matrizParaLlenar = matrizQueVeElJugador;                
            }
            for (int i = 0; i < matrizParaLlenar.length; i++) {
                for (int j = 0; j < matrizParaLlenar[i].length; j++) {
                    matrizParaLlenar[i][j] = vacio;
                }
            }
        }
        char barco = '=';
        int contadorDeBarcos = 4;
        for (int k = 0; k < 2; k++) {
            char[][] matrizParaLlenar = new char[4][4];
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
                        } else if ((celda != barco ) && (((int) (Math.random()*(10)+1)) < 5)){
                            matrizParaLlenar[i][j] = barco; 
                            contadorDeBarcos--;
                        }                
                    }
                    if (contadorDeBarcos == 0){
                        break;
                    }
                }
            }
            contadorDeBarcos = 4;
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
        if (matrizSeleccionada[fila][columna] == '='){
            // marcar barco undido.
            matrizSeleccionada[fila][columna] = 'A';
        } else if (matrizSeleccionada[fila][columna] == '~'){
            matrizSeleccionada[fila][columna] = 'X';
        }

        if (turno.equals("jugador")){
            mostrarMatriz(matrizJugador);

            for (int i = 0; i < matrizQueVeElJugador.length; i++) {
                for (int j = 0; j < matrizQueVeElJugador[i].length; j++) {
                    char celda = matrizComputadora[i][j];
                    switch (celda) {
                        case '~':
                            // Nada
                            break;
                        case '=':
                            // Nada
                            break;
                        case 'A':
                            matrizQueVeElJugador[i][j] = matrizComputadora[i][j];
                            break;  
                        case 'X':
                            matrizQueVeElJugador[i][j] = matrizComputadora[i][j];
                            break;                  
                        default:
                            // se feliz kpo
                            break;
                    }
                }
            }
            mostrarMatriz(matrizQueVeElJugador);
            System.out.println("Fue el turno de: " + turno);
        } else if (turno.equals("computadora")){
            mostrarMatriz(matrizJugador);
            System.out.println("Fue el turno de: " + turno);
        }
    } 

    public boolean hayBarcosEnJuego(char[][] matrizQueQuieroEvaluar) {
        
        for (int i = 0; i < matrizQueQuieroEvaluar.length; i++) {
            for (int j = 0; j < matrizQueQuieroEvaluar[i].length; j++) {
                if (matrizQueQuieroEvaluar[i][j] == '=') return true;
            }
        }
        return false;
    }

    public void jugar() {    
        // Formato letras -> fila y columnas -> números
        // Ejemplo a-4
        String coordenadas;
        System.out.println("Bienvenidos a la batalla Naval ndeeeahh..");
        System.out.println("Formato letras -> fila y columnas -> números\n\tDel tipo a-3 cómo ejemplo.");
        do {
            // Realizar la jugada el jugador
            System.out.println("Ingrese coordenadas para el ataque:");
            coordenadas = myScanner.nextLine();
            verificar(coordenadas, matrizComputadora, "jugador");
            if (!hayBarcosEnJuego(matrizComputadora)) {
                ganoLaIA = false;
                enJuego = false;
            }
            // Realizar la jugada la computadora
            Integer columnaRandom = (int) (Math.random()*100/30);
            Integer filaRandom = (int) (Math.random()*100/30); 
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
            System.out.println("Las coordenadas de pc: " + coordenadas);
            verificar(coordenadas, matrizJugador, "computadora");
            if (!hayBarcosEnJuego(matrizJugador)){
                ganoLaIA = true;
                enJuego = false;
            }
        } while (enJuego);
        String ganador;
        if (ganoLaIA){
            ganador = "Skynet";
        } else {
            ganador = "vos kpo";
        }
        System.out.println("El ganador es: " + ganador);
        System.out.println("GAME OVER!");
    }

    public static void main(String[] args) {

        BatallaDeNavios batalla = new BatallaDeNavios();
        batalla.inicializacionDeMatrices();

        batalla.mostrarMatriz(matrizComputadora);
        batalla.mostrarMatriz(matrizJugador);        
        // batalla.mostrarMatriz(matrizQueVeElJugador);

        batalla.jugar();
    }
}