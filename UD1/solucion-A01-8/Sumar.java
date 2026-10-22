import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Proceso hijo: lee números de la entrada estándar, uno por línea, y cuando la entrada se acaba
 * escribe su suma en la salida estándar.
 *
 * Uso: java Sumar
 */
public class Sumar {

    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        long suma = 0;
        String linea;
        while ((linea = entrada.readLine()) != null) {
            suma += Long.parseLong(linea.trim());
        }
        System.out.println(suma);
    }
}
