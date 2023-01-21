package com.example.MPRJAVAS2102133C.model;

import com.example.MPRJAVAS2102133C.repository.TransactionRepository;
import com.example.MPRJAVAS2102133C.services.AccountS;

public class Acc {

    TransactionRepository transactionRepository;
    AccountS accountS;

    public Acc(TransactionRepository transactionRepository,
               AccountS accountSt) {
        this.transactionRepository = transactionRepository;
        this.accountS = accountSt;
    }

    public void deposit(int amount) {
        transactionRepository.addDeposit(amount);
    }

    public void withdrawal(int amount) {
        transactionRepository.addWithdrawal(amount);
    }
    public void printStatement() {
        accountS.print(transactionRepository.allOperations());
    }


}
