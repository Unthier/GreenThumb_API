package henrotaym.env.http.controllers;

import henrotaym.env.http.requests.DiseaseRequest;
import henrotaym.env.http.resources.DiseaseResource;
import henrotaym.env.services.DiseaseService;
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
@RequestMapping("diseases")
public class DiseaseController {
  private final DiseaseService diseaseService;

  @PostMapping("")
  public ResponseEntity<DiseaseResource> store(@RequestBody @Valid DiseaseRequest request) {
    DiseaseResource plant = this.diseaseService.store(request);

    return ResponseEntity.status(HttpStatus.CREATED).body(plant);
  }

  @GetMapping("{id}")
  public ResponseEntity<DiseaseResource> show(
      @PathVariable BigInteger id, @RequestParam(required = false) Set<String> include) {
    DiseaseResource plant = this.diseaseService.show(id, include);

    return ResponseEntity.ok(plant);
  }

  @PutMapping("{id}")
  public ResponseEntity<DiseaseResource> update(
      @PathVariable BigInteger id, @RequestBody @Valid DiseaseRequest request) {
    DiseaseResource plant = this.diseaseService.update(id, request);

    return ResponseEntity.ok(plant);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Object> destroy(@PathVariable BigInteger id) {
    this.diseaseService.destroy(id);

    return ResponseEntity.noContent().build();
  }

  @GetMapping("")
  public ResponseEntity<List<DiseaseResource>> index() {
    List<DiseaseResource> plants = this.diseaseService.index();

    return ResponseEntity.ok(plants);
  }
}
