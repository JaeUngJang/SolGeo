package project.solgeo.repository.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class BuildingDto {

    private Long id;
    private Integer buildingNo;

    @Builder
    public BuildingDto(Long id, Integer buildingNo) {
        this.id = id;
        this.buildingNo = buildingNo;
    }
}
