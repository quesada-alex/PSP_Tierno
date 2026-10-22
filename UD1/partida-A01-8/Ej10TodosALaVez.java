import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Ejercicio 10. Varios hijos a la vez, con tiempo límite.
 *
 * El padre lanza un Dormilon por cada valor de SEGUNDOS, todos a la vez. Después espera a cada uno
 * como mucho LIMITE segundos y, si no ha terminado, lo termina. Suma los segundos que han dormido
 * los hijos que han terminado bien y lo compara con lo que ha tardado él.
 */
public class Ej10TodosALaVez {

    static final int[] SEGUNDOS = {3, 1, 2, 30};  // el último no va a terminar a tiempo
    static final int LIMITE = 5;                    // segundos que se espera, como mucho, a cada hijo

    public static void main(String[] args) throws IOException, InterruptedException {
        long inicio = System.currentTimeMillis();
        int dormidos = dormirTodos();
        long tiempo = (System.currentTimeMillis() - inicio) / 1000;
        System.out.println("Padre: los hijos han dormido " + dormidos + " s en total y yo he tardado "
                + tiempo + " s");
    }

    /** Lanza un Dormilon que duerme los segundos indicados; sus avisos, en la consola. Ya está hecho. */
    static Process lanzar(int segundos) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(comandoJava("Dormilon", String.valueOf(segundos)));
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        return pb.start();
    }

    /** Lee los segundos que el hijo ha escrito en su salida estándar. Ya está hecho. */
    static int leerSegundos(Process hijo) throws IOException {
        try (BufferedReader salida = hijo.inputReader()) {
            return Integer.parseInt(salida.readLine());
        }
    }

    /**
     * Espera al hijo como mucho LIMITE segundos. Si ha terminado, devuelve true solo si su código de
     * salida es 0. Si no ha terminado, escribe que lo va a terminar, lo termina a la fuerza y
     * devuelve false.
     */
    static boolean esperarConLimite(Process hijo) throws InterruptedException {
        // TODO (6 líneas): espera al hijo con tiempo límite; si no termina a tiempo, avisa y
        //     termínalo a la fuerza
        return false;  // provisional, para que compile: bórralo
    }

    /**
     * Lanza un Dormilon por cada valor de SEGUNDOS, todos antes de esperar a ninguno. Después espera
     * a cada uno con esperarConLimite y, si ha terminado bien, suma los segundos que ha dormido.
     * Devuelve la suma.
     */
    static int dormirTodos() throws IOException, InterruptedException {
        int total = 0;
        // TODO (9 líneas): lanza todos los hijos y guárdalos en una lista; después espera a
        //     cada uno y suma los segundos de los que han terminado bien
        return total;
    }

    /** Comando que ejecuta la clase indicada con la misma JVM que el padre. Ya está hecho. */
    static List<String> comandoJava(String clase, String... argumentos) {
        List<String> comando = new ArrayList<>();
        comando.add(Path.of(System.getProperty("java.home"), "bin", "java").toString());
        comando.add("-cp");
        comando.add(System.getProperty("java.class.path"));
        comando.add(clase);
        for (String argumento : argumentos) {
            comando.add(argumento);
        }
        return comando;
    }
}
