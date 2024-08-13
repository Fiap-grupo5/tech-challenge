package com.videocustom.application.repositories;

import com.videocustom.model.project.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectRepository2 {

    private List<Project> projects = new ArrayList<>();
    private int currentId = 1;

    public Optional<Project> findById(int id) {
        return projects.stream().filter(product -> product.getId() == id).findFirst();
    }

    public List<Project> getAllProjects() {
        return new ArrayList<>(projects); // Retorna uma cópia da lista para evitar modificações externas
    }

    public Project saveProject(Project project) {
        if (project.getId() == 0) {
            project.setId(currentId++);
            projects.add(project);
        } else {
            updateProject(project);
        }
        return project;
    }

    public void updateProject(Project updatedProject) {
        for (Project project : projects) {
            if (project.getId() == updatedProject.getId()) {
                project.setName(updatedProject.getName());
                project.setDescription(updatedProject.getDescription());
                project.setStatus(updatedProject.getStatus());

                return;
            }
        }
    }

    public void deleteProject(int id) {
        projects.removeIf(project -> project.getId() == id);
    }
}
