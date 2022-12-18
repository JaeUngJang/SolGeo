package project.solgeo.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import project.solgeo.domain.Admin;

import java.util.List;

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
        Admin selectAdmin = Admin.builder()
                .adminName("name")
                .adminId("id")
                .adminPhoneNumber("phone")
                .build();
        List<Admin> selectedAdmins = adminMapper.findAll(selectAdmin);

        // when


        // then
    }



}
