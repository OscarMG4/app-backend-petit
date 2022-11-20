package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.AccountDTO;
import idat.edu.pe.apiPetit.Dto.RoleDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleService {

    RoleDTO createRole(Integer accountId, RoleDTO roleDTO);
    List<RoleDTO> showRoles();
    List<RoleDTO> showRolesByAccountId(@Param("idAccount") Integer idAccount);
    RoleDTO showRolesById(Integer accountId, Integer id);
    RoleDTO updateRole(Integer accountId, RoleDTO roleDTO, Integer id);
    void deleteRole(Integer accountId, Integer id);

}
