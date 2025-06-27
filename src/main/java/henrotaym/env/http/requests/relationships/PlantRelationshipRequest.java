package henrotaym.env.http.requests.relationships;

import henrotaym.env.annotations.ExistsInDatabase;
import henrotaym.env.repositories.PlantRepository;
import java.math.BigInteger;

public record PlantRelationshipRequest(
    @ExistsInDatabase(repository = PlantRepository.class) BigInteger id) {}
