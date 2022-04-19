package bo.ucb.edu.walikispring.dao;

import bo.ucb.edu.walikispring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
