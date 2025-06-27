package henrotaym.env.mappers;

import henrotaym.env.entities.Plant;
import henrotaym.env.http.requests.PlantRequest;
import henrotaym.env.http.requests.relationships.PlantRelationshipRequest;
import henrotaym.env.http.resources.exceptions.PlantResource;
import java.sql.Date;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class PlantMapper {
  public PlantResource resource(Plant plant) {
    return new PlantResource(plant.getId(), plant.getName(), plant.getSpecie(), plant.getStatus());
  }

  public Plant request(PlantRequest request, Plant plant) {
    plant.setName(request.name());
    plant.setSpecie(request.specie());
    plant.setStatus(request.status());
    if (plant.getBuying_date() == null) {
      plant.setBuying_date(Date.valueOf(LocalDate.now()));
    } else {
      plant.setBuying_date(plant.getBuying_date());
    }

    return plant;
  }

  public PlantRelationshipRequest relationshipRequest(Plant plant) {
    return new PlantRelationshipRequest(plant.getId());
  }
}
