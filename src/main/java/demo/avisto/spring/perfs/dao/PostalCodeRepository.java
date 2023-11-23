package demo.avisto.spring.perfs.dao;

import demo.avisto.spring.perfs.model.entity.PostalCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostalCodeRepository extends JpaRepository<PostalCode, String> {
}
