/**
 * EJBatallaNaval
 */
public class EJBatallaNaval {
    public static void main(String[] args) {

        /*
         * ~ ~ ~ ~
         * A X ~ =
         * X ~ = X
         * ~ = ~ A
         */

        /* inicio de matrices mar, compu y jugador */

        char[][] mar = { { '~', '~', '~', '~' }, { '~', '~', '~', '~' }, { '~', '~', '~', '~' },
                { '~', '~', '~', '~' } };
        char[][] compu = { { '~', '~', '~', '~' }, { '~', '~', '~', '~' }, { '~', '~', '~', '~' },
                { '~', '~', '~', '~' } };

        char[][] jugador = { { '~', '~', '~', '~' }, { '~', '~', '~', '~' }, { '~', '~', '~', '~' },
                { '~', '~', '~', '~' } };

        // ubicar barcos en jugador y
        ubicarBarcos(jugador);
        ubicarBarcos(compu);

        System.out.println("Matriz jugador");
        mostrarMatriz(jugador);

        System.out.println("Matriz Compu");
        mostrarMatriz(compu);

        //jugar
        //cordenadas para jugar
        int x=0,y=0;

        

        while(true){
            x = (int) (Math.random() * (3 - 0 + 1) + 0);
            y = (int) (Math.random() * (3 - 0 + 1) + 0);    

            //turno jugador
            System.out.println("Turno jugador Matriz Compu");
            jugada(compu,x,y);
            mostrarMatriz(compu);
            if(contarBarcos(compu)==0){
                System.out.println("Gano Jugador");
                break;
            }
            waitForSeconds(10);
            //turno compu
            System.out.println("Turno compu Matriz Jugador");
            jugada(jugador,x,y);
            mostrarMatriz(jugador);
             if(contarBarcos(jugador)==0){
                System.out.println("Gano Compu");
                break;
            };

        }


    }

    // funciones auxiliares

    //cambia = por A si acerto o X caso contrario
    //retorna true si no hay mas barcos, false si aun quedan, para seguir el juego
    static void jugada(char[][] matrix, int i, int j){
        
        if(matrix[i][j] == '=')matrix[i][j] = 'A'; else matrix[i][j] = 'X';
        
    }

    //cuenta los barcos en la matriz
    static int contarBarcos(char[][] matrix){
        int contar=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]=='=')contar++;
            }
        }
        return contar;
    }


    static void ubicarBarcos(char[][] mBarco) {
        // ubicar barcos en jugador y
        for (int i = 0; i < mBarco.length; i++) {
            // ubicacion aleatoria entre 0 a 4 para ubicar el barco
            // en cada fila
            int j = (int) (Math.random() * (3 - 0 + 1) + 0);
            mBarco[i][j] = '=';
        }
    }

    static void mostrarMatriz(char[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(" " + matrix[i][j]);
            }

            System.out.println(" ]");
        }

    }

    static void waitForSeconds(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Error delay");
            e.printStackTrace();
        }
    }
}