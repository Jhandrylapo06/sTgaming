/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import Entidades.Valoracion;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ordon
 */
public class ValoracionJpaController implements Serializable {

    public ValoracionJpaController() {
        this.emf = Persistence.createEntityManagerFactory("sTgamingPU");

    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Valoracion valoracion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(valoracion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Valoracion valoracion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            valoracion = em.merge(valoracion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = valoracion.getIdvaloracion();
                if (findValoracion(id) == null) {
                    throw new NonexistentEntityException("The valoracion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Valoracion valoracion;
            try {
                valoracion = em.getReference(Valoracion.class, id);
                valoracion.getIdvaloracion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The valoracion with id " + id + " no longer exists.", enfe);
            }
            em.remove(valoracion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Valoracion> findValoracionEntities() {
        return findValoracionEntities(true, -1, -1);
    }

    public List<Valoracion> findValoracionEntities(int maxResults, int firstResult) {
        return findValoracionEntities(false, maxResults, firstResult);
    }

    private List<Valoracion> findValoracionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Valoracion.class));
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

    public Valoracion findValoracion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Valoracion.class, id);
        } finally {
            em.close();
        }
    }

    public int getValoracionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Valoracion> rt = cq.from(Valoracion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
