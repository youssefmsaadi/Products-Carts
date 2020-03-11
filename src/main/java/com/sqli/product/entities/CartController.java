package com.sqli.product.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    public CartRepository cartRepository;

    @GetMapping("/{id}")
    public Map<Long, Double> getCart(@PathVariable Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        List<CartLine> cartLines = cart.get().getCartLines();
        Map<Long, Double> response = new HashMap<>();
        for (CartLine cl: cartLines) {
            response.put(cl.getProduct().getId(), cl.getQuantity());
        }
        return response;
    }

}
