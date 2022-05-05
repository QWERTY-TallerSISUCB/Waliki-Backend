package bo.ucb.edu.walikispring.controller;

import bo.ucb.edu.walikispring.service.CheckoutService;
import bo.ucb.edu.walikispring.dto.Purchase;
import bo.ucb.edu.walikispring.dto.PurchaseResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }

}









