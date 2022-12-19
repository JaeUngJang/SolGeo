package project.solgeo.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import project.solgeo.domain.Admin;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
@Rollback(value = true)
public class AdminMapperTest {

    @Autowired
    AdminMapper adminMapper;

    @Test
    @DisplayName("Save Admin")
    void save() {
        // given
        Admin admin = Admin.builder()
                .adminName("admin")
                .adminId("adminId")
                .adminPassword("adminPassword")
                .adminPhoneNumber("adminPhoneNumber")
                .adminSex(true)  //true-Male, false-female
                .build();

        // when
        adminMapper.save(admin);
    }

    @Test
    @DisplayName("Select Admin")
    void select() {
        // given
        String adminName = "admin";
        String adminId = "adminId";
        String adminPassword = "adminPassword";
        String adminPhoneNumber = "adminPhoneNumber";
        Boolean adminSex = true;  //true-Male, false-female

        Admin admin = adminSave(adminName, adminId, adminPassword, adminPhoneNumber, adminSex);

        // when
        // 모든 정보 입력 검증
        test(null, adminName, adminId, adminPhoneNumber, admin);
        // adminName 입력
        test(null, "dm", null, null, admin);

    }

    Admin adminSave(String adminName, String adminId, String adminPassword, String adminPhoneNumber, Boolean adminSex) {
        Admin admin = Admin.builder()
                .adminName(adminName)
                .adminId(adminId)
                .adminPassword(adminPassword)
                .adminPhoneNumber(adminPhoneNumber)
                .adminSex(adminSex)  //true-Male, false-female
                .build();
        adminMapper.save(admin);
        return admin;
    }

    void test(Long id, String adminName, String adminId, String adminPhoneNumber, Admin... admins) {
        Admin selectAdmin = Admin.builder()
                .id(id)
                .adminName(adminName)
                .adminId(adminId)
                .adminPhoneNumber(adminPhoneNumber)
                .build();
        List<Admin> result = adminMapper.findAll(selectAdmin);
        assertThat(result.size()).isEqualTo(admins.length);
    }

}
