package com.doback.E_rank.repository.jpa;

import com.doback.E_rank.entity.Times;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesJpa extends JpaRepository<Times, Integer> {
}