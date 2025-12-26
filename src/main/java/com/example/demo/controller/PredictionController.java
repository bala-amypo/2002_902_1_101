@RestController
@RequestMapping("/api/predict")
public class PredictionController {

    private final PredictionService service;

    public PredictionController(PredictionService service) {
        this.service = service;
    }

    @GetMapping("/restock-date/{id}")
    public LocalDate predict(@PathVariable Long id) {
        return service.predictRestockDate(id);
    }

    @PostMapping("/rules")
    public PredictionRule create(@RequestBody PredictionRule rule) {
        return service.createRule(rule);
    }

    @GetMapping("/rules")
    public List<PredictionRule> rules() {
        return service.getAllRules();
    }
}
