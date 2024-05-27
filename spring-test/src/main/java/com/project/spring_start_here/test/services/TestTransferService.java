package com.project.spring_start_here.test.services;

import com.project.spring_start_here.test.exceptions.TestAccountNotFoundException;
import com.project.spring_start_here.test.repositories.TestAccountRepository;
import com.project.spring_start_here.test.model.TestAccount;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TestTransferService {

    private final TestAccountRepository testAccountRepository;

    public TestTransferService(TestAccountRepository testAccountRepository) {
        this.testAccountRepository = testAccountRepository;
    }

    @Transactional
    public void transferMoney(
            long idSender,
            long idReceiver,
            BigDecimal amount
    ) {
        TestAccount sender = testAccountRepository.findById(idSender)
                .orElseThrow(() -> new TestAccountNotFoundException());
        TestAccount receiver = testAccountRepository.findById(idReceiver)
                .orElseThrow(() -> new TestAccountNotFoundException());

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        testAccountRepository.changeAmount(idSender, senderNewAmount);
        testAccountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public Iterable<TestAccount> getAllAccounts() {
        return testAccountRepository.findAll();
    }

    public List<TestAccount> findAccountsByName(String name) {
        return testAccountRepository.findAccountsByName(name);
    }
}
