package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Entity.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Integer> {

}
