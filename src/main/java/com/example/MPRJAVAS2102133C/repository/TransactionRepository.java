package com.example.MPRJAVAS2102133C.repository;


import com.example.MPRJAVAS2102133C.model.Operation;
import com.example.MPRJAVAS2102133C.utile.TimeDate;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class TransactionRepository {
    private final TimeDate timeDate;
    private List<Operation> operations =new ArrayList<>();

    public TransactionRepository(TimeDate timeDate) {
        this.timeDate=timeDate;
    }

    public void addDeposit(int amount) {
        //Wartość
        Operation deposit = new Operation(timeDate.toDayAsString(),amount);
        operations.add(deposit);
    }

    public void addWithdrawal(int amount) {
        //wartość
        Operation withdrawal = new Operation(timeDate.toDayAsString(),amount);
        operations.add(withdrawal);
    }

    public List<Operation> allOperations() {
        //pobierz wszystko
        return unmodifiableList(operations);
    }

}
