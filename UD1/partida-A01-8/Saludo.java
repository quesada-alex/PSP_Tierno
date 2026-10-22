/**
 * Proceso hijo: saluda a quien se le indica y dice su PID y el de su padre.
 *
 * Uso: java Saludo [nombre]
 * Código de salida: siempre 0.
 */
public class Saludo {

    public static void main(String[] args) {
        String nombre = "desconocido";
        if (args.length > 0) {
            nombre = args[0];
        }

        ProcessHandle yo = ProcessHandle.current();
        long pidPadre = -1;
        if (yo.parent().isPresent()) {
            pidPadre = yo.parent().get().pid();
        }

        System.out.println("Hijo: hola, " + nombre + ". He recibido " + args.length + " argumento(s).");
        System.out.println("Hijo: soy el proceso " + yo.pid() + " y mi padre es el " + pidPadre + ".");
    }
}
