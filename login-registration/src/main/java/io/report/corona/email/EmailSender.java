package io.report.corona.email;

public interface EmailSender {
    void send(String to, String email);
}
