import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);


        ConsultaMoneda consulta = new ConsultaMoneda();
        Moneda moneda = consulta.buscarMoneda("USD");
        System.out.println(moneda);

        int opcion ;
        double cantidad;
        double tasaDeCambio;
        double resultado;
        do {
            System.out.println("""
        ***********************************************************
        Sea Bienvenido al conversor  de moneda =]
        1)Dolar  => Peso argentino
        2)Peso Argentino => Dolar
        3)Dolar => Real brasileño
        4)real brasileño =>> Dolar
        5)Dolar =>> Peso colombiano
        6)Peso colombiano =>> Dolar
        7)salir
        ***********************************************************
        ingrese su opcion:
        """);
            try {
                opcion = lectura.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("Ingrese la cantidad en dólares:");
                        cantidad = lectura.nextDouble();
                        tasaDeCambio = moneda.conversion_rates().get("ARS");
                        resultado = cantidad * tasaDeCambio;
                        System.out.println("El valor "+cantidad + "  [USD] corresponde al valor final de =>>> " + resultado + " [ARS]");
                        break;
                    case 2:
                        System.out.println("Ingrese la cantidad en pesos argentinos:");
                        cantidad = lectura.nextDouble();
                        tasaDeCambio = moneda.conversion_rates().get("ARS");
                        resultado =  cantidad/tasaDeCambio;
                        System.out.println("El valor "+cantidad+"[ARS] corresponde al valor final de =>>>"+ resultado + "[USD]");
                        break;
                    case 3:
                        System.out.println("Ingrese la cantidad en dólares:");
                        cantidad = lectura.nextDouble();
                        tasaDeCambio = moneda.conversion_rates().get("BRL");
                        resultado = cantidad * tasaDeCambio;
                        System.out.println("El valor "+cantidad + "  [USD] corresponde al valor final de =>>> " + resultado + " [BRL]");
                        break;
                    case 4:
                        System.out.println("Ingrese la cantidad en reales brasileños:");
                        cantidad = lectura.nextDouble();
                        tasaDeCambio = moneda.conversion_rates().get("BRL");
                        resultado = cantidad / tasaDeCambio;
                        System.out.println("El valor "+cantidad + "  [BRL] corresponde al valor final de =>>> " + resultado + " [USD]");
                        break;
                    case 5:
                        System.out.println("Ingrese la cantidad en dólares:");
                        cantidad = lectura.nextDouble();
                        tasaDeCambio = moneda.conversion_rates().get("COP");
                        resultado = cantidad * tasaDeCambio;
                        System.out.println("El valor "+cantidad + "  [USD] corresponde al valor final de =>>> " + resultado + " [COP]");
                        break;
                    case 6:
                        System.out.println("Ingrese la cantidad en pesos colombianos:");
                        cantidad = lectura.nextDouble();
                        tasaDeCambio = moneda.conversion_rates().get("COP");
                        resultado = cantidad / tasaDeCambio;
                        System.out.println("El valor "+cantidad + "  [COP] corresponde al valor final de =>>> " + resultado + " [USD]");
                        break;
                    case 7:
                        System.out.println("Muchas gracias por usar el conversor de monedas :D !!!");
                        break;
                    default:
                        System.out.println("Por favor ingresa una de las 7 opciones ");
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingresa solo números enteros.");
                lectura.next(); // Limpia el buffer del scanner para evitar un bucle infinito
                opcion = 0; // Establece opcion a 0 para evitar bucle infinito
            }
        }while (opcion != 7);
    }
}
