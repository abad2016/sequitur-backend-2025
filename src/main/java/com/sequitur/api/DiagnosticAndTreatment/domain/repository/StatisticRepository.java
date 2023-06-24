package com.sequitur.api.DiagnosticAndTreatment.domain.repository;

import com.sequitur.api.DiagnosticAndTreatment.domain.model.Recommendation;
import com.sequitur.api.DiagnosticAndTreatment.domain.model.Statistic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic,Long> {

    Optional<Statistic> findByIdAndUniversityId(Long id, Long universityId);
    Page<Statistic> findAllByUniversityId(Long universityId, Pageable pageable);
}
