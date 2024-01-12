package co.com.jorgecabrerasouto.ls.web.controller;

import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import co.com.jorgecabrerasouto.ls.persistence.model.Project;
import co.com.jorgecabrerasouto.ls.persistence.model.Task;
import co.com.jorgecabrerasouto.ls.service.IProjectService;
import co.com.jorgecabrerasouto.ls.web.dto.ProjectDto;
import co.com.jorgecabrerasouto.ls.web.dto.TaskDto;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    //

    @GetMapping(value = "/{id}")
    public ProjectDto findOne(@PathVariable Long id) {
        Project entity = projectService.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDto(entity);
    }

    @PostMapping
    public void create(@RequestBody ProjectDto newProject) {
        Project entity = convertToEntity(newProject);
        this.projectService.save(entity);
    }

    protected ProjectDto convertToDto(Project entity) {
        return new ProjectDto(entity.getId(), entity.getName(), entity.getDateCreated(),
            entity.getTasks()
                .stream()
                .map(t -> convertTaskToDto(t))
                .collect(Collectors.toSet()));
    }

    protected Project convertToEntity(ProjectDto dto) {
        Project project = new Project(dto.name(), dto.dateCreated());
        if (!Objects.isNull(dto.id())) {
            project.setId(dto.id());
        }
        return project;
    }

    protected TaskDto convertTaskToDto(Task entity) {
        return new TaskDto(entity.getId(), entity.getName(), entity.getDescription(), entity.getDateCreated(), entity.getDueDate(), entity.getStatus());
    }

    protected Task convertTaskToEntity(TaskDto dto) {
        Task task = new Task(dto.name(), dto.description(), dto.dateCreated(), dto.dueDate(), dto.status());
        if (!Objects.isNull(dto.id())) {
            task.setId(dto.id());
        }
        return task;
    }

}