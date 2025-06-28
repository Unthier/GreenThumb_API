package henrotaym.env.mappers;

import henrotaym.env.entities.Action;
import henrotaym.env.http.requests.ActionRequest;
import henrotaym.env.http.requests.relationships.ActionRelationshipRequest;
import henrotaym.env.http.resources.ActionResource;
import org.springframework.stereotype.Component;

@Component
public class ActionMapper {
  public ActionResource resource(Action action) {
    return new ActionResource(
        action.getId(), action.getName(), action.getDueDate(), action.getPlant());
  }

  public Action request(ActionRequest request, Action action) {
    action.setName(request.name());
    action.setDueDate(request.dueDate());

    return action;
  }

  public ActionRelationshipRequest relationshipRequest(Action action) {
    return new ActionRelationshipRequest(action.getId());
  }
}
