package entities;

import entities.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Sep 27, 2016 
 */
public class PersonEntityJpaController implements Serializable {

    public PersonEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PersonEntity personEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(personEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PersonEntity personEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            personEntity = em.merge(personEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = personEntity.getId();
                if (findPersonEntity(id) == null) {
                    throw new NonexistentEntityException("The personEntity with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PersonEntity personEntity;
            try {
                personEntity = em.getReference(PersonEntity.class, id);
                personEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The personEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(personEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PersonEntity> findPersonEntityEntities() {
        return findPersonEntityEntities(true, -1, -1);
    }

    public List<PersonEntity> findPersonEntityEntities(int maxResults, int firstResult) {
        return findPersonEntityEntities(false, maxResults, firstResult);
    }

    private List<PersonEntity> findPersonEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PersonEntity.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public PersonEntity findPersonEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PersonEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PersonEntity> rt = cq.from(PersonEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
