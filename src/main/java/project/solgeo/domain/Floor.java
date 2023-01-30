package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Floor {

    // PK
    private Long id;
    private Integer number;

    //FK
    private Long buildingId;

    @Builder
    public Floor(Long id, Integer number, Long buildingId) {
        this.id = id;
        this.number = number;
        this.buildingId = buildingId;
    }
}
