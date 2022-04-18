package bo.edu.ucb.sis.WalikiBackend.service;

import bo.edu.ucb.sis.WalikiBackend.dto.Purchase;
import bo.edu.ucb.sis.WalikiBackend.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
