import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 2. Pasar argumentos a un hijo.
 *
 * El padre lanza tres hijos Saludo, uno detrás de otro, y a cada uno le pasa un nombre como
 * argumento.
 */
public class Ej02Argumentos {

    public static void main(String[] args) throws IOException, InterruptedException {
        String[] nombres = {"Ana", "Luis", "Juan Carlos"};
        for (String nombre : nombres) {
            Process hijo = lanzarSaludo(nombre);
            hijo.waitFor();  // espera a cada hijo antes de lanzar el siguiente
        }
        System.out.println("Padre: he saludado a " + nombres.length + " personas");
    }

    /** Lanza un Saludo que recibe el nombre como argumento y escribe en la consola del padre. */
    static Process lanzarSaludo(String nombre) throws IOException {
        // TODO (3 líneas): prepara un Saludo que reciba el nombre como argumento y que
        //     escriba en la consola del padre; después, lánzalo
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
