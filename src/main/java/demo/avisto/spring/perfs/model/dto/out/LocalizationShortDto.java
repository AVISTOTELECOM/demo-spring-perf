package demo.avisto.spring.perfs.model.dto.out;

import demo.avisto.spring.perfs.model.entity.AbstractLocalization;

public record LocalizationShortDto(String name, String inseeCode) {
    public static LocalizationShortDto of(AbstractLocalization localization) {
        return new LocalizationShortDto(localization.getName(), localization.getInseeCode());
    }
}
