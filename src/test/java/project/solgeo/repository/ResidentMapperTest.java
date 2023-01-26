package project.solgeo.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import project.solgeo.domain.Building;
import project.solgeo.domain.Resident;
import project.solgeo.domain.Room;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(value = true)
public class ResidentMapperTest {

    @Autowired
    BuildingMapper buildingMapper;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    ResidentMapper residentMapper;

    @Test
    @DisplayName("Resident Save")
    void save() {

        // given
        Building building = saveBuilding(10);
        Room room = saveRoom(building, 1, 101);
        String residentName = "residentName";
        Boolean residentSex = true;
        String residentId = "residentIdA";
        String residentPassword = "residentPassword";
        String residentPhoneNumber = "010";
        Integer residentSignOutCount = 0;

        // when
        Resident resident = saveResident(room.getId(), residentName, residentSex, residentId, residentPassword, residentPhoneNumber, residentSignOutCount);

        // then
//        Resident foundResident = residentMapper.findById(resident.getId()).get();
//        assertThat(foundResident.getId()).isEqualTo(resident.getId());
    }








    private Resident saveResident(Long roomId, String residentName, Boolean residentSex, String residentId, String residentPassword, String residentPhoneNumber, Integer residentSignOutCount) {
        Resident resident = Resident.builder()
                .residentName(residentName)
                .residentSex(residentSex)
                .residentId(residentId)
                .residentPassword(residentPassword)
                .residentPhoneNumber(residentPhoneNumber)
                .residentSignOutCount(residentSignOutCount)
                .roomId(roomId)
                .build();
        residentMapper.save(resident);
        return resident;
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
