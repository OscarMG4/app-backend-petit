package idat.edu.pe.apiPetit.Dto;

public class EmailDTO {
    private String to;
    private String subject;
    private String body;

    public EmailDTO(){

    }

    public String getBody() {
        return body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setBody(String body) {
        this.body = body;
    }



    public void setSubject(String subject) {
        this.subject = subject;
    }
}
