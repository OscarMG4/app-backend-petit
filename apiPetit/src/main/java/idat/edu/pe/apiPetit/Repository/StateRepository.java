package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
