package services;

public class Message {
    String subject;
    String body;

    User sender;
    User receptionist;

    public Message(User sender, User receptionist) {
        this.subject = "Test Email - " + System.currentTimeMillis();
        this.body = "This is a test email sent by an automated script.";
        this.sender = sender;
        this.receptionist = receptionist;
    }
    public Message(String body, String subject, User sender, User receptionist) {
        this.subject = subject;
        this.body = body;
        this.sender = sender;
        this.receptionist = receptionist;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getAddress(){return receptionist.getUserName();}
}
