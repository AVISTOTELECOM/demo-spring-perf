package demo.avisto.spring.perfs.model.dto.out;

import demo.avisto.spring.perfs.model.entity.Museum;
import lombok.Getter;

@Getter
public class MuseumShortDtoOut {
    private final int id;
    private final String name;
    private final String postalCode;
    private final LocalizationShortDto city;

    public MuseumShortDtoOut(Museum museum) {
        id = museum.getId();
        name = museum.getName();
        postalCode = museum.getPostalCode().getCode();
        city = LocalizationShortDto.of(museum.getCity());
    }
}
