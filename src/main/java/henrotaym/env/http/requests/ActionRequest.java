package henrotaym.env.http.requests;

import henrotaym.env.http.requests.relationships.ActionRelationshipRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.sql.Date;

public record ActionRequest(
    @NotBlank String name, Date due_date, @Valid ActionRelationshipRequest plant) {}
