/**
 * Proceso hijo: duerme los segundos indicados y escribe en la salida estándar cuántos ha dormido.
 * En la salida de error avisa de cuándo se duerme y de cuándo se despierta.
 *
 * Uso: java Dormilon <segundos>
 * Código de salida: 0 si se despierta solo y 1 si falta el argumento.
 */
public class Dormilon {

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.err.println("Uso: java Dormilon <segundos>");
            System.exit(1);
        }
        int segundos = Integer.parseInt(args[0]);
        long pid = ProcessHandle.current().pid();

        System.err.println("Hijo " + pid + ": me duermo " + segundos + " s");
        Thread.sleep(segundos * 1000L);
        System.err.println("Hijo " + pid + ": me despierto");
        System.out.println(segundos);
    }
}
