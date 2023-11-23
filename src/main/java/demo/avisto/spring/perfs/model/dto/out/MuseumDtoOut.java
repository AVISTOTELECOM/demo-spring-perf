package demo.avisto.spring.perfs.model.dto.out;
import demo.avisto.spring.perfs.model.entity.Museum;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MuseumDtoOut {
    private final int id;
    private final String name;
    private final String address;
    private final String postalCode;
    private final String phone;
    private final String url;
    private final LocalDate date;
    private final LocalizationShortDto city;

    public MuseumDtoOut(Museum museum) {
        id = museum.getId();
        name = museum.getName();
        address = museum.getAddress();
        postalCode = museum.getPostalCode().getCode();
        phone = museum.getPhone();
        url = museum.getUrl();
        date = museum.getDate();
        city = LocalizationShortDto.of(museum.getCity());
    }
}