package com.hcl.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parking.entity.ReleasedSlot;

@Repository
public interface AvailableSlotsRepository extends JpaRepository<ReleasedSlot, Integer> {

	
}
