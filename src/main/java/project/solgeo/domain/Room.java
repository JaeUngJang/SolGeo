package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Room {

    //PK
    private Long id;

    private Integer roomNo;

    //FK
    private Long buildingId;


    @Builder
    public Room(Long id, Integer roomNo, Long buildingId) {
        this.id = id;
        this.roomNo = roomNo;
        this.buildingId = buildingId;
    }
}
