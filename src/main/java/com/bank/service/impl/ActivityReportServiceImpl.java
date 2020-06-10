package com.bank.service.impl;

import com.bank.model.ActivityReport;
import com.bank.repository.ActivityReportRepository;
import com.bank.service.ActivityReportService;

public class ActivityReportServiceImpl implements ActivityReportService {

    private final ActivityReportRepository activityReportRepository;

    public ActivityReportServiceImpl(ActivityReportRepository activityReportRepository) {
        this.activityReportRepository = activityReportRepository;
    }

    @Override
    public boolean addActivity(ActivityReport activityReport) {
        return activityReportRepository.addActivity(activityReport);
    }
}
