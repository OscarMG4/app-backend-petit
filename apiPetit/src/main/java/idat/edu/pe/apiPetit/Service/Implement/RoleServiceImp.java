package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.RoleDTO;
import idat.edu.pe.apiPetit.Entity.Role;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.RoleRepository;
import idat.edu.pe.apiPetit.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

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
    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = mappingEntity(roleDTO);
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
    public RoleDTO showRolesById(Integer id) {
        Role roleId = roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Role", "id", id));
        return mappingDTO(roleId);
    }

    @Override
    public RoleDTO updateRole(RoleDTO roleDTO, Integer id) {
        Role roleId = roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Role", "id", id));

        roleId.setRole(roleDTO.getRole());

        Role roleUpdated = roleRepository.save(roleId);

        return mappingDTO(roleUpdated);
    }

    @Override
    public void deleteRole(Integer id) {
        Role roleId = roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Role", "id", id));
        roleRepository.delete(roleId);
    }
}
