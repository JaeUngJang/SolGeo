package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Admin {

    // PK
    private Long id;
    private String adminName;
    private String adminId;
    private String adminPassword;
    private String adminPhoneNumber;
    private Boolean adminSex;

    @Builder
    public Admin(Long id, String adminName, String adminId, String adminPassword, String adminPhoneNumber, Boolean adminSex) {
        this.id = id;
        this.adminName = adminName;
        this.adminId = adminId;
        this.adminPassword = adminPassword;
        this.adminPhoneNumber = adminPhoneNumber;
        this.adminSex = adminSex;
    }

    public Admin(Long id, String adminName, String adminId, String adminPhoneNumber, Boolean adminSex) {
        this.id = id;
        this.adminName = adminName;
        this.adminId = adminId;
        this.adminPhoneNumber = adminPhoneNumber;
        this.adminSex = adminSex;
    }
}
