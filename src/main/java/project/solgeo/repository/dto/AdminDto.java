package project.solgeo.repository.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class AdminDto {
    private String adminName;
    private String adminId;
    private String adminPassword;
    private String adminPhoneNumber;
    private Boolean adminSex;

    @Builder
    public AdminDto(String adminName, String adminId, String adminPassword, String adminPhoneNumber, Boolean adminSex) {
        this.adminName = adminName;
        this.adminId = adminId;
        this.adminPassword = adminPassword;
        this.adminPhoneNumber = adminPhoneNumber;
        this.adminSex = adminSex;
    }


}
