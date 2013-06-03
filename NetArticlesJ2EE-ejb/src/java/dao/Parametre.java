/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Clem
 */
@Entity
@Table(name = "parametre", catalog = "net_articles", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametre.findAll", query = "SELECT p FROM Parametre p"),
    @NamedQuery(name = "Parametre.findByIdParametre", query = "SELECT p FROM Parametre p WHERE p.idParametre = :idParametre"),
    @NamedQuery(name = "Parametre.findByValparametre", query = "SELECT p FROM Parametre p WHERE p.valparametre = :valparametre"),
    @NamedQuery(name = "Parametre.findByLibparametre", query = "SELECT p FROM Parametre p WHERE p.libparametre = :libparametre")})
public class Parametre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_parametre")
    private String idParametre;
    @Column(name = "valparametre")
    private Integer valparametre;
    @Size(max = 80)
    @Column(name = "libparametre")
    private String libparametre;

    public Parametre() {
    }

    public Parametre(String idParametre) {
        this.idParametre = idParametre;
    }

    public String getIdParametre() {
        return idParametre;
    }

    public void setIdParametre(String idParametre) {
        this.idParametre = idParametre;
    }

    public Integer getValparametre() {
        return valparametre;
    }

    public void setValparametre(Integer valparametre) {
        this.valparametre = valparametre;
    }

    public String getLibparametre() {
        return libparametre;
    }

    public void setLibparametre(String libparametre) {
        this.libparametre = libparametre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametre != null ? idParametre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametre)) {
            return false;
        }
        Parametre other = (Parametre) object;
        if ((this.idParametre == null && other.idParametre != null) || (this.idParametre != null && !this.idParametre.equals(other.idParametre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metier.Parametre[ idParametre=" + idParametre + " ]";
    }
    
}
