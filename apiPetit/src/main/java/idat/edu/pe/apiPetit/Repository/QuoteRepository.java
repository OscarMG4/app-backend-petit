package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

    @Query(value = "select u.id_user, u.names, u.last_names, q.id_quote , q.date_issued, q.date_attention, st.id_service_type, st.service_type, q.price, s.id_state, s.state from quotes as q\n" +
            "inner join services_types as st on q.id_service_type like st.id_service_type\n" +
            "inner join users as u on q.id_user like u.id_user\n" +
            "inner join states as s on q.id_state like s.id_state\n" +
            "where q.id_user like %:idUser%", nativeQuery = true)
    List<Quote> findByUserId(@Param("idUser") Integer idUser);

    @Query(value = "select count(q.id_quote) from quotes q where q.date_attention like %:dateAttention%", nativeQuery = true)
    Integer countQuotesDates(@Param("dateAttention") LocalDate dateAttention);

}
