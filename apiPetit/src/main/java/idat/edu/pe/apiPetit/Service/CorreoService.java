package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.EmailDTO;
import idat.edu.pe.apiPetit.Dto.PublicResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CorreoService {

    @Autowired
    private JavaMailSender javaMailSender;

    public PublicResponseDTO sendEmail(EmailDTO email) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setFrom("PET IT <PETITVETERINARIACHICLAYO@gmail.com>");
        mensaje.setTo(email.getTo());
        mensaje.setText(email.getBody());
        mensaje.setSubject(email.getSubject());

        javaMailSender.send(mensaje);
        System.out.println("Correo enviado");

        return new PublicResponseDTO(1100, "Correo enviado exitosamente", null);
    }
}
