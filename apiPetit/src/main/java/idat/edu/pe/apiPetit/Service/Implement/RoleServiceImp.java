package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.RoleDTO;
import idat.edu.pe.apiPetit.Entity.Account;
import idat.edu.pe.apiPetit.Entity.Role;
import idat.edu.pe.apiPetit.Exceptions.AppException;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.AccountRepository;
import idat.edu.pe.apiPetit.Repository.RoleRepository;
import idat.edu.pe.apiPetit.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountRepository accountRepository;

    private RoleDTO mappingDTO(Role role){
        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId(role.getIdRole());
        roleDTO.setRole(role.getRole());

        return roleDTO;
    }

    private Role mappingEntity(RoleDTO roleDTO){
        Role role = new Role();

        role.setIdRole(roleDTO.getId());
        role.setRole(roleDTO.getRole());

        return role;
    }

    @Override
    public RoleDTO createRole(Integer accountId, RoleDTO roleDTO) {
        Role role = mappingEntity(roleDTO);
        Account account = accountRepository.findById(accountId).orElseThrow(()-> new ResourceNotFoundException("Account", "id", accountId));
        role.setAccount(account);
        Role newRole = roleRepository.save(role);
        RoleDTO roleResponse = mappingDTO(newRole);

        return roleResponse;
    }

    @Override
    public List<RoleDTO> showRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(role -> mappingDTO(role)).collect(Collectors.toList());
    }

    @Override
    public List<RoleDTO> showRolesByAccountId(Integer idAccount) {
        List<Role> roles = roleRepository.findByAccountId(idAccount);
        return roles.stream().map(role -> mappingDTO(role)).collect(Collectors.toList());
    }

    @Override
    public RoleDTO showRolesById(Integer accountId, Integer id) {
        Account account = accountRepository.findById(accountId).orElseThrow(()-> new ResourceNotFoundException("Account", "id", accountId));
        Role role = roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Role", "id", id));

        if(!role.getAccount().getIdAccount().equals(account.getIdAccount())){
            throw new AppException(HttpStatus.BAD_REQUEST, "El rol no existe!");
        }

        return mappingDTO(role);
    }

    @Override
    public RoleDTO updateRole(Integer accountId, RoleDTO roleDTO, Integer id) {
        Account account = accountRepository.findById(accountId).orElseThrow(()-> new ResourceNotFoundException("Account", "id", accountId));
        Role role = roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Role", "id", id));

        if(!role.getAccount().getIdAccount().equals(account.getIdAccount())){
            throw new AppException(HttpStatus.BAD_REQUEST, "El rol no existe!");
        }

        role.setRole(roleDTO.getRole());
        Role roleUpdated = roleRepository.save(role);

        return mappingDTO(roleUpdated);
    }

    @Override
    public void deleteRole(Integer accountId, Integer id) {
        Account account = accountRepository.findById(accountId).orElseThrow(()-> new ResourceNotFoundException("Account", "id", accountId));
        Role role = roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Role", "id", id));

        if(!role.getAccount().getIdAccount().equals(account.getIdAccount())){
            throw new AppException(HttpStatus.BAD_REQUEST, "El rol no existe!");
        }

        roleRepository.delete(role);
    }
}
