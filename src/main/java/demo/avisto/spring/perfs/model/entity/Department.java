package demo.avisto.spring.perfs.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Department extends AbstractLocalization {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "contigous_department",
            joinColumns = @JoinColumn(name = "department1_insee_code"),
            inverseJoinColumns = @JoinColumn(name = "department2_insee_code")
    )
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<Department> nearToDepartments;

    @ManyToMany(fetch = FetchType.EAGER)
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


    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<City> cities;
    @ManyToOne(fetch = FetchType.EAGER)
    private Region region;

    public Set<Department> getContigousDepartments() {
        this.contigousDepartments = new HashSet<>();
        this.contigousDepartments.addAll(this.nearToDepartments);
        this.contigousDepartments.addAll(this.nearAtDepartments);
        return contigousDepartments;
    }
}
