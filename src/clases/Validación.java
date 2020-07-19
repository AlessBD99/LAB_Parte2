package clases;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validación extends Exception {

    Scanner datosEntrada = new Scanner(System.in);
    boolean continuarCiclo = true;
    int n = 0;
    String respuesta;

    //Constructor
    public Validación() {
    }

    public Validación(String msg) {
        super(msg);
    }

    //EXPRESIONES REGULARES
    public static boolean validarExpresionRegular(String patron, String cadenaIndicada) {
        Pattern pat = Pattern.compile(patron);
        Matcher mat = pat.matcher(cadenaIndicada);
        return mat.matches();
    }
    
     public static boolean validarNombre(String patron) {
        return patron.matches("^[\\p{L} .'-]+$");
    }

    public static boolean validarEspecialidad(String patron) {
        return patron.matches("^[a-zA-Z ]+$");
    }

    public static boolean validarEnteroPositivo(String patron) {
        return patron.matches("^[0-9]{7,9}$");
    }

    public static boolean validarDireccion(String patron) {
        return patron.matches("^[a-zA-Z0-9.# ]*$");
    }

    public static boolean validarDoublePositivo(String patron) {
        return patron.matches("\\d+(\\.\\d{1,2})?");
    }

    public static boolean validarEntradaEdad(String patron) {
        return patron.matches("[1-9][0-9]*");
    }
   
    public static boolean validarRitmoCardiaco(String patron) {
        return patron.matches("^0*([6-8][0-9]|9[0-9]|[1-8][0-9]{2}|9[0-8][0-9]|99[0-9]|1000)$");
    }
    
    public static boolean validarFrecuenciaEntrenamiento(String patron) {
        return patron.matches("^(^(diario)+$|^(semanal)+$)$");
    }
    
    public static boolean validarSexo(String patron) {
        return patron.matches("^(^(masculino)+$|^(femenino)+$)$");
    }
    
    public static boolean validarTipoEjercicio(String patron) {
        return patron.matches("^(^(tonificacion)*$|^(reduccion de peso)*$|^(reduccion de medidas)*$|^(cardio)*$|^(pesas)*$|^(flexibilidad y equilibrio)*$|^(relajacion)*$)$");
    }

    private void rango(int num) throws Validación {
        if (num <= 0) {
            throw new Validación("Números fuera de rango");
        }

    }

    //TRY CATCH
    public int validarExpresionNumericoGimnasio() {

        do {

            try {

                System.out.print("Indica número de personas a ser incorporados: ");
                n = datosEntrada.nextInt();
                rango(n);
                continuarCiclo = false;

            } catch (Validación tipoExcepcion) {
                System.err.printf("\nExcepcion : %s\n ", " Tipo de dato incompatible ");
                System.out.println("Debe ingresar un numero positivo , Intente de nuevo \n");
                datosEntrada.nextLine();

            } catch (NumberFormatException tipoExcepcion2) {
                System.err.printf("\nExcepcion : %s\n ", " Tipo de dato incompatible ");
                System.out.println("Debe ingresar un numero , Intente de nuevo \n");
                datosEntrada.nextLine();

            } catch (InputMismatchException tipoExcepcion3) {
                System.err.printf("\nExcepcion : %s\n ", " Tipo de dato incompatible ");
                System.out.println("Debe ingresar un numero , Intente de nuevo \n");
                datosEntrada.nextLine();

            }

        } while (continuarCiclo);
        return (n);

    }

    public int validarExpresionNumericoMenu() {

        do {

            try {

                System.out.print(" Seleccione una opcion : ");

                n = datosEntrada.nextInt();
                rango(n);
                continuarCiclo = false;

            } catch (Validación tipoExcepcion) {
                System.err.printf("\nExcepcion : %s\n ", " Tipo de dato incompatible ");
                System.out.println("Debe ingresar un numero positivo , Intente de nuevo \n");
                datosEntrada.nextLine();

            } catch (NumberFormatException tipoExcepcion2) {
                System.err.printf("\nExcepcion : %s\n ", " Tipo de dato incompatible ");
                System.out.println("Debe ingresar un numero , Intente de nuevo \n");
                datosEntrada.nextLine();

            } catch (InputMismatchException tipoExcepcion3) {
                System.err.printf("\nExcepcion : %s\n ", " Tipo de dato incompatible ");
                System.out.println("Debe ingresar un numero , Intente de nuevo \n");
                datosEntrada.nextLine();

            }

        } while (continuarCiclo);
        return (n);

    }

}
