
import java.util.Scanner;

public class Challenge_2 {
    
    private static Scanner input = new Scanner(System.in);
    private static int x = 0;
    
    public static void main(String[] args) {

        boolean aux = true;        

        String banner = """
        
        ██████╗ ██╗     ███████╗███████╗██╗    ██╗ █████╗ ██████╗ ███████╗
        ██╔══██╗██║     ██╔════╝██╔════╝██║    ██║██╔══██╗██╔══██╗██╔════╝
        ██████╔╝██║     █████╗  ███████╗██║ █╗ ██║███████║██████╔╝█████╗  
        ██╔══██╗██║     ██╔══╝  ╚════██║██║███╗██║██╔══██║██╔══██╗██╔══╝  
        ██████╔╝███████╗███████╗███████║╚███╔███╔╝██║  ██║██║  ██║███████╗
        ╚═════╝ ╚══════╝╚══════╝╚══════╝ ╚══╝╚══╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝

        Desafio semana 2 de Codember v1.0
        """;

        System.out.println(banner);
        System.out.println("Escriba Help, para ver los comandos disponibles");

        do {

           aux = run();

        } while(aux);
    }

    //Metodo run
    private static boolean run() {

        boolean aux = true;        
        String instrucciones;

        resetInput();
        System.out.print("$ ");
        instrucciones = input.nextLine();

        switch (instrucciones.trim()) {
                
            case "Help" ->  //Comando Help

                    help();

            case "Reset" ->  //Comando Reset

                    reset();

            case "Exit" ->  //Comando Exit

                    aux = false; //Terminar la ejecucion

            default -> {  //Evaluacion de los otros comandos del compilador

                otherCommands(instrucciones);
            }
        }

        return aux;
    }

    //Metodo para evaluar y ejecutar los comandos "#", "@", "*", "&"
    private static void otherCommands(String instrucciones) {

        boolean space = false;

        //Validar espacios
        for (int i = 0; i < instrucciones.trim().length(); i++) {

            if (instrucciones.charAt(i) == ' ') {

                space = true;
                break;
            }            
        }       

        if (!space) {

            executeCommands(instrucciones);

        } else {

            String mensaje = """
                    No se reconoce el comando, recuerda no usar espacios
                    Escriba Help, para ver los comandos disponibles
                    """;

            System.out.println("");
            System.out.println(mensaje);            
            System.out.println("");
        }        
    }    

    //Metodo para ejecutar los comandos
    private static void executeCommands(String instrucciones) {

        for (int i = 0; i < instrucciones.trim().length(); i++) {

            switch (instrucciones.charAt(i)) {

                case '#' ->

                    x = increment(x);                    

                case '@' ->

                    x = decrement(x);                    

                case '*' ->

                    x = multi(x);

                case '&' -> {

                    returnValue(x);                    
                }                                        
            }
        }
    }

    //Metodo para resetear el valor de x a 0
    private static void reset() {
        
        x = 0;
    }

    //Metodo help para listar los comandos disponibles
    private static void help() {
        
        String help = """
                Los comandos \"#\", \"@\", \"*\", \"&\" se pueden combinar entre si,        
                sin poner espacios
                \"#\" Incrementa el valor numérico en 1.
                \"@\" Decrementa el valor numérico en 1.
                \"*\" Multiplica el valor numérico por sí mismo.
                \"&\" Imprime el valor numérico actual.
                \"Help\" Muestra los comandos disponibles
                \"Reset\" Devuelve el valor inicial a 0
                \"Exit\" Acabar con la ejecucion del programa
                """;
        
        System.out.println("");
        System.out.println(help);
        System.out.println("");
    }

    //Metodo para #
    private static int increment(int x) {

        x++;
        return x;
    }

    //Metodo para @
    private static int decrement(int x) {

        x--;
        return x;
    }

    //Metodo para *
    private static int multi(int x) {

        x = x * x;
        return x;
    }

    //Metodo para &
    private static void returnValue(int x) {

        System.out.print(x);
    }

    //Metodo para volver a inicializar el input
    private static void resetInput() {

        input = new Scanner(System.in);
    }
}
