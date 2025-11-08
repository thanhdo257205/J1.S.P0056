/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dotha
 */
public class SalaryHistory {

    Worker worker;
    String status;
    Date date;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public SalaryHistory(Worker worker, String status) {
        this.worker = worker;
        this.status = status;
        this.date = new Date();
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-10s %-5d %-10.2f %-7s %-10s",
                worker.getCode(), worker.getName(), worker.getAge(),
                worker.getSalary(), status, sdf.format(date));
    }

}
