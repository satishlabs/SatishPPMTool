package com.satishlabs.ppmtool.services;

import com.satishlabs.ppmtool.domain.Project;
import com.satishlabs.ppmtool.exceptions.ProjectIdException;
import com.satishlabs.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        //Logic to be write here
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw  new ProjectIdException("Project ID '"+project.getProjectIdentifier().toLowerCase()+"' already exists");
        }

    }

    public Project findProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null){
            throw  new ProjectIdException("Project ID '"+projectId+"' doesn't exists");
        }
        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if(project == null){
            throw new ProjectIdException("Can not delete project with Id: '"+projectId+"'. This project does not exist");
        }
        projectRepository.delete(project);
    }


}
