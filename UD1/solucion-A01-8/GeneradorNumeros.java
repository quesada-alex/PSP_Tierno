/**
 * Escribe en la salida estándar los números del intervalo [desde, hasta], uno por línea.
 *
 * Uso: java GeneradorNumeros <desde> <hasta>
 */
public class GeneradorNumeros {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: java GeneradorNumeros <desde> <hasta>");
            System.exit(1);
        }
        long desde = Long.parseLong(args[0]);
        long hasta = Long.parseLong(args[1]);

        for (long n = desde; n <= hasta; n++) {
            System.out.println(n);
        }
    }
}
