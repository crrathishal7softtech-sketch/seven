package eee.com.sevenfit.product;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")

public class ProductController {

    @Autowired
    private ProductService service;

    // ADD PRODUCT
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    // GET ALL PRODUCTS
    @GetMapping("/fetch")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    // GET PRODUCT BY ID
    @GetMapping("/fetch/{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.getProductById(id);
    }

    // GET BY CATEGORY
    @GetMapping("/fetch/{categoryId}")
    public List<Product> getByCategory(@PathVariable Long categoryId) {
        return service.getProductsByCategory(categoryId);
    }

    // SEARCH PRODUCT
    @GetMapping("/search")
    public List<Product> search(@RequestParam String keyword) {
        return service.searchProducts(keyword);
    }

    // DELETE PRODUCT
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return service.deleteProduct(id);
    }
}
