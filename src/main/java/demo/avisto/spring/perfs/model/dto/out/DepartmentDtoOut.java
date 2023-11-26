package demo.avisto.spring.perfs.model.dto.out;

import demo.avisto.spring.perfs.model.entity.City;
import demo.avisto.spring.perfs.model.entity.Department;
import demo.avisto.spring.perfs.model.entity.PostalCode;
import lombok.Getter;

import java.util.List;

@Getter
public class DepartmentDtoOut {
    private final String name;
    private final String inseeCode;
    private final LocalizationShortDto region;
    private final List<LocalizationShortDto> contigousDepartments;
    private final List<CityInternalDto> cities;

    public DepartmentDtoOut(Department department) {
        region = LocalizationShortDto.of(department.getRegion());
        name = department.getName();
        inseeCode = department.getInseeCode();
        contigousDepartments = department.getContigousDepartments().stream().map(LocalizationShortDto::of).toList();
        cities = department.getCities().stream().map(CityInternalDto::new).toList();
    }

    @Getter
    public static class CityInternalDto {
        private final String name;
        private final String inseeCode;
        private final List<String> postalCodes;
        private final List<MuseumShortDto> museums;

        public CityInternalDto(City city) {
            name = city.getName();
            inseeCode = city.getInseeCode();
            postalCodes = city.getPostalCodes().stream().map(PostalCode::getCode).toList();
            museums = city.getMuseums().stream().map(MuseumShortDto::of).toList();
        }
    }
}
