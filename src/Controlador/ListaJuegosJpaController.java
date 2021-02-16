/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import Controlador.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Cuenta;
import Entidades.ListaJuegos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ordon
 */
public class ListaJuegosJpaController implements Serializable {

    public ListaJuegosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("sTgamingPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ListaJuegos listaJuegos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cuenta cuenta = listaJuegos.getCuenta();
            if (cuenta != null) {
                cuenta = em.getReference(cuenta.getClass(), cuenta.getIdCuenta());
                listaJuegos.setCuenta(cuenta);
            }
            em.persist(listaJuegos);
            if (cuenta != null) {
                cuenta.getListaJuegosCollection().add(listaJuegos);
                cuenta = em.merge(cuenta);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findListaJuegos(listaJuegos.getIdListajuegos()) != null) {
                throw new PreexistingEntityException("ListaJuegos " + listaJuegos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ListaJuegos listaJuegos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ListaJuegos persistentListaJuegos = em.find(ListaJuegos.class, listaJuegos.getIdListajuegos());
            Cuenta cuentaOld = persistentListaJuegos.getCuenta();
            Cuenta cuentaNew = listaJuegos.getCuenta();
            if (cuentaNew != null) {
                cuentaNew = em.getReference(cuentaNew.getClass(), cuentaNew.getIdCuenta());
                listaJuegos.setCuenta(cuentaNew);
            }
            listaJuegos = em.merge(listaJuegos);
            if (cuentaOld != null && !cuentaOld.equals(cuentaNew)) {
                cuentaOld.getListaJuegosCollection().remove(listaJuegos);
                cuentaOld = em.merge(cuentaOld);
            }
            if (cuentaNew != null && !cuentaNew.equals(cuentaOld)) {
                cuentaNew.getListaJuegosCollection().add(listaJuegos);
                cuentaNew = em.merge(cuentaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = listaJuegos.getIdListajuegos();
                if (findListaJuegos(id) == null) {
                    throw new NonexistentEntityException("The listaJuegos with id " + id + " no longer exists.");
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
            ListaJuegos listaJuegos;
            try {
                listaJuegos = em.getReference(ListaJuegos.class, id);
                listaJuegos.getIdListajuegos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The listaJuegos with id " + id + " no longer exists.", enfe);
            }
            Cuenta cuenta = listaJuegos.getCuenta();
            if (cuenta != null) {
                cuenta.getListaJuegosCollection().remove(listaJuegos);
                cuenta = em.merge(cuenta);
            }
            em.remove(listaJuegos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ListaJuegos> findListaJuegosEntities() {
        return findListaJuegosEntities(true, -1, -1);
    }

    public List<ListaJuegos> findListaJuegosEntities(int maxResults, int firstResult) {
        return findListaJuegosEntities(false, maxResults, firstResult);
    }

    private List<ListaJuegos> findListaJuegosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ListaJuegos.class));
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

    public ListaJuegos findListaJuegos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ListaJuegos.class, id);
        } finally {
            em.close();
        }
    }

    public int getListaJuegosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ListaJuegos> rt = cq.from(ListaJuegos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
