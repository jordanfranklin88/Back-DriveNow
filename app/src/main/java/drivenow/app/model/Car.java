package drivenow.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String category;
    private Double dailyPrice;

    @Column(nullable = false)
    private Boolean available = true;
}