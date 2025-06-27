package henrotaym.env.services;

import henrotaym.env.entities.Action;
import henrotaym.env.entities.Disease;
import henrotaym.env.entities.Plant;
import henrotaym.env.http.requests.PlantRequest;
import henrotaym.env.http.resources.exceptions.PlantResource;
import henrotaym.env.mappers.ResourceMapper;
import henrotaym.env.repositories.ActionRepository;
import henrotaym.env.repositories.DiseaseRepository;
import henrotaym.env.repositories.PlantRepository;
import jakarta.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlantService {
  //   private final TagRepository tagRepository;
  private PlantRepository plantRepository;
  private ActionRepository actionRepository;
  private DiseaseRepository diseaseRepository;

  private ResourceMapper resourceMapper;

  public PlantResource store(PlantRequest request) {
    Plant plant = new Plant();

    return this.storeOrUpdate(request, plant);
  }

  public PlantResource update(BigInteger id, PlantRequest request) {
    Plant plant = this.findById(id);

    return this.storeOrUpdate(request, plant);
  }

  public PlantResource show(BigInteger id, Set<String> include) {
    Plant plant = this.findById(id);

    return this.resourceMapper.plantResource(plant);
  }

  public List<PlantResource> index() {
    return this.plantRepository.findAll().stream()
        .map(p -> this.resourceMapper.plantResource(p))
        .toList();
  }

  public void destroy(BigInteger id) {
    Plant plant = this.findById(id);

    this.plantRepository.delete(plant);
  }

  private List<Action> getActions(PlantRequest request) {
    if (request.actions() == null) {
      return null;
    }
    return request.actions().stream()
        .map(d -> this.actionRepository.findById(d.id()).get())
        .toList();
  }

  private List<Disease> getDiseases(PlantRequest request) {
    if (request.diseases() == null) {
      return null;
    }
    return request.diseases().stream()
        .map(d -> this.diseaseRepository.findById(d.id()).get())
        .toList();
  }

  private PlantResource storeOrUpdate(PlantRequest request, Plant plant) {
    plant.setDiseases(this.getDiseases(request));
    plant.setActions(this.getActions(request));
    plant = this.resourceMapper.getPlantMapper().request(request, plant);
    plant = this.plantRepository.save(plant);

    return this.resourceMapper.plantResource(plant);
  }

  private Plant findById(BigInteger id) {
    return this.plantRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Plant not found."));
  }
}
