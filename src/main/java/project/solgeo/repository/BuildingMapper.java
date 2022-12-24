package project.solgeo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import project.solgeo.domain.Building;
import project.solgeo.repository.dto.BuildingDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BuildingMapper {

    void save(Building building);

    void update(@Param("id") Integer id, @Param("building") BuildingDto buildingDto);

    List<Building> findAll();

    Optional<Building> findById(Integer id);

    void delete(Integer id);

}
