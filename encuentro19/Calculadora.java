/*
 * 
 * Autor: Cristian Aparicio
 * 
 */


import java.util.Scanner;

public class Calculadora {
  public static boolean menu() {    
    int op = 0;
    Scanner scanNro = new Scanner(System.in);
    System.out.println("Calculadora");
    System.out.println("Menu de Operaciones");
    System.out.println("1-> Suma");
    System.out.println("2-> Resta");
    System.out.println("3-> Producto");
    System.out.println("4-> Division");
    System.out.println("5-> Resto");
    System.out.println("0-> Salir");
    System.out.print("Ingrese Opción del Menu de Operaciones: ");
    op = scanNro.nextInt();    
    int nroA = 0, nroB = 0;// Numeros A y B inicializados en 0. Codigo de Operacion
    if (op != 0 && op <= 5) {
      System.out.println("-------------------------");
      System.out.print("Ingrese el Nro A: ");
      nroA = scanNro.nextInt();
      System.out.println("-------------------------");
      System.out.print("Ingrese el Nro B: ");
      nroB = scanNro.nextInt();
      System.out.println("-------------------------");
    }
    
    // scanNro.close();//se debe cerrar el scanner luego de dejar de usarlo, sino da error
    if (op != 0){
      calcular(nroA, nroB, op);
    } else if (op == 0){
      return false;
    }
    return true;
  }

  public static void calcular(int nroA, int nroB, int op) {
    

    if (op == 1) {
      System.out.println("Suma A + B = " + (nroA + nroB));
    }

    if (op == 2) {
      System.out.println("Resta A - B = " + (nroA - nroB));
    }

    if (op == 3) {
      System.out.println("Producto A * B = " + (nroA * nroB));
    }

    if (op == 4)
      if (nroB != 0) {

        System.out.println("División A / B = " + (nroA / nroB));
      } else {
        System.out.println("Error Disvisión por 0");
      }

    if (op == 5)
      if (nroB != 0) {
        System.out.println("Resto de A % B = " + (nroA % nroB));
      } else {
        System.out.println("Error Disvisión por 0");
      }
  }
  public static void main(String[] args) {
    boolean calculando;
    do {
      calculando = menu();
    } while (calculando);
    
    System.out.println("-------------------------");
    System.out.println("Fin de la Calculadora. Adios!!!!");
    System.out.println("-------------------------");

  }
}
