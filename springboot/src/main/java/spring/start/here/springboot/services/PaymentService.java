package spring.start.here.springboot.services;

import org.springframework.stereotype.Service;
import spring.start.here.springboot.exceptions.NotEnoughMoneyException;
import spring.start.here.springboot.model.PaymentDetails;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
