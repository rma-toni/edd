package helper;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

import org.w3c.dom.html.HTMLBRElement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Helper {


    //region Static Objects
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    //endregion


    //region Character Helpers
    public static Character getCharacter(Scanner scanner, String inputMessage, String errorMessage) {
        Character characterValue;
        while (true) {
            System.out.print(inputMessage);
            try {
                characterValue = scanner.nextLine().charAt(0);
                return characterValue;
            } catch (Exception exception) {
                System.out.println(errorMessage);
                scanner.nextLine();
            }
        }
    }

    public static Character getCharacter(Scanner scanner, String inputMessage) {
        return getCharacter(scanner, inputMessage, "Ingrese un caracter válido");
    }

    public static Character getCharacter(String inputMessage, String errorMessage) {
        return getCharacter(Helper.scanner, inputMessage, errorMessage);
    }

    public static Character getCharacter(String inputMessage) {
        return getCharacter(Helper.scanner, inputMessage, "Ingrese un caracter válido");
    }
    //endregion


    //region Integer Helpers
    private static Integer getInteger(Scanner scanner, String inputMessage, String errorMessage) {
        Integer integerValue = 0;
        while (true) {
            try {
                System.out.print(inputMessage);
                integerValue = Integer.parseInt(scanner.nextLine());
                return integerValue;
            } catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }

    private static Integer getInteger(Scanner scanner, String inputMessage) {
        return getInteger(scanner, inputMessage, "Ingrese un número válido");
    }

    private static Integer getInteger(String inputMessage, String errorMessage) {
        return getInteger(Helper.scanner, inputMessage, errorMessage);
    }

    public static Integer getInteger(String inputMessage) {
        return getInteger(Helper.scanner, inputMessage, "Ingrese un número válido");
    }
    //endregion


    //region Double Helpers
    public static Double getDouble(Scanner scanner, String inputMessage, String errorMessage) {
        Double doubleValue = 0.0;
        while (true) {
            try {
                System.out.print(inputMessage);
                doubleValue = Double.parseDouble(scanner.nextLine());
                return doubleValue;
            } catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }

    public static Double getDouble(Scanner scanner, String inputMessage) {
        return getDouble(scanner, inputMessage, "Ingrese un número válido");
    }

    public static Double getDouble(String inputMessage, String errorMessage) {
        return getDouble(Helper.scanner, inputMessage, errorMessage);
    }

    public static Double getDouble(String inputMessage) {
        return getDouble(Helper.scanner, inputMessage, "Ingrese un número válido");
    }
    //endregion


    //region Float Helpers
    public static Float getFloat(Scanner scanner, String inputMessage, String errorMessage) {
        Float floatValue = 0f;
        while (true) {
            try {
                System.out.print(inputMessage);
                floatValue = Float.parseFloat(scanner.nextLine());
                return floatValue;
            } catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }

    public static Float getFloat(Scanner scanner, String inputMessage) {
        return getFloat(scanner, inputMessage, "Ingrese un número válido");
    }

    public static Float getFloat(String inputMessage, String errorMessage) {
        return getFloat(Helper.scanner, inputMessage, errorMessage);
    }

    public static Float getFloat(String inputMessage) {
        return getFloat(Helper.scanner, inputMessage, "Ingrese un número válido");
    }
    //endregion


    //region Array Helpers

    static void printOneDimensionArray(String textBefore, Object[] array, String textAfter) {
        System.out.print(textBefore);
        System.out.print("[" + array[0]);
        for (int i = 1; i < array.length; ++i) {
            System.out.print("," + array[i]);
        }
        System.out.print("]");
        System.out.print(textAfter);
    }


    static void printTwoDimensionArray(String textBefore, Object[][] array, String textAfter) {
        System.out.print(textBefore);

        System.out.print("[[" + array[0][0]);
        for (int j = 1; j < array[0].length; ++j) {
            System.out.print("," + array[0][j]);
        }
        System.out.print("]");

        for (int i = 1; i < array.length; ++i) {
            System.out.print(",[" + array[i][0]);
            for (int j = 1; j < array[i].length; ++j) {
                System.out.print("," + array[i][j]);
            }
            System.out.print("]");
        }
        System.out.print("]");
        System.out.print(textAfter);
    }
    //endregion


    //region Enum Helpers

    // from http://stackoverflow.com/questions/13783295/getting-all-names-in-an-enum-as-a-string
    public static String[] getEnumNames(Class<? extends Enum<?>> e) {
        return Arrays.toString(e.getEnumConstants()).replaceAll("^.|.$", "").split(", ");
    }
    //endregion

    //region String Helpers - Toni:)
    public static String getString(String inputMessage){
        System.out.print(inputMessage);
        String stringValue = scanner.nextLine();
        return stringValue;
    }
    //endregion

    //region LocalDate LocalTime Helpers - Toni:)
    public static LocalDate getLocalDate(String inputMessage, String separator){
        int day;
        int month;
        int year;

        while (true){

            System.out.print(inputMessage);
            String[] splitDate = scanner.nextLine().split(separator);
            day = Integer.parseInt(splitDate[0]);
            month = Integer.parseInt(splitDate[1]);
            year = Integer.parseInt(splitDate[2]);
            //TODO Si el año es bisiesto
            //TODO Meses
            boolean dayC = day <= 31 && day > 0;
            boolean monthC = month <= 12 && month > 0;
            boolean yearC = year < 2100 && year > 1950;
            if(dayC && monthC && yearC){
                break;
            }
        }
        return LocalDate.of(year,month,day);
    }

    public static LocalTime getLocalTime(){
        int hour;
        int minute;
        while (true) {

            hour = getInteger("Ingrese la hora (0 a 23): ");
            minute = getInteger("Ingrese los minutos (0 a 59): ");

            if (!((hour <= 23 && hour >= 0) && (minute <= 59 && minute >= 0))){
                System.out.println("Ingrese un horario valido");
            }else{
                break;
            }
        }

        return LocalTime.of(hour,minute);
    }
    //endregion

    //region Boolean Helpers - Toni:)
    public static Boolean getBoolean(String inputMessage){
        System.out.println(inputMessage);
        int option;
        while (true){
            System.out.println("1 - True");
            System.out.println("0 - False");
            option = Helper.getInteger("Ingrse la opcion elegida: ");
            switch (option) {
                case 1:
                    return true;
                case 0:
                    return false;
                default:
                    System.out.println("Valor invalido.");
            }
        }
    }
    //endregion
}