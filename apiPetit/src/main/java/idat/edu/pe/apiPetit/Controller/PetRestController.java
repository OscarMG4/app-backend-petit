package idat.edu.pe.apiPetit.Controller;

import idat.edu.pe.apiPetit.Dto.PetDTO;
import idat.edu.pe.apiPetit.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetRestController {

    @Autowired
    private PetService petService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<PetDTO> saveUser(@RequestBody PetDTO petDTO){
        return new ResponseEntity<>(petService.createPet(petDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<PetDTO> listPet(){
        return petService.showPets();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PetDTO> showPetId(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(petService.showPetsId(id));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PetDTO> updatePet(@RequestBody PetDTO petDTO, @PathVariable(name = "id") Integer id){
        PetDTO petResponse = petService.updatePet(petDTO, id);
        return new ResponseEntity<>(petResponse, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePet(@PathVariable(name = "id") Integer id){
        petService.deletePet(id);
        return new ResponseEntity<>("Mascota eliminada!", HttpStatus.OK);
    }
}
