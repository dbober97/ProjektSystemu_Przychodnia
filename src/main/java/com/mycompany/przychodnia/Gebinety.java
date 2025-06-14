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
import java.math.BigInteger;
import java.util.Collection;

/**
 *
 * @author Dorota
 */
@Entity
@Table(name = "GEBINETY")
@NamedQueries({
    @NamedQuery(name = "Gebinety.findAll", query = "SELECT g FROM Gebinety g"),
    @NamedQuery(name = "Gebinety.findById", query = "SELECT g FROM Gebinety g WHERE g.id = :id"),
    @NamedQuery(name = "Gebinety.findByNrPokoju", query = "SELECT g FROM Gebinety g WHERE g.nrPokoju = :nrPokoju"),
    @NamedQuery(name = "Gebinety.findByUrz\u0105dzenie", query = "SELECT g FROM Gebinety g WHERE g.urz\u0105dzenie = :urz\u0105dzenie"),
    @NamedQuery(name = "Gebinety.findByGebinetyId", query = "SELECT g FROM Gebinety g WHERE g.gebinetyId = :gebinetyId")})
public class Gebinety implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ID")
    private BigInteger id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NR_POKOJU")
    private BigInteger nrPokoju;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "URZ\u0104DZENIE")
    private String urządzenie;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GEBINETY_ID")
    private BigDecimal gebinetyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gebinetyGebinetyId")
    private Collection<Terminarze> terminarzeCollection;

    public Gebinety() {
    }

    public Gebinety(BigDecimal gebinetyId) {
        this.gebinetyId = gebinetyId;
    }

    public Gebinety(BigDecimal gebinetyId, BigInteger nrPokoju, String urządzenie) {
        this.gebinetyId = gebinetyId;
        this.nrPokoju = nrPokoju;
        this.urządzenie = urządzenie;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getNrPokoju() {
        return nrPokoju;
    }

    public void setNrPokoju(BigInteger nrPokoju) {
        this.nrPokoju = nrPokoju;
    }

    public String getUrządzenie() {
        return urządzenie;
    }

    public void setUrządzenie(String urządzenie) {
        this.urządzenie = urządzenie;
    }

    public BigDecimal getGebinetyId() {
        return gebinetyId;
    }

    public void setGebinetyId(BigDecimal gebinetyId) {
        this.gebinetyId = gebinetyId;
    }

    public Collection<Terminarze> getTerminarzeCollection() {
        return terminarzeCollection;
    }

    public void setTerminarzeCollection(Collection<Terminarze> terminarzeCollection) {
        this.terminarzeCollection = terminarzeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gebinetyId != null ? gebinetyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gebinety)) {
            return false;
        }
        Gebinety other = (Gebinety) object;
        if ((this.gebinetyId == null && other.gebinetyId != null) || (this.gebinetyId != null && !this.gebinetyId.equals(other.gebinetyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.przychodnia.Gebinety[ gebinetyId=" + gebinetyId + " ]";
    }
    
}
