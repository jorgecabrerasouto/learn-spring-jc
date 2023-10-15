package co.com.jorgecabrerasouto.ls.persistence.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import co.com.jorgecabrerasouto.ls.persistence.model.Project;
import co.com.jorgecabrerasouto.ls.persistence.repository.IProjectRepository;

@Repository
@Profile("prod")
public class ProjectRepositoryDBBasedImpl implements IProjectRepository {

    List<Project> projects = new ArrayList<>();

    public ProjectRepositoryDBBasedImpl() {
        super();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        if (existingProject == null) {
            projects.add(project);
        } else {
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
        }
        return project;
    }

}
