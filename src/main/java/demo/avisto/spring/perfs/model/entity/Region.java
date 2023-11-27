package demo.avisto.spring.perfs.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Region extends AbstractLocalization {

    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    private List<Department> departments;
}
