import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 8. El código de salida y la salida de error.
 *
 * El padre lanza cuatro divisiones; unas van bien y otras no. Con el código de salida de cada hijo
 * decide si lee su resultado (salida estándar) o su mensaje de error (salida de error).
 */
public class Ej08CodigoSalida {

    public static void main(String[] args) throws IOException, InterruptedException {
        dividir("84", "2");
        dividir("7", "0");
        dividir("7");
        dividir("siete", "2");
    }

    /** Lanza un hijo Division con los argumentos indicados y escribe cómo le ha ido. */
    static void dividir(String... argumentos) throws IOException, InterruptedException {
        Process hijo = new ProcessBuilder(comandoJava("Division", argumentos)).start();
        System.out.println("Division " + String.join(" ", argumentos) + " -> " + informe(hijo));
    }

    /**
     * Espera a que el hijo termine. Si su código de salida es 0, devuelve "resultado " seguido de
     * la línea de su salida estándar; si no, "error ", el código, ": " y la línea de su salida de
     * error. Por ejemplo, "resultado 42" o "error 3: No se puede dividir entre 0".
     */
    static String informe(Process hijo) throws IOException, InterruptedException {
        // TODO (9 líneas): espera a que el hijo termine y, según su código de salida, lee su
        //     salida estándar o su salida de error
        return null;  // provisional, para que compile: bórralo
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
