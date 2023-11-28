package demo.avisto.spring.perfs.model.dto.out;

import demo.avisto.spring.perfs.model.entity.Museum;

public record MuseumShortDto(int id, String name) {
    public static MuseumShortDto of(Museum museum) {
        return new MuseumShortDto(museum.getId(), museum.getName());
    }
}
