package fp;

import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Calculator {


    /*
     * este metodo devuelve el Class del object que le pasamos
     */
    public static Class classTypeOf (Object x) {
        return x.getClass();
    }


    /*
     * devuelve una lista con los n n�meros de la serie de fibonacci.
     */
    public static List<Integer> fibonacci (int n) {
        List<Integer> fibonnaciList = new ArrayList<Integer>();
        Integer n1 = 0, n2 = 1;
        fibonnaciList.add(1);

        for (int i = 0; i < n - 1; i++) {
            Integer summa = n1 + n2;
            n1 = n2;
            n2 = summa;
            fibonnaciList.add(summa);
        }

        return fibonnaciList;
    }

    /*
     * Escribir todos los n�meros del number al 0 de step en step.
     */
    public static int[] stepThisNumber (int number, int step) {
        List<Integer> stepList = new ArrayList<>();
        while (number - step > 0) {
            stepList.add(number -= step);
        }
        return ListToArray(stepList);
    }

    public static int[] ListToArray (List<Integer> list) {
        int[] intArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            intArray[i] = list.get(i);
        }
        return intArray;
    }

    /*
     * M�dulo al que se le pasa un n�mero entero del 0 al 20 y devuelve los
     * divisores que tiene.
     */
    public static int[] divisors (int n) {
        if (n == 0)
            return null;
        List<Integer> divisorsList = new ArrayList<Integer>();
        if (n >= 0 && n <= 20) {
            int counter = 0;
            for (int i = 20; i > 0; i--) {
                if (n % i == 0) {
                    divisorsList.add(i);
                }
            }

            return ListToArray(divisorsList);
        }
        return new int[] {-1};
    }

    /*
     * Toma como par�metros una cadena de caracteres y devuelve cierto si la cadena resulta ser un pal�ndromo
     */

    public static void main (String[] args) {
        System.out.println(checkIsPalindrome("Buena suerte con los Test"));
    }

    public static boolean checkIsPalindrome (String _cadena) {
        if (_cadena == null) {
            return false;
        }
        String cadena = StringUtils.stripAccents(_cadena).toLowerCase();
        cadena = cadena.replaceAll(" ", "");
        cadena = cadena.replaceAll("\\.", "");
        cadena = cadena.replaceAll(",", "");
        cadena = cadena.replaceAll("\\?", "");
        cadena = cadena.replaceAll("\\�", "");
        cadena = cadena.replaceAll(":", "");
        cadena = cadena.replaceAll("�", "");

        int i = 0, j = cadena.length() - 1;
        while (i < j) {
            if (cadena.charAt(i) != cadena.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    /*
     * Pedir un n�mero de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
     * mostrar: cincuenta y seis
     */
    public static String speakToMe (int n) {
        int iUnidad = n % 10;
        n = n / 10;
        String sTexto = unidadEnTexto(iUnidad);
        int iDecena = n % 10;
        n = n / 10;

        if ((iUnidad == 0) && (iDecena > 0)) {
            sTexto = decenaEnTexto(iDecena);
        } else if (iDecena == 1) {
            sTexto = decenas(10 + iUnidad);
        } else if (iDecena > 1) {
            sTexto = decenaEnTexto(iDecena) + " y " + sTexto.toLowerCase();
        }
        return sTexto;
    }

    public static String unidadEnTexto (int iNumero) {
        switch (iNumero) {
            case 1:
                return "Uno";
            case 2:
                return "Dos";
            case 3:
                return "Tres";
            case 4:
                return "Cuatro";
            case 5:
                return "Cinco";
            case 6:
                return "Seis";
            case 7:
                return "Siete";
            case 8:
                return "Ocho";
            case 9:
                return "Nueve";
            case 0:
                return "Cero";
            default:
                return "";
        }
    }

    public static String decenaEnTexto (int iDecena) {
        switch (iDecena) {
            case 1:
                return "Diez";
            case 2:
                return "Veinte";
            case 3:
                return "Treinta";
            case 4:
                return "Cuarenta";
            case 5:
                return "Cincuenta";
            case 6:
                return "Sesenta";
            case 7:
                return "Setenta";
            case 8:
                return "Ochenta";
            case 9:
                return "Noventa";
            default:
                return "";
        }
    }

    public static String decenas (int iDecena) {
        switch (iDecena) {
            case 11:
                return "once";
            case 12:
                return "doce";
            case 13:
                return "trece";
            case 14:
                return "catorce";
            case 15:
                return "quince";
            case 16:
                return "dieciseis";
            case 17:
                return "diecisiete";
            case 18:
                return "dieciocho";
            case 19:
                return "diecinueve";
            default:
                return "";
        }
    }

    /*
     * este metodo devuelve cierto si el a�o de la fecha es bisiesto fecha
     * dd-MM-yyyy
     */
    public static boolean isLeapYear (String fecha) {
        if (fecha == "")
            return false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(fecha, formatter).isLeapYear();
    }

    /*
     * este metodo devuelve cierto si la fecha es v�lida
     */
    public static boolean isValidDate (String date) {
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}