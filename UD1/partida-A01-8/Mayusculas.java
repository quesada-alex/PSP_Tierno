import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Proceso hijo: lee frases de la entrada estándar, una por línea, y las escribe en mayúsculas en
 * la salida estándar. Las frases en blanco no las copia: avisa en la salida de error.
 * Termina cuando la entrada se acaba.
 *
 * Uso: java Mayusculas
 */
public class Mayusculas {

    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String linea;
        while ((linea = entrada.readLine()) != null) {  // se bloquea hasta que llega una línea
            if (linea.isBlank()) {
                System.err.println("Hijo: frase en blanco, no la copio");
            } else {
                System.out.println(linea.toUpperCase());
            }
        }
    }
}
