package idat.edu.pe.apiPetit.Dto;

import java.util.Date;

public class DetailsError {

    private Date timesTamp;
    private String message;
    private String details;

    public DetailsError() {
    }

    public DetailsError(Date timesTamp, String message, String details) {
        this.timesTamp = timesTamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(Date timesTamp) {
        this.timesTamp = timesTamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
