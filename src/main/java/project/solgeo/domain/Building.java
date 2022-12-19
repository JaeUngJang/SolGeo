package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Building {

    // PK
    private Long id;
    private Integer buildingNo;

    @Builder
    public Building(Long id, Integer buildingNo) {
        this.id = id;
        this.buildingNo = buildingNo;
    }



}
