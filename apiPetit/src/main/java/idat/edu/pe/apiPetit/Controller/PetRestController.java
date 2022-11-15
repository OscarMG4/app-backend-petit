package idat.edu.pe.apiPetit.Controller;

import idat.edu.pe.apiPetit.Dto.PetDTO;
import idat.edu.pe.apiPetit.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PetRestController {

    @Autowired
    private PetService petService;

    @RequestMapping(path = "/pets/{idTypePet}/create", method = RequestMethod.POST)
    public ResponseEntity<PetDTO> savePet(@PathVariable(name = "idTypePet") Integer idTypePet, @RequestBody PetDTO petDTO){
        return new ResponseEntity<>(petService.createPet(idTypePet, petDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/pets/listPets", method = RequestMethod.GET)
    public List<PetDTO> listPet(){
        return petService.showPets();
    }

    @RequestMapping(path = "/pets/petTypeId/{petTypeId}", method = RequestMethod.GET)
    public List<PetDTO> showPetsByTypeId(@PathVariable(name = "petTypeId") Integer petTypeId){
        return petService.showPetsByTypeId(petTypeId);
    }

    @RequestMapping(path = "/pets/petType/{petType}", method = RequestMethod.GET)
    public List<PetDTO> showPetsByType(@PathVariable(name = "petType") String petType){
        return petService.showPetsByType(petType);
    }

    @RequestMapping(path = "/pets/{petTypeId}/{id}", method = RequestMethod.GET)
    public ResponseEntity<PetDTO> showPetId(@PathVariable(name = "petTypeId") Integer petTypeId, @PathVariable(name = "id") Integer id){
        return new ResponseEntity<>(petService.showPetsId(petTypeId, id), HttpStatus.OK);
    }

    @RequestMapping(path = "/pets/{petTypeId}/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PetDTO> updatePet(@PathVariable(name = "petTypeId") Integer petTypeId, @PathVariable(name = "id") Integer id, @RequestBody PetDTO petDTO){
        PetDTO petResponse = petService.updatePet(petDTO, id, petTypeId);
        return new ResponseEntity<>(petResponse, HttpStatus.OK);
    }

    @RequestMapping(path = "/pets/{petTypeId}/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePet(@PathVariable(name = "petTypeId") Integer petTypeId, @PathVariable(name = "id") Integer id){
        petService.deletePet(petTypeId, id);
        return new ResponseEntity<>("Mascota eliminada!", HttpStatus.OK);
    }
}
