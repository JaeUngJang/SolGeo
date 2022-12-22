package project.solgeo.repository;

import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import project.solgeo.domain.Admin;
import project.solgeo.repository.dto.AdminDto;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


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
        String adminName = "admin";
        String adminId = "adminId";
        String adminPassword = "adminPassword";
        String adminPhoneNumber = "adminPhoneNumber";
        Boolean adminSex = true;  //true-Male, false-female

        // when
        adminSave(adminName, adminId, adminPassword, adminPhoneNumber, adminSex);

        // then
        Admin foundAdmin = adminMapper.findByAdminId(adminId).get();
        assertThat(foundAdmin.getId()).isEqualTo(foundAdmin.getId());

    }

    @Test
    @DisplayName("Find All Admin")
    void findAll() {
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

    @Test
    @DisplayName("Find by Admin Id")
    void findByAdminId() {
        // given
        String adminName = "admin";
        String adminId = "adminId";
        String adminPassword = "adminPassword";
        String adminPhoneNumber = "adminPhoneNumber";
        Boolean adminSex = true;  //true-Male, false-female
        Admin admin = adminSave(adminName, adminId, adminPassword, adminPhoneNumber, adminSex);

        // when
        Optional<Admin> selectedAdmin = adminMapper.findByAdminId(admin.getAdminId());

        // then
        assertThat(admin.getId()).isEqualTo(selectedAdmin.get().getId());
    }


    @Test
    @DisplayName("Update Admin")
    void update() {
        // given
        String adminName = "admin";
        String adminId = "adminId";
        String adminPassword = "adminPassword";
        String adminPhoneNumber = "adminPhoneNumber";
        Boolean adminSex = true;  //true-Male, false-female

        Admin admin = adminSave(adminName, adminId, adminPassword, adminPhoneNumber, adminSex);

        // when
        String updatedAdminName = "updatedAdmin";
        String updatedAdminId = "updatedAdminId";
        String updatedAdminPassword = "updatedAdminPassword";
        String updatedAdminPhoneNumber = "updatedAdminPN";
        Boolean updatedAdminSex = false;  //true-Male, false-female

        AdminDto adminDto = new AdminDto(updatedAdminName, updatedAdminId, updatedAdminPassword, updatedAdminPhoneNumber, updatedAdminSex);
        adminMapper.update(admin.getId(), adminDto);


        // then
        Optional<Admin> updatedAdmin = adminMapper.findByAdminId(updatedAdminId);
        Long id = updatedAdmin.get().getId();
        Long id1 = admin.getId();
        assertThat(updatedAdmin.get().getId()).isEqualTo(admin.getId());
    }

    @Test
    @DisplayName("Delete Admin")
    void delete() {
        // given
        String adminName = "admin";
        String adminId = "adminId";
        String adminPassword = "adminPassword";
        String adminPhoneNumber = "adminPhoneNumber";
        Boolean adminSex = true;  //true-Male, false-female

        Admin admin = adminSave(adminName, adminId, adminPassword, adminPhoneNumber, adminSex);

        // when
        adminMapper.delete(admin.getId());

        // then
        Admin selectedAdmin = Admin.builder()
                .adminId("adminId")
                .build();

        List<Admin> allAdmin = adminMapper.findAll(selectedAdmin);

        assertThatThrownBy(() -> allAdmin.get(0)).isInstanceOf(IndexOutOfBoundsException.class);
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

    /**
     * id, adminName, adminId, adminPhoneNumber 으로 Admin select
     * @param id
     * @param adminName
     * @param adminId
     * @param adminPhoneNumber
     * @param admins
     */
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
