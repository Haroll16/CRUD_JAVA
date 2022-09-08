package konrad.edu.co.nuevas_tecnologias_20212.entity;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCedulaCliente", query = "SELECT c FROM Cliente c WHERE c.cedulaCliente = :cedulaCliente"),
    @NamedQuery(name = "Cliente.findByDireccionCliente", query = "SELECT c FROM Cliente c WHERE c.direccionCliente = :direccionCliente"),
    @NamedQuery(name = "Cliente.findByEmailCliente", query = "SELECT c FROM Cliente c WHERE c.emailCliente = :emailCliente"),
    @NamedQuery(name = "Cliente.findByNombreCliente", query = "SELECT c FROM Cliente c WHERE c.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "Cliente.findByTelefonoCliente", query = "SELECT c FROM Cliente c WHERE c.telefonoCliente = :telefonoCliente")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cedula_cliente")
    private Long cedulaCliente;
    @Column(name = "direccion_cliente")
    private String direccionCliente;
    @Column(name = "email_cliente")
    private String emailCliente;
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Column(name = "telefono_cliente")
    private String telefonoCliente;

    public Cliente() {
    }

    public Cliente(Long cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Long getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Long cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaCliente != null ? cedulaCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cedulaCliente == null && other.cedulaCliente != null) || (this.cedulaCliente != null && !this.cedulaCliente.equals(other.cedulaCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "konrad.edu.co.nuevas_tecnologias_20212.entidad.Cliente[ cedulaCliente=" + cedulaCliente + " ]";
    }
    
}

