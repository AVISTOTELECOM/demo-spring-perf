package demo.avisto.spring.perfs.model.dto.out;

import demo.avisto.spring.perfs.model.entity.Department;
import lombok.Getter;

import java.util.List;

@Getter
public class DepartmentDtoOut {
    private final String name;
    private final String inseeCode;
    private final List<DepartmentDtoOut> contigousDepartments;
    private final List<CityDtoOut> cities;

    public DepartmentDtoOut(Department department) {
        this(department, true);
    }

    private static DepartmentDtoOut withoutContigousDepartments(Department department) {
        return new DepartmentDtoOut(department, false);
    }

    private DepartmentDtoOut(Department department, boolean withContigousDepartments) {
        name = department.getName();
        inseeCode = department.getInseeCode();
        contigousDepartments = withContigousDepartments ?
                department.getContigousDepartments().stream().map(DepartmentDtoOut::withoutContigousDepartments).toList()
                : null;
        cities = department.getCities().stream().map(CityDtoOut::new).toList();
    }
}
