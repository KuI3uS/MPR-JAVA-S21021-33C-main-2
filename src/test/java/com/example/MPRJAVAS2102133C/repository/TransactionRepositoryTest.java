package com.example.MPRJAVAS2102133C.repository;


import com.example.MPRJAVAS2102133C.model.Operation;
import com.example.MPRJAVAS2102133C.utile.TimeDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryTest {

    private TransactionRepository transactionRepository;
    public static final String TODAY = "21/01/2023";
    @Mock
    TimeDate timeDate;

    @Before
    public void initilise(){
        transactionRepository = new TransactionRepository(timeDate);
        given(timeDate.toDayAsString()).willReturn(TODAY);
    }
    @Test
    public void create_and_save_deposit_operation(){
        transactionRepository.addDeposit(100);
        transactionRepository.addDeposit(200);

        List<Operation> operations = transactionRepository.allOperations();

        assertThat(operations.size(), is(2));
        assertThat(operations.get(0), is(operations(TODAY,100)));
        assertThat(operations.get(1), is(operations(TODAY,200)));
    }
    @Test
    public void create_and_save_withdrawal_operation(){
        transactionRepository.addWithdrawal(-100);

        List<Operation> operations = transactionRepository.allOperations();
        assertThat(operations.size(), is(1));
        assertThat(operations.get(0), is(operations(TODAY,-100)));

    }

    private Operation operations(String date, int amount) {
        return new Operation(date,amount);
    }

}