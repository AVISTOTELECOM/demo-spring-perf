package demo.avisto.spring.perfs.model.dto.out;

import demo.avisto.spring.perfs.model.entity.City;
import lombok.Getter;

import java.util.List;
@Getter
public class CityShortDtoOut {
    private final String name;
    private final String inseeCode;
    private final LocalizationShortDto department;
    private final List<MuseumShortDto> museums;

    public CityShortDtoOut(City city) {
        name = city.getName();
        inseeCode = city.getInseeCode();
        department = LocalizationShortDto.of(city.getDepartment());
        museums = city.getMuseums().stream().map(MuseumShortDto::of).toList();
    }
}
