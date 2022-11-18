package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.AccountDTO;
import idat.edu.pe.apiPetit.Entity.Account;
import idat.edu.pe.apiPetit.Entity.AccountType;
import idat.edu.pe.apiPetit.Entity.Role;
import idat.edu.pe.apiPetit.Entity.User;
import idat.edu.pe.apiPetit.Exceptions.AppException;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.AccountRepository;
import idat.edu.pe.apiPetit.Repository.AccountTypeRepository;
import idat.edu.pe.apiPetit.Repository.RoleRepository;
import idat.edu.pe.apiPetit.Repository.UserRepository;
import idat.edu.pe.apiPetit.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private RoleRepository roleRepository;

    private Account mapingEntity(AccountDTO accountDTO){
        Account account = new Account();

        account.setIdAccount(accountDTO.getId());
        account.setEmail(accountDTO.getEmail());
        account.setPass(accountDTO.getPass());

        return account;
    }

    private AccountDTO mapingDTO(Account account){
        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setId(account.getIdAccount());
        accountDTO.setEmail(account.getEmail());
        accountDTO.setPass(account.getPass());

        return accountDTO;
    }

    @Override
    public AccountDTO createAccount(Integer accountTypeId, Integer userId, Integer roleId, AccountDTO accountDTO) {
        Account account = mapingEntity(accountDTO);
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        AccountType accountType = accountTypeRepository.findById(accountTypeId).orElseThrow(()-> new ResourceNotFoundException("AccountType", "id", accountTypeId));
        Role role = roleRepository.findById(roleId).orElseThrow(()-> new ResourceNotFoundException("Role", "id", roleId));

        account.setUser(user);
        account.setAccountType(accountType);
        account.setRole(role);
        Account newAccount = accountRepository.save(account);
        AccountDTO accountResponse = mapingDTO(newAccount);

        return accountResponse;
    }

    @Override
    public List<AccountDTO> showAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(account -> mapingDTO(account)).collect(Collectors.toList());
    }

    @Override
    public List<AccountDTO> showAccountsByUserId(Integer userId) {
        List<Account> accounts = accountRepository.findByUserId(userId);
        return accounts.stream().map(account -> mapingDTO(account)).collect(Collectors.toList());
    }

    @Override
    public AccountDTO showAccountById(Integer userId, Integer accountId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));

        if(!account.getUser().getIdUser().equals(user.getIdUser())){
            throw new AppException(HttpStatus.BAD_REQUEST, "La cuenta no existe!");
        }

        return mapingDTO(account);
    }

    @Override
    public AccountDTO updateAccount(Integer userId, Integer accountId, AccountDTO accountDTO) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));

        if(!account.getUser().getIdUser().equals(user.getIdUser())){
            throw new AppException(HttpStatus.BAD_REQUEST, "La cuenta no existe!");
        }

        account.setEmail(accountDTO.getEmail());
        account.setPass(accountDTO.getPass());

        Account accountUpdate = accountRepository.save(account);

        return mapingDTO(accountUpdate);
    }

    @Override
    public void deleteAccount(Integer userId, Integer accountId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));

        if(!account.getUser().getIdUser().equals(user.getIdUser())){
            throw new AppException(HttpStatus.BAD_REQUEST, "La cuenta no existe!");
        }

        accountRepository.delete(account);
    }

}
