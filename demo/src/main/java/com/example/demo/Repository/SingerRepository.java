package com.example.demo.Repository;

import com.example.demo.DomainObject.SingerDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SingerRepository extends JpaRepository<SingerDomain, Long> {

    Optional<SingerDomain> findByName(String name);
}
