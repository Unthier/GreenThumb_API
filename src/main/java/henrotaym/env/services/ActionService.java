package henrotaym.env.services;

import henrotaym.env.entities.Action;
import henrotaym.env.entities.Plant;
import henrotaym.env.http.requests.ActionRequest;
import henrotaym.env.http.resources.ActionResource;
import henrotaym.env.mappers.ResourceMapper;
import henrotaym.env.repositories.ActionRepository;
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
public class ActionService {

  private ResourceMapper resourceMapper;

  private ActionRepository actionRepository;
  private PlantRepository plantRepository;

  public ActionResource store(ActionRequest request) {
    Action action = new Action();

    return this.storeOrUpdate(request, action);
  }

  public ActionResource update(BigInteger id, ActionRequest request) {
    Action plant = this.findById(id);

    return this.storeOrUpdate(request, plant);
  }

  public ActionResource show(BigInteger id, Set<String> include) {
    Action action = this.findById(id);
    return this.resourceMapper.actionResource(action);
  }

  public List<ActionResource> index() {
    return this.actionRepository.findAll().stream()
        .map(a -> this.resourceMapper.actionResource(a))
        .toList();
  }

  public void destroy(BigInteger id) {
    Action action = this.findById(id);

    this.actionRepository.delete(action);
  }

  private Plant getPlant(ActionRequest request) {
    if (request.plant() == null) {
      return null;
    }
    return this.plantRepository.findById(request.plant().id()).get();
  }

  private ActionResource storeOrUpdate(ActionRequest request, Action action) {
    action.setPlant(this.getPlant(request));
    action.setDueDate(request.dueDate());
    action.setName(request.name());
    action = this.resourceMapper.getActionMapper().request(request, action);
    action = this.actionRepository.save(action);

    return this.resourceMapper.actionResource(action);
  }

  private Action findById(BigInteger id) {
    return this.actionRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("action not found."));
  }
}
