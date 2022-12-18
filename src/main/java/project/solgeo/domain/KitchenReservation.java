package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class KitchenReservation {

    // PK
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    // FK
    private Long residentId;


    @Builder
    public KitchenReservation(Long id, LocalDateTime date, Long residentId) {
        this.id = id;
        this.date = date;
        this.residentId = residentId;
    }
}
