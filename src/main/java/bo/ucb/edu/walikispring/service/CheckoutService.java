package bo.ucb.edu.walikispring.service;

import bo.ucb.edu.walikispring.dto.Purchase;
import bo.ucb.edu.walikispring.dto.PurchaseResponse;
import org.springframework.stereotype.Service;

@Service
public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
