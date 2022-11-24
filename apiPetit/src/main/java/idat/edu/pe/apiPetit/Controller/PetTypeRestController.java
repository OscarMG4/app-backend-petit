package idat.edu.pe.apiPetit.Controller;

import idat.edu.pe.apiPetit.Dto.PetTypeDTO;
import idat.edu.pe.apiPetit.Service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/petsTypes")
public class PetTypeRestController {

    @Autowired
    private PetTypeService petTypeService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<PetTypeDTO> savePetType(@Valid @RequestBody PetTypeDTO petTypeDTO){
        return new ResponseEntity<>(petTypeService.createTypeService(petTypeDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<PetTypeDTO> showPetsTypes(){
        return petTypeService.showTypesServices();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PetTypeDTO> showPetTypeId(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(petTypeService.showTypeServiceById(id));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PetTypeDTO> updatePetType(@Valid @RequestBody PetTypeDTO petTypeDTO, @PathVariable(name = "id") Integer id){
        PetTypeDTO petTypeResponse = petTypeService.updateTypeService(petTypeDTO, id);
        return new ResponseEntity<>(petTypeResponse, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePetType(@PathVariable(name = "id") Integer id){
        petTypeService.deleteTypeService(id);
        return new ResponseEntity<>("Tipo de mascota eliminado!", HttpStatus.OK);
    }


}
