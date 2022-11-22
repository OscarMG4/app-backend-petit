package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.StateDTO;
import idat.edu.pe.apiPetit.Entity.State;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.StateRepository;
import idat.edu.pe.apiPetit.Service.StateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateServiceImp implements StateService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StateRepository stateRepository;

    @Override
    public StateDTO createState(StateDTO stateDTO) {
        State state = mappingEntity(stateDTO);
        State newState = stateRepository.save(state);
        StateDTO stateResponse = mappingDTO(newState);

        return stateResponse;
    }

    @Override
    public List<StateDTO> showStates() {
        List<State> listStates = stateRepository.findAll();
        return listStates.stream().map(state -> mappingDTO(state)).collect(Collectors.toList());
    }

    @Override
    public StateDTO showStateById(Integer id) {
        State stateId = stateRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("State", "id", id));
        return mappingDTO(stateId);
    }

    @Override
    public StateDTO updateState(StateDTO stateDTO, Integer id) {
        State stateId = stateRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("State", "id", id));

        stateId.setState(stateDTO.getState());

        State stateUpdated = stateRepository.save(stateId);

        return mappingDTO(stateUpdated);
    }

    @Override
    public void deleteState(Integer id) {
        State stateId = stateRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("State", "id", id));
        stateRepository.delete(stateId);
    }

    private StateDTO mappingDTO(State state){
        StateDTO stateDTO = modelMapper.map(state, StateDTO.class);
        return stateDTO;
    }

    private State mappingEntity(StateDTO stateDTO){
        State state = modelMapper.map(stateDTO, State.class);
        return state;
    }
}
