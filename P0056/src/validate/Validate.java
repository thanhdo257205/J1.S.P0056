/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validate;

import Model.Worker;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dotha
 */
public class Validate {

    private static Scanner sc = new Scanner(System.in);

    public static String inputString(String message, String errorMessage) {
        while (true) {
            System.out.print(message);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println(errorMessage);
        }
    }

    public static int inputInt(String message, String errorMessage, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println(errorMessage + " (" + min + " - " + max + ")");
            } catch (NumberFormatException e) {
                System.out.println(errorMessage + " (" + min + " - " + max + ")");
            }
        }
    }

    public static double inputDouble(String message, String errorMessage, double min, double max) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(sc.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println(errorMessage + " (" + min + " - " + max + ")");
            } catch (NumberFormatException e) {
                System.out.println(errorMessage + " (" + min + " - " + max + ")");
            }
        }
    }

    public static String inputUniqueCode(String message, String errorMessage, List<Worker> list) {
        while (true) {
            System.out.print(message);
            String code = sc.nextLine().trim();
            boolean exists = false;
            for (Worker w : list) {
                if (w.getCode().equalsIgnoreCase(code)) {
                    exists = true;
                    break;
                }
            }
            if (!code.isEmpty() && !exists) {
                return code;
            }
            System.out.println(errorMessage);
        }
    }
    
    public static Worker inputExistingWorker(String message, String errorMessage, List<Worker> list) {
        while (true) {
            System.out.print(message);
            String code = sc.nextLine().trim();
            for (Worker w : list) {
                if (w.getCode().equalsIgnoreCase(code)) {
                    return w;
                }
            }
            System.out.println(errorMessage);
        }
    }
}
