public interface ProductService {

    Product save(Product product);

    Product findById(Long id);

    List<Product> findAll();
}
