/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import Model.SalaryHistory;
import Model.Worker;
import java.util.*;

/**
 *
 * @author dotha
 */
public class Management {

    private List<Worker> workers = new ArrayList<>();
    
    public boolean addWorker(Worker worker) {
        workers.add(worker);
        return true;
    }
    public boolean changeSalary(String status, String code, double amount) {
        for (Worker w : workers) {
            if (w.getCode().equalsIgnoreCase(code)) {
                if (status.equalsIgnoreCase("UP")) {
                    w.setSalary(w.getSalary() + amount);
                } else if (status.equalsIgnoreCase("DOWN")) {
                    w.setSalary(w.getSalary() - amount);
                }
                SalaryHistory history = new SalaryHistory(w, status);
                w.addSalaryHistory(history);

                return true;
            }
        }
        return false;
    }
    
    public List<SalaryHistory> getInformationSalary() {
        List<SalaryHistory> allHistories = new ArrayList<>();
        for (Worker w : workers) {
            allHistories.addAll(w.getSalaryHistoryList());
        }
        Collections.sort(allHistories, new Comparator<SalaryHistory>() {
            @Override
            public int compare(SalaryHistory h1, SalaryHistory h2) {
                return h1.getWorker().getCode().compareToIgnoreCase(h2.getWorker().getCode());
            }
        });
        return allHistories;
    }

    public void displayCurrentWorkers() {
        if (workers.isEmpty()) {
            System.out.println("No workers found!");
            return;
        }
        System.out.println("----- Current Worker Information -----");
        System.out.printf("%-5s %-10s %-5s %-10s %-10s\n", "Code", "Name", "Age", "Salary", "Location");
        for (Worker w : workers) {
            System.out.printf("%-5s %-10s %-5d %-10.2f %-10s\n",
                    w.getCode(), w.getName(), w.getAge(), w.getSalary(), w.getWorkLocation());
        }
        System.out.println();
    }

    public List<Worker> getWorkers() {
        return workers;
    }

}
