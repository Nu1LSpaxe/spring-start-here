package springboot.services;

import springboot.model.PaymentDetails;
import org.springframework.stereotype.Service;
import springboot.exceptions.NotEnoughMoneyException;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
