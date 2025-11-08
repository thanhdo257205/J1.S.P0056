/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dotha
 */
public class Worker {

    private String code;
    private String name;
    private int age;
    private double salary;
    private String workLocation;
    private List<SalaryHistory> salaryHistoryList;

    public Worker(String code, String name, int age, double salary, String workLocation) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
        this.salaryHistoryList = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<SalaryHistory> getSalaryHistoryList() {
        return salaryHistoryList;
    }

    public void addSalaryHistory(SalaryHistory history) {
        salaryHistoryList.add(history);
    }

    @Override
    public String toString() {
        return String.format("%-5s %-10s %-5d %-10.2f %-10s",
                code, name, age, salary, workLocation);
    }

}
