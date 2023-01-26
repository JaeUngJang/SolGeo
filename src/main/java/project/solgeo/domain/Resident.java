package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Resident {

    // PK
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastModifiedDate;
    private String name;
    private Boolean sex;
    private String residentId;
    private String password;
    private String phone;
    private String email;
    private Integer signOutCount;

    // FK
    private Long roomId;

    @Builder
    public Resident(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, String name, Boolean sex, String residentId, String password, String phone, String email, Integer signOutCount, Long roomId) {
        this.id = id;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.name = name;
        this.sex = sex;
        this.residentId = residentId;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.signOutCount = signOutCount;
        this.roomId = roomId;
    }
}
