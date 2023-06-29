import java.util.Scanner;

public class MetodosEjercicio2 {
    public static void main(String[] args) {
        Integer numero = null;
        System.out.println("Por favor ingrese un número:");
        do {
            numero = solicitarNumero();
        } while (!esPar(numero));
    }

    //  Método para tomar número entero
    public static Integer solicitarNumero() {
        Integer numerski = 0;
        Scanner pepe = new Scanner(System.in);
        try {
            numerski = pepe.nextInt();            
        } catch (Exception e) {
            // TODO: handle exception
            pepe.nextLine();
            System.out.println("No ingresó un número, intente");
        }
        return numerski;
    }

    public static boolean esPar(Integer enteroski) {
        //  return true si es par
        //  sino me retorna falso si no es par

        if (enteroski % 2 == 0) {
            System.out.println("El " + enteroski + " es par");
            return true;
        } else {
            System.out.println("El " + enteroski + " NO es par");
            return false;
        }
    }
}
