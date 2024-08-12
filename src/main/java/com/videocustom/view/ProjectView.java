package com.videocustom.view;

import com.videocustom.model.Project;

import java.util.List;

public class ProjectView {
    public void projectDetails(List<Project> projects) {
        for (Project project : projects) {
            System.out.println(project);
        }
    }
}
