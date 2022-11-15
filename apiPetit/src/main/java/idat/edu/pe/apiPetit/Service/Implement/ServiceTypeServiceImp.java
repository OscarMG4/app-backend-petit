package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.ServiceTypeDTO;
import idat.edu.pe.apiPetit.Entity.ServiceType;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.ServiceTypeRepository;
import idat.edu.pe.apiPetit.Service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceTypeServiceImp implements ServiceTypeService {

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    private ServiceType mapingEntity(ServiceTypeDTO serviceTypeDTO){
        ServiceType serviceType = new ServiceType();

        serviceType.setIdServiceType(serviceTypeDTO.getId());
        serviceType.setServiceType(serviceTypeDTO.getServiceType());

        return serviceType;
    }

    private ServiceTypeDTO mapingDTO(ServiceType serviceType){
        ServiceTypeDTO serviceTypeDTO = new ServiceTypeDTO();

        serviceTypeDTO.setId(serviceType.getIdServiceType());
        serviceTypeDTO.setServiceType(serviceType.getServiceType());

        return serviceTypeDTO;
    }

    @Override
    public ServiceTypeDTO createServiceType(ServiceTypeDTO serviceTypeDTO) {
        ServiceType serviceType = mapingEntity(serviceTypeDTO);
        ServiceType newServiceType = serviceTypeRepository.save(serviceType);
        ServiceTypeDTO serviceTypeResponse = mapingDTO(newServiceType);

        return serviceTypeResponse;
    }

    @Override
    public List<ServiceTypeDTO> showServicesTypes() {
        List<ServiceType> servicesTypes = serviceTypeRepository.findAll();
        return servicesTypes.stream().map(serviceType -> mapingDTO(serviceType)).collect(Collectors.toList());
    }

    @Override
    public ServiceTypeDTO showServiceTypeById(Integer id) {
        ServiceType serviceTypeId = serviceTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ServiceType", "id", id));
        ServiceTypeDTO serviceTypeResponse = mapingDTO(serviceTypeId);

        return serviceTypeResponse;
    }

    @Override
    public ServiceTypeDTO updateServiceType(ServiceTypeDTO serviceTypeDTO, Integer id) {
        ServiceType serviceTypeId = serviceTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ServiceType", "id", id));

        serviceTypeId.setServiceType(serviceTypeDTO.getServiceType());

        ServiceType serviceTypeUpdated = serviceTypeRepository.save(serviceTypeId);
        ServiceTypeDTO serviceTypeResponse = mapingDTO(serviceTypeUpdated);

        return serviceTypeResponse;
    }

    @Override
    public void deleteServiceType(Integer id) {
        ServiceType serviceTypeId = serviceTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ServiceType", "id", id));
        serviceTypeRepository.delete(serviceTypeId);
    }
}
