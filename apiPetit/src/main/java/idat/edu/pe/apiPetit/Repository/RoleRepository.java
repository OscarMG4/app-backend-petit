package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
