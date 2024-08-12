package com.videocustom.videocustom;

import com.videocustom.controller.ProjectController;
import com.videocustom.model.Project;
import com.videocustom.view.ProjectView;
import model.ProjectDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		ProjectDAO projectDAO = new ProjectDAO();
		ProjectView projectView = new ProjectView();
		ProjectController projectController = new ProjectController(projectDAO, projectView);

		//Criando um projeto
		Project project1 = new Project(1, "Cacau do zé", "descrição do vídeo do cacau do zé", "em andamento");
		projectController.newProjectt(project1);

		Project project2 = new Project(2, "Tapioca do Figueira", "descrição do vídeo", "concluído");
		projectController.newProjectt(project2);

		//Exibindo um projeto
		projectController.showAllProjects();

		//Atualizando um projeto
		project1.setName("Chocolate do Zé");
		project1.setDescription("descrição do chocolate do zé");
		project1.setStatus("cancelado");

		projectController.showAllProjects();

		//Deletando um produto
		projectController.deleteProject(project2.getId());

		//Exibindo todos os projetos após exclusão
		projectController.showAllProjects();



	}

}
