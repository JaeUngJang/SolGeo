package project.solgeo.repository.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class RoomDto {

    private Integer roomFloor;

    private Integer roomNo;

    //FK
    private Long buildingId;

    @Builder
    public RoomDto(Integer roomFloor, Integer roomNo, Long buildingId) {
        this.roomFloor = roomFloor;
        this.roomNo = roomNo;
        this.buildingId = buildingId;
    }

}
