package henrotaym.env.http.requests;

import henrotaym.env.enums.DiseaseTypeName;
import henrotaym.env.http.requests.relationships.PlantRelationshipRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record DiseaseRequest(
    @NotBlank String name,
    @NotNull DiseaseTypeName type,
    @Valid List<PlantRelationshipRequest> plants) {}
