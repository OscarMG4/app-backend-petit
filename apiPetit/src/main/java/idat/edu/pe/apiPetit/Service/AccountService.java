package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.AccountDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountService {
    AccountDTO createAccount(Integer accountTypeId, Integer userId, Integer roleId, AccountDTO accountDTO);
    List<AccountDTO> showAccounts();
    List<AccountDTO> showAccountsByUserId(@Param("idUser") Integer userId);
    AccountDTO showAccountById(Integer userId, Integer accountId);
    AccountDTO updateAccount(Integer userId, Integer accountId, AccountDTO accountDTO);
    void deleteAccount(Integer userId, Integer accountId);
}
