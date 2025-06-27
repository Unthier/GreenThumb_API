package henrotaym.env.http.controllers;

import henrotaym.env.http.requests.ActionRequest;
import henrotaym.env.http.resources.ActionResource;
import henrotaym.env.services.ActionService;
import jakarta.validation.Valid;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("actions")
public class ActionController {
  private final ActionService actionService;

  @PostMapping("")
  public ResponseEntity<ActionResource> store(@RequestBody @Valid ActionRequest request) {
    ActionResource actcion = this.actionService.store(request);

    return ResponseEntity.status(HttpStatus.CREATED).body(actcion);
  }

  @GetMapping("{id}")
  public ResponseEntity<ActionResource> show(
      @PathVariable BigInteger id, @RequestParam(required = false) Set<String> include) {
    ActionResource action = this.actionService.show(id, include);

    return ResponseEntity.ok(action);
  }

  @PutMapping("{id}")
  public ResponseEntity<ActionResource> update(
      @PathVariable BigInteger id, @RequestBody @Valid ActionRequest request) {
    ActionResource action = this.actionService.update(id, request);

    return ResponseEntity.ok(action);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Object> destroy(@PathVariable BigInteger id) {
    this.actionService.destroy(id);

    return ResponseEntity.noContent().build();
  }

  @GetMapping("")
  public ResponseEntity<List<ActionResource>> index() {
    List<ActionResource> actions = this.actionService.index();

    return ResponseEntity.ok(actions);
  }
}
