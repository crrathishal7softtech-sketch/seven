package eee.com.sevenfit.product;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public Category saveCategory(Category category) {
    	category.setId(null); 
        return repo.save(category);
    }

    public List<Category> getAllCategories() {
        return repo.findAll();
    }
 // UPDATE
    public Category update(Long id, Category category) {

        Category existing = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found with id " + id));

        existing.setName(category.getName());
        return repo.save(existing);
    }
    
 // DELETE
    public void delete(Long id) {
        repo.deleteById(id);
    }
}

