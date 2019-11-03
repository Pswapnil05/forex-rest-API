package com.innovecture.forex.repository;

import com.innovecture.forex.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate,Integer> {

  Rate findByBaseAndCurrency(String base, String to);
}
