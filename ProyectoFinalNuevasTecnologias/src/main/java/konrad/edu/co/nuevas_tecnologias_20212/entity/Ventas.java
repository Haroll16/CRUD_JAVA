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
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v"),
    @NamedQuery(name = "Ventas.findByCodigoVenta", query = "SELECT v FROM Ventas v WHERE v.codigoVenta = :codigoVenta"),
    @NamedQuery(name = "Ventas.findByCedulaCliente", query = "SELECT v FROM Ventas v WHERE v.cedulaCliente = :cedulaCliente"),
    @NamedQuery(name = "Ventas.findByCedulaUsuario", query = "SELECT v FROM Ventas v WHERE v.cedulaUsuario = :cedulaUsuario"),
    @NamedQuery(name = "Ventas.findByIvaventa", query = "SELECT v FROM Ventas v WHERE v.ivaventa = :ivaventa"),
    @NamedQuery(name = "Ventas.findByTotalVenta", query = "SELECT v FROM Ventas v WHERE v.totalVenta = :totalVenta"),
    @NamedQuery(name = "Ventas.findByValorVenta", query = "SELECT v FROM Ventas v WHERE v.valorVenta = :valorVenta")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo_venta")
    private Long codigoVenta;
    @Column(name = "cedula_cliente")
    private Long cedulaCliente;
    @Column(name = "cedula_usuario")
    private Long cedulaUsuario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ivaventa")
    private Double ivaventa;
    @Column(name = "total_venta")
    private Double totalVenta;
    @Column(name = "valor_venta")
    private Double valorVenta;

    public Ventas() {
    }

    public Ventas(Long codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Long getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Long codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Long getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Long cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Long getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(Long cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    public Double getIvaventa() {
        return ivaventa;
    }

    public void setIvaventa(Double ivaventa) {
        this.ivaventa = ivaventa;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Double valorVenta) {
        this.valorVenta = valorVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoVenta != null ? codigoVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.codigoVenta == null && other.codigoVenta != null) || (this.codigoVenta != null && !this.codigoVenta.equals(other.codigoVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "konrad.edu.co.nuevas_tecnologias_20212.entidad.Ventas[ codigoVenta=" + codigoVenta + " ]";
    }
    
}

