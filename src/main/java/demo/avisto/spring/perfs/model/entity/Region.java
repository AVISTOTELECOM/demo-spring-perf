package demo.avisto.spring.perfs.model.entity;

import demo.avisto.spring.perfs.util.Constants;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedEntityGraphs;
import jakarta.persistence.NamedSubgraph;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = Constants.EntityGraphs.REGION_WITH_DEPARTMENTS,
                attributeNodes = {
                        @NamedAttributeNode("departments")
                }
        ),
        @NamedEntityGraph(name = Constants.EntityGraphs.REGION_WITH_DEPARTMENTS_WITH_CONTIGOUS_DEPARTMENTS_AND_CITIES_WITH_MUSEUMS_AND_POSTAL_CODES,
                attributeNodes = {
                        @NamedAttributeNode(
                                value = "departments",
                                subgraph = Constants.SubEntityGraphs.DEPARTMENTS_WITH_CONTIGOUS_DEPARTMENTS_AND_CITIES_WITH_MUSEUMS_AND_POSTAL_CODES
                        )
                },
                subgraphs = {
                        @NamedSubgraph(
                                name = Constants.SubEntityGraphs.DEPARTMENTS_WITH_CONTIGOUS_DEPARTMENTS_AND_CITIES_WITH_MUSEUMS_AND_POSTAL_CODES,
                                attributeNodes = {
                                        @NamedAttributeNode(
                                                value = "cities",
                                                subgraph = Constants.SubEntityGraphs.CITIES_WITH_MUSEUMS_AND_POSTAL_CODES),
                                        @NamedAttributeNode("nearAtDepartments"),
                                        @NamedAttributeNode("nearToDepartments")
                                }
                        ),
                        @NamedSubgraph(
                                name = Constants.SubEntityGraphs.CITIES_WITH_MUSEUMS_AND_POSTAL_CODES,
                                attributeNodes = {
                                        @NamedAttributeNode("museums"),
                                        @NamedAttributeNode("postalCodes")
                                }
                        )
                }
        )
})
@Entity
@NoArgsConstructor
@Getter
public class Region extends AbstractLocalization {

    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    private List<Department> departments;
}
