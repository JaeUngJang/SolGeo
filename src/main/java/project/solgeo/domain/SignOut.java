package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SignOut {

    // PK
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registerDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private String destination;

    // FK
    private Long residentId;



    @Builder
    public SignOut(Long id, LocalDateTime registerDate, LocalDate startDate, LocalDate endDate, String destination, Long residentId) {
        this.id = id;
        this.registerDate = registerDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.destination = destination;
        this.residentId = residentId;
    }
}
