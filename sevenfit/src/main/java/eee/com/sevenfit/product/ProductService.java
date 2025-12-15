package eee.com.sevenfit.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    // CREATE / UPDATE
    public Product saveProduct(Product product) {
        return repo.save(product);
    }

    // GET ALL
    public List<Product> getAllProducts() {
        return repo.findByActiveTrue();
    }

    // GET BY ID
    public Product getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // GET BY CATEGORY
    public List<Product> getProductsByCategory(Long categoryId) {
        return repo.findByCategory_Id(categoryId);
    }

    // SEARCH
    public List<Product> searchProducts(String keyword) {
        return repo.findByNameContainingIgnoreCase(keyword);
    }

    // DELETE (Soft delete)
    public String deleteProduct(Long id) {
        Product product = getProductById(id);
        if (product != null) {
            product.setActive(false);
            repo.save(product);
            return "Product deleted successfully";
        }
        return "Product not found";
    }
}


