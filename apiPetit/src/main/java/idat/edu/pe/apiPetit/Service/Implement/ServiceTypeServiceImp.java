package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.ServiceTypeDTO;
import idat.edu.pe.apiPetit.Entity.ServiceType;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.ServiceTypeRepository;
import idat.edu.pe.apiPetit.Service.ServiceTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceTypeServiceImp implements ServiceTypeService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public ServiceTypeDTO createServiceType(ServiceTypeDTO serviceTypeDTO) {
        ServiceType serviceType = mappingEntity(serviceTypeDTO);
        ServiceType newServiceType = serviceTypeRepository.save(serviceType);
        ServiceTypeDTO serviceTypeResponse = mappingDTO(newServiceType);

        return serviceTypeResponse;
    }

    @Override
    public List<ServiceTypeDTO> showServicesTypes() {
        List<ServiceType> servicesTypes = serviceTypeRepository.findAll();
        return servicesTypes.stream().map(serviceType -> mappingDTO(serviceType)).collect(Collectors.toList());
    }

    @Override
    public ServiceTypeDTO showServiceTypeById(Integer id) {
        ServiceType serviceTypeId = serviceTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ServiceType", "id", id));
        ServiceTypeDTO serviceTypeResponse = mappingDTO(serviceTypeId);

        return serviceTypeResponse;
    }

    @Override
    public ServiceTypeDTO updateServiceType(ServiceTypeDTO serviceTypeDTO, Integer id) {
        ServiceType serviceTypeId = serviceTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ServiceType", "id", id));

        serviceTypeId.setServiceType(serviceTypeDTO.getServiceType());

        ServiceType serviceTypeUpdated = serviceTypeRepository.save(serviceTypeId);
        ServiceTypeDTO serviceTypeResponse = mappingDTO(serviceTypeUpdated);

        return serviceTypeResponse;
    }

    @Override
    public void deleteServiceType(Integer id) {
        ServiceType serviceTypeId = serviceTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ServiceType", "id", id));
        serviceTypeRepository.delete(serviceTypeId);
    }

    private ServiceType mappingEntity(ServiceTypeDTO serviceTypeDTO){
        ServiceType serviceType = modelMapper.map(serviceTypeDTO, ServiceType.class);
        return serviceType;
    }

    private ServiceTypeDTO mappingDTO(ServiceType serviceType){
        ServiceTypeDTO serviceTypeDTO = modelMapper.map(serviceType, ServiceTypeDTO.class);
        return serviceTypeDTO;
    }
}
