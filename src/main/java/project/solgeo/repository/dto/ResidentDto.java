package project.solgeo.repository.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ResidentDto {

    private String residentName;
    private Boolean residentSex;
    private String residentId;
    private String residentPassword;
    private String residentPhoneNumber;
    private Integer residentSignOutCount;

    // FK
    private Long roomId;

    @Builder
    public ResidentDto( String residentName, Boolean residentSex, String residentId, String residentPassword, String residentPhoneNumber,Integer residentSignOutCount, Long roomId) {
        this.residentName = residentName;
        this.residentSex = residentSex;
        this.residentId = residentId;
        this.residentPassword = residentPassword;
        this.residentPhoneNumber = residentPhoneNumber;
        this.residentSignOutCount = residentSignOutCount;
        this.roomId = roomId;
    }
}
