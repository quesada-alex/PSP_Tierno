import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 1. Lanzar un hijo y esperar a que termine.
 *
 * El padre lanza el programa Saludo como proceso hijo y espera a que termine para escribir su
 * código de salida. El hijo escribe en la misma consola que el padre.
 */
public class Ej01Lanzar {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Padre: soy el proceso " + ProcessHandle.current().pid());

        ProcessBuilder pb = new ProcessBuilder(comandoJava("Saludo"));
        pb.inheritIO();  // el hijo escribe en la misma consola que el padre

        Process hijo = lanzar(pb);
        System.out.println("Padre: he lanzado un hijo con PID " + hijo.pid());

        int codigo = esperar(hijo);
        System.out.println("Padre: el hijo ha terminado con código " + codigo);
    }

    /** Lanza el proceso que describe pb y devuelve el Process del hijo. */
    static Process lanzar(ProcessBuilder pb) throws IOException {
        return pb.start();
    }

    /** Espera a que el hijo termine y devuelve su código de salida. */
    static int esperar(Process hijo) throws InterruptedException {
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
