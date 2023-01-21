package com.example.MPRJAVAS2102133C.services;


import com.example.MPRJAVAS2102133C.model.Operation;
import com.example.MPRJAVAS2102133C.utile.Printer;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AccountS {

    private Printer printer;
    public static final String STATEMENT_HEADER = "data || ilość || saldo";
    private DecimalFormat decimalFormatter = new DecimalFormat("0.00");

    public AccountS(Printer printer) {
        this.printer=printer;
    }

    public void print(List<Operation> operations) {
        printer.printLine(STATEMENT_HEADER);
        AtomicInteger runningBalance= new AtomicInteger(0);
        operations.stream()
                .map(operation -> statementOperation(operation,runningBalance))
                .collect(Collectors.toCollection(LinkedList::new))
                .forEach(printer::printLine);

    }

    private String statementOperation(Operation operation, AtomicInteger runningSaldo) {
        return operation.date()
                +" || "
                + decimalFormatter.format(operation.amount())
                +" || "
                + decimalFormatter.format(runningSaldo.addAndGet(operation.amount()));
    }


}
