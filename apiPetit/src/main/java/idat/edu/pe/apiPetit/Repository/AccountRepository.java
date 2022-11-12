package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value="select u.id_user, a.id_account, a.email , a.pass from accounts as a\n" +
            "inner join users as u on a.id_user like u.id_user\n" +
            "where a.id_user like %:idUser%", nativeQuery=true)
    List<Account> findByUserId(@Param("idUser") Integer idUser);

}
