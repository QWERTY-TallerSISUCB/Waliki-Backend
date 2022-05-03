package bo.ucb.edu.walikispring.dao;

import bo.ucb.edu.walikispring.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface OrderRepository {
    Page<Product> findByUserId(@RequestParam("id") Long id, Pageable pageable);
}
