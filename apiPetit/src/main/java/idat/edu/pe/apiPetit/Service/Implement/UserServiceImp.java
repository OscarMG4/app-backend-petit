package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.UserDTO;
import idat.edu.pe.apiPetit.Entity.User;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.UserRepository;
import idat.edu.pe.apiPetit.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    //Convierte DTO a entidad
    private User mapingEntity(UserDTO userDTO){
        User user = new User();

        user.setIdUser(userDTO.getId());
        user.setNames(userDTO.getNames());
        user.setLastNames(userDTO.getLastNames());
        user.setDni(userDTO.getDni());
        user.setPhone(userDTO.getPhone());
        user.setPhoto(userDTO.getPhoto());

        return user;
    }

    //Convierte entidad a DTO
    private UserDTO mapingDTO(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getIdUser());
        userDTO.setNames(user.getNames());
        userDTO.setLastNames(user.getLastNames());
        userDTO.setDni(user.getDni());
        userDTO.setPhone(user.getPhone());
        userDTO.setPhoto(user.getPhoto());

        return userDTO;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = mapingEntity(userDTO);
        User newUser = userRepository.save(user);
        UserDTO userResponse = mapingDTO(newUser);

        return userResponse;
    }

    @Override
    public List<UserDTO> showUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> mapingDTO(user)).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findByEmail(String email) {
        List<User> users = userRepository.findByEmail(email);
        return users.stream().map(user -> mapingDTO(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO showUsersId(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return mapingDTO(user);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer id) {
        User userId = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        userId.setNames(userDTO.getNames());
        userId.setLastNames(userDTO.getLastNames());
        userId.setDni(userDTO.getDni());
        userId.setPhone(userDTO.getPhone());
        userId.setPhoto(userDTO.getPhoto());

        User userUpdated = userRepository.save(userId);
        return mapingDTO(userUpdated);
    }

    @Override
    public void deleteUser(Integer id) {
        User userId = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(userId);
    }


}
