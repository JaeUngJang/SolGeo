package project.solgeo.repository.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class BuildingDto {

    private Integer id;

    @Builder
    public BuildingDto(Integer id) {
        this.id = id;
    }
}
