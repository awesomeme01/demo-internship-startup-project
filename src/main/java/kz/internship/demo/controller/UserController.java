package kz.internship.demo.controller;

import kz.internship.demo.dto.UserDto;
import kz.internship.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * User Rest Controller.
 *
 * @author shabdan
 * Date: 6/9/2022
 */
@RestController
@RequestMapping(UserController.RESOURCE_URI)
public class UserController {

    public static final String RESOURCE_URI = "/v1/users";

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserDto>> readAll(
            Pageable pageable) {
        return ResponseEntity.ok(this.userService.getAllUsers(pageable));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(
            @RequestBody UserDto dto) {
        var createdUser = this.userService.saveUser(dto);

        return ResponseEntity.created(URI.create(RESOURCE_URI + "/" + createdUser.getId()))
                             .body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(
            @PathVariable final Long id) {
        return ResponseEntity.ok(this.userService.getUser(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(
            @RequestBody final UserDto dto) {
        this.userService.deleteUser(dto);
        return ResponseEntity.ok().body(null);
    }
}
