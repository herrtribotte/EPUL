/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Clem
 */
@Entity
@Table(name = "domaine", catalog = "net_articles", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domaine.findAll", query = "SELECT d FROM Domaine d"),
    @NamedQuery(name = "Domaine.findByIdDomaine", query = "SELECT d FROM Domaine d WHERE d.idDomaine = :idDomaine"),
    @NamedQuery(name = "Domaine.findByLibdomaine", query = "SELECT d FROM Domaine d WHERE d.libdomaine = :libdomaine")})
public class Domaine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_domaine")
    private Integer idDomaine;
    @Size(max = 80)
    @Column(name = "libdomaine")
    private String libdomaine;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDomaine")
    private Collection<Article> articleCollection;

    public Domaine() {
    }

    public Domaine(Integer idDomaine) {
        this.idDomaine = idDomaine;
    }

    public Integer getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(Integer idDomaine) {
        this.idDomaine = idDomaine;
    }

    public String getLibdomaine() {
        return libdomaine;
    }

    public void setLibdomaine(String libdomaine) {
        this.libdomaine = libdomaine;
    }

    @XmlTransient
    public Collection<Article> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(Collection<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDomaine != null ? idDomaine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domaine)) {
            return false;
        }
        Domaine other = (Domaine) object;
        if ((this.idDomaine == null && other.idDomaine != null) || (this.idDomaine != null && !this.idDomaine.equals(other.idDomaine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metier.Domaine[ idDomaine=" + idDomaine + " ]";
    }
    
}
