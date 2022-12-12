package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.QuoteDTO;
import idat.edu.pe.apiPetit.Dto.QuoteResponseDTO;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface QuoteService {

    QuoteDTO createQuote(Integer serviceTypeId, Integer userId, Integer stateId, QuoteDTO quoteDTO);
    List<QuoteDTO> showQuotes();
    List<QuoteDTO> showQuoteByUserId(@Param("idUser") Integer userId);
    List<LocalDate> countQuotes();
    QuoteDTO showQuoteById(Integer userId, Integer quoteId);
    QuoteDTO updateQuote(Integer userId, Integer quoteId, QuoteDTO quoteDTO);
    void deleteQuote(Integer userId, Integer quoteId);


    List<QuoteResponseDTO> showAllQuotesByUserId(Integer idUser);
}
