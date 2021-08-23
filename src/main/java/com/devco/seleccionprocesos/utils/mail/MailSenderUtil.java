package com.devco.seleccionprocesos.utils.mail;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailSenderUtil {
    private final JavaMailSender mailSender;
    @Autowired
    public MailSenderUtil(JavaMailSender javaMailSender){this.mailSender = javaMailSender;}

    public boolean sendSimpleMessage(String to, String subject, String text){

        boolean send = false;
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try{
            helper.setTo(to);
            helper.setText(text, true);
            helper.setSubject(subject);
            mailSender.send(message);
            send = true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return send;
    }
}
