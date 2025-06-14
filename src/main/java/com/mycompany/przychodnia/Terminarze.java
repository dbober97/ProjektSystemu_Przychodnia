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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Dorota
 */
@Entity
@Table(name = "TERMINARZE")
@NamedQueries({
    @NamedQuery(name = "Terminarze.findAll", query = "SELECT t FROM Terminarze t"),
    @NamedQuery(name = "Terminarze.findById", query = "SELECT t FROM Terminarze t WHERE t.id = :id"),
    @NamedQuery(name = "Terminarze.findByDataRozpoczenia", query = "SELECT t FROM Terminarze t WHERE t.dataRozpoczenia = :dataRozpoczenia"),
    @NamedQuery(name = "Terminarze.findByDataZakonczenia", query = "SELECT t FROM Terminarze t WHERE t.dataZakonczenia = :dataZakonczenia"),
    @NamedQuery(name = "Terminarze.findByPrzedzialCzasu", query = "SELECT t FROM Terminarze t WHERE t.przedzialCzasu = :przedzialCzasu")})
public class Terminarze implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_ROZPOCZENIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRozpoczenia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_ZAKONCZENIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataZakonczenia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRZEDZIAL_CZASU")
    private BigInteger przedzialCzasu;
    @JoinColumn(name = "GEBINETY_GEBINETY_ID", referencedColumnName = "GEBINETY_ID")
    @ManyToOne(optional = false)
    private Gebinety gebinetyGebinetyId;
    @JoinColumn(name = "U\u017bYTKOWNICY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Uzytkownicy użytkownicyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terminarzeId")
    private Collection<Terminy> terminyCollection;

    public Terminarze() {
    }

    public Terminarze(BigDecimal id) {
        this.id = id;
    }

    public Terminarze(BigDecimal id, Date dataRozpoczenia, Date dataZakonczenia, BigInteger przedzialCzasu) {
        this.id = id;
        this.dataRozpoczenia = dataRozpoczenia;
        this.dataZakonczenia = dataZakonczenia;
        this.przedzialCzasu = przedzialCzasu;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getDataRozpoczenia() {
        return dataRozpoczenia;
    }

    public void setDataRozpoczenia(Date dataRozpoczenia) {
        this.dataRozpoczenia = dataRozpoczenia;
    }

    public Date getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(Date dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public BigInteger getPrzedzialCzasu() {
        return przedzialCzasu;
    }

    public void setPrzedzialCzasu(BigInteger przedzialCzasu) {
        this.przedzialCzasu = przedzialCzasu;
    }

    public Gebinety getGebinetyGebinetyId() {
        return gebinetyGebinetyId;
    }

    public void setGebinetyGebinetyId(Gebinety gebinetyGebinetyId) {
        this.gebinetyGebinetyId = gebinetyGebinetyId;
    }

    public Uzytkownicy getUżytkownicyId() {
        return użytkownicyId;
    }

    public void setUżytkownicyId(Uzytkownicy użytkownicyId) {
        this.użytkownicyId = użytkownicyId;
    }

    public Collection<Terminy> getTerminyCollection() {
        return terminyCollection;
    }

    public void setTerminyCollection(Collection<Terminy> terminyCollection) {
        this.terminyCollection = terminyCollection;
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
        if (!(object instanceof Terminarze)) {
            return false;
        }
        Terminarze other = (Terminarze) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.przychodnia.Terminarze[ id=" + id + " ]";
    }
    
}
