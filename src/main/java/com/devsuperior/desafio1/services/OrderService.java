package com.devsuperior.desafio1.services;

import com.devsuperior.desafio1.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public Double total(Order order){
        Double value;
        if (order.getDiscount() > 0){
            value = order.getBasic() - ((order.getDiscount() / 100) * order.getBasic());
        }else {
            value = order.getBasic();
        }
        return value + shippingService.shipment(order);
    }
}
