package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.UserDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserService {

    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> showUsers();
    List<UserDTO> findByEmail(@Param("email") String email);
    UserDTO showUsersId(Integer id);
    UserDTO updateUser(UserDTO userDTO, Integer id);
    void deleteUser(Integer id);

    UserDTO findByDni(String dni);

    UserDTO findByPhone(String phone);

}
