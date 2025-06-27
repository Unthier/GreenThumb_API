package henrotaym.env.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import henrotaym.env.enums.DiseaseTypeName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.math.BigInteger;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "diseases")
public class Disease {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private BigInteger id;

  private String name;
  private DiseaseTypeName type;

  @ManyToMany(mappedBy = "diseases")
  @JsonBackReference
  private List<Plant> plants;
}
