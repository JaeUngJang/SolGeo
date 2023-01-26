package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Room {

    //PK
    private Long id;
    private Integer roomFloor;
    private Integer roomNo;
    //FK
    private Long buildingId;


    @Builder
    public Room(Long id, Integer roomFloor, Integer roomNo, Long buildingId) {
        this.id = id;
        this.roomFloor = roomFloor;
        this.roomNo = roomNo;
        this.buildingId = buildingId;
    }
}
