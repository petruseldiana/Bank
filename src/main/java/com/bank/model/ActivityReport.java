package com.bank.model;

import java.util.Date;

public class ActivityReport {

    private int id;
    private String type;
    private Date date;
    private int idEmployee;

    public ActivityReport(String type, Date date) {
        this.type = type;
        this.date = date;
    }

    public ActivityReport() {
    }

    public ActivityReport(String type, Date date, int idEmployee) {
        this.type = type;
        this.date = date;
        this.idEmployee = idEmployee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", idEmployee=" + idEmployee +
                '}';
    }
}
