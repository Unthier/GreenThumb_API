package henrotaym.env.repositories;

import henrotaym.env.entities.Plant;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, BigInteger> {}
