package henrotaym.env.repositories;

import henrotaym.env.entities.Action;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, BigInteger> {}
