package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value="select u.id_user, u.names, u.last_names, a.id_account, a.email , a.pass, tc.id_account_type, tc.account_type from accounts as a\n" +
            "inner join users as u on a.id_user like u.id_user\n" +
            "inner join accounts_types as tc on a.id_account like tc.id_account_type\n" +
            "where a.id_user like %:idUser%", nativeQuery=true)
    List<Account> findByUserId(@Param("idUser") Integer idUser);

/*    @Query(value = "select u.id_user, u.names, u.last_names, a.id_account, a.email from accounts as a\n" +
            "inner join users as u on u.id_user like a.id_user\n" +
            "where a.email like %:account%")
    List<Account> findByAccount(@Param("account") String account);*/
}
