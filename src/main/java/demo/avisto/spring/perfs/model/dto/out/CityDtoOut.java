package demo.avisto.spring.perfs.model.dto.out;

import demo.avisto.spring.perfs.model.entity.City;
import demo.avisto.spring.perfs.model.entity.PostalCode;
import lombok.Getter;

import java.util.List;

@Getter
public class CityDtoOut {
    private final String name;
    private final String inseeCode;
    private final List<String> postalCodes;
    private final List<MuseumDtoOut> museums;

    public CityDtoOut(City city) {
        name = city.getName();
        inseeCode = city.getInseeCode();
        postalCodes = city.getPostalCodes().stream().map(PostalCode::getCode).toList();
        museums = city.getMuseums().stream().map(MuseumDtoOut::new).toList();
    }
}
