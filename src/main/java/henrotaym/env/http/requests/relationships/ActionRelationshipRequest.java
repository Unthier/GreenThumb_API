package henrotaym.env.http.requests.relationships;

import henrotaym.env.annotations.ExistsInDatabase;
import henrotaym.env.repositories.ActionRepository;
import java.math.BigInteger;

public record ActionRelationshipRequest(
    @ExistsInDatabase(repository = ActionRepository.class) BigInteger id) {}
