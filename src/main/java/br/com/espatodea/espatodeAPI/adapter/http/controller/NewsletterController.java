package br.com.espatodea.espatodeAPI.adapter.http.controller;

import br.com.espatodea.espatodeAPI.core.model.HttpReturn;
import br.com.espatodea.espatodeAPI.core.model.NewsletterSubscriber;
import br.com.espatodea.espatodeAPI.core.service.NewsletterService;
import br.com.espatodea.espatodeAPI.core.service.NewsletterSubscriberService;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.people.v1.PeopleService;
import com.google.api.services.people.v1.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@CrossOrigin
@RestController
@RequestMapping("news")
public class NewsletterController {

    @Autowired
    private NewsletterSubscriberService subService = new NewsletterSubscriberService();
    private NewsletterService service = new NewsletterService();
    private static final String source_email = "espatodea3@gmail.com";
    private static final String newsletter_group = "7518cc498cabfbfa";

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

    @PostMapping("/add")
    public HttpReturn<Object> addEmailToNewsletter(@RequestParam String email, @RequestParam String name) throws IOException, GeneralSecurityException {
        subService.persist(NewsletterSubscriber.builder().email(email).name(name).build());

        PeopleService peopleService = service.getPeopleService();

        Person new_person = new Person().setNames(Collections.singletonList(new Name().setGivenName(name)));
        Person created = peopleService.people().createContact(new_person).execute();

        List people = Collections.singletonList(created.getResourceName());
        ModifyContactGroupMembersRequest request = new ModifyContactGroupMembersRequest().setResourceNamesToAdd(people);
        peopleService.contactGroups().members().modify("contactGroups/"+newsletter_group, request).execute();

        return new HttpReturn<>(created, HttpStatus.OK);
    }

}
