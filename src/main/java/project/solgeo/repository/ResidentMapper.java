package project.solgeo.repository;

import org.apache.ibatis.annotations.Mapper;
import project.solgeo.domain.Resident;

@Mapper
public interface ResidentMapper {

    void save(Resident resident);





}
