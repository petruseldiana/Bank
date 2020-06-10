package com.bank.repository.impl;

import com.bank.configuration.JDBConnectionWrapper;
import com.bank.model.ActivityReport;
import com.bank.repository.ActivityReportRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActivityReportRepositoryImpl implements ActivityReportRepository {

    private final JDBConnectionWrapper jdbConnectionWrapper;

    public ActivityReportRepositoryImpl(JDBConnectionWrapper jdbConnectionWrapper) {
        this.jdbConnectionWrapper = jdbConnectionWrapper;
    }

    @Override
    public boolean addActivity(ActivityReport activityReport) {

        Connection connection = jdbConnectionWrapper.getConnection();

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO activity(type, date, idEmployee) VALUES(?,?,?);"
            );

            preparedStatement.setString(1,activityReport.getType());
            preparedStatement.setDate(2, (Date) activityReport.getDate());
            preparedStatement.setInt(3,activityReport.getIdEmployee());

            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
