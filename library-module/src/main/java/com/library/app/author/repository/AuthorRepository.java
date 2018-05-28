package com.library.app.author.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.library.app.author.model.Author;

@Stateless
public class AuthorRepository {

    @PersistenceContext
    EntityManager em;

    public Author add(final Author author) {
        em.persist(author);
        return author;
    }

    public Author findById(final Long id) {
        if (id == null) {
            return null;
        }
        return em.find(Author.class, id);
    }

    public void update(final Author author) {
        em.merge(author);
    }

    public boolean existsById(final long id) {
        return em.createQuery("Select 1 From Author e where e.id = :id")
                .setParameter("id", id)
                .setMaxResults(1)
                .getResultList().size() > 0;
    }

}