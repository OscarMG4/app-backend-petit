package idat.edu.pe.apiPetit.Controller;

import idat.edu.pe.apiPetit.Dto.AdoptionDTO;
import idat.edu.pe.apiPetit.Service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class AdoptionRestController {

    @Autowired
    private AdoptionService adoptionService;

    @RequestMapping(path = "/users/{userId}/{stateId}/{petId}/createAdoption", method = RequestMethod.POST)
    public ResponseEntity<AdoptionDTO> saveAdoption(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "stateId") Integer stateId, @PathVariable(name = "petId") Integer petId, @RequestBody AdoptionDTO adoptionDTO){
        return new ResponseEntity<>(adoptionService.createAdoption(userId, stateId, petId, adoptionDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/users/{userId}/listAdoptions", method = RequestMethod.GET)
    public List<AdoptionDTO> showAdoptionsByUser(@PathVariable(name = "userId") Integer userId){
        return adoptionService.showAdoptionsByUserId(userId);
    }

    @RequestMapping(path = "/users/{userId}/listAdoptions/{id}", method = RequestMethod.GET)
    public ResponseEntity<AdoptionDTO> showAdoptionById(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "id") Integer adoptionId){
        return new ResponseEntity<>(adoptionService.showAdoptionById(userId, adoptionId), HttpStatus.OK);
    }

    @RequestMapping(path = "/users/{userId}/listAdoptions/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AdoptionDTO> updateQuotes(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "id") Integer adoptionId, @RequestBody AdoptionDTO adoptionDTO){
        return new ResponseEntity<>(adoptionService.updateAdoption(userId, adoptionId, adoptionDTO), HttpStatus.OK);
    }

    @RequestMapping(path = "/users/{userId}/listAdoptions/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAdoption(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "id") Integer adoptionId){
        adoptionService.deleteAdoption(userId, adoptionId);
        return new ResponseEntity<>("Solicitud de Adopción Eliminada!", HttpStatus.OK);
    }

}
