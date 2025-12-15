package eee.com.sevenfit.wishlist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eee.com.sevenfit.LoginandRegister.User;
import eee.com.sevenfit.LoginandRegister.UserRepository;
import eee.com.sevenfit.product.Product;
import eee.com.sevenfit.product.ProductRepository;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    // ADD TO WISHLIST
    public String add(Long userId, Long productId) {

        wishlistRepo.findByUserIdAndProductId(userId, productId)
            .ifPresent(w -> {
                throw new RuntimeException("Product already in wishlist");
            });

        User user = userRepo.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepo.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));

        Wishlist wishlist = new Wishlist();
        wishlist.setUser(user);
        wishlist.setProduct(product);

        wishlistRepo.save(wishlist);
        return "Added to wishlist";
    }

    // VIEW WISHLIST
    public List<Wishlist> getUserWishlist(Long userId) {
        return wishlistRepo.findByUserId(userId);
    }

    // REMOVE FROM WISHLIST
    public String remove(Long userId, Long productId) {

        Wishlist wishlist = wishlistRepo
            .findByUserIdAndProductId(userId, productId)
            .orElseThrow(() -> new RuntimeException("Wishlist item not found"));

        wishlistRepo.delete(wishlist);
        return "Removed from wishlist";
    }
}

