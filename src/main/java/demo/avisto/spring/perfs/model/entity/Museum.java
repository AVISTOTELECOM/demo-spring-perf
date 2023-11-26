package demo.avisto.spring.perfs.model.entity;

import demo.avisto.spring.perfs.util.Constants;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedEntityGraphs;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = Constants.EntityGraphs.MUSEUM_WITH_CITY_AND_POSTAL_CODE,
                attributeNodes = {
                        @NamedAttributeNode("city"),
                        @NamedAttributeNode("postalCode")
                }
        ),
})
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Museum {
    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    private String name;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postal_code")
    private PostalCode postalCode;

    private String phone;

    private String url;

    private LocalDate date;
}
