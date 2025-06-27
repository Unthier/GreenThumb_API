package henrotaym.env.http.resources;

import henrotaym.env.enums.DiseaseTypeName;
import henrotaym.env.http.resources.exceptions.PlantResource;
import henrotaym.env.serializers.HasIncludables;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DiseaseResource implements HasIncludables {

  private final BigInteger id;
  private final String name;
  private final DiseaseTypeName type;
  private List<PlantResource> plants;

  @Override
  public Set<String> includables() {
    return Set.of("plants");
  }
}
