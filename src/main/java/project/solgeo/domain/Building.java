package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
