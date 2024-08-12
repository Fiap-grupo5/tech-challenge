package com.videocustom.videocustom;

import com.videocustom.controller.ProjectController;
import com.videocustom.model.Project;
import com.videocustom.model.ProjectDAO;
import com.videocustom.view.ProjectView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		ProjectDAO projectDAO = new ProjectDAO();
		ProjectView projectView = new ProjectView();
		ProjectController projectController = new ProjectController(projectDAO, projectView);

		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			projectView.printMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					Project newProduct = projectView.getInputProject();
					projectController.newProjectt(newProduct);
					break;
				case 2:
					projectController.showAllProjects();
					break;
				case 3:
					Project updatedProduct = projectView.getUpdatedProject();
					projectController.updateProject(updatedProduct);
					break;
				case 4:
					int productId = projectView.getProjectId();
					projectController.deleteProject(productId);
					break;
				case 5:
					running = false;
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice, please try again.");
			}
			System.out.println();
		}

		scanner.close();
	}


}
