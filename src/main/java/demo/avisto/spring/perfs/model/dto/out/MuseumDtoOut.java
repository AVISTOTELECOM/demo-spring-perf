package demo.avisto.spring.perfs.model.dto.out;
import demo.avisto.spring.perfs.model.entity.Museum;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MuseumDtoOut {
    private String name;
    private String address;
    private String postalCode;
    private String phone;
    private String url;
    private LocalDate date;

    public MuseumDtoOut(Museum museum) {
        name = museum.getName();
        address = museum.getAddress();
        postalCode = museum.getPostalCode().getCode();
        phone = museum.getPhone();
        url = museum.getUrl();
        date = museum.getDate();
    }
}
