package br.com.espatodea.espatodeAPI.adapter.http.controller;

import br.com.espatodea.espatodeAPI.core.model.HttpReturn;
import br.com.espatodea.espatodeAPI.core.service.NewsletterService;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.people.v1.PeopleService;
import com.google.api.services.people.v1.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
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

    @PostMapping("/add")
    public HttpReturn<Object> addEmailToNewsletter(@RequestParam String email, @RequestParam String name) throws IOException, GeneralSecurityException {
        PeopleService peopleService = service.getPeopleService();

        Person new_person = new Person();

        List names = new ArrayList<>();
        names.add(new Name().setGivenName(name));
        new_person.setNames(names);

//        ContactGroupMembership contactGroupMembership = new ContactGroupMembership().setContactGroupResourceName("newsletter");
//
//        List memberships = new ArrayList();
//        Membership membership = new Membership().setContactGroupMembership(contactGroupMembership);
//        memberships.add(membership);
//        new_person.setMemberships(memberships);

        Person created = peopleService.people().createContact(new_person).execute();

        return new HttpReturn<>(created, HttpStatus.OK);
    }
}
