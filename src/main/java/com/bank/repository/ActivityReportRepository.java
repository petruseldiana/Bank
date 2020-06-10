package com.bank.repository;

import com.bank.model.ActivityReport;

public interface ActivityReportRepository {

    boolean addActivity(ActivityReport activityReport);
}
