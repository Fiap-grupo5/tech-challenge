package com.videocustom;

import com.videocustom.controller.project.ProjectController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		ProjectRepository2 projectRepository = new ProjectRepository2();
		ProjectService projectService = new ProjectService(projectRepository);
		ProjectController projectController = new ProjectController(projectService);

		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("1. Create Project");
			System.out.println("2. Show All Project");
			System.out.println("3. Update Project");
			System.out.println("4. Delete Project");
			System.out.println("5. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
				case 1:
					projectController.createProject();
					break;
				case 2:
					projectController.showAllProducts();
					break;
				case 3:
					projectController.updateProject();
					break;
				case 4:
					projectController.deleteProject();
					break;
				case 5:
					running = false;
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid option. Please try again.");
			}
			System.out.println();
		}

		scanner.close();
	}


}
