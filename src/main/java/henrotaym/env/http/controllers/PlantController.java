package henrotaym.env.http.controllers;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

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

import henrotaym.env.http.requests.PlantRequest;
import henrotaym.env.http.resources.exceptions.PlantResource;
import henrotaym.env.services.PlantService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("plants")
public class PlantController {

  private final PlantService plantService;

  @PostMapping("")
  public ResponseEntity<PlantResource> store(@RequestBody @Valid PlantRequest request) {
    PlantResource plant = this.plantService.store(request);

    return ResponseEntity.status(HttpStatus.CREATED).body(plant);
  }

  @GetMapping("{id}")
  public ResponseEntity<PlantResource> show(
      @PathVariable BigInteger id, @RequestParam(required = false) Set<String> include) {
    PlantResource plant = this.plantService.show(id, include);

    return ResponseEntity.ok(plant);
  }

  @PutMapping("{id}")
  public ResponseEntity<PlantResource> update(
      @PathVariable BigInteger id, @RequestBody @Valid PlantRequest request) {
    PlantResource plant = this.plantService.update(id, request);

    return ResponseEntity.ok(plant);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Object> destroy(@PathVariable BigInteger id) {
    this.plantService.destroy(id);

    return ResponseEntity.noContent().build();
  }

  @GetMapping("")
  public ResponseEntity<List<PlantResource>> index() {
    List<PlantResource> plants = this.plantService.index();

    return ResponseEntity.ok(plants);
  }
}
