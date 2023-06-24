package com.sequitur.api.DiagnosticAndTreatment.domain.service;

import com.sequitur.api.DiagnosticAndTreatment.domain.model.Statistic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StatisticService {
    Statistic createStatistic(Long universityId, Statistic statistic);

    Statistic updateStatistic(Long statisticId, Statistic statisticRequest);

    ResponseEntity<?> deleteStatistic(Long statisticId);

    Page<Statistic> getStatisticsByUniversity(Long universityId, Pageable pageable);
}
