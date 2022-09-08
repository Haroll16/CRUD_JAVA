package konrad.edu.co.nuevas_tecnologias_20212.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "proveedor")
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByNitProveedor", query = "SELECT p FROM Proveedor p WHERE p.nitProveedor = :nitProveedor"),
    @NamedQuery(name = "Proveedor.findByCiudadProveedor", query = "SELECT p FROM Proveedor p WHERE p.ciudadProveedor = :ciudadProveedor"),
    @NamedQuery(name = "Proveedor.findByDireccionProveedor", query = "SELECT p FROM Proveedor p WHERE p.direccionProveedor = :direccionProveedor"),
    @NamedQuery(name = "Proveedor.findByNombreProveedor", query = "SELECT p FROM Proveedor p WHERE p.nombreProveedor = :nombreProveedor"),
    @NamedQuery(name = "Proveedor.findByTelefonoProveedor", query = "SELECT p FROM Proveedor p WHERE p.telefonoProveedor = :telefonoProveedor")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nit_proveedor")
    private Long nitProveedor;
    @Column(name = "ciudad_proveedor")
    private String ciudadProveedor;
    @Column(name = "direccion_proveedor")
    private String direccionProveedor;
    @Basic(optional = false)
    @Column(name = "nombre_proveedor")
    private String nombreProveedor;
    @Column(name = "telefono_proveedor")
    private String telefonoProveedor;

    public Proveedor() {
    }

    public Proveedor(Long nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public Proveedor(Long nitProveedor, String nombreProveedor) {
        this.nitProveedor = nitProveedor;
        this.nombreProveedor = nombreProveedor;
    }

    public Long getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(Long nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public String getCiudadProveedor() {
        return ciudadProveedor;
    }

    public void setCiudadProveedor(String ciudadProveedor) {
        this.ciudadProveedor = ciudadProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nitProveedor != null ? nitProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.nitProveedor == null && other.nitProveedor != null) || (this.nitProveedor != null && !this.nitProveedor.equals(other.nitProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "konrad.edu.co.nuevas_tecnologias_20212.entidad.Proveedor[ nitProveedor=" + nitProveedor + " ]";
    }
    
}
