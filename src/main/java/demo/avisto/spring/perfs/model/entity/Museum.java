package demo.avisto.spring.perfs.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Museum {
    @Id
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

    private String name;

    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postal_code")
    private PostalCode postalCode;

    private String phone;

    private String url;

    private LocalDate date;
}
