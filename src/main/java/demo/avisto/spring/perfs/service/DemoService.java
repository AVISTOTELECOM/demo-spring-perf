package demo.avisto.spring.perfs.service;

import demo.avisto.spring.perfs.dao.CityRepository;
import demo.avisto.spring.perfs.dao.DepartmentRepository;
import demo.avisto.spring.perfs.dao.MuseumRepository;
import demo.avisto.spring.perfs.dao.RegionRepository;
import demo.avisto.spring.perfs.model.entity.City;
import demo.avisto.spring.perfs.model.entity.Department;
import demo.avisto.spring.perfs.model.entity.Museum;
import demo.avisto.spring.perfs.model.entity.Region;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j
public class DemoService {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final CityRepository cityRepository;
    private final MuseumRepository museumRepository;

    public <R> List<R> getRegions(Function<Region, R> mapper) {
        return getRegions().stream().map(mapper).toList();
    }

    public List<Region> getRegions() {
        return regionRepository.findAll();
    }

    public <D> List<D> getDepartments(Function<Department, D> mapper) {
        return getDepartments().stream().map(mapper).toList();
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public <C> List<C> getCities(Function<City, C> mapper) {
        return getCities().stream().map(mapper).toList();
    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public <M> List<M> getMuseums(Function<Museum, M> mapper) {
        return getMuseums().stream().map(mapper).toList();
    }

    public List<Museum> getMuseums() {
        return museumRepository.findAll();
    }

    public <R> R getRegionById(String id, Function<Region, R> mapper) {
        return mapper.apply(getRegionById(id));
    }

    public Region getRegionById(String id) {
        return regionRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public <D> D getDepartmentById(String id, Function<Department, D> mapper) {
        return mapper.apply(getDepartmentById(id));
    }

    public Department getDepartmentById(String id) {
        return departmentRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public <C> C getCityById(String id, Function<City, C> mapper) {
        return mapper.apply(getCityById(id));
    }

    public City getCityById(String id) {
        return cityRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public <M> M getMuseumById(int id, Function<Museum, M> mapper) {
        return mapper.apply(getMuseumById(id));
    }

    public Museum getMuseumById(int id) {
        return museumRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
