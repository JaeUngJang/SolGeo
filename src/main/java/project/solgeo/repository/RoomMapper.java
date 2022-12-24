package project.solgeo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import project.solgeo.domain.Room;
import project.solgeo.repository.dto.RoomDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface RoomMapper {

    void save(Room room);

    List<Room> findAll();

    List<Room> findByBuildingFloorRoom(Room room);

    //Optional<Room> findByRoomNo(Room room);

    void update(@Param("id") Long id, @Param("room") RoomDto adminDto);

    void delete(Long id);

}
