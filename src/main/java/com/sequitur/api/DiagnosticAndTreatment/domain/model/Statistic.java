package com.sequitur.api.DiagnosticAndTreatment.domain.model;

import com.sequitur.api.IdentityAccessManagement.domain.model.University;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "statistics")
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    @Column(name = "depression_percentage")
    private double depressionPercentage;

    @Column(name = "no_depression_percentage")
    private double noDepressionPercentage;

    private int studentsQuantity;
}
