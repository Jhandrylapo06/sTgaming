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
import Entidades.Clasificacion;
import Entidades.Juego;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ordon
 */
public class JuegoJpaController implements Serializable {

    public JuegoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("sTgamingPU");

    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Juego juego) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clasificacion clasificacion = juego.getClasificacion();
            if (clasificacion != null) {
                clasificacion = em.getReference(clasificacion.getClass(), clasificacion.getIdclasificacion());
                juego.setClasificacion(clasificacion);
            }
            em.persist(juego);
            if (clasificacion != null) {
                clasificacion.getJuegoCollection().add(juego);
                clasificacion = em.merge(clasificacion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Juego juego) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Juego persistentJuego = em.find(Juego.class, juego.getIdJuego());
            Clasificacion clasificacionOld = persistentJuego.getClasificacion();
            Clasificacion clasificacionNew = juego.getClasificacion();
            if (clasificacionNew != null) {
                clasificacionNew = em.getReference(clasificacionNew.getClass(), clasificacionNew.getIdclasificacion());
                juego.setClasificacion(clasificacionNew);
            }
            juego = em.merge(juego);
            if (clasificacionOld != null && !clasificacionOld.equals(clasificacionNew)) {
                clasificacionOld.getJuegoCollection().remove(juego);
                clasificacionOld = em.merge(clasificacionOld);
            }
            if (clasificacionNew != null && !clasificacionNew.equals(clasificacionOld)) {
                clasificacionNew.getJuegoCollection().add(juego);
                clasificacionNew = em.merge(clasificacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = juego.getIdJuego();
                if (findJuego(id) == null) {
                    throw new NonexistentEntityException("The juego with id " + id + " no longer exists.");
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
            Juego juego;
            try {
                juego = em.getReference(Juego.class, id);
                juego.getIdJuego();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The juego with id " + id + " no longer exists.", enfe);
            }
            Clasificacion clasificacion = juego.getClasificacion();
            if (clasificacion != null) {
                clasificacion.getJuegoCollection().remove(juego);
                clasificacion = em.merge(clasificacion);
            }
            em.remove(juego);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Juego> findJuegoEntities() {
        return findJuegoEntities(true, -1, -1);
    }

    public List<Juego> findJuegoEntities(int maxResults, int firstResult) {
        return findJuegoEntities(false, maxResults, firstResult);
    }

    private List<Juego> findJuegoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Juego.class));
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

    public Juego findJuego(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Juego.class, id);
        } finally {
            em.close();
        }
    }

    public int getJuegoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Juego> rt = cq.from(Juego.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
