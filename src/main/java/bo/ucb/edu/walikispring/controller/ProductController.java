package bo.ucb.edu.walikispring.controller;

import bo.ucb.edu.walikispring.dto.Purchase;
import bo.ucb.edu.walikispring.dto.PurchaseResponse;
import bo.ucb.edu.walikispring.service.CheckoutService;
import bo.ucb.edu.walikispring.service.ProductService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;


}
