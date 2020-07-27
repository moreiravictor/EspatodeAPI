package br.com.espatodea.espatodeAPI.core.service;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.NewsletterSubscriberEntity;
import br.com.espatodea.espatodeAPI.adapter.datastore.mapper.NewsletterSubscriberMapper;
import br.com.espatodea.espatodeAPI.adapter.datastore.repository.NewsletterSubscriberRepository;
import br.com.espatodea.espatodeAPI.core.model.NewsletterSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsletterSubscriberService {

    @Autowired
    NewsletterSubscriberRepository repo;

    public NewsletterSubscriber persist(NewsletterSubscriber model) {
        NewsletterSubscriberEntity entity = NewsletterSubscriberMapper.marshall(model);
        NewsletterSubscriberEntity res = repo.save(entity);
        return NewsletterSubscriberMapper.unmarshall(res);
    }
}
