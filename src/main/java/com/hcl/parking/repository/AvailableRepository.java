package com.hcl.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parking.entity.Slot;

@Repository
public interface AvailableRepository extends JpaRepository<Slot, Integer> {

}
