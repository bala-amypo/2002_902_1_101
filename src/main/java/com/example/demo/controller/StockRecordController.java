@RestController
@RequestMapping("/api/stocks")
public class StockRecordController {

    private final StockRecordService service;

    public StockRecordController(StockRecordService service) {
        this.service = service;
    }

    @PostMapping("/{productId}/{warehouseId}")
    public StockRecord create(@PathVariable Long productId,
                              @PathVariable Long warehouseId,
                              @RequestBody StockRecord sr) {
        return service.createStockRecord(productId, warehouseId, sr);
    }

    @GetMapping("/{id}")
    public StockRecord get(@PathVariable Long id) {
        return service.getStockRecord(id);
    }

    @GetMapping("/product/{productId}")
    public List<StockRecord> byProduct(@PathVariable Long productId) {
        return service.getRecordsBy_product(productId);
    }

    @GetMapping("/warehouse/{warehouseId}")
    public List<StockRecord> byWarehouse(@PathVariable Long warehouseId) {
        return service.getRecordsByWarehouse(warehouseId);
    }
}
