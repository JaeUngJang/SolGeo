package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Building {

    // PK
    private Long id;
    private String name;

    @Builder
    public Building(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
