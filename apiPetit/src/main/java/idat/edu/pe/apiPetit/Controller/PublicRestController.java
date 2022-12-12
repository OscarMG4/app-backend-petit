package idat.edu.pe.apiPetit.Controller;

import idat.edu.pe.apiPetit.Dto.AccountDTO;
import idat.edu.pe.apiPetit.Dto.PublicRequestDTO;
import idat.edu.pe.apiPetit.Dto.PublicResponseDTO;
import idat.edu.pe.apiPetit.Dto.UserDTO;
import idat.edu.pe.apiPetit.Service.AccountService;
import idat.edu.pe.apiPetit.Service.PublicService;
import idat.edu.pe.apiPetit.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/public/api/users")
public class PublicRestController {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PublicService publicService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/account/{accountTypeId}/{userId}/createAccount", method = RequestMethod.POST)
    public ResponseEntity<AccountDTO> saveAccount(@PathVariable(name = "accountTypeId") Integer accountTypeId, @PathVariable(name = "userId") Integer userId, @RequestBody AccountDTO accountDTO) {
        return new ResponseEntity<>(accountService.createAccount(accountTypeId, userId, accountDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/createAccountUser", method = RequestMethod.POST)
    public ResponseEntity<PublicResponseDTO> createAccountUser(@RequestBody PublicRequestDTO requestDTO) {
        if (requestDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(publicService.createAccount(requestDTO), HttpStatus.OK);
    }

    @RequestMapping(path = "/email/{email}", method = RequestMethod.GET)
    public List<UserDTO> showUserByEmail(@PathVariable(name = "email") String email){
        return userService.findByEmail(email);
    }
}
