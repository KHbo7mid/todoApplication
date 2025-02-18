package org.bo7mid.todoapp.Controller;

import org.bo7mid.todoapp.Services.TaskService;
import org.bo7mid.todoapp.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller

public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping
    public String createTask(@RequestParam String title) {
        taskService.createTask(title);
        return "redirect:/";

    }
    @GetMapping
    public String getTasks(Model model)
    {
        List<Task>  tasks=taskService.getAllTasks();
        model.addAttribute("tasks", tasks);

        return "tasks";
    }
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id)
    {
       taskService.deleteTask(id);

        return "redirect:/";
    }
    @GetMapping("/{id}/toggle")
    public String completeTask(@PathVariable Long id)
    {
        taskService.toggleTask(id);

        return "redirect:/";
    }

}
