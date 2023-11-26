package demo.avisto.spring.perfs.model.entity;

import demo.avisto.spring.perfs.util.Constants;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedEntityGraphs;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;



@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = Constants.EntityGraphs.CITY_WITH_DEPARTMENT_AND_MUSEUMS_AND_POSTAL_CODES,
                attributeNodes = {
                        @NamedAttributeNode("department"),
                        @NamedAttributeNode("museums"),
                        @NamedAttributeNode("postalCodes")
                }
        ),
})
@Entity
@NoArgsConstructor
@Getter
@Setter
public class City extends AbstractLocalization {

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "postal_code_cities",
            joinColumns = @JoinColumn(name = "city_insee_code"),
            inverseJoinColumns = @JoinColumn(name = "postal_code")
    )
    Set<PostalCode> postalCodes;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<Museum> museums;
}
