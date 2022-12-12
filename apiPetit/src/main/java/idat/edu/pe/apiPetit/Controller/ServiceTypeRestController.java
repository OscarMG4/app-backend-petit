package idat.edu.pe.apiPetit.Controller;

import idat.edu.pe.apiPetit.Dto.ServiceTypeDTO;
import idat.edu.pe.apiPetit.Service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicesTypes")
public class ServiceTypeRestController {

    @Autowired
    private ServiceTypeService serviceTypeService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<ServiceTypeDTO> saveServiceType(@RequestBody ServiceTypeDTO serviceTypeDTO){
        return new ResponseEntity<>(serviceTypeService.createServiceType(serviceTypeDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<ServiceTypeDTO> showServicesTypes(){
        return serviceTypeService.showServicesTypes();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ServiceTypeDTO> showServicesTypesId(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(serviceTypeService.showServiceTypeById(id));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ServiceTypeDTO> updateServiceType(@RequestBody ServiceTypeDTO serviceTypeDTO, @PathVariable(name = "id") Integer id){
        ServiceTypeDTO serviceTypeResponse = serviceTypeService.updateServiceType(serviceTypeDTO, id);
        return new ResponseEntity<>(serviceTypeResponse, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteServiceType(@PathVariable(name = "id") Integer id){
        serviceTypeService.deleteServiceType(id);
        return new ResponseEntity<>("Tipo de servicio eliminado!", HttpStatus.OK);
    }

}
