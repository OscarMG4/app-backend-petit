package idat.edu.pe.apiPetit.Controller;

import idat.edu.pe.apiPetit.Dto.RoleDTO;
import idat.edu.pe.apiPetit.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class RoleRestController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(path = "/accounts/{accountId}/createRole", method = RequestMethod.POST)
    public ResponseEntity<RoleDTO> saveRole(@PathVariable(name = "accountId") Integer accountId, @Valid @RequestBody RoleDTO roleDTO){
        return new ResponseEntity<>(roleService.createRole(accountId, roleDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/listRoles", method = RequestMethod.GET)
    public List<RoleDTO> showRoles(){
        return roleService.showRoles();
    }

    @RequestMapping(path = "/accounts/{accountId}/listRoles", method = RequestMethod.GET)
    public List<RoleDTO> showRolesByAccountId(@PathVariable(name = "accountId") Integer accountId){
        return roleService.showRolesByAccountId(accountId);
    }

    @RequestMapping(path = "/accounts/{accountId}/listRoles/{id}", method = RequestMethod.GET)
    public ResponseEntity<RoleDTO> showRoleId(@PathVariable(name = "accountId") Integer accountId, @PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(roleService.showRolesById(accountId, id));
    }

    @RequestMapping(path = "/accounts/{accountId}/listRoles/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RoleDTO> updateRole(@PathVariable(name = "accountId") Integer accountId, @Valid @RequestBody RoleDTO roleDTO, @PathVariable(name = "id") Integer id){
        RoleDTO roleResponse = roleService.updateRole(accountId, roleDTO, id);
        return new ResponseEntity<>(roleResponse, HttpStatus.OK);
    }

    @RequestMapping(path = "/accounts/{accountId}/listRoles/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteRole(@PathVariable(name = "accountId") Integer accountId, @PathVariable(name = "id") Integer id){
        roleService.deleteRole(accountId, id);
        return new ResponseEntity<>("Rol eliminado!", HttpStatus.OK);
    }

}
