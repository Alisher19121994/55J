package com.best.a55j.User;

public class Users {

    String name;
    boolean available;

    public Users(String name, boolean available) {
        this.name = name;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", available=" + available +
                '}';
    }
}
