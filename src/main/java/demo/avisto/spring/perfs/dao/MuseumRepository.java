package demo.avisto.spring.perfs.dao;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import demo.avisto.spring.perfs.model.entity.Museum;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseumRepository extends EntityGraphJpaRepository<Museum, Integer> {
}
