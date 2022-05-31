package com.example.demo.dao.model;

import com.example.demo.enumerate.ProjectStatus;
import com.example.demo.enumerate.converter.ProjectStatusConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "Projects")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Project  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id",nullable = false)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Memo")
    private String memo;

    @Column(name = "Scope")
    private String scope;

    @Column(name = "ProjectManager")
    private String projectManager;

    @Column(name = "ProjectAssistant")
    private String projectAssistant;

    @Temporal(TemporalType.DATE)
    @Column(name = "StartDate")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "FinishDate")
    private Date finishDate;

    @Convert(converter= ProjectStatusConverter.class)
    @Column(name = "Status")
    private ProjectStatus status;

}
