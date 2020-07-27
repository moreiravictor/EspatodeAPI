package br.com.espatodea.espatodeAPI.adapter.datastore.mapper;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.NewsletterSubscriberEntity;
import br.com.espatodea.espatodeAPI.core.model.NewsletterSubscriber;

public class NewsletterSubscriberMapper {

    public static NewsletterSubscriberEntity marshall(NewsletterSubscriber model) {
        return NewsletterSubscriberEntity.builder()
                .email(model.getEmail())
                .name(model.getName())
                .build();
    }

    public static NewsletterSubscriber unmarshall(NewsletterSubscriberEntity model) {
        return NewsletterSubscriber.builder()
                .email(model.getEmail())
                .name(model.getName())
                .build();
    }
}
