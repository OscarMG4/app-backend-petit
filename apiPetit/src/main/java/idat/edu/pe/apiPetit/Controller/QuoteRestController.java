package idat.edu.pe.apiPetit.Controller;

import idat.edu.pe.apiPetit.Dto.QuoteDTO;
import idat.edu.pe.apiPetit.Dto.QuoteResponseDTO;
import idat.edu.pe.apiPetit.Service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class QuoteRestController {

    @Autowired
    private QuoteService quoteService;

    @RequestMapping(path = "/users/{serviceTypeId}/{userId}/{stateId}/createQuote", method = RequestMethod.POST)
    public ResponseEntity<QuoteDTO> saveQuote(@PathVariable(name = "serviceTypeId") Integer serviceTypeId, @PathVariable(name = "userId") Integer userId, @PathVariable(name = "stateId") Integer stateId, @RequestBody QuoteDTO quoteDTO){
        return new ResponseEntity<>(quoteService.createQuote(serviceTypeId, userId, stateId, quoteDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/listQuotes", method = RequestMethod.GET)
    public List<QuoteDTO> listQuote(){
        return quoteService.showQuotes();
    }


    @RequestMapping(path = "/users/{userId}/listQuotes", method = RequestMethod.GET)
    public List<QuoteResponseDTO> showQuotesByUser(@PathVariable(name = "userId") Integer userId){
        return quoteService.showAllQuotesByUserId(userId);
    }

    @RequestMapping(path = "/countQuotes", method = RequestMethod.GET)
    public List<LocalDate> countQuotes(){
        return quoteService.countQuotes();
    }

    @RequestMapping(path = "/users/{userId}/listQuotes/{id}", method = RequestMethod.GET)
    public ResponseEntity<QuoteDTO> showQuoteById(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "id") Integer quoteId){
        return new ResponseEntity<>(quoteService.showQuoteById(userId, quoteId), HttpStatus.OK);
    }

    @RequestMapping(path = "/users/{userId}/listQuotes/{id}", method = RequestMethod.PUT)
    public ResponseEntity<QuoteDTO> updateQuotes(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "id") Integer quoteId, @RequestBody QuoteDTO quoteDTO){
        return new ResponseEntity<>(quoteService.updateQuote(userId, quoteId, quoteDTO), HttpStatus.OK);
    }

    @RequestMapping(path = "/users/{userId}/listQuotes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAccount(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "id") Integer quotetId){
        quoteService.deleteQuote(userId, quotetId);
        return new ResponseEntity<>("Cita Eliminada!", HttpStatus.OK);
    }

}
