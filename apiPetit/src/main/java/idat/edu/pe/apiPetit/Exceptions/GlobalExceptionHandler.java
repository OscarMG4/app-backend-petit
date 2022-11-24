package idat.edu.pe.apiPetit.Exceptions;

import idat.edu.pe.apiPetit.Dto.DetailsError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<DetailsError> ResourceNotFoundExceptionManage(ResourceNotFoundException exception, WebRequest webRequest){
        DetailsError detailsError = new DetailsError(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(detailsError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<DetailsError> AppExceptionManage(AppException exception, WebRequest webRequest){
        DetailsError detailsError = new DetailsError(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(detailsError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
        public ResponseEntity<DetailsError> ExceptionManage(Exception exception, WebRequest webRequest){
        DetailsError detailsError = new DetailsError(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(detailsError, HttpStatus.BAD_REQUEST);
    }

}
