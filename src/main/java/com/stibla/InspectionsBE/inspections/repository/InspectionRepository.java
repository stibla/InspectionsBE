package com.stibla.InspectionsBE.inspections.repository;

import com.stibla.InspectionsBE.inspections.model.InspectionDB;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionRepository extends JpaRepository<InspectionDB, Long> {
    
}
