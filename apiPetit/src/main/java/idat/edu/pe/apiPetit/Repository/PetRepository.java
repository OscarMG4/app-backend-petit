package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

    @Query(value="select p.id_pet, p.name, pt.id_pet_type, pt.pet_type, p.age, p.race, p.sex from pets as p\n" +
            "inner join pets_types as pt on p.id_pet_type like pt.id_pet_type\n" +
            "where pt.id_pet_type like %:idPetType%", nativeQuery=true)
    List<Pet> findByPetTypeId(@Param("idPetType") Integer idPetType);
    @Query(value="select p.id_pet, p.name, pt.id_pet_type, pt.pet_type, p.age, p.race, p.sex from pets as p\n" +
            "inner join pets_types as pt on p.id_pet_type like pt.id_pet_type\n" +
            "where pt.pet_type like %:petType%", nativeQuery=true)
    List<Pet> findByPetType(@Param("petType") String petType);

}
