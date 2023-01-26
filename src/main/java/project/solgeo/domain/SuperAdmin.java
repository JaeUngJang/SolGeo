package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SuperAdmin {

    // PK
    private Long id;
    private LocalDateTime createdTime;
    private LocalDateTime lastModifiedTime;
    private String name;
    private String superId;
    private String password;
    private String phone;
    private String email;

    @Builder
    public SuperAdmin(Long id, LocalDateTime createdTime, LocalDateTime lastModifiedTime, String name, String superId, String password, String phone, String email) {
        this.id = id;
        this.createdTime = createdTime;
        this.lastModifiedTime = lastModifiedTime;
        this.name = name;
        this.superId = superId;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
}