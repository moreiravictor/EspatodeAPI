package br.com.espatodea.espatodeAPI.adapter.datastore.repository;

import br.com.espatodea.espatodeAPI.adapter.datastore.entity.NewsletterSubscriberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsletterSubscriberRepository extends JpaRepository<NewsletterSubscriberEntity, String> {

}
