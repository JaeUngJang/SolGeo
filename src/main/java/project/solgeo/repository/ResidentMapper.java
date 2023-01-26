package project.solgeo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import project.solgeo.domain.Resident;
import project.solgeo.repository.dto.ResidentDto;

import java.util.List;

@Mapper
public interface ResidentMapper {

    void save(Resident resident);

    void update(@Param("id") Long id, @Param("resident")ResidentDto residentDto);

    List<Resident> findAll(Resident resident);

    List<Resident> findbyName(Resident resident);

    List<Resident> findByRoom(Long roomId);

    List<Resident> findByFloor(Long a);


}
