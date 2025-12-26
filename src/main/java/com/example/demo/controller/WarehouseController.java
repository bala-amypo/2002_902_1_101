@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    private final WarehouseService service;

    public WarehouseController(WarehouseService service) {
        this.service = service;
    }

    @PostMapping
    public Warehouse create(@RequestBody Warehouse w) {
        return service.createWarehouse(w);
    }

    @GetMapping
    public List<Warehouse> all() {
        return service.getAllWarehouses();
    }

    @GetMapping("/{id}")
    public Warehouse one(@PathVariable Long id) {
        return service.getWarehouse(id);
    }
}
