package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.ServiceTypeDTO;

import java.util.List;

public interface ServiceTypeService {

    ServiceTypeDTO createServiceType(ServiceTypeDTO serviceTypeDTO);
    List<ServiceTypeDTO> showServicesTypes();
    ServiceTypeDTO showServiceTypeById(Integer id);
    ServiceTypeDTO updateServiceType(ServiceTypeDTO serviceTypeDTO, Integer id);
    void deleteServiceType(Integer id);

}
