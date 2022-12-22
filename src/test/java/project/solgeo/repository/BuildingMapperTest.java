package project.solgeo.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import project.solgeo.domain.Admin;
import project.solgeo.domain.Building;
import project.solgeo.repository.dto.BuildingDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
@Rollback(value = true)
public class BuildingMapperTest {

    @Autowired
    BuildingMapper buildingMapper;

    @Test
    @DisplayName("Save Building")
    void save() {
        // given
        Integer buildingNo = 10;
        Building building = Building.builder()
                .buildingNo(buildingNo)
                .build();

        // when
        buildingMapper.save(building);

        // then
        Building foundBuilding = buildingMapper.findById(building.getId()).get();
        assertThat(foundBuilding.getId()).isEqualTo(building.getId());
    }

    @Test
    @DisplayName("Find All Buildings")
    void findAll() {
        // given
        Integer buildingNo1 = 9;
        Integer buildingNo2 = 10;
        Building building1 = Building.builder()
                .buildingNo(buildingNo1)
                .build();
        Building building2 = Building.builder()
                .buildingNo(buildingNo2)
                .build();
        buildingMapper.save(building1);
        buildingMapper.save(building2);

        // when
        List<Building> allBuildings = buildingMapper.findAll();

        // then
        assertThat(allBuildings.get(0).getId()).isEqualTo(building1.getId());
        assertThat(allBuildings.get(1).getId()).isEqualTo(building2.getId());
    }


    @Test
    @DisplayName("Find by Id")
    void findById() {
        // given
        Integer buildingNo = 10;
        Building building = Building.builder()
                .buildingNo(buildingNo)
                .build();
        buildingMapper.save(building);

        // when
        Building foundBuilding = buildingMapper.findById(building.getId()).get();

        // then
        assertThat(foundBuilding).isEqualTo(building);
    }

    @Test
    @DisplayName("Update Building")
    void update() {
        // given
        Integer buildingNo = 10;
        Building building = Building.builder()
                .buildingNo(buildingNo)
                .build();
        buildingMapper.save(building);

        // when
        Integer updatedBuildingNo = 9;
        BuildingDto buildingDto = new BuildingDto(updatedBuildingNo);
        buildingMapper.update(building.getId(), buildingDto);

        // then
        Building updatedBuilding = buildingMapper.findById(building.getId()).get();
        assertThat(updatedBuilding.getBuildingNo()).isEqualTo(updatedBuildingNo);
    }

    @Test
    @DisplayName("Delete Building")
    void delete() {
        // given
        Integer buildingNo = 10;
        Building building = Building.builder()
                .buildingNo(buildingNo)
                .build();
        buildingMapper.save(building);

        // when
        buildingMapper.delete(building.getId());

        // then
        List<Building> allBuildings = buildingMapper.findAll();
        assertThatThrownBy(() -> allBuildings.get(0)).isInstanceOf(IndexOutOfBoundsException.class);
    }

}
