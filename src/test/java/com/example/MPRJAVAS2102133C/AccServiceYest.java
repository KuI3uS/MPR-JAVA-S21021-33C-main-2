package com.example.MPRJAVAS2102133C;

import com.example.MPRJAVAS2102133C.model.Acc;
import com.example.MPRJAVAS2102133C.repository.TransactionRepository;
import com.example.MPRJAVAS2102133C.services.AccountS;
import com.example.MPRJAVAS2102133C.utile.Printer;
import com.example.MPRJAVAS2102133C.utile.TimeDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class AccServiceYest {

    @Mock
    Printer printer;
    private Acc account;
    @Mock
    TimeDate timeDate;

    @Before
    public void initilise(){

        TransactionRepository transactionRepository = new TransactionRepository(timeDate);
        AccountS accountS = new AccountS(printer);
        account = new Acc(transactionRepository, accountS);
    }

//    @Test
//    public void statement_including_all_operation_Test(){
//        given(timeDate.toDayAsString()).willReturn("02/11/2020","06/02/2021","07/04/2021");
//
//        account.deposit(1000);
//        account.withdrawal(-100);
//        account.deposit(500);
//
//        account.printStatement();
//
//        //
//        InOrder inOrder = inOrder(printer);
//
//        inOrder.verify(printer).printLine("Date || Amount || Balance");
//        inOrder.verify(printer).printLine("02/11/2020 || 1000,00 || 1000,00");
//        inOrder.verify(printer).printLine("06/02/2021 || -100,00 || 900,00");
//        inOrder.verify(printer).printLine("07/04/2021 || 500,00 || 1400,00");
//    }



}
