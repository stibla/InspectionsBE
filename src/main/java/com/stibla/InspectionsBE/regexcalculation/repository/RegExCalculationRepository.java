package com.stibla.InspectionsBE.regexcalculation.repository;

import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.stibla.InspectionsBE.regexcalculation.model.RegExCalculationDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegExCalculationRepository extends JpaRepository<RegExCalculationDB, Long>
{
    @Query(value = "SELECT a.s_column FROM regexcalculation a GROUP BY a.s_column", nativeQuery = true)
    List<String> findAllregexcalculation();
    
    @Query(value = "SELECT * FROM regexcalculation a WHERE a.s_column = ?1 ORDER BY n_priority", nativeQuery = true)
    List<RegExCalculationDB> findRegexcalculationByColumn(final String column);
}