package demo.avisto.spring.perfs.service;

import com.cosium.spring.data.jpa.entity.graph.domain2.NamedEntityGraph;
import demo.avisto.spring.perfs.dao.CityRepository;
import demo.avisto.spring.perfs.dao.DepartmentRepository;
import demo.avisto.spring.perfs.dao.MuseumRepository;
import demo.avisto.spring.perfs.dao.RegionRepository;
import demo.avisto.spring.perfs.model.entity.City;
import demo.avisto.spring.perfs.model.entity.Department;
import demo.avisto.spring.perfs.model.entity.Museum;
import demo.avisto.spring.perfs.model.entity.Region;
import demo.avisto.spring.perfs.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class DemoService {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final CityRepository cityRepository;
    private final MuseumRepository museumRepository;

    public <R> List<R> getRegions(Function<Region, R> mapper) {
        return StreamSupport.stream(getRegions().spliterator(), false).map(mapper).toList();
    }

    public Iterable<Region> getRegions() {
        return regionRepository.findAll(new NamedEntityGraph(Constants.EntityGraphs.REGION_WITH_DEPARTMENTS));
    }

    public <D> List<D> getDepartments(Function<Department, D> mapper) {
        return StreamSupport.stream(getDepartments().spliterator(), false).map(mapper).toList();
    }

    public Iterable<Department> getDepartments() {
        return departmentRepository.findAll(new NamedEntityGraph(Constants.EntityGraphs.DEPARTMENT_WITH_REGION_AND_CITIES));
    }

    public <C> List<C> getCities(Function<City, C> mapper) {
        return StreamSupport.stream(getCities().spliterator(), false).map(mapper).toList();
    }

    public Iterable<City> getCities() {
        return cityRepository.findAll(new NamedEntityGraph(Constants.EntityGraphs.CITY_WITH_DEPARTMENT_AND_MUSEUMS_AND_POSTAL_CODES));
    }

    public <M> List<M> getMuseums(Function<Museum, M> mapper) {
        return StreamSupport.stream(getMuseums().spliterator(), false).map(mapper).toList();
    }

    public Iterable<Museum> getMuseums() {
        return museumRepository.findAll(new NamedEntityGraph(Constants.EntityGraphs.MUSEUM_WITH_CITY_AND_POSTAL_CODE));
    }

    @Transactional(readOnly = true)
    public <R> R getRegionById(String id, Function<Region, R> mapper) {
        return mapper.apply(getRegionById(id));
    }

    @Transactional(readOnly = true)
    public Region getRegionById(String id) {
        return regionRepository.findById(id, new NamedEntityGraph(Constants.EntityGraphs.REGION_WITH_DEPARTMENTS_WITH_CONTIGOUS_DEPARTMENTS_AND_CITIES_WITH_MUSEUMS_AND_POSTAL_CODES)).orElseThrow(RuntimeException::new);
    }

    public <D> D getDepartmentById(String id, Function<Department, D> mapper) {
        return mapper.apply(getDepartmentById(id));
    }

    public Department getDepartmentById(String id) {
        return departmentRepository.findById(id, new NamedEntityGraph(Constants.EntityGraphs.DEPARTMENTS_WITH_REGION_AND_CONTIGOUS_DEPARTMENTS_AND_CITIES_WITH_MUSEUMS_AND_POSTAL_CODES)).orElseThrow(RuntimeException::new);
    }

    public <C> C getCityById(String id, Function<City, C> mapper) {
        return mapper.apply(getCityById(id));
    }

    public City getCityById(String id) {
        return cityRepository.findById(id, new NamedEntityGraph(Constants.EntityGraphs.CITY_WITH_DEPARTMENT_AND_MUSEUMS_AND_POSTAL_CODES)).orElseThrow(RuntimeException::new);
    }

    public <M> M getMuseumById(int id, Function<Museum, M> mapper) {
        return mapper.apply(getMuseumById(id));
    }

    public Museum getMuseumById(int id) {
        return museumRepository.findById(id, new NamedEntityGraph(Constants.EntityGraphs.MUSEUM_WITH_CITY_AND_POSTAL_CODE)).orElseThrow(RuntimeException::new);
    }
}
