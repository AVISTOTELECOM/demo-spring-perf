package demo.avisto.spring.perfs.model.dto.out;

import demo.avisto.spring.perfs.model.entity.Department;
import lombok.Getter;

import java.util.List;

@Getter
public class DepartmentDtoOut {
    private final String name;
    private final String inseeCode;
    private final LocalizationShortDto region;
    private final List<LocalizationShortDto> contigousDepartments;
    private final List<LocalizationShortDto> cities;

    public DepartmentDtoOut(Department department) {
        region = LocalizationShortDto.of(department.getRegion());
        name = department.getName();
        inseeCode = department.getInseeCode();
        contigousDepartments = department.getContigousDepartments().stream().map(LocalizationShortDto::of).toList();
        cities = department.getCities().stream().map(LocalizationShortDto::of).toList();
    }
}