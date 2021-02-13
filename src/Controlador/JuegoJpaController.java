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
import Entidades.Valoracion;
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
            Valoracion valoracion = juego.getValoracion();
            if (valoracion != null) {
                valoracion = em.getReference(valoracion.getClass(), valoracion.getIdvaloracion());
                juego.setValoracion(valoracion);
            }
            em.persist(juego);
            if (clasificacion != null) {
                clasificacion.getJuegoCollection().add(juego);
                clasificacion = em.merge(clasificacion);
            }
            if (valoracion != null) {
                valoracion.getJuegoCollection().add(juego);
                valoracion = em.merge(valoracion);
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
            Valoracion valoracionOld = persistentJuego.getValoracion();
            Valoracion valoracionNew = juego.getValoracion();
            if (clasificacionNew != null) {
                clasificacionNew = em.getReference(clasificacionNew.getClass(), clasificacionNew.getIdclasificacion());
                juego.setClasificacion(clasificacionNew);
            }
            if (valoracionNew != null) {
                valoracionNew = em.getReference(valoracionNew.getClass(), valoracionNew.getIdvaloracion());
                juego.setValoracion(valoracionNew);
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
            if (valoracionOld != null && !valoracionOld.equals(valoracionNew)) {
                valoracionOld.getJuegoCollection().remove(juego);
                valoracionOld = em.merge(valoracionOld);
            }
            if (valoracionNew != null && !valoracionNew.equals(valoracionOld)) {
                valoracionNew.getJuegoCollection().add(juego);
                valoracionNew = em.merge(valoracionNew);
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
            Valoracion valoracion = juego.getValoracion();
            if (valoracion != null) {
                valoracion.getJuegoCollection().remove(juego);
                valoracion = em.merge(valoracion);
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
    public List<Entidades.Juego> Buscarjuego(String nombreb){
    
        Entidades.Juego jbuscado;
        EntityManager em= getEntityManager();
        Query query=em.createQuery("SELECT j FROM Juego j WHERE j.nombre LIKE :nombre");
        query.setParameter("nombre" ,nombreb+"%");
        List<Entidades.Juego> buscado= query.getResultList();
        return buscado;
    }
    
}
