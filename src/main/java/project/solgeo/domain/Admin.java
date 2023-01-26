package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Admin {

    // PK
    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private String name;
    private String adminId;
    private String password;
    private String phone;
    private Boolean sex;

    @Builder
    public Admin(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, String name, String adminId, String password, String phone, Boolean sex) {
        this.id = id;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.name = name;
        this.adminId = adminId;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
    }

    public Admin(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, String name, String adminId, String phone, Boolean sex) {
        this.id = id;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.name = name;
        this.adminId = adminId;
        this.phone = phone;
        this.sex = sex;
    }
}
