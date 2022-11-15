package idat.edu.pe.apiPetit.Controller;

import idat.edu.pe.apiPetit.Dto.AccountDTO;
import idat.edu.pe.apiPetit.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class AccountRestController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(path = "/users/{accountTypeId}/{userId}/createAccount", method = RequestMethod.POST)
    public ResponseEntity<AccountDTO> saveAccount(@PathVariable(name = "accountTypeId") Integer accountTypeId, @PathVariable(name = "userId") Integer userId, @RequestBody AccountDTO accountDTO){
        return new ResponseEntity<>(accountService.createAccount(accountTypeId, userId, accountDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/users/{userId}/listAccounts", method = RequestMethod.GET)
    public List<AccountDTO> showAccountsByUser(@PathVariable(name = "userId") Integer userId){
        return accountService.showAccountsByUserId(userId);
    }

    @RequestMapping(path = "/users/{userId}/listAccounts/{id}", method = RequestMethod.GET)
    public ResponseEntity<AccountDTO> showAccountById(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "id") Integer accountId){
        return new ResponseEntity<>(accountService.showAccountById(userId, accountId), HttpStatus.OK);
    }

    @RequestMapping(path = "/users/{userId}/listAccounts/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AccountDTO> updateAccount(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "id") Integer accountId, @RequestBody AccountDTO accountDTO){
        return new ResponseEntity<>(accountService.updateAccount(userId, accountId, accountDTO), HttpStatus.OK);
    }

    @RequestMapping(path = "/users/{userId}/listAccounts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAccount(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "id") Integer accountId){
        accountService.deleteAccount(userId, accountId);
        return new ResponseEntity<>("Cuenta Eliminada!", HttpStatus.OK);
    }
}
