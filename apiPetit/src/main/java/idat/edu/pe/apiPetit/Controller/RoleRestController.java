package idat.edu.pe.apiPetit.Controller;

import idat.edu.pe.apiPetit.Dto.RoleDTO;
import idat.edu.pe.apiPetit.Dto.StateDTO;
import idat.edu.pe.apiPetit.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleRestController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<RoleDTO> saveRole(@RequestBody RoleDTO roleDTO){
        return new ResponseEntity<>(roleService.createRole(roleDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<RoleDTO> showRoles(){
        return roleService.showRoles();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RoleDTO> showRoleId(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(roleService.showRolesById(id));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RoleDTO> updateRole(@RequestBody RoleDTO roleDTO, @PathVariable(name = "id") Integer id){
        RoleDTO roleResponse = roleService.updateRole(roleDTO, id);
        return new ResponseEntity<>(roleResponse, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteRole(@PathVariable(name = "id") Integer id){
        roleService.deleteRole(id);
        return new ResponseEntity<>("Rol eliminado!", HttpStatus.OK);
    }

}
