import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 5. Leer la salida estándar de un hijo.
 *
 * El padre pide a un hijo Division que divida 84 entre 2, lee el resultado y lo usa.
 */
public class Ej05LeerSalida {

    public static void main(String[] args) throws IOException, InterruptedException {
        Process hijo = new ProcessBuilder(comandoJava("Division", "84", "2")).start();

        int resultado = leerResultado(hijo);
        System.out.println("Padre: el hijo dice que 84 / 2 = " + resultado);
        System.out.println("Padre: y el doble es " + (resultado * 2));
        System.out.println("Padre: el hijo ha terminado con código " + hijo.waitFor());
    }

    /** Lee la línea que el hijo escribe en su salida estándar y la devuelve convertida en número. */
    static int leerResultado(Process hijo) throws IOException {
        try (BufferedReader salida = hijo.inputReader()) {
            return Integer.parseInt(salida.readLine());
        }
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
