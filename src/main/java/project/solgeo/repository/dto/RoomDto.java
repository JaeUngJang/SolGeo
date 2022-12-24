package project.solgeo.repository.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class RoomDto {

    private Integer roomFloor;

    private Integer roomNo;

    //FK
    private Integer buildingId;

    @Builder
    public RoomDto(Integer roomFloor, Integer roomNo, Integer buildingId) {
        this.roomFloor = roomFloor;
        this.roomNo = roomNo;
        this.buildingId = buildingId;
    }

}
