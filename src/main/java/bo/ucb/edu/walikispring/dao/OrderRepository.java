package bo.ucb.edu.walikispring.dao;

import bo.ucb.edu.walikispring.entity.Order;
import bo.ucb.edu.walikispring.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("https://localhost:4200")
public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findByCustomerEmailOrderByDateCreatedDesc(@Param("email") String email, Pageable pageable);

    Page<Order> findByCustomerIdOrderByDateCreatedDesc(@Param("id") String id, Pageable pageable);

}
