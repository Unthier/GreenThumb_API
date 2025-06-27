package henrotaym.env.mappers;

import henrotaym.env.entities.Disease;
import henrotaym.env.http.requests.DiseaseRequest;
import henrotaym.env.http.requests.relationships.DiseaseRelationshipRequest;
import henrotaym.env.http.resources.DiseaseResource;
import org.springframework.stereotype.Component;

@Component
public class DiseaseMapper {
  public DiseaseResource resource(Disease disease) {
    return new DiseaseResource(disease.getId(), disease.getName(), disease.getType());
  }

  public Disease request(DiseaseRequest request, Disease disease) {
    disease.setName(request.name());
    disease.setType(request.type());

    return disease;
  }

  public DiseaseRelationshipRequest relationshipRequest(Disease disease) {
    return new DiseaseRelationshipRequest(disease.getId());
  }
}
