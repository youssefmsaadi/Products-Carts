package com.sqli.product.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    public CartRepository cartRepository;

    @GetMapping("/{id}")
    public List<CartLine> getCart(@PathVariable Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        return cart.get().getCartLines();
    }

}
