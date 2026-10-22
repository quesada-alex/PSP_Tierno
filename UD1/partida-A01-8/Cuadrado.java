import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Proceso hijo: lee números de la entrada estándar, uno por línea, y escribe el cuadrado de cada
 * uno en la salida estándar. Termina cuando la entrada se acaba.
 *
 * Uso: java Cuadrado
 */
public class Cuadrado {

    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String linea;
        while ((linea = entrada.readLine()) != null) {
            long n = Long.parseLong(linea.trim());
            System.out.println(n * n);
        }
    }
}
