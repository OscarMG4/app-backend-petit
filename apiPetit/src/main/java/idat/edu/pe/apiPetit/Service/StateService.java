package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.StateDTO;

import java.util.List;

public interface StateService {

    StateDTO createState(StateDTO stateDTO);
    List<StateDTO> showStates();
    StateDTO showStateById(Integer id);
    StateDTO updateState(StateDTO stateDTO, Integer id);
    void deleteState(Integer id);

}
