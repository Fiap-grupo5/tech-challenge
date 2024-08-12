package com.videocustom.model.project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ProjectDAO {

    private List<Project> projects = new ArrayList<>();
    private AtomicInteger idGenerator = new AtomicInteger(1);

    public void newProject(Project project) {
        project.setId(idGenerator.getAndIncrement());
        projects.add(project);
    }

    public List<Project> getAllProjects() {
        return new ArrayList<>(projects); // Retorna uma cópia da lista para evitar modificações externas
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
