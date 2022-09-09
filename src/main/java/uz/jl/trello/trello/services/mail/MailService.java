package uz.jl.trello.trello.services.mail;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * @author "Elmurodov Javohir"
 * @since 09/09/22/20:06 (Friday)
 * trello/IntelliJ IDEA
 */
public interface MailService {

    void send(String to, String subject, String mailBody) throws MessagingException;

    void sendActivationLink(String to, Map<String, Object> models) ;
}
