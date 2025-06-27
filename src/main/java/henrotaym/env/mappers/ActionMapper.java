package henrotaym.env.mappers;

import henrotaym.env.entities.Action;
import henrotaym.env.http.requests.ActionRequest;
import henrotaym.env.http.requests.relationships.ActionRelationshipRequest;
import henrotaym.env.http.resources.ActionResource;
import java.sql.Date;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class ActionMapper {
  public ActionResource resource(Action action) {
    return new ActionResource(action.getId(), action.getName());
  }

  public Action request(ActionRequest request, Action action) {
    action.setName(request.name());
    if (action.getDue_date() == null) {
      action.setDue_date(Date.valueOf(LocalDate.now()));
    } else {
      action.setDue_date(request.due_date());
    }

    return action;
  }

  public ActionRelationshipRequest relationshipRequest(Action action) {
    return new ActionRelationshipRequest(action.getId());
  }
}
