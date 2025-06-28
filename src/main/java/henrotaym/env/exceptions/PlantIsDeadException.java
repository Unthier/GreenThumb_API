package henrotaym.env.exceptions;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PlantIsDeadException extends RuntimeException {
  public PlantIsDeadException() {
    super("Cette plante est morte");
  }
}
