package project.solgeo.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Super {

    // PK
    private Long id;
    private String superName;
    private String superId;
    private String superPassword;
    private String superPhoneNumber;
    private String superEmail;

    @Builder
    public Super(Long id, String superName, String superId, String superPassword, String superPhoneNumber, String superEmail) {
        this.id = id;
        this.superName = superName;
        this.superId = superId;
        this.superPassword = superPassword;
        this.superPhoneNumber = superPhoneNumber;
        this.superEmail = superEmail;
    }
}
