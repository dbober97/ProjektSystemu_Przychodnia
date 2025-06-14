/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.przychodnia;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author Dorota
 */
@Entity
@Table(name = "LEKI")
@NamedQueries({
    @NamedQuery(name = "Leki.findAll", query = "SELECT l FROM Leki l"),
    @NamedQuery(name = "Leki.findById", query = "SELECT l FROM Leki l WHERE l.id = :id"),
    @NamedQuery(name = "Leki.findByNazwa", query = "SELECT l FROM Leki l WHERE l.nazwa = :nazwa"),
    @NamedQuery(name = "Leki.findByDawkowanie", query = "SELECT l FROM Leki l WHERE l.dawkowanie = :dawkowanie")})
public class Leki implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAZWA")
    private String nazwa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DAWKOWANIE")
    private String dawkowanie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lekiId")
    private Collection<AsocReceptaLek> asocReceptaLekCollection;

    public Leki() {
    }

    public Leki(BigDecimal id) {
        this.id = id;
    }

    public Leki(BigDecimal id, String nazwa, String dawkowanie) {
        this.id = id;
        this.nazwa = nazwa;
        this.dawkowanie = dawkowanie;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getDawkowanie() {
        return dawkowanie;
    }

    public void setDawkowanie(String dawkowanie) {
        this.dawkowanie = dawkowanie;
    }

    public Collection<AsocReceptaLek> getAsocReceptaLekCollection() {
        return asocReceptaLekCollection;
    }

    public void setAsocReceptaLekCollection(Collection<AsocReceptaLek> asocReceptaLekCollection) {
        this.asocReceptaLekCollection = asocReceptaLekCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Leki)) {
            return false;
        }
        Leki other = (Leki) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.przychodnia.Leki[ id=" + id + " ]";
    }
    
}
