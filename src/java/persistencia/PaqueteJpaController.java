/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Servicio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Paquete;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author maxi
 */
public class PaqueteJpaController implements Serializable {
    
    public PaqueteJpaController() {
        emf = Persistence.createEntityManagerFactory("RugnaSantiagoTPFinalPU");
    }

    public PaqueteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paquete paquete) {
        if (paquete.getListaServicios() == null) {
            paquete.setListaServicios(new ArrayList<Servicio>());
        }
        if (paquete.getListaVentas() == null) {
            paquete.setListaVentas(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Servicio> attachedListaServicios = new ArrayList<Servicio>();
            for (Servicio listaServiciosServicioToAttach : paquete.getListaServicios()) {
                listaServiciosServicioToAttach = em.getReference(listaServiciosServicioToAttach.getClass(), listaServiciosServicioToAttach.getCodigo());
                attachedListaServicios.add(listaServiciosServicioToAttach);
            }
            paquete.setListaServicios(attachedListaServicios);
            List<Venta> attachedListaVentas = new ArrayList<Venta>();
            for (Venta listaVentasVentaToAttach : paquete.getListaVentas()) {
                listaVentasVentaToAttach = em.getReference(listaVentasVentaToAttach.getClass(), listaVentasVentaToAttach.getNumero());
                attachedListaVentas.add(listaVentasVentaToAttach);
            }
            paquete.setListaVentas(attachedListaVentas);
            em.persist(paquete);
            for (Servicio listaServiciosServicio : paquete.getListaServicios()) {
                listaServiciosServicio.getListaPaquetes().add(paquete);
                listaServiciosServicio = em.merge(listaServiciosServicio);
            }
            for (Venta listaVentasVenta : paquete.getListaVentas()) {
                Paquete oldUnPaqueteOfListaVentasVenta = listaVentasVenta.getUnPaquete();
                listaVentasVenta.setUnPaquete(paquete);
                listaVentasVenta = em.merge(listaVentasVenta);
                if (oldUnPaqueteOfListaVentasVenta != null) {
                    oldUnPaqueteOfListaVentasVenta.getListaVentas().remove(listaVentasVenta);
                    oldUnPaqueteOfListaVentasVenta = em.merge(oldUnPaqueteOfListaVentasVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paquete paquete) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paquete persistentPaquete = em.find(Paquete.class, paquete.getCodigo());
            List<Servicio> listaServiciosOld = persistentPaquete.getListaServicios();
            List<Servicio> listaServiciosNew = paquete.getListaServicios();
            List<Venta> listaVentasOld = persistentPaquete.getListaVentas();
            List<Venta> listaVentasNew = paquete.getListaVentas();
            List<Servicio> attachedListaServiciosNew = new ArrayList<Servicio>();
            for (Servicio listaServiciosNewServicioToAttach : listaServiciosNew) {
                listaServiciosNewServicioToAttach = em.getReference(listaServiciosNewServicioToAttach.getClass(), listaServiciosNewServicioToAttach.getCodigo());
                attachedListaServiciosNew.add(listaServiciosNewServicioToAttach);
            }
            listaServiciosNew = attachedListaServiciosNew;
            paquete.setListaServicios(listaServiciosNew);
            List<Venta> attachedListaVentasNew = new ArrayList<Venta>();
            for (Venta listaVentasNewVentaToAttach : listaVentasNew) {
                listaVentasNewVentaToAttach = em.getReference(listaVentasNewVentaToAttach.getClass(), listaVentasNewVentaToAttach.getNumero());
                attachedListaVentasNew.add(listaVentasNewVentaToAttach);
            }
            listaVentasNew = attachedListaVentasNew;
            paquete.setListaVentas(listaVentasNew);
            paquete = em.merge(paquete);
            for (Servicio listaServiciosOldServicio : listaServiciosOld) {
                if (!listaServiciosNew.contains(listaServiciosOldServicio)) {
                    listaServiciosOldServicio.getListaPaquetes().remove(paquete);
                    listaServiciosOldServicio = em.merge(listaServiciosOldServicio);
                }
            }
            for (Servicio listaServiciosNewServicio : listaServiciosNew) {
                if (!listaServiciosOld.contains(listaServiciosNewServicio)) {
                    listaServiciosNewServicio.getListaPaquetes().add(paquete);
                    listaServiciosNewServicio = em.merge(listaServiciosNewServicio);
                }
            }
            for (Venta listaVentasOldVenta : listaVentasOld) {
                if (!listaVentasNew.contains(listaVentasOldVenta)) {
                    listaVentasOldVenta.setUnPaquete(null);
                    listaVentasOldVenta = em.merge(listaVentasOldVenta);
                }
            }
            for (Venta listaVentasNewVenta : listaVentasNew) {
                if (!listaVentasOld.contains(listaVentasNewVenta)) {
                    Paquete oldUnPaqueteOfListaVentasNewVenta = listaVentasNewVenta.getUnPaquete();
                    listaVentasNewVenta.setUnPaquete(paquete);
                    listaVentasNewVenta = em.merge(listaVentasNewVenta);
                    if (oldUnPaqueteOfListaVentasNewVenta != null && !oldUnPaqueteOfListaVentasNewVenta.equals(paquete)) {
                        oldUnPaqueteOfListaVentasNewVenta.getListaVentas().remove(listaVentasNewVenta);
                        oldUnPaqueteOfListaVentasNewVenta = em.merge(oldUnPaqueteOfListaVentasNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = paquete.getCodigo();
                if (findPaquete(id) == null) {
                    throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paquete paquete;
            try {
                paquete = em.getReference(Paquete.class, id);
                paquete.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.", enfe);
            }
            List<Servicio> listaServicios = paquete.getListaServicios();
            for (Servicio listaServiciosServicio : listaServicios) {
                listaServiciosServicio.getListaPaquetes().remove(paquete);
                listaServiciosServicio = em.merge(listaServiciosServicio);
            }
            List<Venta> listaVentas = paquete.getListaVentas();
            for (Venta listaVentasVenta : listaVentas) {
                listaVentasVenta.setUnPaquete(null);
                listaVentasVenta = em.merge(listaVentasVenta);
            }
            em.remove(paquete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paquete> findPaqueteEntities() {
        return findPaqueteEntities(true, -1, -1);
    }

    public List<Paquete> findPaqueteEntities(int maxResults, int firstResult) {
        return findPaqueteEntities(false, maxResults, firstResult);
    }

    private List<Paquete> findPaqueteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paquete.class));
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

    public Paquete findPaquete(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paquete.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaqueteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paquete> rt = cq.from(Paquete.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
