package demo.avisto.spring.perfs.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class City extends AbstractLocalization {

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "postal_code_cities",
            joinColumns = @JoinColumn(name = "city_insee_code"),
            inverseJoinColumns = @JoinColumn(name = "postal_code")
    )
    Set<PostalCode> postalCodes;

    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;

    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private List<Museum> museums;
}
