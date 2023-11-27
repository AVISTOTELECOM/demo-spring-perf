package demo.avisto.spring.perfs.model.dto.out;

import demo.avisto.spring.perfs.model.entity.Region;
import lombok.Getter;

import java.util.List;

@Getter
public class RegionShortDtoOut {

    private final String name;
    private final String inseeCode;
    private final List<LocalizationShortDto> departments;

    public RegionShortDtoOut(Region region) {
        name = region.getName();
        inseeCode = region.getInseeCode();
        departments = region.getDepartments().stream().map(LocalizationShortDto::of).toList();
    }
}
