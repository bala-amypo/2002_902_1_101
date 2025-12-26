@RestController
@RequestMapping("/api/consumption")
public class ConsumptionLogController {

    private final ConsumptionLogService service;

    public ConsumptionLogController(ConsumptionLogService service) {
        this.service = service;
    }

    @PostMapping("/{stockRecordId}")
    public ConsumptionLog log(@PathVariable Long stockRecordId,
                              @RequestBody ConsumptionLog log) {
        return service.logConsumption(stockRecordId, log);
    }

    @GetMapping("/record/{stockRecordId}")
    public List<ConsumptionLog> logs(@PathVariable Long stockRecordId) {
        return service.getLogsByStockRecord(stockRecordId);
    }

    @GetMapping("/{id}")
    public ConsumptionLog one(@PathVariable Long id) {
        return service.getLog(id);
    }
}
