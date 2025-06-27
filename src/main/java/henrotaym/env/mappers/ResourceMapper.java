package henrotaym.env.mappers;

import henrotaym.env.entities.Action;
import henrotaym.env.entities.Disease;
import henrotaym.env.entities.Plant;
import henrotaym.env.http.resources.ActionResource;
import henrotaym.env.http.resources.DiseaseResource;
import henrotaym.env.http.resources.exceptions.PlantResource;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class ResourceMapper {
  private final ActionMapper actionMapper;
  private final DiseaseMapper diseaseMapper;
  private final PlantMapper plantMapper;

  public PlantResource plantResource(Plant plant) {
    PlantResource plantResource = this.plantMapper.resource(plant);
    List<ActionResource> actionresouces =
        plant.getActions().stream().map(action -> this.actionMapper.resource(action)).toList();
    plantResource.setActions(actionresouces);

    List<DiseaseResource> diseaseresouces =
        plant.getDiseases().stream().map(disease -> this.diseaseMapper.resource(disease)).toList();
    plantResource.setDiseases(diseaseresouces);

    return plantResource;
  }

  public ActionResource actionResource(Action action) {

    return this.actionMapper.resource(action);
  }

  public DiseaseResource diseaseResource(Disease disease) {
    DiseaseResource diseaseResource = this.diseaseMapper.resource(disease);
    List<PlantResource> plants =
        disease.getPlants().stream().map(plant -> this.plantMapper.resource(plant)).toList();
    diseaseResource.setPlants(plants);
    return diseaseResource;
  }
}
