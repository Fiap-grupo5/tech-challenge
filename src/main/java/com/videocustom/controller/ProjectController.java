package com.videocustom.controller;

import com.videocustom.model.Project;
import com.videocustom.view.ProjectView;

import java.util.List;

public class ProjectController {
    private model.ProjectDAO projectDAO;
    private ProjectView projectView;

    public ProjectController(model.ProjectDAO projectDAO, ProjectView projectView) {
        this.projectDAO = projectDAO;
        this.projectView = projectView;
    }

    public void newProjectt(Project product) {
        projectDAO.newProject(product);
    }

    public void showAllProjects() {
        List<Project> products = projectDAO.getAllProjects();
        projectView.projectDetails(products);
    }

    public void updateProject(Project product) {
        projectDAO.updateProject(product);
    }

    public void deleteProject(int id) {
        projectDAO.deleteProject(id);
    }

    // funções com a conexao com o banco de dado
}
