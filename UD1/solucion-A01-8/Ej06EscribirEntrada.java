import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 6. Escribir en la entrada estándar de un hijo.
 *
 * El padre envía unas frases al hijo Mayusculas por su entrada estándar y lee las frases en
 * mayúsculas que el hijo le devuelve por su salida estándar.
 */
public class Ej06EscribirEntrada {

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(comandoJava("Mayusculas"));
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);  // los avisos del hijo, en la consola
        Process hijo = pb.start();

        String[] frases = {"hola", "esto lo escribe el padre", "", "y el hijo lo pasa a mayusculas"};
        enviar(hijo, frases);

        System.out.println("Padre: el hijo me devuelve:");
        try (BufferedReader salida = hijo.inputReader()) {
            String linea;
            while ((linea = salida.readLine()) != null) {
                System.out.println("  " + linea);
            }
        }
        System.out.println("Padre: el hijo ha terminado con código " + hijo.waitFor());
    }

    /**
     * Escribe cada frase en la entrada estándar del hijo, una por línea, y cierra el flujo para
     * que el hijo sepa que no hay más frases.
     */
    static void enviar(Process hijo, String[] frases) throws IOException {
        try (BufferedWriter entrada = hijo.outputWriter()) {
            for (String frase : frases) {
                entrada.write(frase);
                entrada.newLine();
            }
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
