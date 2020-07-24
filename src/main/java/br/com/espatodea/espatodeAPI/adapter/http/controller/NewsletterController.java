package br.com.espatodea.espatodeAPI.adapter.http.controller;

import br.com.espatodea.espatodeAPI.core.model.HttpReturn;
import br.com.espatodea.espatodeAPI.core.service.NewsletterService;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.security.GeneralSecurityException;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@CrossOrigin
@RestController
@RequestMapping("news")
public class NewsletterController {

    private NewsletterService service = new NewsletterService();
    private static final String source_email = "espatodea3@gmail.com";

    @PostMapping("/auth")
    public HttpReturn<Object> auth() throws IOException, GeneralSecurityException {
        return service.auth();
    }

    @PostMapping
    public HttpReturn<Object> sendEmail(@RequestParam List<String> emails, @RequestBody String bodyText, @RequestParam String subject) throws MessagingException, IOException, GeneralSecurityException {
        MimeMessage email = service.createEmail(source_email, emails, subject, bodyText);
        Message message = service.createMessage(email);
        Gmail gmailService = service.getGmailervice();
        message = gmailService.users().messages().send(source_email, message).execute();

        return new HttpReturn<>(message, HttpStatus.OK);
    }
}
