package idat.edu.pe.apiPetit.Controller;

import idat.edu.pe.apiPetit.Dto.StateDTO;
import idat.edu.pe.apiPetit.Service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/states")
public class StateRestController {

    @Autowired
    private StateService stateService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<StateDTO> saveState(@Valid @RequestBody StateDTO stateDTO){
        return new ResponseEntity<>(stateService.createState(stateDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<StateDTO> showStates(){
        return stateService.showStates();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StateDTO> showStateId(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(stateService.showStateById(id));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<StateDTO> updateState(@Valid @RequestBody StateDTO stateDTO, @PathVariable(name = "id") Integer id){
        StateDTO stateResponse = stateService.updateState(stateDTO, id);
        return new ResponseEntity<>(stateResponse, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteState(@PathVariable(name = "id") Integer id){
        stateService.deleteState(id);
        return new ResponseEntity<>("Estado eliminado!", HttpStatus.OK);
    }

}
