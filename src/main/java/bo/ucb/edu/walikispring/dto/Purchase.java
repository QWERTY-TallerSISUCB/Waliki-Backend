package bo.ucb.edu.walikispring.dto;

import bo.ucb.edu.walikispring.entity.Customer;
import bo.ucb.edu.walikispring.entity.Address;
import bo.ucb.edu.walikispring.entity.Order;
import bo.ucb.edu.walikispring.entity.OrderItem;
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
