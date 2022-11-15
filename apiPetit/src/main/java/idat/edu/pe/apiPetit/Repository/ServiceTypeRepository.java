package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer> {

}
