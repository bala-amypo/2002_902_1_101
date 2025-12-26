@Entity
@Table(name = "prediction_rules")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PredictionRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private Integer averageDaysWindow;
    private Integer minDailyUsage;
    private Integer maxDailyUsage;
    private LocalDateTime createdAt;
}
`