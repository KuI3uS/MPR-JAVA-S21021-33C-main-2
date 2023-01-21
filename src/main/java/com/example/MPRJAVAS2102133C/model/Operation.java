package com.example.MPRJAVAS2102133C.model;


import java.util.Objects;

public class Operation {


    private final String date;
    private final int saldo;

    public Operation(String date, int amount) {
        this.date = date;
        this.saldo = amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(date, operation.date) && Objects.equals(saldo, operation.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, saldo);
    }

    public String date() {
        return date;
    }

    public int amount() {
        return saldo;
    }
}
