package org.example;

public class birthday_agenda {

    private String NAME;
    private int DAY;
    private int MONTH;

    public birthday_agenda(String name, int day, int month) {
        this.NAME = name;
        this.DAY = day;
        this.MONTH = month;
    }

    public String GetName() {
        return NAME;
    }

    public int GetDay() {
        return DAY;
    }

    public int GetMonth() {
        return MONTH;
    }
}
