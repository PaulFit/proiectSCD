package Package;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long courierId;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private String deliveryAddress;

    private boolean payOnDelivery;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        NEW, PENDING, DELIVERED
    }
}
