package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.PetTypeDTO;

import java.util.List;

public interface PetTypeService {
    PetTypeDTO createTypeService(PetTypeDTO petTypeDTO);
    List<PetTypeDTO> showTypesServices();
    PetTypeDTO showTypeServiceById(Integer id);
    PetTypeDTO updateTypeService(PetTypeDTO petTypeDTO, Integer id);
    void deleteTypeService(Integer id);
}
