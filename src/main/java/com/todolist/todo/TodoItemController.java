package com.todolist.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable; 
import jakarta.validation.Valid; // <-- NEW IMPORT
import org.springframework.validation.BindingResult; // <-- NEW IMPORT

@Controller
public class TodoItemController {

    private final TodoItemRepository todoItemRepository;

    @Autowired
    public TodoItemController(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    // READ (R) - Displays all items
    @GetMapping("/")
    public String listTodoItems(Model model) {
        Iterable<TodoItem> items = todoItemRepository.findAll();
        model.addAttribute("todoItems", items);
        return "index"; 
    }

    // CREATE (C) - Shows the form
    @GetMapping("/add")
    public String showAddForm(TodoItem todoItem) {
        return "add-todo-item";
    }

    // CREATE (C) - Processes the form
    @PostMapping("/add")
    public String addTodoItem(
            @Valid @ModelAttribute TodoItem todoItem, // <-- ADDED @Valid
            BindingResult result,                      // <-- ADDED BindingResult
            Model model) {                             // <-- ADDED Model

        if (result.hasErrors()) {
            // If validation errors exist, return the user to the form template
            return "add-todo-item";
        }
        
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

    // UPDATE (U) - Toggles the 'completed' status
    @GetMapping("/update/{id}")
    public String toggleCompletion(@PathVariable("id") long id) {
        TodoItem item = todoItemRepository.findById(id)
                                          .orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));
        item.setCompleted(!item.isCompleted());
        todoItemRepository.save(item);
        return "redirect:/";
    }

    // DELETE (D) - Deletes the item by ID
    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") long id) {
        TodoItem item = todoItemRepository.findById(id)
                                          .orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));
        todoItemRepository.delete(item);
        return "redirect:/";
    }
}