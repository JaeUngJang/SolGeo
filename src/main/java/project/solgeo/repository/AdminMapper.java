package project.solgeo.repository;

import org.apache.ibatis.annotations.Mapper;
import project.solgeo.domain.Admin;

import java.util.List;

@Mapper
public interface AdminMapper {

    void save(Admin admin);

    List<Admin> findAll(Admin admin);
}
