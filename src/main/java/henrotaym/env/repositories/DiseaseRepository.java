package henrotaym.env.repositories;

import henrotaym.env.entities.Disease;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository extends JpaRepository<Disease, BigInteger> {}
