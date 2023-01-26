package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Room {

    //PK
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastModifiedDate;
    private Integer number;
    private Integer peopleNum;
    //FK
    private Long floorId;
    private Long buildingId;


    @Builder
    public Room(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, Integer number, Integer peopleNum, Long floorId, Long buildingId) {
        this.id = id;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.number = number;
        this.peopleNum = peopleNum;
        this.floorId = floorId;
        this.buildingId = buildingId;
    }
}
