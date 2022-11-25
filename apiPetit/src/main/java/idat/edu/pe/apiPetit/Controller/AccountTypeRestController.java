package idat.edu.pe.apiPetit.Controller;

import idat.edu.pe.apiPetit.Dto.AccountTypeDTO;
import idat.edu.pe.apiPetit.Service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/accountsTypes")
public class AccountTypeRestController {

    @Autowired
    private AccountTypeService accountTypeService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<AccountTypeDTO> saveAccountType(@Valid @RequestBody AccountTypeDTO accountTypeDTO){
        return new ResponseEntity<>(accountTypeService.createAccountType(accountTypeDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<AccountTypeDTO> listAccountType(){
        return accountTypeService.showAccountType();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AccountTypeDTO> showAccountTypeId(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(accountTypeService.showAccountTypeId(id));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AccountTypeDTO> updateAccountType(@Valid @RequestBody AccountTypeDTO accountTypeDTO, @PathVariable(name = "id") Integer id){
        return new ResponseEntity<>(accountTypeService.updateAccountType(accountTypeDTO, id), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAccountType(@PathVariable(name = "id") Integer id){
        accountTypeService.deleteAccountType(id);
        return new ResponseEntity<>("Tipo de cuenta eliminada!", HttpStatus.OK);
    }

}
