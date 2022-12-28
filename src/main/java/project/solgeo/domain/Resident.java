package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Resident {

    // PK
    private Long id;

    private String residentName;
    private Boolean residentSex;
    private String residentId;
    private String residentPassword;
    private Integer residentSignOutCount;

    // FK
    private Long roomId;

    @Builder
    public Resident(Long id, String residentName, Boolean residentSex, String residentId, String residentPassword, Integer residentSignOutCount, Long roomId) {
        this.id = id;
        this.residentName = residentName;
        this.residentSex = residentSex;
        this.residentId = residentId;
        this.residentPassword = residentPassword;
        this.residentSignOutCount = residentSignOutCount;
        this.roomId = roomId;
    }
}
