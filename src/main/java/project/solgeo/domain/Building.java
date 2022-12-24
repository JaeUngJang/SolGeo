package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Building {

    // PK
    private Integer id;

    @Builder
    public Building(Integer id) {
        this.id = id;
    }
}
