package demo.avisto.spring.perfs.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostalCode {

    @Id
    private String code;

    @ManyToMany(mappedBy = "postalCodes", fetch = FetchType.LAZY)
    private List<City> cities;

    @OneToMany(mappedBy = "postalCode", fetch = FetchType.LAZY)
    private List<Museum> museums;
}
