package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query(value = "select a.id_account, a.email, r.`role` from roles as r\n" +
            "inner join accounts as a on a.id_account like r.id_account\n" +
            "where a.id_account like %:idAccount%", nativeQuery = true)
    List<Role> findByAccountId(@Param("idAccount") Integer idAccount);
}
