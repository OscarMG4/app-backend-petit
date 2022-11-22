package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.PetTypeDTO;
import idat.edu.pe.apiPetit.Entity.PetType;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.PetTypeRepository;
import idat.edu.pe.apiPetit.Service.PetTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetTypeServiceImp implements PetTypeService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PetTypeRepository petTypeRepository;


    @Override
    public PetTypeDTO createTypeService(PetTypeDTO petTypeDTO) {
        PetType petType = mappingEntity(petTypeDTO);
        PetType newPetType = petTypeRepository.save(petType);
        PetTypeDTO PetTypeResponse = mappingDTO(newPetType);

        return PetTypeResponse;
    }

    @Override
    public List<PetTypeDTO> showTypesServices() {
        List<PetType> petTypes = petTypeRepository.findAll();
        return petTypes.stream().map(petType -> mappingDTO(petType)).collect(Collectors.toList());
    }

    @Override
    public PetTypeDTO showTypeServiceById(Integer id) {
        PetType petTypeId = petTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("PetType", "id", id));
        return mappingDTO(petTypeId);
    }

    @Override
    public PetTypeDTO updateTypeService(PetTypeDTO petTypeDTO, Integer id) {
        PetType petTypeId = petTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("PetType", "id", id));
        petTypeId.setPetType(petTypeDTO.getPetType());
        PetType petTypeUpdate = petTypeRepository.save(petTypeId);

        return mappingDTO(petTypeUpdate);
    }

    @Override
    public void deleteTypeService(Integer id) {
        PetType petTypeId = petTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("PetType", "id", id));
        petTypeRepository.delete(petTypeId);
    }

    private PetTypeDTO mappingDTO(PetType petType){
        PetTypeDTO petTypeDTO = modelMapper.map(petType, PetTypeDTO.class);
        return petTypeDTO;
    }

    private PetType mappingEntity(PetTypeDTO petTypeDTO){
        PetType petType = modelMapper.map(petTypeDTO, PetType.class);
        return petType;
    }

}
