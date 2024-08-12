package com.videocustom.view.project;

import com.videocustom.model.project.Project;

import java.util.List;
import java.util.Scanner;

public class ProjectView {
    private Scanner scanner;

    public ProjectView() {
        scanner = new Scanner(System.in);
    }

    public Project getInputProject() {
        System.out.print("Enter project name: ");
        String name = scanner.nextLine();
        System.out.print("Enter project description: ");
        String description = scanner.nextLine();
        System.out.print("Enter project status: ");
        String status = scanner.nextLine();

        return new Project(0, name, description, status);
    }

    public int getProjectId() {
        System.out.print("Enter project ID: ");
        return scanner.nextInt();
    }

    public Project getUpdatedProject() {
        System.out.print("Enter project ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Clear the newline character
        System.out.print("Enter new project name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new project description: ");
        String description = scanner.nextLine();
        System.out.print("Enter new project status: ");
        String status = scanner.nextLine();
        scanner.nextLine();  // Clear the newline character
        return new Project(id, name, description, status);
    }

    public void projectDetails(List<Project> projects) {
        if (projects.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Project project : projects) {
                System.out.println(project);
            }
        }
    }
    public void printMenu() {
        System.out.println("1. Add Project");
        System.out.println("2. Show All Projects");
        System.out.println("3. Update Project");
        System.out.println("4. Delete Project");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }
}
