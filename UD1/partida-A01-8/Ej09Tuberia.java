import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 9. Una tubería de tres procesos.
 *
 * Encadena tres hijos como "GeneradorNumeros 1 10 | Cuadrado | Sumar": la salida de cada uno es la
 * entrada del siguiente. El padre solo lee la salida del último, que es la suma de los cuadrados
 * de los números del 1 al 10.
 */
public class Ej09Tuberia {

    public static void main(String[] args) throws IOException, InterruptedException {
        List<Process> procesos = lanzarTuberia();
        for (Process p : procesos) {
            System.out.println("Padre: proceso de la tubería con PID " + p.pid());
        }

        System.out.println("Padre: la suma de los cuadrados del 1 al 10 es " + leerUltimo(procesos));
        for (Process p : procesos) {
            p.waitFor();
        }
    }

    /** Lanza la tubería GeneradorNumeros 1 10 | Cuadrado | Sumar y devuelve sus tres procesos. */
    static List<Process> lanzarTuberia() throws IOException {
        // TODO (5 líneas): prepara las tres etapas y lánzalas como una tubería
        return null;  // provisional, para que compile: bórralo
    }

    /** Lee la línea que escribe en su salida estándar el último proceso de la tubería. */
    static String leerUltimo(List<Process> procesos) throws IOException {
        // TODO (4 líneas): lee la línea que escribe el último proceso de la lista
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
