package demo.avisto.spring.perfs.model.dto.out;

import demo.avisto.spring.perfs.model.entity.Department;
import lombok.Getter;

import java.util.List;

@Getter
public class DepartmentShortDtoOut {
    private final String name;
    private final String inseeCode;
    private final LocalizationShortDto region;
    private final List<LocalizationShortDto> cities;

    public DepartmentShortDtoOut(Department department) {
        name = department.getName();
        inseeCode = department.getInseeCode();
        region = LocalizationShortDto.of(department.getRegion());
        cities = department.getCities().stream().map(LocalizationShortDto::of).toList();
    }
}
