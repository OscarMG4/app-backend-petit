package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

}
