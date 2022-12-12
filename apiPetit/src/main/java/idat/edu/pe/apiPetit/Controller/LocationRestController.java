package idat.edu.pe.apiPetit.Controller;

import idat.edu.pe.apiPetit.Dto.LocalizationDTO;
import idat.edu.pe.apiPetit.Dto.PublicResponseDTO;
import idat.edu.pe.apiPetit.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/location")
public class LocationRestController {

    @Autowired
    private LocationService service;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        LocalizationDTO locationDTO = service.findById(id);
        if (locationDTO == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/create/{id}", method = RequestMethod.POST)
    public ResponseEntity<PublicResponseDTO> save(@PathVariable Integer id, @RequestBody LocalizationDTO locationDTO) {
        if (locationDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        service.save(id, locationDTO);
        return new ResponseEntity<>(new PublicResponseDTO(1500, "Guardado", null), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> saveAndFlush(@PathVariable Integer id, @RequestBody LocalizationDTO locationDTO) {
        if (locationDTO == null || id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        LocalizationDTO locationDTODb = service.findById(id);
        if (locationDTODb == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        locationDTO.setId(id);
        service.saveAndFlush(locationDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        LocalizationDTO locationDTO = service.findById(id);
        if (locationDTO == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
