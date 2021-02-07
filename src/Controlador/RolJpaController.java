/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import Entidades.Rol;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Usuario;
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
public class RolJpaController implements Serializable {

    public RolJpaController() {
        this.emf = Persistence.createEntityManagerFactory("sTgamingPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rol rol) {
        if (rol.getUsuarioCollection() == null) {
            rol.setUsuarioCollection(new ArrayList<Usuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Usuario> attachedUsuarioCollection = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionUsuarioToAttach : rol.getUsuarioCollection()) {
                usuarioCollectionUsuarioToAttach = em.getReference(usuarioCollectionUsuarioToAttach.getClass(), usuarioCollectionUsuarioToAttach.getIdusuario());
                attachedUsuarioCollection.add(usuarioCollectionUsuarioToAttach);
            }
            rol.setUsuarioCollection(attachedUsuarioCollection);
            em.persist(rol);
            for (Usuario usuarioCollectionUsuario : rol.getUsuarioCollection()) {
                Rol oldRoluserOfUsuarioCollectionUsuario = usuarioCollectionUsuario.getRoluser();
                usuarioCollectionUsuario.setRoluser(rol);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
                if (oldRoluserOfUsuarioCollectionUsuario != null) {
                    oldRoluserOfUsuarioCollectionUsuario.getUsuarioCollection().remove(usuarioCollectionUsuario);
                    oldRoluserOfUsuarioCollectionUsuario = em.merge(oldRoluserOfUsuarioCollectionUsuario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rol rol) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol persistentRol = em.find(Rol.class, rol.getIdrol());
            Collection<Usuario> usuarioCollectionOld = persistentRol.getUsuarioCollection();
            Collection<Usuario> usuarioCollectionNew = rol.getUsuarioCollection();
            Collection<Usuario> attachedUsuarioCollectionNew = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionNewUsuarioToAttach : usuarioCollectionNew) {
                usuarioCollectionNewUsuarioToAttach = em.getReference(usuarioCollectionNewUsuarioToAttach.getClass(), usuarioCollectionNewUsuarioToAttach.getIdusuario());
                attachedUsuarioCollectionNew.add(usuarioCollectionNewUsuarioToAttach);
            }
            usuarioCollectionNew = attachedUsuarioCollectionNew;
            rol.setUsuarioCollection(usuarioCollectionNew);
            rol = em.merge(rol);
            for (Usuario usuarioCollectionOldUsuario : usuarioCollectionOld) {
                if (!usuarioCollectionNew.contains(usuarioCollectionOldUsuario)) {
                    usuarioCollectionOldUsuario.setRoluser(null);
                    usuarioCollectionOldUsuario = em.merge(usuarioCollectionOldUsuario);
                }
            }
            for (Usuario usuarioCollectionNewUsuario : usuarioCollectionNew) {
                if (!usuarioCollectionOld.contains(usuarioCollectionNewUsuario)) {
                    Rol oldRoluserOfUsuarioCollectionNewUsuario = usuarioCollectionNewUsuario.getRoluser();
                    usuarioCollectionNewUsuario.setRoluser(rol);
                    usuarioCollectionNewUsuario = em.merge(usuarioCollectionNewUsuario);
                    if (oldRoluserOfUsuarioCollectionNewUsuario != null && !oldRoluserOfUsuarioCollectionNewUsuario.equals(rol)) {
                        oldRoluserOfUsuarioCollectionNewUsuario.getUsuarioCollection().remove(usuarioCollectionNewUsuario);
                        oldRoluserOfUsuarioCollectionNewUsuario = em.merge(oldRoluserOfUsuarioCollectionNewUsuario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = rol.getIdrol();
                if (findRol(id) == null) {
                    throw new NonexistentEntityException("The rol with id " + id + " no longer exists.");
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
            Rol rol;
            try {
                rol = em.getReference(Rol.class, id);
                rol.getIdrol();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rol with id " + id + " no longer exists.", enfe);
            }
            Collection<Usuario> usuarioCollection = rol.getUsuarioCollection();
            for (Usuario usuarioCollectionUsuario : usuarioCollection) {
                usuarioCollectionUsuario.setRoluser(null);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
            }
            em.remove(rol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rol> findRolEntities() {
        return findRolEntities(true, -1, -1);
    }

    public List<Rol> findRolEntities(int maxResults, int firstResult) {
        return findRolEntities(false, maxResults, firstResult);
    }

    private List<Rol> findRolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rol.class));
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

    public Rol findRol(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rol.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rol> rt = cq.from(Rol.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
