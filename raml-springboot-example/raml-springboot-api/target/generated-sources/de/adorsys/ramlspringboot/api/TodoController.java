
package de.adorsys.ramlspringboot.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * The Todos resource.
 * (Generated with springmvc-raml-parser v.0.4.3)
 * 
 */
@RestController
@RequestMapping(value = "/api/todos", produces = "application/json")
public interface TodoController {


    /**
     * Returns a list of todos.
     * 
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getTodos();

    /**
     * Generate a new todo.
     * 
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity createTodo(
        @RequestBody
        de.adorsys.ramlspringboot.api.model.Todo todo);

    /**
     * Return the todo with given id.
     * 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<de.adorsys.ramlspringboot.api.model.Todo> getTodoById(
        @PathVariable
        Long id);

}
