package com.example.MPRJAVAS2102133C.utile;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TimeDateTest {

    @Test
    public void convert_ToDays_date_to_dd_MM_yyyy(){
        TimeDate timeDate = new TestableTimeDate();
        String date = timeDate.toDayAsString();
        assertThat(date, is("01/01/2023"));
    }

    private class TestableTimeDate extends TimeDate {
        @Override
        protected LocalDate toDay() {
            return LocalDate.of(2023,01,1);
        }
    }
}