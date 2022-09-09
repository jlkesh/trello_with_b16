package uz.jl.trello.trello.services.mail;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * @author "Elmurodov Javohir"
 * @since 09/09/22/20:06 (Friday)
 * trello/IntelliJ IDEA
 */

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final Configuration configuration;
    private final JavaMailSender javaMailSender;

    @Value("${spring.application.name}")
    private String appName;
    @Value("${spring.application.mail}")
    private String appMail;


    @Override
    public void send(String to, String subject, String mailBody) throws MessagingException {
        send(to, subject, mailBody, false);
    }

    @Override
    public void sendActivationLink(String to, Map<String, Object> models) {
        try {
            String emailContent = processTemplate("activation.ftlh", models);
            String subject = "Activate your account for %s".formatted(appName);
            send(to, subject, emailContent, true);
        } catch (IOException | TemplateException | MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Async
    void send(String to, String subject, String emailContent, boolean html) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject(subject);
        helper.setFrom(appMail);
        helper.setTo(to);
        helper.setText(emailContent, html);
        javaMailSender.send(mimeMessage);
    }

    private String processTemplate(String templateName, Map<String, Object> model) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        Template template = configuration.getTemplate(templateName);
        template.process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}
