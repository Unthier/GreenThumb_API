package henrotaym.env.services;

import henrotaym.env.entities.Disease;
import henrotaym.env.entities.Plant;
import henrotaym.env.http.requests.DiseaseRequest;
import henrotaym.env.http.resources.DiseaseResource;
import henrotaym.env.mappers.ResourceMapper;
import henrotaym.env.repositories.DiseaseRepository;
import henrotaym.env.repositories.PlantRepository;
import jakarta.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class DiseaseService {
  //   private final TagRepository tagRepository;
  private PlantRepository plantRepository;
  private DiseaseRepository diseaseRepository;

  private ResourceMapper resourceMapper;

  public DiseaseResource store(DiseaseRequest request) {
    Disease disease = new Disease();

    return this.storeOrUpdate(request, disease);
  }

  public DiseaseResource update(BigInteger id, DiseaseRequest request) {
    Disease disease = this.findById(id);

    return this.storeOrUpdate(request, disease);
  }

  public DiseaseResource show(BigInteger id, Set<String> include) {
    Disease plant = this.findById(id);

    return this.resourceMapper.diseaseResource(plant);
  }

  public List<DiseaseResource> index() {
    return this.diseaseRepository.findAll().stream()
        .map(d -> this.resourceMapper.diseaseResource(d))
        .toList();
  }

  public void destroy(BigInteger id) {
    Disease disease = this.findById(id);

    this.diseaseRepository.delete(disease);
  }

  private List<Plant> getPlants(DiseaseRequest request) {
    if (request.plants() == null) {

      return null;
    }
    return request.plants().stream().map(d -> this.plantRepository.findById(d.id()).get()).toList();
  }

  private DiseaseResource storeOrUpdate(DiseaseRequest request, Disease disease) {
    disease.setPlants(this.getPlants(request));
    disease.setName(request.name());
    disease.setType(request.type());
    disease = this.resourceMapper.getDiseaseMapper().request(request, disease);
    disease = this.diseaseRepository.save(disease);

    return this.resourceMapper.diseaseResource(disease);
  }

  private Disease findById(BigInteger id) {
    return this.diseaseRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Diseace not found."));
  }
}
