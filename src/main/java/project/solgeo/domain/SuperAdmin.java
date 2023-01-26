package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class SuperAdmin {

    // PK
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastModifiedDate;
    private String name;
    private String superId;
    private String password;
    private String phone;
    private String email;

    @Builder
    public SuperAdmin(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, String name, String superId, String password, String phone, String email) {
        this.id = id;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.name = name;
        this.superId = superId;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
}
