package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.AccountTypeDTO;

import java.util.List;

public interface AccountTypeService {

    AccountTypeDTO createAccountType(AccountTypeDTO accountTypeDTO);
    List<AccountTypeDTO> showAccountType();
    AccountTypeDTO showAccountTypeId(Integer id);
    AccountTypeDTO updateAccountType(AccountTypeDTO accountTypeDTO, Integer id);
    void deleteAccountType(Integer id);

}
