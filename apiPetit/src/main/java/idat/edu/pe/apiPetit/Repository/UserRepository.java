package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
