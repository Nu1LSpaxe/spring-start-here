package com.project.spring_start_here.test;

import com.project.spring_start_here.test.model.TestAccount;
import com.project.spring_start_here.test.repositories.TestAccountRepository;
import com.project.spring_start_here.test.services.TestTransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TransferServiceUnitTests {

    @Test
    @DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
    public void moneyTransferHappyFlow() {
        TestAccountRepository testAccountRepository = mock(TestAccountRepository.class);
        TestTransferService testTransferService = new TestTransferService(testAccountRepository);

        TestAccount sender = new TestAccount();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        TestAccount destination = new TestAccount();
        destination.setId(2);
        destination.setAmount(new BigDecimal(1000));

        given(testAccountRepository.findById(sender.getId()))
                .willReturn(Optional.of(sender));
        given(testAccountRepository.findById(destination.getId()))
                .willReturn(Optional.of(destination));

        testTransferService.transferMoney(
                sender.getId(),
                destination.getId(),
                new BigDecimal(100)
        );

        verify(testAccountRepository).changeAmount(1, new BigDecimal(900));
        verify(testAccountRepository).changeAmount(2, new BigDecimal(1100));
    }

}
