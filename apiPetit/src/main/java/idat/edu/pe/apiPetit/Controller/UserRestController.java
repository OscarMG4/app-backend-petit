package idat.edu.pe.apiPetit.Controller;

import idat.edu.pe.apiPetit.Dto.UserDTO;
import idat.edu.pe.apiPetit.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<UserDTO> showUsers(){
        return userService.showUsers();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> showUserId(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(userService.showUsersId(id));
    }

    @RequestMapping(path = "/email/{email}", method = RequestMethod.GET)
    public List<UserDTO> showUserByEmail(@PathVariable(name = "email") String email){
        return userService.findByEmail(email);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable(name = "id") Integer id){
        UserDTO userResponse = userService.updateUser(userDTO, id);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Usuario eliminado!", HttpStatus.OK);
    }
}
