/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.przychodnia;

import jakarta.persistence.Basic;
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
@Table(name = "CHOROBY")
@NamedQueries({
    @NamedQuery(name = "Choroby.findAll", query = "SELECT c FROM Choroby c"),
    @NamedQuery(name = "Choroby.findById", query = "SELECT c FROM Choroby c WHERE c.id = :id"),
    @NamedQuery(name = "Choroby.findByNazwa", query = "SELECT c FROM Choroby c WHERE c.nazwa = :nazwa"),
    @NamedQuery(name = "Choroby.findByKodChoroby", query = "SELECT c FROM Choroby c WHERE c.kodChoroby = :kodChoroby")})
public class Choroby implements Serializable {

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
    @Size(min = 1, max = 20)
    @Column(name = "KOD_CHOROBY")
    private String kodChoroby;
    @OneToMany(mappedBy = "chorobyId")
    private Collection<Wizyty> wizytyCollection;

    public Choroby() {
    }

    public Choroby(BigDecimal id) {
        this.id = id;
    }

    public Choroby(BigDecimal id, String nazwa, String kodChoroby) {
        this.id = id;
        this.nazwa = nazwa;
        this.kodChoroby = kodChoroby;
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

    public String getKodChoroby() {
        return kodChoroby;
    }

    public void setKodChoroby(String kodChoroby) {
        this.kodChoroby = kodChoroby;
    }

    public Collection<Wizyty> getWizytyCollection() {
        return wizytyCollection;
    }

    public void setWizytyCollection(Collection<Wizyty> wizytyCollection) {
        this.wizytyCollection = wizytyCollection;
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
        if (!(object instanceof Choroby)) {
            return false;
        }
        Choroby other = (Choroby) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.przychodnia.Choroby[ id=" + id + " ]";
    }
    
}
