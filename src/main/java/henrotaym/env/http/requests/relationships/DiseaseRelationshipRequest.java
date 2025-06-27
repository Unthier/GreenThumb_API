package henrotaym.env.http.requests.relationships;

import java.math.BigInteger;

import henrotaym.env.annotations.ExistsInDatabase;
import henrotaym.env.repositories.DiseaseRepository;

public record DiseaseRelationshipRequest(
    @ExistsInDatabase(repository = DiseaseRepository.class) BigInteger id) {}
