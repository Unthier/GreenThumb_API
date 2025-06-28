package henrotaym.env.http.requests;

import henrotaym.env.enums.PlantStatusName;
import henrotaym.env.http.requests.relationships.ActionRelationshipRequest;
import henrotaym.env.http.requests.relationships.DiseaseRelationshipRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

public record PlantRequest(
    @NotBlank String name,
    @NotNull String specie,
    @NotNull Date buyingDate,
    @NotNull PlantStatusName status,
    @Valid List<DiseaseRelationshipRequest> diseases,
    @Valid List<ActionRelationshipRequest> actions
    // @Valid CoverRelationshipRequest cover,
    // @Valid @NotNull StudioRelationshipRequest studio,
    // @Valid @NotNull List<TagRelationshipRequest> tags
    ) {}
