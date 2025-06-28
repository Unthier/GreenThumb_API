package henrotaym.env.database.factories.Feature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import henrotaym.env.ApplicationTest;
import henrotaym.env.entities.Action;
import henrotaym.env.repositories.ActionRepository;
import java.sql.Date;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionHTTPFeatureTest extends ApplicationTest {
  @Autowired private ActionRepository actionRepository;

  @Test
  public void it_Find_By_Id_Action_Request() {
    Action action = new Action();

    action.setName(":detterer");
    action.setPlant(null);
    action.setDueDate(Date.valueOf(LocalDate.now()));

    Action newaction = this.actionRepository.save(action);

    assertEquals(action.getId(), newaction.getId());
  }
}
