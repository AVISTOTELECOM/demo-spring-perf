package demo.avisto.spring.perfs.model.dto.out;


import demo.avisto.spring.perfs.model.entity.City;
import demo.avisto.spring.perfs.model.entity.Department;
import demo.avisto.spring.perfs.model.entity.PostalCode;
import demo.avisto.spring.perfs.model.entity.Region;
import lombok.Getter;

import java.util.List;

@Getter
public class RegionDtoOut {
    private final String name;
    private final String inseeCode;
    private final List<DepartmentInternalDto> departments;

    public RegionDtoOut(Region region) {
        name = region.getName();
        inseeCode = region.getInseeCode();
        departments = region.getDepartments().stream().map(DepartmentInternalDto::new).toList();
    }

    @Getter
    public static class DepartmentInternalDto {
        private final String name;
        private final String inseeCode;
        private final List<LocalizationShortDto> contigousDepartments;
        private final List<CityInternalDto> cities;

        public DepartmentInternalDto(Department department) {
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
}
