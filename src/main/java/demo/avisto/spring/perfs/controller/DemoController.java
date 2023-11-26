package demo.avisto.spring.perfs.controller;

import demo.avisto.spring.perfs.model.dto.out.CityDtoOut;
import demo.avisto.spring.perfs.model.dto.out.DepartmentDtoOut;
import demo.avisto.spring.perfs.model.dto.out.DepartmentShortDtoOut;
import demo.avisto.spring.perfs.model.dto.out.MuseumDtoOut;
import demo.avisto.spring.perfs.model.dto.out.MuseumShortDtoOut;
import demo.avisto.spring.perfs.model.dto.out.RegionDtoOut;
import demo.avisto.spring.perfs.model.dto.out.RegionShortDtoOut;
import demo.avisto.spring.perfs.service.DemoService;
import demo.avisto.spring.perfs.util.TimeStatistic;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DemoController {
    private final DemoService demoService;

    @GetMapping("/regions")
    @ResponseStatus(HttpStatus.OK)
    @TimeStatistic("/regions Request : {} ms")
    public List<RegionShortDtoOut> getRegions() {
        return demoService.getRegions(RegionShortDtoOut::new);
    }

    @GetMapping("/departments")
    @ResponseStatus(HttpStatus.OK)
    @TimeStatistic("/departments Request : {} ms")
    public List<DepartmentShortDtoOut> getDepartments() {
        return demoService.getDepartments(DepartmentShortDtoOut::new);
    }

    @GetMapping("/cities")
    @ResponseStatus(HttpStatus.OK)
    @TimeStatistic("/cities Request : {} ms")
    public List<CityDtoOut> getCities() {
        return demoService.getCities(CityDtoOut::new);
    }

    @GetMapping("/museums")
    @ResponseStatus(HttpStatus.OK)
    @TimeStatistic("/museums Request : {} ns")
    public List<MuseumShortDtoOut> getMuseums() {
        return demoService.getMuseums(MuseumShortDtoOut::new);
    }

    @GetMapping("/regions/{inseeCode}")
    @ResponseStatus(HttpStatus.OK)
    @TimeStatistic("/region/inseeCode Request : {} ms")
    public RegionDtoOut getRegion(@PathVariable String inseeCode) {
        return demoService.getRegionById(inseeCode, RegionDtoOut::new);
    }

    @GetMapping("/departments/{inseeCode}")
    @ResponseStatus(HttpStatus.OK)
    @TimeStatistic("/departments/inseeCode Request : {} ms")
    public DepartmentDtoOut getDepartment(@PathVariable String inseeCode) {
        return demoService.getDepartmentById(inseeCode, DepartmentDtoOut::new);
    }

    @GetMapping("/cities/{inseeCode}")
    @ResponseStatus(HttpStatus.OK)
    @TimeStatistic("/cities/inseeCode Request : {} ms")
    public CityDtoOut getCitie(@PathVariable String inseeCode) {
        return demoService.getCityById(inseeCode, CityDtoOut::new);
    }

    @GetMapping("/museums/{id}")
    @ResponseStatus(HttpStatus.OK)
    @TimeStatistic("/museums/id Request : {} ns")
    public MuseumDtoOut getMuseum(@PathVariable int id) {
        return demoService.getMuseumById(id, MuseumDtoOut::new);
    }
}
