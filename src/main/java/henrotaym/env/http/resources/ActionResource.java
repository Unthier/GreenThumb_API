package henrotaym.env.http.resources;

import henrotaym.env.http.resources.exceptions.PlantResource;
import henrotaym.env.serializers.HasIncludables;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ActionResource implements HasIncludables {
  private final BigInteger id;
  private final String name;
  private Date due_date;
  private PlantResource plant;

  @Override
  public Set<String> includables() {
    return Set.of("plant");
  }
}
