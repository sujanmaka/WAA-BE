package edu.miu.cs545.waa.controller;


import edu.miu.cs545.waa.domain.User;
import edu.miu.cs545.waa.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<User>> getAll() {
    return ResponseEntity.ok(userService.getAll());
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public void save(@RequestBody User p) {
    userService.save(p);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getById(@PathVariable long id) {
    return ResponseEntity.ok(userService.findById(id));
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable long id) {
    userService.deleteById(id);
  }
}
