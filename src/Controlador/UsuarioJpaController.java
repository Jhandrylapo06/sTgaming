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
import Entidades.Cuenta;
import Entidades.Rol;
import Entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario iTC
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController() {
        this.emf = Persistence.createEntityManagerFactory("sTgamingPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cuenta cuentauser = usuario.getCuentauser();
            if (cuentauser != null) {
                cuentauser = em.getReference(cuentauser.getClass(), cuentauser.getIdCuenta());
                usuario.setCuentauser(cuentauser);
            }
            Rol roluser = usuario.getRoluser();
            if (roluser != null) {
                roluser = em.getReference(roluser.getClass(), roluser.getIdrol());
                usuario.setRoluser(roluser);
            }
            em.persist(usuario);
            if (cuentauser != null) {
                cuentauser.getUsuarioCollection().add(usuario);
                cuentauser = em.merge(cuentauser);
            }
            if (roluser != null) {
                roluser.getUsuarioCollection().add(usuario);
                roluser = em.merge(roluser);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdusuario());
            Cuenta cuentauserOld = persistentUsuario.getCuentauser();
            Cuenta cuentauserNew = usuario.getCuentauser();
            Rol roluserOld = persistentUsuario.getRoluser();
            Rol roluserNew = usuario.getRoluser();
            if (cuentauserNew != null) {
                cuentauserNew = em.getReference(cuentauserNew.getClass(), cuentauserNew.getIdCuenta());
                usuario.setCuentauser(cuentauserNew);
            }
            if (roluserNew != null) {
                roluserNew = em.getReference(roluserNew.getClass(), roluserNew.getIdrol());
                usuario.setRoluser(roluserNew);
            }
            usuario = em.merge(usuario);
            if (cuentauserOld != null && !cuentauserOld.equals(cuentauserNew)) {
                cuentauserOld.getUsuarioCollection().remove(usuario);
                cuentauserOld = em.merge(cuentauserOld);
            }
            if (cuentauserNew != null && !cuentauserNew.equals(cuentauserOld)) {
                cuentauserNew.getUsuarioCollection().add(usuario);
                cuentauserNew = em.merge(cuentauserNew);
            }
            if (roluserOld != null && !roluserOld.equals(roluserNew)) {
                roluserOld.getUsuarioCollection().remove(usuario);
                roluserOld = em.merge(roluserOld);
            }
            if (roluserNew != null && !roluserNew.equals(roluserOld)) {
                roluserNew.getUsuarioCollection().add(usuario);
                roluserNew = em.merge(roluserNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getIdusuario();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdusuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            Cuenta cuentauser = usuario.getCuentauser();
            if (cuentauser != null) {
                cuentauser.getUsuarioCollection().remove(usuario);
                cuentauser = em.merge(cuentauser);
            }
            Rol roluser = usuario.getRoluser();
            if (roluser != null) {
                roluser.getUsuarioCollection().remove(usuario);
                roluser = em.merge(roluser);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
