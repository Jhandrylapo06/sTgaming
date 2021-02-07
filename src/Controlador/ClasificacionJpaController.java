/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import Controlador.exceptions.PreexistingEntityException;
import Instancias.Clasificacion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Instancias.Juego;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Usuario iTC
 */
public class ClasificacionJpaController implements Serializable {

    public ClasificacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clasificacion clasificacion) throws PreexistingEntityException, Exception {
        if (clasificacion.getJuegoCollection() == null) {
            clasificacion.setJuegoCollection(new ArrayList<Juego>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Juego> attachedJuegoCollection = new ArrayList<Juego>();
            for (Juego juegoCollectionJuegoToAttach : clasificacion.getJuegoCollection()) {
                juegoCollectionJuegoToAttach = em.getReference(juegoCollectionJuegoToAttach.getClass(), juegoCollectionJuegoToAttach.getIdJuego());
                attachedJuegoCollection.add(juegoCollectionJuegoToAttach);
            }
            clasificacion.setJuegoCollection(attachedJuegoCollection);
            em.persist(clasificacion);
            for (Juego juegoCollectionJuego : clasificacion.getJuegoCollection()) {
                Clasificacion oldClasificacionOfJuegoCollectionJuego = juegoCollectionJuego.getClasificacion();
                juegoCollectionJuego.setClasificacion(clasificacion);
                juegoCollectionJuego = em.merge(juegoCollectionJuego);
                if (oldClasificacionOfJuegoCollectionJuego != null) {
                    oldClasificacionOfJuegoCollectionJuego.getJuegoCollection().remove(juegoCollectionJuego);
                    oldClasificacionOfJuegoCollectionJuego = em.merge(oldClasificacionOfJuegoCollectionJuego);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClasificacion(clasificacion.getNombreclasi()) != null) {
                throw new PreexistingEntityException("Clasificacion " + clasificacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Clasificacion clasificacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clasificacion persistentClasificacion = em.find(Clasificacion.class, clasificacion.getNombreclasi());
            Collection<Juego> juegoCollectionOld = persistentClasificacion.getJuegoCollection();
            Collection<Juego> juegoCollectionNew = clasificacion.getJuegoCollection();
            Collection<Juego> attachedJuegoCollectionNew = new ArrayList<Juego>();
            for (Juego juegoCollectionNewJuegoToAttach : juegoCollectionNew) {
                juegoCollectionNewJuegoToAttach = em.getReference(juegoCollectionNewJuegoToAttach.getClass(), juegoCollectionNewJuegoToAttach.getIdJuego());
                attachedJuegoCollectionNew.add(juegoCollectionNewJuegoToAttach);
            }
            juegoCollectionNew = attachedJuegoCollectionNew;
            clasificacion.setJuegoCollection(juegoCollectionNew);
            clasificacion = em.merge(clasificacion);
            for (Juego juegoCollectionOldJuego : juegoCollectionOld) {
                if (!juegoCollectionNew.contains(juegoCollectionOldJuego)) {
                    juegoCollectionOldJuego.setClasificacion(null);
                    juegoCollectionOldJuego = em.merge(juegoCollectionOldJuego);
                }
            }
            for (Juego juegoCollectionNewJuego : juegoCollectionNew) {
                if (!juegoCollectionOld.contains(juegoCollectionNewJuego)) {
                    Clasificacion oldClasificacionOfJuegoCollectionNewJuego = juegoCollectionNewJuego.getClasificacion();
                    juegoCollectionNewJuego.setClasificacion(clasificacion);
                    juegoCollectionNewJuego = em.merge(juegoCollectionNewJuego);
                    if (oldClasificacionOfJuegoCollectionNewJuego != null && !oldClasificacionOfJuegoCollectionNewJuego.equals(clasificacion)) {
                        oldClasificacionOfJuegoCollectionNewJuego.getJuegoCollection().remove(juegoCollectionNewJuego);
                        oldClasificacionOfJuegoCollectionNewJuego = em.merge(oldClasificacionOfJuegoCollectionNewJuego);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = clasificacion.getNombreclasi();
                if (findClasificacion(id) == null) {
                    throw new NonexistentEntityException("The clasificacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clasificacion clasificacion;
            try {
                clasificacion = em.getReference(Clasificacion.class, id);
                clasificacion.getNombreclasi();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clasificacion with id " + id + " no longer exists.", enfe);
            }
            Collection<Juego> juegoCollection = clasificacion.getJuegoCollection();
            for (Juego juegoCollectionJuego : juegoCollection) {
                juegoCollectionJuego.setClasificacion(null);
                juegoCollectionJuego = em.merge(juegoCollectionJuego);
            }
            em.remove(clasificacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Clasificacion> findClasificacionEntities() {
        return findClasificacionEntities(true, -1, -1);
    }

    public List<Clasificacion> findClasificacionEntities(int maxResults, int firstResult) {
        return findClasificacionEntities(false, maxResults, firstResult);
    }

    private List<Clasificacion> findClasificacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Clasificacion.class));
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

    public Clasificacion findClasificacion(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clasificacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getClasificacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Clasificacion> rt = cq.from(Clasificacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
