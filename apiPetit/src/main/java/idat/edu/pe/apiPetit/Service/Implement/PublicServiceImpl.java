package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.AccountDTO;
import idat.edu.pe.apiPetit.Dto.PublicRequestDTO;
import idat.edu.pe.apiPetit.Dto.PublicResponseDTO;
import idat.edu.pe.apiPetit.Dto.UserDTO;
import idat.edu.pe.apiPetit.Entity.Account;
import idat.edu.pe.apiPetit.Entity.AccountType;
import idat.edu.pe.apiPetit.Entity.User;
import idat.edu.pe.apiPetit.Exceptions.AppException;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.AccountRepository;
import idat.edu.pe.apiPetit.Repository.AccountTypeRepository;
import idat.edu.pe.apiPetit.Repository.UserRepository;
import idat.edu.pe.apiPetit.Service.PublicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PublicServiceImpl implements PublicService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PublicResponseDTO createAccount(PublicRequestDTO requestDTO) {
        UserDTO usuarioDb = findByDni(requestDTO.getDni());
        if (usuarioDb != null)
            return new PublicResponseDTO(1001, "Ya existe un usuario con el dni " + requestDTO.getDni(), null);

        usuarioDb = findByPhone(requestDTO.getPhone());

        if (usuarioDb != null)
            return new PublicResponseDTO(1002, "Ya existe un usuario con el telefono " + requestDTO.getPhone(), null);

        AccountDTO accountDb = findByEmail(requestDTO.getEmail());

        if (accountDb != null)
            return new PublicResponseDTO(1003, "Ya existe un usuario con el email " + requestDTO.getEmail(), null);


        UserDTO userDTO = new UserDTO(requestDTO.getIdUser(), requestDTO.getNames(), requestDTO.getLastNames(), requestDTO.getDni(), requestDTO.getPhone(), requestDTO.getPhoto());
        AccountDTO accountDTO = new AccountDTO(requestDTO.getIdAccount(), requestDTO.getEmail(), requestDTO.getPassword());

        int iduser = createUser(userDTO);

        if (iduser != 0)
            if (createAccount(requestDTO.getIdAccountType(), iduser, accountDTO))
                return new PublicResponseDTO(201, "La cuenta ha sido creada", requestDTO);

        return new PublicResponseDTO(1000, "Algo ocurrio mal", requestDTO);
    }

    public int createUser(UserDTO userDTO) {
        User user = mappingUserEntity(userDTO);
        UserDTO usuarioDb = findByDni(user.getDni());

        if (usuarioDb != null)
            throw new AppException(HttpStatus.BAD_REQUEST, "Ya existe un usuario con el dni " + user.getDni());

        usuarioDb = findByPhone(user.getPhone());

        if (usuarioDb != null)
            throw new AppException(HttpStatus.BAD_REQUEST, "Ya existe un usuario con el telefono  " + user.getPhone());

        User newUser = userRepository.save(user);

        if (newUser != null) return newUser.getIdUser();
        else return 0;
    }

    public boolean createAccount(Integer accountTypeId, Integer userId, AccountDTO accountDTO) {
        Account account = mappingAccountEntity(accountDTO);
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        AccountType accountType = accountTypeRepository.findById(accountTypeId).orElseThrow(() -> new ResourceNotFoundException("AccountType", "id", accountTypeId));

        account.setUser(user);
        account.setAccountType(accountType);
        account.setPass(new BCryptPasswordEncoder().encode(account.getPass()));
        Account newAccount = accountRepository.save(account);

        if (newAccount != null) return true;
        else return false;
    }

    //Convierte DTO a entidad
    private User mappingUserEntity(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }

    //Convierte entidad a DTO
    private UserDTO mappingUserDTO(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    private Account mappingAccountEntity(AccountDTO accountDTO) {
        Account account = modelMapper.map(accountDTO, Account.class);
        return account;
    }

    private AccountDTO mappingAccountDTO(Account account) {
        AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
        return accountDTO;
    }

    public UserDTO findByDni(String dni) {
        User usuario = userRepository.findByDni(dni);
        if (usuario == null) return null;
        else return mappingUserDTO(usuario);
    }


    public UserDTO findByPhone(String phone) {
        User usuario = userRepository.findByPhone(phone);
        if (usuario == null) return null;
        else return mappingUserDTO(usuario);
    }

    public AccountDTO findByEmail(String email) {
        Account account = accountRepository.findByAccount(email);
        if (account == null) return null;
        else return mappingAccountDTO(account);
    }
}
