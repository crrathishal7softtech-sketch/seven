package eee.com.sevenfit.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/cart")
@SecurityRequirement(name = "bearerAuth")
public class CartController {

    @Autowired
    private CartService service;

    @PostMapping("/add")
    public String addToCart(@RequestBody CartRequest request) {
    	
    	// user already authenticated by filter
        service.addToCart(
            "LOGGED_IN_USER",
            request.getProductId(),
            request.getQuantity()
            );
        return "Added to cart";
    }
}

