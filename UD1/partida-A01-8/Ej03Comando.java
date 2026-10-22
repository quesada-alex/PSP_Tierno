import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 3. El comando que lanza un programa Java.
 *
 * Hasta ahora comandoJava venía hecho; ahora lo completas tú. El padre construye el comando que
 * lanza Saludo con el argumento Marta, lo escribe parte a parte y lanza el hijo.
 */
public class Ej03Comando {

    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> comando = comandoJava("Saludo", "Marta");
        System.out.println("Padre: voy a lanzar este comando, parte a parte:");
        for (String parte : comando) {
            System.out.println("  " + parte);
        }

        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.inheritIO();
        int codigo = pb.start().waitFor();
        System.out.println("Padre: el hijo ha terminado con código " + codigo);
    }

    /**
     * Construye el comando que ejecuta la clase indicada con la misma JVM y el mismo classpath que
     * este programa: java -cp <classpath> <clase> <argumentos...>
     */
    static List<String> comandoJava(String clase, String... argumentos) {
        List<String> comando = new ArrayList<>();
        // TODO (4 líneas): añade al comando la ruta del java de esta JVM, "-cp", el classpath
        //     de este programa y la clase
        for (String argumento : argumentos) {
            comando.add(argumento);
        }
        return comando;
    }
}
