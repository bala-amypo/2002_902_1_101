@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product create(@RequestBody Product p) {
        return service.createProduct(p);
    }

    @GetMapping
    public List<Product> all() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product one(@PathVariable Long id) {
        return service.getProduct(id);
    }
}
