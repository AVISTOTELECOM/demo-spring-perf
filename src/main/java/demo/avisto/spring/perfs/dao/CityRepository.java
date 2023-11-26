package demo.avisto.spring.perfs.dao;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import demo.avisto.spring.perfs.model.entity.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends EntityGraphJpaRepository<City, String> {
}
