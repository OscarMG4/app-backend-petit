package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.UserDTO;

import java.util.List;


public interface UserService {

    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> showUsers();
    UserDTO showUsersId(Integer id);
    UserDTO updateUser(UserDTO userDTO, Integer id);
    void deleteUser(Integer id);



}
