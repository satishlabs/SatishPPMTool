package com.satishlabs.ppmtool.services;

import com.satishlabs.ppmtool.domain.Project;
import com.satishlabs.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        //Logic to be write here
        return projectRepository.save(project);
    }

}
