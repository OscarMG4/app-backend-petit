package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Dto.UbicacionDTO;
import idat.edu.pe.apiPetit.Entity.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Integer> {

    @Query(value = "select u.id_user, u.names, u.last_names, a.id_adoption, a.description, p.id_pet, p.name, s.id_state, s.state  from adoptions as a\n" +
            "inner join pets as p on a.id_pet like p.id_pet \n" +
            "inner join states as s on a.id_state like s.id_state\n" +
            "inner join users as u on a.id_user like u.id_user\n" +
            "where a.id_user like %:idUser%", nativeQuery = true)
    List<Adoption> findByIdUser(@Param("idUser") Integer idUser);


//    List<UbicacionDTO> obtenerEntregas(@Param("idState") Integer idState);

    @Query(value = "select * from adoptions as a where a.id_state like %:idState%", nativeQuery = true)
    List<Adoption> findByIdState(Integer idState);
}
