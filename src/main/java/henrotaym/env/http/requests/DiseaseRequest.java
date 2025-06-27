package henrotaym.env.http.requests;

import henrotaym.env.entities.Plant;
import henrotaym.env.enums.DiseaseTypeName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record DiseaseRequest(
    @NotBlank String name, @NotNull DiseaseTypeName type, List<Plant> plants) {}
