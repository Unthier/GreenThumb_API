package henrotaym.env.mappers;

import henrotaym.env.entities.Plant;
import henrotaym.env.enums.PlantStatusName;
import henrotaym.env.http.requests.PlantRequest;
import henrotaym.env.http.requests.relationships.PlantRelationshipRequest;
import henrotaym.env.http.resources.exceptions.PlantResource;
import org.springframework.stereotype.Component;

@Component
public class PlantMapper {
  public PlantResource resource(Plant plant) {
    return new PlantResource(
        plant.getId(),
        plant.getName(),
        plant.getSpecie(),
        plant.getStatus(),
        plant.getBuyingDate());
  }

  public Plant request(PlantRequest request, Plant plant) {
    plant.setName(request.name());
    plant.setSpecie(request.specie());
    plant.setStatus(checkStatus(request));
    plant.setBuyingDate(plant.getBuyingDate());

    return plant;
  }

  public PlantRelationshipRequest relationshipRequest(Plant plant) {
    return new PlantRelationshipRequest(plant.getId());
  }

  private PlantStatusName checkStatus(PlantRequest plant) {
    if (plant.status() == PlantStatusName.DEAD) return PlantStatusName.DEAD;
    if (plant.diseases() != null && plant.diseases().size() > 0) {
      return PlantStatusName.SICK;
    } else {
      return PlantStatusName.ALIVE;
    }
  }
}
