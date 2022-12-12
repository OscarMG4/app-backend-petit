package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.UserDTO;
import idat.edu.pe.apiPetit.Entity.User;
import idat.edu.pe.apiPetit.Exceptions.AppException;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.UserRepository;
import idat.edu.pe.apiPetit.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = mappingEntity(userDTO);
        UserDTO usuarioDb = findByDni(user.getDni());

        if (usuarioDb != null)
            throw new AppException(HttpStatus.BAD_REQUEST, "Ya existe un usuario con el dni " + user.getDni());

        usuarioDb = findByPhone(user.getPhone());

        if (usuarioDb != null)
            throw new AppException(HttpStatus.BAD_REQUEST, "Ya existe un usuario con el telefono  " + user.getPhone());

        User newUser = userRepository.save(user);
        UserDTO userResponse = mappingDTO(newUser);

        return userResponse;
    }

    @Override
    public List<UserDTO> showUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> mappingDTO(user)).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findByEmail(String email) {
        List<User> users = userRepository.findByEmail(email);
        return users.stream().map(user -> mappingDTO(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO showUsersId(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return mappingDTO(user);
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
        return mappingDTO(userUpdated);
    }

    @Override
    public void deleteUser(Integer id) {
        User userId = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(userId);
    }

    @Override
    public UserDTO findByDni(String dni) {
        User usuario = userRepository.findByDni(dni);
        if (usuario == null) return null;
        else return mappingDTO(usuario);
    }

    @Override
    public UserDTO findByPhone(String phone) {
        User usuario = userRepository.findByPhone(phone);
        if (usuario == null) return null;
        else return mappingDTO(usuario);
    }

    //Convierte DTO a entidad
    private User mappingEntity(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }

    //Convierte entidad a DTO
    private UserDTO mappingDTO(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

}
