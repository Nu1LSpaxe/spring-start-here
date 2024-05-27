package com.project.spring_start_here.test;

import com.project.spring_start_here.test.exceptions.TestAccountNotFoundException;
import com.project.spring_start_here.test.model.TestAccount;
import com.project.spring_start_here.test.repositories.TestAccountRepository;
import com.project.spring_start_here.test.services.TestTransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransferServiceWithAnnotationsUnitTests {

    @Mock
    private TestAccountRepository testAccountRepository;

    @InjectMocks
    private TestTransferService testTransferService;

    @Test
    public void moneyTransferDestinationAccountNotFoundFlow() {
        TestAccount sender = new TestAccount();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        given(testAccountRepository.findById(1L))
                .willReturn(Optional.of(sender));

        given(testAccountRepository.findById(2L))
                .willReturn(Optional.empty());

        assertThrows(
                TestAccountNotFoundException.class,
                () -> testTransferService.transferMoney(1, 2, new BigDecimal(100))
        );

        verify(testAccountRepository, never()).changeAmount(anyLong(), any());
    }
}
