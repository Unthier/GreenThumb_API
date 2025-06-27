package henrotaym.env.http.requests;

import henrotaym.env.entities.Plant;
import jakarta.validation.constraints.NotBlank;
import java.sql.Date;

public record ActionRequest(@NotBlank String name, Date due_date, Plant plant) {}
