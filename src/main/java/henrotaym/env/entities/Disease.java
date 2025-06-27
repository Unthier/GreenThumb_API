package henrotaym.env.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import henrotaym.env.enums.DiseaseTypeName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.math.BigInteger;
import java.util.ArrayList;
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

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private DiseaseTypeName type;

  @ManyToMany(mappedBy = "diseases")
  @JsonBackReference
  private List<Plant> plants = new ArrayList<>();

  public void setPlants(List<Plant> plants) {
    this.plants.forEach(game -> game.getDiseases().remove(this));
    plants.forEach(game -> game.getDiseases().add(this));
    this.plants.clear();
    this.plants.addAll(plants);
  }
}
