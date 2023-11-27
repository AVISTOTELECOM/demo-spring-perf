package demo.avisto.spring.perfs.model.entity;

import demo.avisto.spring.perfs.util.Constants;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedEntityGraphs;
import jakarta.persistence.NamedSubgraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = Constants.EntityGraphs.DEPARTMENT_WITH_REGION_AND_CITIES,
                attributeNodes = {
                        @NamedAttributeNode("region"),
                        @NamedAttributeNode("cities")
                }
        ),
        @NamedEntityGraph(name = Constants.EntityGraphs.DEPARTMENTS_WITH_REGION_AND_CONTIGOUS_DEPARTMENTS_AND_CITIES_WITH_MUSEUMS_AND_POSTAL_CODES,
                attributeNodes = {
                        @NamedAttributeNode("region"),
                        @NamedAttributeNode("nearAtDepartments"),
                        @NamedAttributeNode("nearToDepartments"),
                        @NamedAttributeNode(
                                value = "cities",
                                subgraph = Constants.SubEntityGraphs.CITIES_WITH_MUSEUMS_AND_POSTAL_CODES)
                },
                subgraphs = {
                        @NamedSubgraph(
                                    name = Constants.SubEntityGraphs.CITIES_WITH_MUSEUMS_AND_POSTAL_CODES,
                                    attributeNodes = {
                                            @NamedAttributeNode("museums"),
                                            @NamedAttributeNode("postalCodes")
                                    }
                            )
                }
        ),
})
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Department extends AbstractLocalization {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "contigous_department",
            joinColumns = @JoinColumn(name = "department1_insee_code"),
            inverseJoinColumns = @JoinColumn(name = "department2_insee_code")
    )
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<Department> nearToDepartments;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "contigous_department",
            joinColumns = @JoinColumn(name = "department2_insee_code"),
            inverseJoinColumns = @JoinColumn(name = "department1_insee_code")
    )
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<Department> nearAtDepartments;

    @Setter(AccessLevel.NONE)
    @Transient
    private Set<Department> contigousDepartments;


    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<City> cities;
    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;

    public Set<Department> getContigousDepartments() {
        this.contigousDepartments = new HashSet<>();
        this.contigousDepartments.addAll(this.nearToDepartments);
        this.contigousDepartments.addAll(this.nearAtDepartments);
        return contigousDepartments;
    }
}
