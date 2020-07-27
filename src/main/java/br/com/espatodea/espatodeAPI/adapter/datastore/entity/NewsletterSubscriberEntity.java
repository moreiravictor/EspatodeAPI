package br.com.espatodea.espatodeAPI.adapter.datastore.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name="subscribers")
public class NewsletterSubscriberEntity {

    @Id
    @Column(name="email")
    private String email;

    @Column(name="name")
    private String name;

}
