package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.QuoteDTO;
import idat.edu.pe.apiPetit.Entity.Quote;
import idat.edu.pe.apiPetit.Entity.ServiceType;
import idat.edu.pe.apiPetit.Entity.State;
import idat.edu.pe.apiPetit.Entity.User;
import idat.edu.pe.apiPetit.Exceptions.AppException;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.QuoteRepository;
import idat.edu.pe.apiPetit.Repository.ServiceTypeRepository;
import idat.edu.pe.apiPetit.Repository.StateRepository;
import idat.edu.pe.apiPetit.Repository.UserRepository;
import idat.edu.pe.apiPetit.Service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuoteServiceImp implements QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StateRepository stateRepository;

    private Quote mapingEntity(QuoteDTO quoteDTO){
        Quote quote = new Quote();

        quote.setIdQuote(quoteDTO.getId());
        quote.setDateIssued(quoteDTO.getDateIssued());
        quote.setDateAttention(quoteDTO.getDateAttention());
        quote.setPrice(quoteDTO.getPrice());

        return quote;
    }

    private QuoteDTO mapingDTO(Quote quote){
        QuoteDTO quoteDTO = new QuoteDTO();

        quoteDTO.setId(quote.getIdQuote());
        quoteDTO.setDateIssued(quote.getDateIssued());
        quoteDTO.setDateAttention(quote.getDateAttention());
        quoteDTO.setPrice(quote.getPrice());

        return quoteDTO;
    }

    @Override
    public QuoteDTO createQuote(Integer serviceTypeId, Integer userId, Integer stateId, QuoteDTO quoteDTO) {
        Quote quote = mapingEntity(quoteDTO);

        ServiceType serviceType = serviceTypeRepository.findById(serviceTypeId).orElseThrow(()-> new ResourceNotFoundException("ServiceType", "id", serviceTypeId));
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
        State state = stateRepository.findById(stateId).orElseThrow(()-> new ResourceNotFoundException("State", "id", stateId));

        quote.setTypeService(serviceType);
        quote.setUser(user);
        quote.setState(state);

        Quote newQuote = quoteRepository.save(quote);
        QuoteDTO quoteResponse = mapingDTO(newQuote);

        return quoteResponse;
    }

    @Override
    public List<QuoteDTO> showQuotes() {
        List<Quote> quotes = quoteRepository.findAll();
        return quotes.stream().map(quote -> mapingDTO(quote)).collect(Collectors.toList());
    }

    @Override
    public List<QuoteDTO> showQuoteByUserId(Integer userId) {
        List<Quote> quotes = quoteRepository.findByUserId(userId);
        return quotes.stream().map(quote -> mapingDTO(quote)).collect(Collectors.toList());
    }

    @Override
    public QuoteDTO showQuoteById(Integer userId, Integer quoteId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
        Quote quote = quoteRepository.findById(quoteId).orElseThrow(()->new ResourceNotFoundException("Quote", "id", quoteId));

        if(!quote.getUser().getIdUser().equals(user.getIdUser())){
            throw new AppException(HttpStatus.BAD_REQUEST, "La cita no existe!");
        }

        return mapingDTO(quote);
    }

    @Override
    public QuoteDTO updateQuote(Integer userId, Integer quoteId, QuoteDTO quoteDTO) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
        Quote quote = quoteRepository.findById(quoteId).orElseThrow(()->new ResourceNotFoundException("Quote", "id", quoteId));

        if(!quote.getUser().getIdUser().equals(user.getIdUser())){
            throw new AppException(HttpStatus.BAD_REQUEST, "La cuenta no existe!");
        }

        quote.setDateIssued(quoteDTO.getDateIssued());
        quote.setDateAttention(quoteDTO.getDateAttention());
        quote.setPrice(quoteDTO.getPrice());

        Quote newQuote = quoteRepository.save(quote);

        return mapingDTO(newQuote);
    }

    @Override
    public void deleteQuote(Integer userId, Integer quoteId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
        Quote quote = quoteRepository.findById(quoteId).orElseThrow(()->new ResourceNotFoundException("Quote", "id", quoteId));

        if(!quote.getUser().getIdUser().equals(user.getIdUser())){
            throw new AppException(HttpStatus.BAD_REQUEST, "La cuenta no existe!");
        }

        quoteRepository.delete(quote);
    }
}
