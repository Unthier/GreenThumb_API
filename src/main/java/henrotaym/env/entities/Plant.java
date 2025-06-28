package henrotaym.env.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import henrotaym.env.enums.PlantStatusName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "plants")
public class Plant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private BigInteger id;

  private String specie;
  private String name;

  @Column(name = "buying_date", nullable = false)
  private Date buyingDate;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private PlantStatusName status;

  @OneToMany(mappedBy = "plant")
  @JsonBackReference
  private List<Action> actions = new ArrayList<Action>();

  @ManyToMany()
  @JoinTable(
      name = "plant_disease",
      joinColumns = @JoinColumn(name = "plant_id", nullable = false),
      inverseJoinColumns = @JoinColumn(name = "disease_id", nullable = false))
  @JsonManagedReference
  private List<Disease> diseases = new ArrayList<Disease>();

  public void setDiseases(List<Disease> diseases) {
    this.diseases.clear();
    if (diseases != null) {
      this.diseases.addAll(diseases);
    }
  }

  public void setActions(List<Action> actions) {
    this.actions.clear();
    if (actions != null) {
      this.actions.addAll(actions);
    }
  }
}
