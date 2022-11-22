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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuoteServiceImp implements QuoteService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StateRepository stateRepository;


    @Override
    public QuoteDTO createQuote(Integer serviceTypeId, Integer userId, Integer stateId, QuoteDTO quoteDTO) {
        Quote quote = mappingEntity(quoteDTO);

        ServiceType serviceType = serviceTypeRepository.findById(serviceTypeId).orElseThrow(()-> new ResourceNotFoundException("ServiceType", "id", serviceTypeId));
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
        State state = stateRepository.findById(stateId).orElseThrow(()-> new ResourceNotFoundException("State", "id", stateId));

        quote.setTypeService(serviceType);
        quote.setUser(user);
        quote.setState(state);

        Quote newQuote = quoteRepository.save(quote);
        QuoteDTO quoteResponse = mappingDTO(newQuote);

        return quoteResponse;
    }

    @Override
    public List<QuoteDTO> showQuotes() {
        List<Quote> quotes = quoteRepository.findAll();
        return quotes.stream().map(quote -> mappingDTO(quote)).collect(Collectors.toList());
    }

    @Override
    public List<QuoteDTO> showQuoteByUserId(Integer userId) {
        List<Quote> quotes = quoteRepository.findByUserId(userId);
        return quotes.stream().map(quote -> mappingDTO(quote)).collect(Collectors.toList());
    }

    public boolean validateDate(LocalDate localDate) {
        Integer amount = quoteRepository.countQuotesDates(localDate);

        if (amount >= 5) return false;
        else return true;
    }

    public static List<LocalDate> showDates() {
        List<LocalDate> dates = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();

        int day, month, year;

        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH) + 1;
        year = calendar.get(Calendar.YEAR);

        switch (month) {
            case 1:
                for (int i = 0; i < 32; i++) {
                    if (day == 32) {
                        day = 1;
                        month++;
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    } else {
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    }
                }

                break;
            case 2:
                if (year % 4 == 0) {
                    for (int i = 0; i < 30; i++) {
                        if (day == 30) {
                            day = 1;
                            month++;
                            dates.add(LocalDate.of(year, month, day));
                            day++;
                        } else {
                            dates.add(LocalDate.of(year, month, day));
                            day++;
                        }
                    }
                } else {
                    for (int i = 0; i < 29; i++) {
                        if (day == 29) {
                            day = 1;
                            month++;
                            dates.add(LocalDate.of(year, month, day));
                            day++;
                        } else {
                            dates.add(LocalDate.of(year, month, day));
                            day++;
                        }
                    }
                }

                break;

            case 3:
                for (int i = 0; i < 32; i++) {
                    if (day == 32) {
                        day = 1;
                        month++;
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    } else {
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    }
                }

                break;
            case 4:
                for (int i = 0; i < 31; i++) {
                    if (day == 31) {
                        day = 1;
                        month++;
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    } else {
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    }
                }

                break;
            case 5:
                for (int i = 0; i < 32; i++) {
                    if (day == 32) {
                        day = 1;
                        month++;
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    } else {
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    }
                }

                break;
            case 6:
                for (int i = 0; i < 31; i++) {
                    if (day == 31) {
                        day = 1;
                        month++;
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    } else {
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    }
                }

                break;
            case 7:
                for (int i = 0; i < 32; i++) {
                    if (day == 32) {
                        day = 1;
                        month++;
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    } else {
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    }
                }

                break;
            case 8:
                for (int i = 0; i < 32; i++) {
                    if (day == 32) {
                        day = 1;
                        month++;
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    } else {
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    }
                }

                break;
            case 9:
                for (int i = 0; i < 31; i++) {
                    if (day == 31) {
                        day = 1;
                        month++;
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    } else {
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    }
                }

                break;
            case 10:
                for (int i = 0; i < 32; i++) {
                    if (day == 32) {
                        day = 1;
                        month++;
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    } else {
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    }
                }

                break;
            case 11:
                for (int i = 0; i < 31; i++) {
                    if (day == 31) {
                        day = 1;
                        month++;
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    } else {
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    }
                }

                break;
            case 12:
                for (int i = 0; i < 32; i++) {
                    if (day == 32) {
                        day = 1;
                        month++;
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    } else {
                        dates.add(LocalDate.of(year, month, day));
                        day++;
                    }
                }

                break;
        }

        return dates;
    }

    @Override
    public List<LocalDate> countQuotes() {
        List<LocalDate> list = showDates();
        List<LocalDate> outputList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            boolean isValid = validateDate(list.get(i));
            if (isValid) outputList.add(list.get(i));
        }

        return outputList;
    }

    @Override
    public QuoteDTO showQuoteById(Integer userId, Integer quoteId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
        Quote quote = quoteRepository.findById(quoteId).orElseThrow(()->new ResourceNotFoundException("Quote", "id", quoteId));

        if(!quote.getUser().getIdUser().equals(user.getIdUser())){
            throw new AppException(HttpStatus.BAD_REQUEST, "La cita no existe!");
        }

        return mappingDTO(quote);
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

        return mappingDTO(newQuote);
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

    private Quote mappingEntity(QuoteDTO quoteDTO){
        Quote quote = modelMapper.map(quoteDTO, Quote.class);
        return quote;
    }

    private QuoteDTO mappingDTO(Quote quote){
        QuoteDTO quoteDTO = modelMapper.map(quote, QuoteDTO.class);
        return quoteDTO;
    }
}
