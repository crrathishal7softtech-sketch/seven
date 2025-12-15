package eee.com.sevenfit.product;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Get only active products
    List<Product> findByActiveTrue();

    // Filter by category
    
    List<Product> findByCategory_Id(Long categoryId);


    // Search by name
    List<Product> findByNameContainingIgnoreCase(String name);
}


