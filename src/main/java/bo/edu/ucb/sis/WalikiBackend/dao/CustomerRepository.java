package bo.edu.ucb.sis.WalikiBackend.dao;

import bo.edu.ucb.sis.WalikiBackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
