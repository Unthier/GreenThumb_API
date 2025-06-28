package henrotaym.env.http.requests;

import henrotaym.env.http.requests.relationships.ActionRelationshipRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;

public record ActionRequest(
    @NotBlank String name, @NotNull Date dueDate, @Valid ActionRelationshipRequest plant) {}
