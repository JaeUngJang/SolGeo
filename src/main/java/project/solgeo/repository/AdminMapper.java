package project.solgeo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import project.solgeo.domain.Admin;
import project.solgeo.repository.dto.AdminDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminMapper {

    void save(Admin admin);

    void update(@Param("id") Long id, @Param("admin")AdminDto adminDto);

    List<Admin> findAll(Admin admin);

    Optional<Admin> findByAdminId(String adminId);

    void delete(Long id);

}
