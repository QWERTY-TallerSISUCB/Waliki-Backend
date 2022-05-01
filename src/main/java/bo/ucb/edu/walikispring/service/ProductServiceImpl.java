package bo.ucb.edu.walikispring.service;

import bo.ucb.edu.walikispring.entity.Customer;
import bo.ucb.edu.walikispring.entity.Order;
import bo.ucb.edu.walikispring.entity.OrderItem;

import java.util.Set;

public class ProductServiceImpl {
    // retrieve the order info from dto
    Order order = purchase.getOrder();

    // generate tracking number
    String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

    // populate order with orderItems
    Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

    // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

    // populate customer with order
    Customer customer = purchase.getCustomer();
        customer.add(order);

    // save to the database
        customerRepository.save(customer);

    // return a response
        return new PurchaseResponse(orderTrackingNumber);
}
