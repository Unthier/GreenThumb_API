package henrotaym.env.http.resources.exceptions;

import henrotaym.env.enums.PlantStatusName;
import henrotaym.env.http.resources.ActionResource;
import henrotaym.env.http.resources.DiseaseResource;
import henrotaym.env.serializers.HasIncludables;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PlantResource implements HasIncludables {
  private final BigInteger id;
  private final String specie;
  private final String name;
  private final PlantStatusName status;
  private Date buying_date;
  private List<DiseaseResource> diseases;
  private List<ActionResource> actions;

  @Override
  public Set<String> includables() {
    return Set.of("diseases", "actions");
  }
}
