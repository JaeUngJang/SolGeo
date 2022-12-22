package project.solgeo.repository.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class BuildingDto {

    private Integer buildingNo;

    @Builder
    public BuildingDto(Integer buildingNo) {
        this.buildingNo = buildingNo;
    }
}
