package br.com.espatodea.espatodeAPI.core.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class NewsletterSubscriber {

    private String email;

    private String name;
}
