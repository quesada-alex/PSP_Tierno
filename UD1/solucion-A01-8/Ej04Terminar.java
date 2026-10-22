import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 4. Terminar un hijo.
 *
 * El padre lanza un Dormilon que va a dormir 60 segundos, lo deja dormir 3 y lo termina.
 */
public class Ej04Terminar {

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(comandoJava("Dormilon", "60"));
        pb.inheritIO();
        Process hijo = pb.start();
        System.out.println("Padre: he lanzado un hijo con PID " + hijo.pid());

        Thread.sleep(3000);  // el padre espera 3 segundos sin hacer nada
        System.out.println("Padre: ¿sigue vivo? " + hijo.isAlive());

        int codigo = terminar(hijo);
        System.out.println("Padre: ¿sigue vivo? " + hijo.isAlive());
        System.out.println("Padre: el hijo ha terminado con código " + codigo);
    }

    /**
     * Si el hijo sigue vivo, le pide que termine. Después espera a que termine de verdad y
     * devuelve su código de salida.
     */
    static int terminar(Process hijo) throws InterruptedException {
        if (hijo.isAlive()) {
            hijo.destroy();
        }
        return hijo.waitFor();
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
