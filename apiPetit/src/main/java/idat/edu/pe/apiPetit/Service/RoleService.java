package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.RoleDTO;

import java.util.List;

public interface RoleService {

    RoleDTO createRole(RoleDTO roleDTO);
    List<RoleDTO> showRoles();
    RoleDTO showRolesById(Integer id);
    RoleDTO updateRole(RoleDTO roleDTO, Integer id);
    void deleteRole(Integer id);

}
