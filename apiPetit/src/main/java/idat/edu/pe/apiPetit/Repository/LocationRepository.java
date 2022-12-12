package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query(value = "select * from locationes as l where l.id_user like %:idUser%", nativeQuery = true)
    Location findByIdUser(@Param("idUser") Integer idUser);
}
