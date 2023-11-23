package demo.avisto.spring.perfs.model.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@MappedSuperclass
public abstract class AbstractLocalization {
    @Id
    protected String inseeCode;

    protected String name;
}
