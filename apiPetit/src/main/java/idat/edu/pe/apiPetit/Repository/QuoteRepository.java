package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

    @Query(value = "select u.id_user, q.id_quote , q.date_issued, q.date_attention, q.type_service, q.price, s.id_state, s.name from quotes as q\n" +
            "inner join users as u on q.id_user like u.id_user\n" +
            "inner join states as s on q.id_state like s.id_state \n" +
            "where q.id_user like %:idUser%", nativeQuery = true)
    List<Quote> findByUserId(@Param("idUser") Integer idUser);

}