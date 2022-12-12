package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select u.id_user, u.names, u.last_names, u.dni, u.phone, u.photo, a.id_account, a.email from users as u\n" +
            "inner join accounts as a on a.id_user like u.id_user\n" +
            "where a.email like %:email%", nativeQuery = true)
    List<User> findByEmail(@Param("email") String email);

    @Query(value = "select u from User u where u.dni=?1")
    User findByDni(String dni);

    User findByPhone(String phone);

}
