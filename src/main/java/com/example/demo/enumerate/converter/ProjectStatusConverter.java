package com.example.demo.enumerate.converter;
import com.example.demo.enumerate.ProjectStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ProjectStatusConverter implements AttributeConverter<ProjectStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProjectStatus projectStatus) {
        if (projectStatus == null) return null;
        return projectStatus.getID();
    }

    @Override
    public ProjectStatus convertToEntityAttribute(Integer databaseValue) {
        if (databaseValue == null) return null;
        return ProjectStatus.getStatus(databaseValue);    }
}
