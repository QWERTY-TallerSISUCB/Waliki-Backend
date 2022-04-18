package bo.edu.ucb.sis.WalikiBackend.dto;

import bo.edu.ucb.sis.WalikiBackend.entity.Address;
import bo.edu.ucb.sis.WalikiBackend.entity.Customer;
import bo.edu.ucb.sis.WalikiBackend.entity.Order;
import bo.edu.ucb.sis.WalikiBackend.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
