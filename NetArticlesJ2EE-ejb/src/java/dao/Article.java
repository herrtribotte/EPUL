/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Michael
 */
@Entity
@Table(name = "article", catalog = "net_articles", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findByIdArticle", query = "SELECT a FROM Article a WHERE a.idArticle = :idArticle"),
    @NamedQuery(name = "Article.findByTitre", query = "SELECT a FROM Article a WHERE a.titre = :titre"),
    @NamedQuery(name = "Article.findByResume", query = "SELECT a FROM Article a WHERE a.resume = :resume"),
    @NamedQuery(name = "Article.findByPrix", query = "SELECT a FROM Article a WHERE a.prix = :prix"),
    @NamedQuery(name = "Article.findByDateArticle", query = "SELECT a FROM Article a WHERE a.dateArticle = :dateArticle"),
    @NamedQuery(name = "Article.findByFichier", query = "SELECT a FROM Article a WHERE a.fichier = :fichier")})
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_article")
    private Integer idArticle;
    @Size(max = 250)
    @Column(name = "titre")
    private String titre;
    @Size(max = 2048)
    @Column(name = "resume")
    private String resume;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prix")
    private BigDecimal prix;
    @Column(name = "date_article")
    @Temporal(TemporalType.DATE)
    private Date dateArticle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fichier")
    private String fichier;
    @JoinColumn(name = "id_domaine", referencedColumnName = "id_domaine")
    @ManyToOne(optional = false)
    private Domaine idDomaine;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private Collection<Achete> acheteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private Collection<Redige> redigeCollection;

    public Article() {
    }

    public Article(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public Article(Integer idArticle, String fichier) {
        this.idArticle = idArticle;
        this.fichier = fichier;
    }

    public Integer getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Date getDateArticle() {
        return dateArticle;
    }

    public void setDateArticle(Date dateArticle) {
        this.dateArticle = dateArticle;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public Domaine getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(Domaine idDomaine) {
        this.idDomaine = idDomaine;
    }

    @XmlTransient
    public Collection<Achete> getAcheteCollection() {
        return acheteCollection;
    }

    public void setAcheteCollection(Collection<Achete> acheteCollection) {
        this.acheteCollection = acheteCollection;
    }

    @XmlTransient
    public Collection<Redige> getRedigeCollection() {
        return redigeCollection;
    }

    public void setRedigeCollection(Collection<Redige> redigeCollection) {
        this.redigeCollection = redigeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticle != null ? idArticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.idArticle == null && other.idArticle != null) || (this.idArticle != null && !this.idArticle.equals(other.idArticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metier.Article[ idArticle=" + idArticle + " ]";
    }
    
}
