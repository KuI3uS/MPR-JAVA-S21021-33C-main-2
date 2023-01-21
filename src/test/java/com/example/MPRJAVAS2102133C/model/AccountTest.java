package com.example.MPRJAVAS2102133C.model;



import com.example.MPRJAVAS2102133C.repository.TransactionRepository;
import com.example.MPRJAVAS2102133C.services.AccountS;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    TransactionRepository transactionRepository;
    private Acc saldo;
    @Mock
    AccountS accountS;

    @Before
    public void initilise(){
        saldo = new Acc(transactionRepository, accountS);
    }

    @Test
    public void deposit(){
        saldo.deposit(100);
        verify(transactionRepository).addDeposit(100);
    }
    @Test
    public void save_withdrawal(){
        saldo.withdrawal(100);
        verify(transactionRepository).addWithdrawal(100);
    }

    @Test
    public void print_statement(){

        List<Operation> operations = asList(new Operation("01/01/2023",100));
        //kiedy transakcjaRepository.allOperations() zwróci wszystkie operacje
        given(transactionRepository.allOperations()).willReturn(operations);

        //when print dla konta Oczekuję listy transakcji
        saldo.printStatement();

        verify(accountS).print(operations);
    }

}