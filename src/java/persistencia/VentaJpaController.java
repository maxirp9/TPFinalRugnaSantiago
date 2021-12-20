package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Cliente;
import logica.Empleado;
import logica.Servicio;
import logica.Paquete;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

public class VentaJpaController implements Serializable {
    
    public VentaJpaController() {
        emf = Persistence.createEntityManagerFactory("RugnaSantiagoTPFinalPU");
    }

    public VentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venta venta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente unCliente = venta.getUnCliente();
            if (unCliente != null) {
                unCliente = em.getReference(unCliente.getClass(), unCliente.getId());
                venta.setUnCliente(unCliente);
            }
            Empleado unEmpleado = venta.getUnEmpleado();
            if (unEmpleado != null) {
                unEmpleado = em.getReference(unEmpleado.getClass(), unEmpleado.getId());
                venta.setUnEmpleado(unEmpleado);
            }
            Servicio unServicio = venta.getUnServicio();
            if (unServicio != null) {
                unServicio = em.getReference(unServicio.getClass(), unServicio.getCodigo());
                venta.setUnServicio(unServicio);
            }
            Paquete unPaquete = venta.getUnPaquete();
            if (unPaquete != null) {
                unPaquete = em.getReference(unPaquete.getClass(), unPaquete.getCodigo());
                venta.setUnPaquete(unPaquete);
            }
            em.persist(venta);
            if (unCliente != null) {
                unCliente.getListaVentas().add(venta);
                unCliente = em.merge(unCliente);
            }
            if (unEmpleado != null) {
                unEmpleado.getListaVentas().add(venta);
                unEmpleado = em.merge(unEmpleado);
            }
            if (unServicio != null) {
                unServicio.getListaVentas().add(venta);
                unServicio = em.merge(unServicio);
            }
            if (unPaquete != null) {
                unPaquete.getListaVentas().add(venta);
                unPaquete = em.merge(unPaquete);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venta venta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta persistentVenta = em.find(Venta.class, venta.getNumero());
            Cliente unClienteOld = persistentVenta.getUnCliente();
            Cliente unClienteNew = venta.getUnCliente();
            Empleado unEmpleadoOld = persistentVenta.getUnEmpleado();
            Empleado unEmpleadoNew = venta.getUnEmpleado();
            Servicio unServicioOld = persistentVenta.getUnServicio();
            Servicio unServicioNew = venta.getUnServicio();
            Paquete unPaqueteOld = persistentVenta.getUnPaquete();
            Paquete unPaqueteNew = venta.getUnPaquete();
            if (unClienteNew != null) {
                unClienteNew = em.getReference(unClienteNew.getClass(), unClienteNew.getId());
                venta.setUnCliente(unClienteNew);
            }
            if (unEmpleadoNew != null) {
                unEmpleadoNew = em.getReference(unEmpleadoNew.getClass(), unEmpleadoNew.getId());
                venta.setUnEmpleado(unEmpleadoNew);
            }
            if (unServicioNew != null) {
                unServicioNew = em.getReference(unServicioNew.getClass(), unServicioNew.getCodigo());
                venta.setUnServicio(unServicioNew);
            }
            if (unPaqueteNew != null) {
                unPaqueteNew = em.getReference(unPaqueteNew.getClass(), unPaqueteNew.getCodigo());
                venta.setUnPaquete(unPaqueteNew);
            }
            venta = em.merge(venta);
            if (unClienteOld != null && !unClienteOld.equals(unClienteNew)) {
                unClienteOld.getListaVentas().remove(venta);
                unClienteOld = em.merge(unClienteOld);
            }
            if (unClienteNew != null && !unClienteNew.equals(unClienteOld)) {
                unClienteNew.getListaVentas().add(venta);
                unClienteNew = em.merge(unClienteNew);
            }
            if (unEmpleadoOld != null && !unEmpleadoOld.equals(unEmpleadoNew)) {
                unEmpleadoOld.getListaVentas().remove(venta);
                unEmpleadoOld = em.merge(unEmpleadoOld);
            }
            if (unEmpleadoNew != null && !unEmpleadoNew.equals(unEmpleadoOld)) {
                unEmpleadoNew.getListaVentas().add(venta);
                unEmpleadoNew = em.merge(unEmpleadoNew);
            }
            if (unServicioOld != null && !unServicioOld.equals(unServicioNew)) {
                unServicioOld.getListaVentas().remove(venta);
                unServicioOld = em.merge(unServicioOld);
            }
            if (unServicioNew != null && !unServicioNew.equals(unServicioOld)) {
                unServicioNew.getListaVentas().add(venta);
                unServicioNew = em.merge(unServicioNew);
            }
            if (unPaqueteOld != null && !unPaqueteOld.equals(unPaqueteNew)) {
                unPaqueteOld.getListaVentas().remove(venta);
                unPaqueteOld = em.merge(unPaqueteOld);
            }
            if (unPaqueteNew != null && !unPaqueteNew.equals(unPaqueteOld)) {
                unPaqueteNew.getListaVentas().add(venta);
                unPaqueteNew = em.merge(unPaqueteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = venta.getNumero();
                if (findVenta(id) == null) {
                    throw new NonexistentEntityException("The venta with id " + id + " no longer exists.");
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
            Venta venta;
            try {
                venta = em.getReference(Venta.class, id);
                venta.getNumero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venta with id " + id + " no longer exists.", enfe);
            }
            Cliente unCliente = venta.getUnCliente();
            if (unCliente != null) {
                unCliente.getListaVentas().remove(venta);
                unCliente = em.merge(unCliente);
            }
            Empleado unEmpleado = venta.getUnEmpleado();
            if (unEmpleado != null) {
                unEmpleado.getListaVentas().remove(venta);
                unEmpleado = em.merge(unEmpleado);
            }
            Servicio unServicio = venta.getUnServicio();
            if (unServicio != null) {
                unServicio.getListaVentas().remove(venta);
                unServicio = em.merge(unServicio);
            }
            Paquete unPaquete = venta.getUnPaquete();
            if (unPaquete != null) {
                unPaquete.getListaVentas().remove(venta);
                unPaquete = em.merge(unPaquete);
            }
            em.remove(venta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venta> findVentaEntities() {
        return findVentaEntities(true, -1, -1);
    }

    public List<Venta> findVentaEntities(int maxResults, int firstResult) {
        return findVentaEntities(false, maxResults, firstResult);
    }

    private List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta.class));
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

    public Venta findVenta(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta> rt = cq.from(Venta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
