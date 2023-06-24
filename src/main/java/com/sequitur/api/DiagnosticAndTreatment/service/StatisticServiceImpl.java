package com.sequitur.api.DiagnosticAndTreatment.service;

import com.sequitur.api.DiagnosticAndTreatment.domain.model.Statistic;
import com.sequitur.api.DiagnosticAndTreatment.domain.repository.StatisticRepository;
import com.sequitur.api.DiagnosticAndTreatment.domain.service.StatisticService;
import com.sequitur.api.IdentityAccessManagement.domain.model.University;
import com.sequitur.api.IdentityAccessManagement.domain.repository.UniversityRepository;
import com.sequitur.api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private StatisticRepository statisticRepository;

    @Override
    public Statistic createStatistic(Long universityId, Statistic statistic) {
        University university = universityRepository.findById(universityId)
                .orElseThrow(() -> new ResourceNotFoundException("University", "id", universityId));

        statistic.setUniversity(university);
        return statisticRepository.save(statistic);
    }

    @Override
    public Statistic updateStatistic(Long statisticId, Statistic statisticRequest) {
        Statistic statistic = statisticRepository.findById(statisticId)
                .orElseThrow(() -> new ResourceNotFoundException("Statistic", "id", statisticId));

        statistic.setDepressionPercentage(statisticRequest.getDepressionPercentage());
        statistic.setNoDepressionPercentage(statisticRequest.getNoDepressionPercentage());
        statistic.setStudentsQuantity(statisticRequest.getStudentsQuantity());

        return statisticRepository.save(statistic);
    }

    @Override
    public ResponseEntity<?> deleteStatistic(Long statisticId) {
        Statistic statistic = statisticRepository.findById(statisticId)
                .orElseThrow(() -> new ResourceNotFoundException("Statistic", "id", statisticId));

        statisticRepository.delete(statistic);
        return ResponseEntity.ok().build();
    }

    @Override
    public Page<Statistic> getStatisticsByUniversity(Long universityId, Pageable pageable) {

        return statisticRepository.findAllByUniversityId(universityId, pageable);
    }
}
