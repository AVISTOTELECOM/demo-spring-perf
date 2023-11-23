package demo.avisto.spring.perfs.model.dto.out;


import demo.avisto.spring.perfs.model.entity.Region;
import lombok.Getter;

import java.util.List;

@Getter
public class RegionDtoOut {
    private final String name;
    private final String inseeCode;
    private final List<DepartmentDtoOut> departments;

    public RegionDtoOut(Region region) {
        name = region.getName();
        inseeCode = region.getInseeCode();
        departments = region.getDepartments().stream().map(DepartmentDtoOut::new).toList();
    }
}
