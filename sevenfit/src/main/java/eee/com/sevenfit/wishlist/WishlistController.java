package eee.com.sevenfit.wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService service;

    // ADD
    @PostMapping("/{productId}")
    public String addToWishlist(@RequestParam Long userId,
                                @PathVariable Long productId) {
        return service.add(userId, productId);
    }

    // VIEW
    @GetMapping
    public List<Wishlist> getWishlist(@RequestParam Long userId) {
        return service.getUserWishlist(userId);
    }

    // REMOVE
    @DeleteMapping("/{productId}")
    public String remove(@RequestParam Long userId,
                         @PathVariable Long productId) {
        return service.remove(userId, productId);
    }
}

