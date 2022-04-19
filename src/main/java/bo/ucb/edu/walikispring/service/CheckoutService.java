package bo.ucb.edu.walikispring.service;

import bo.ucb.edu.walikispring.dto.Purchase;
import bo.ucb.edu.walikispring.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
