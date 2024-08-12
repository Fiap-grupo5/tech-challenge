package com.videocustom.controller.video;

import com.videocustom.model.project.Project;
import com.videocustom.model.project.ProjectDAO;
import com.videocustom.view.project.ProjectView;

import java.util.List;

public class ProjectController {
    private ProjectDAO projectDAO;
    private ProjectView projectView;

    public ProjectController(ProjectDAO projectDAO, ProjectView projectView) {
        this.projectDAO = projectDAO;
        this.projectView = projectView;
    }

    public void newProjectt(Project project) {
        projectDAO.newProject(project);
    }

    public void showAllProjects() {
        List<Project> projects = projectDAO.getAllProjects();
        projectView.projectDetails(projects);
    }

    public void updateProject(Project project) {
        projectDAO.updateProject(project);
    }

    public void deleteProject(int id) {
        projectDAO.deleteProject(id);
    }

    // funções com a conexao com o banco de dado
}
