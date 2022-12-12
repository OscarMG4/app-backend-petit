package idat.edu.pe.apiPetit.Controller;

import idat.edu.pe.apiPetit.Dto.EmailDTO;
import idat.edu.pe.apiPetit.Service.CorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/email")
public class EmailRestController {

    @Autowired
    private CorreoService service;

    @RequestMapping(path = "/send", method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailDTO emailDTO) {
        if (emailDTO != null) {
            return new ResponseEntity<>(service.sendEmail(emailDTO), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
