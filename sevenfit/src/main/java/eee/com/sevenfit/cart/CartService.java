package eee.com.sevenfit.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository repo;

    public void addToCart(String user, Long productId, int quantity) {
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProductId(productId);
        cart.setQuantity(quantity);
        repo.save(cart);
    }

    public List<Cart> getUserCart(String user) {
        return repo.findByUser(user);
    }

    public void clearCart(String user) {
        List<Cart> carts = repo.findByUser(user);
        repo.deleteAll(carts);
    }
}
