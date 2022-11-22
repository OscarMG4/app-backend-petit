package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.AccountTypeDTO;
import idat.edu.pe.apiPetit.Entity.AccountType;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.AccountTypeRepository;
import idat.edu.pe.apiPetit.Service.AccountTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountTypeServiceImp implements AccountTypeService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Override
    public AccountTypeDTO createAccountType(AccountTypeDTO accountTypeDTO) {

        AccountType accountType = mappingEntity(accountTypeDTO);
        AccountType newAccountType = accountTypeRepository.save(accountType);
        AccountTypeDTO accountTypeResponse = mappingDTO(newAccountType);

        return accountTypeResponse;
    }


    @Override
    public List<AccountTypeDTO> showAccountType() {
        List<AccountType> accountTypes = accountTypeRepository.findAll();
        return accountTypes.stream().map(accountType -> mappingDTO(accountType)).collect(Collectors.toList());
    }

    @Override
    public AccountTypeDTO showAccountTypeId(Integer id) {
        AccountType accountTypeId = accountTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AccountType", "id", id));
        AccountTypeDTO accountTypeResponse = mappingDTO(accountTypeId);
        return accountTypeResponse;
    }

    @Override
    public AccountTypeDTO updateAccountType(AccountTypeDTO accountTypeDTO, Integer id) {
        AccountType accountTypeId = accountTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AccountType", "id", id));

        accountTypeId.setAccountType(accountTypeDTO.getAccountType());

        AccountType newAccountType = accountTypeRepository.save(accountTypeId);
        AccountTypeDTO accountUpdate = mappingDTO(newAccountType);

        return accountUpdate;
    }

    @Override
    public void deleteAccountType(Integer id) {
        AccountType accountTypeId = accountTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AccountType", "id", id));
        accountTypeRepository.delete(accountTypeId);

    }

    private AccountType mappingEntity(AccountTypeDTO accountTypeDTO){
        AccountType accountType = modelMapper.map(accountTypeDTO, AccountType.class);
        return accountType;
    }

    private AccountTypeDTO mappingDTO(AccountType accountType){
        AccountTypeDTO accountTypeDTO = modelMapper.map(accountType, AccountTypeDTO.class);
        return accountTypeDTO;
    }

}
