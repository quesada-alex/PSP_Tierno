import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 7. Redirigir los flujos de un hijo a ficheros.
 *
 * El hijo Mayusculas lee las frases del fichero frases.txt, deja las frases en mayúsculas en
 * mayusculas.txt y añade sus avisos al final de avisos.log. El padre no lee ni escribe ningún
 * flujo del hijo: prepara el fichero de entrada y, cuando el hijo termina, muestra los otros dos.
 */
public class Ej07Redirecciones {

    public static void main(String[] args) throws IOException, InterruptedException {
        File frases = new File("frases.txt");
        File mayusculas = new File("mayusculas.txt");
        File avisos = new File("avisos.log");
        Files.writeString(frases.toPath(), "primera frase\n\nsegunda frase\n   \ntercera y ultima\n");

        Process hijo = lanzarRedirigido(frases, mayusculas, avisos);
        System.out.println("Padre: el hijo ha terminado con código " + hijo.waitFor());

        System.out.println("--- mayusculas.txt ---");
        System.out.print(Files.readString(mayusculas.toPath()));
        System.out.println("--- avisos.log ---");
        System.out.print(Files.readString(avisos.toPath()));
    }

    /**
     * Lanza un Mayusculas que lee su entrada del fichero entrada, escribe su salida en el fichero
     * salida (si ya existe, lo sustituye) y añade su salida de error al final del fichero avisos.
     */
    static Process lanzarRedirigido(File entrada, File salida, File avisos) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(comandoJava("Mayusculas"));
        pb.redirectInput(entrada);
        pb.redirectOutput(salida);
        pb.redirectError(ProcessBuilder.Redirect.appendTo(avisos));
        return pb.start();
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
