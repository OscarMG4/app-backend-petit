package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.AccountTypeDTO;
import idat.edu.pe.apiPetit.Entity.AccountType;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.AccountTypeRepository;
import idat.edu.pe.apiPetit.Service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountTypeServiceImp implements AccountTypeService {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    private AccountType mapingEntity(AccountTypeDTO accountTypeDTO){
        AccountType accountType = new AccountType();

        accountType.setIdAccountType(accountTypeDTO.getId());
        accountType.setAccountType(accountTypeDTO.getAccountType());

        return accountType;
    }

    private AccountTypeDTO mapingDTO(AccountType accountType){
        AccountTypeDTO accountTypeDTO = new AccountTypeDTO();

        accountTypeDTO.setId(accountType.getIdAccountType());
        accountTypeDTO.setAccountType(accountType.getAccountType());

        return accountTypeDTO;
    }

    @Override
    public AccountTypeDTO createAccountType(AccountTypeDTO accountTypeDTO) {

        AccountType accountType = mapingEntity(accountTypeDTO);
        AccountType newAccountType = accountTypeRepository.save(accountType);
        AccountTypeDTO accountTypeResponse = mapingDTO(newAccountType);

        return accountTypeResponse;
    }

    @Override
    public List<AccountTypeDTO> showAccountType() {
        List<AccountType> accountTypes = accountTypeRepository.findAll();
        return accountTypes.stream().map(accountType -> mapingDTO(accountType)).collect(Collectors.toList());
    }

    @Override
    public AccountTypeDTO showAccountTypeId(Integer id) {
        AccountType accountTypeId = accountTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AccountType", "id", id));
        AccountTypeDTO accountTypeResponse = mapingDTO(accountTypeId);
        return accountTypeResponse;
    }

    @Override
    public AccountTypeDTO updateAccountType(AccountTypeDTO accountTypeDTO, Integer id) {
        AccountType accountTypeId = accountTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AccountType", "id", id));

        accountTypeId.setAccountType(accountTypeDTO.getAccountType());

        AccountType newAccountType = accountTypeRepository.save(accountTypeId);
        AccountTypeDTO accountUpdate = mapingDTO(newAccountType);

        return accountUpdate;
    }

    @Override
    public void deleteAccountType(Integer id) {
        AccountType accountTypeId = accountTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AccountType", "id", id));
        accountTypeRepository.delete(accountTypeId);

    }
}
