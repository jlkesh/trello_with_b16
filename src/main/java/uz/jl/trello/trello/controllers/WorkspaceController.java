package uz.jl.trello.trello.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/18:29 (Wednesday)
 * trello/IntelliJ IDEA
 */

@RestController
public class WorkspaceController {



    @PostMapping
    @PreAuthorize("hasRole('CREATE_BOARD')")
    public ResponseEntity<Void> create(@RequestBody String name) {
        return ResponseEntity.noContent().build();
    }

}
