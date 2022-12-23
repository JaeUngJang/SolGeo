package project.solgeo.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import project.solgeo.domain.Building;
import project.solgeo.domain.Room;
import project.solgeo.repository.dto.RoomDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
@Rollback(value = true)
public class RoomMapperTest {

    @Autowired
    RoomMapper roomMapper;
    @Autowired
    BuildingMapper buildingMapper;

    @Test
    @DisplayName("Save Room")
    void save() {

        // given - Building 먼저 등록 -> Room 등록
        Building building = saveBuilding(10);

        // when - roomFloor, roomNom BuildingId
        Integer roomFloor = 2;
        Integer roomNo = 201;
        Room room = saveRoom(building, roomFloor, roomNo);

    }

    @Test
    @DisplayName("Find All")
    void findAll() {

        // given
        // Save buildings
        Building buildingA = saveBuilding(8);
        Building buildingB = saveBuilding(9);
        // Save Rooms
        Integer roomFloor1 = 2;
        Integer roomNo1 = 201;
        Room room1 = saveRoom(buildingA, roomFloor1, roomNo1);
        Integer roomFloor2 = 3;
        Integer roomNo2 = 301;
        Room room2 = saveRoom(buildingB, roomFloor2, roomNo2);

        // when
        List<Room> allRooms = roomMapper.findAll();

        // then
        assertThat(allRooms).containsExactly(room1, room2);
    }

    @Test
    @DisplayName("Find by Building, Floor, Room No.")
    void findByFloor() {

        // given
        Building building = saveBuilding(10);
        Integer roomFloorA = 1;
        Integer roomFloorB = 2;
        Integer roomNoA = 101;
        Integer roomNoB = 102;
        Integer roomNoC = 202;
        // B10 > 1F > 101
        Room roomA = saveRoom(building, roomFloorA, roomNoA);
        // B10 > 1F > 102
        Room roomB = saveRoom(building, roomFloorA, roomNoB);
        // B10 > 2F > 201
        Room roomC = saveRoom(building, roomFloorB, roomNoC);


        // (A        (B           (C        ) ) )
        // Building  (+ roomFloor (+ roomNo ) ) )

        // Rooms in specific building
        List<Room> roomsInBuilding = findRooms(building, null, null);
        assertThat(roomsInBuilding).containsExactly(roomA, roomB, roomC);

        // Rooms in specific building, floor
        List<Room> roomsInBuildingFloor = findRooms(building, roomFloorA, null);
        assertThat(roomsInBuildingFloor).containsExactly(roomA, roomB);

        // Room in specific building, floor, room
        List<Room> roomsInBuildingFloorRoom = findRooms(building, roomFloorA, roomNoA);
        assertThat(roomsInBuildingFloorRoom).containsExactly(roomA);
    }

    @Test
    @DisplayName("Update Room")
    void update() {

        // given
        Building building = saveBuilding(10);
        Integer roomFloor = 1;
        Integer roomNo = 101;
        Room room = saveRoom(building, roomFloor, roomNo);

        // when
        Integer updatedRoomFloor = 2;
        Integer updatedRoomNo = 202;
        RoomDto updatedRoom = RoomDto.builder()
                .roomFloor(updatedRoomFloor)
                .roomNo(updatedRoomNo)
                .build();

        roomMapper.update(room.getId(), updatedRoom);

        // then
        assertThat(updatedRoom.getRoomFloor()).isEqualTo(updatedRoomFloor);
        assertThat(updatedRoom.getRoomNo()).isEqualTo(updatedRoomNo);

    }

    @Test
    @DisplayName("Delete Room")
    void delete() {

        // given
        Building building = saveBuilding(10);
        Integer roomFloor = 1;
        Integer roomNo = 101;
        Room room = saveRoom(building, roomFloor, roomNo);

        // when
        roomMapper.delete(room.getId());

        // then
        List<Room> allRooms = roomMapper.findByBuildingFloorRoom(room);
        assertThatThrownBy(() -> allRooms.get(0)).isInstanceOf(IndexOutOfBoundsException.class);

    }



    private List<Room> findRooms(Building building, Integer roomFloor, Integer roomNo) {
        Room room = Room.builder()
                .buildingId(building.getId())
                .roomFloor(roomFloor)
                .roomNo(roomNo)
                .build();
        return roomMapper.findByBuildingFloorRoom(room);
    }

    private Room saveRoom(Building building, Integer roomFloor, Integer roomNo) {
        Room room = Room.builder()
                .roomFloor(roomFloor)
                .roomNo(roomNo)
                .buildingId(building.getId())
                .build();
        roomMapper.save(room);
        return room;
    }

    private Building saveBuilding(Integer buildingNo) {
        Building building = Building.builder()
                .buildingNo(buildingNo)
                .build();
        buildingMapper.save(building);
        return building;
    }


}
