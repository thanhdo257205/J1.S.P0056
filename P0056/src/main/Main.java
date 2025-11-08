/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Manager.Management;
import Model.SalaryHistory;
import Model.Worker;
import validate.Validate;

/**
 *
 * @author dotha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Management m = new Management();

        while (true) {
            System.out.println("======== Worker Management =========");
            System.out.println("1. Add Worker");
            System.out.println("2. Up salary");
            System.out.println("3. Down salary");
            System.out.println("4. Display salary history");
            System.out.println("5. Display current workers");
            System.out.println("6. Exit");

            int choice = Validate.inputInt("Choose: ","Invalid input!",1, 6);

            switch (choice) {
                case 1: {
                    String code = Validate.inputUniqueCode(
                            "Enter Code: ",
                            "Code is duplicated!",
                            m.getWorkers());

                    String name = Validate.inputString(
                            "Enter Name: ",
                            "Name cannot be empty!");

                    int age = Validate.inputInt(
                            "Enter Age: ",
                            "Invalid Age ",
                            18, 50);

                    double salary = Validate.inputDouble(
                            "Enter Salary: ",
                            "Salary must be greater than 0 ",
                            1, Double.MAX_VALUE);

                    String loc = Validate.inputString(
                            "Enter Work Location: ",
                            "Work location cannot be empty!");

                    m.addWorker(new Worker(code, name, age, salary, loc));
                    System.out.println("Added successfully!\n");
                    break;
                }

                case 2: {
                    if (m.getWorkers().isEmpty()) {
                        System.out.println("No worker found!");
                        break;
                    }

                    Worker w = Validate.inputExistingWorker(
                            "Enter Code: ",
                            "Worker code not found!",
                            m.getWorkers());

                    double up = Validate.inputDouble(
                            "Enter Raise Amount: ",
                            "Amount must be greater than 0 ",
                            1, Double.MAX_VALUE);

                    m.changeSalary("UP", w.getCode(), up);
                    System.out.println("Salary increased!\n");
                    break;
                }

                case 3: {
                    if (m.getWorkers().isEmpty()) {
                        System.out.println("No worker found!");
                        break;
                    }

                    Worker w = Validate.inputExistingWorker(
                            "Enter Code: ",
                            "Worker code not found!",
                            m.getWorkers());

                    double down = Validate.inputDouble(
                            "Enter Cut Amount: ",
                            "Amount must be greater than 0 ",
                            1, Double.MAX_VALUE);

                    m.changeSalary("DOWN", w.getCode(), down);
                    System.out.println("Salary decreased!\n");
                    break;
                }
                case 4: {
                    System.out.println("----- Salary History Information -----");
                    for (SalaryHistory sh : m.getInformationSalary()) {
                        System.out.println(sh);
                    }
                    System.out.println();
                    break;
                }
                case 5: {
                    m.displayCurrentWorkers();
                    break;
                }
                case 6: {
                    System.out.println("Bye!");
                    return;
                }
                default:
                    break;
            }
        }
    }
}
