/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Juego;
import Entidades.Valoracion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario iTC
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
        if (valoracion.getJuegoCollection() == null) {
            valoracion.setJuegoCollection(new ArrayList<Juego>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Juego> attachedJuegoCollection = new ArrayList<Juego>();
            for (Juego juegoCollectionJuegoToAttach : valoracion.getJuegoCollection()) {
                juegoCollectionJuegoToAttach = em.getReference(juegoCollectionJuegoToAttach.getClass(), juegoCollectionJuegoToAttach.getIdJuego());
                attachedJuegoCollection.add(juegoCollectionJuegoToAttach);
            }
            valoracion.setJuegoCollection(attachedJuegoCollection);
            em.persist(valoracion);
            for (Juego juegoCollectionJuego : valoracion.getJuegoCollection()) {
                Valoracion oldValoracionOfJuegoCollectionJuego = juegoCollectionJuego.getValoracion();
                juegoCollectionJuego.setValoracion(valoracion);
                juegoCollectionJuego = em.merge(juegoCollectionJuego);
                if (oldValoracionOfJuegoCollectionJuego != null) {
                    oldValoracionOfJuegoCollectionJuego.getJuegoCollection().remove(juegoCollectionJuego);
                    oldValoracionOfJuegoCollectionJuego = em.merge(oldValoracionOfJuegoCollectionJuego);
                }
            }
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
            Valoracion persistentValoracion = em.find(Valoracion.class, valoracion.getIdvaloracion());
            Collection<Juego> juegoCollectionOld = persistentValoracion.getJuegoCollection();
            Collection<Juego> juegoCollectionNew = valoracion.getJuegoCollection();
            Collection<Juego> attachedJuegoCollectionNew = new ArrayList<Juego>();
            for (Juego juegoCollectionNewJuegoToAttach : juegoCollectionNew) {
                juegoCollectionNewJuegoToAttach = em.getReference(juegoCollectionNewJuegoToAttach.getClass(), juegoCollectionNewJuegoToAttach.getIdJuego());
                attachedJuegoCollectionNew.add(juegoCollectionNewJuegoToAttach);
            }
            juegoCollectionNew = attachedJuegoCollectionNew;
            valoracion.setJuegoCollection(juegoCollectionNew);
            valoracion = em.merge(valoracion);
            for (Juego juegoCollectionOldJuego : juegoCollectionOld) {
                if (!juegoCollectionNew.contains(juegoCollectionOldJuego)) {
                    juegoCollectionOldJuego.setValoracion(null);
                    juegoCollectionOldJuego = em.merge(juegoCollectionOldJuego);
                }
            }
            for (Juego juegoCollectionNewJuego : juegoCollectionNew) {
                if (!juegoCollectionOld.contains(juegoCollectionNewJuego)) {
                    Valoracion oldValoracionOfJuegoCollectionNewJuego = juegoCollectionNewJuego.getValoracion();
                    juegoCollectionNewJuego.setValoracion(valoracion);
                    juegoCollectionNewJuego = em.merge(juegoCollectionNewJuego);
                    if (oldValoracionOfJuegoCollectionNewJuego != null && !oldValoracionOfJuegoCollectionNewJuego.equals(valoracion)) {
                        oldValoracionOfJuegoCollectionNewJuego.getJuegoCollection().remove(juegoCollectionNewJuego);
                        oldValoracionOfJuegoCollectionNewJuego = em.merge(oldValoracionOfJuegoCollectionNewJuego);
                    }
                }
            }
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
            Collection<Juego> juegoCollection = valoracion.getJuegoCollection();
            for (Juego juegoCollectionJuego : juegoCollection) {
                juegoCollectionJuego.setValoracion(null);
                juegoCollectionJuego = em.merge(juegoCollectionJuego);
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
