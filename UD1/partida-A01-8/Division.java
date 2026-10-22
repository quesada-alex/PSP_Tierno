/**
 * Proceso hijo: hace la división entera de dos números y escribe solo el resultado.
 *
 * Uso: java Division <dividendo> <divisor>
 * Código de salida: 0 si todo va bien, 1 si no hay dos argumentos, 2 si no son números enteros
 * y 3 si el divisor es 0. Los errores se explican en la salida de error.
 */
public class Division {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: java Division <dividendo> <divisor>");
            System.exit(1);
        }

        int dividendo = 0;
        int divisor = 0;
        try {
            dividendo = Integer.parseInt(args[0]);
            divisor = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Los argumentos tienen que ser números enteros: " + args[0] + " "
                    + args[1]);
            System.exit(2);
        }

        if (divisor == 0) {
            System.err.println("No se puede dividir entre 0");
            System.exit(3);
        }
        System.out.println(dividendo / divisor);
    }
}
