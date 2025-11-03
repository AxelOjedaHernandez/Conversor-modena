import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Conversor conversor = new Conversor();
        int opcionElegida;
        int opcionAConvertir;
        double cantidad;
        boolean salir = false;
        double resultado;
        String opcionSalir;

        do {
            System.out.println("""
                -------------------------------------------------------
                Convertidor de monedas
                1) Dolares
                2) Pesos mexicanos
                3) Libra esterlina
                4) Euro
                5) Yen japones
                6) Franco suizo
                
                Ingrese el numero de la moneda que desea convertir: 
                """);
            opcionElegida = lectura.nextInt();

            System.out.println("Ingrese la cantidad a convertir: ");
            cantidad = lectura.nextDouble();

            System.out.println("""
                -------------------------------------------------------
                1) Dolares
                2) Pesos mexicanos
                3) Libra esterlina
                4) Euro
                5) Yen japones
                6) Franco suizo
                
                Ingrese el numero de la moneda a la que desea convertir: 
                """);
            opcionAConvertir = lectura.nextInt();

            String monedOrigen = conversor.obtenerMoneda(opcionElegida);
            String monedaDestino = conversor.obtenerMoneda(opcionAConvertir);

            resultado = conversor.convertirMoneda(monedOrigen, monedaDestino, cantidad);

            System.out.println(cantidad+" "+monedOrigen+" convertido a "+monedaDestino+" son: "+resultado);
            System.out.println("Desea realizar otra conversion? s=si   n=no");

            //arreglar para salir
            opcionSalir = lectura.next();

            if (opcionSalir.equalsIgnoreCase("n")) {
                System.out.println("Fin de la operacion");
                salir = true;
            }
            // agregar historial de conversion con pila
        } while (salir != true);
    }
}
