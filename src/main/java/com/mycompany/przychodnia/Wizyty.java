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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "WIZYTY")
@NamedQueries({
    @NamedQuery(name = "Wizyty.findAll", query = "SELECT w FROM Wizyty w"),
    @NamedQuery(name = "Wizyty.findById", query = "SELECT w FROM Wizyty w WHERE w.id = :id"),
    @NamedQuery(name = "Wizyty.findByDataWizyty", query = "SELECT w FROM Wizyty w WHERE w.dataWizyty = :dataWizyty"),
    @NamedQuery(name = "Wizyty.findByWizytyZaplanowaneId", query = "SELECT w FROM Wizyty w WHERE w.wizytyZaplanowaneId = :wizytyZaplanowaneId"),
    @NamedQuery(name = "Wizyty.findByStatusRealizacji", query = "SELECT w FROM Wizyty w WHERE w.statusRealizacji = :statusRealizacji"),
    @NamedQuery(name = "Wizyty.findByZarajestrowaniPacjenciId", query = "SELECT w FROM Wizyty w WHERE w.zarajestrowaniPacjenciId = :zarajestrowaniPacjenciId")})
public class Wizyty implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_WIZYTY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataWizyty;
    @Lob
    @Column(name = "ROZPOZNANIE")
    private String rozpoznanie;
    @Lob
    @Column(name = "UWAGI")
    private String uwagi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WIZYTY_ZAPLANOWANE_ID")
    private BigInteger wizytyZaplanowaneId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS_REALIZACJI")
    private Character statusRealizacji;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZARAJESTROWANI_PACJENCI_ID")
    private BigInteger zarajestrowaniPacjenciId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wizytyZrealizowaneId")
    private Collection<Recepty> receptyCollection;
    @JoinColumn(name = "CHOROBY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Choroby chorobyId;
    @JoinColumn(name = "TERMINY_ID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private Terminy terminyId;

    public Wizyty() {
    }

    public Wizyty(BigDecimal id) {
        this.id = id;
    }

    public Wizyty(BigDecimal id, Date dataWizyty, BigInteger wizytyZaplanowaneId, Character statusRealizacji, BigInteger zarajestrowaniPacjenciId) {
        this.id = id;
        this.dataWizyty = dataWizyty;
        this.wizytyZaplanowaneId = wizytyZaplanowaneId;
        this.statusRealizacji = statusRealizacji;
        this.zarajestrowaniPacjenciId = zarajestrowaniPacjenciId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getDataWizyty() {
        return dataWizyty;
    }

    public void setDataWizyty(Date dataWizyty) {
        this.dataWizyty = dataWizyty;
    }

    public String getRozpoznanie() {
        return rozpoznanie;
    }

    public void setRozpoznanie(String rozpoznanie) {
        this.rozpoznanie = rozpoznanie;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    public BigInteger getWizytyZaplanowaneId() {
        return wizytyZaplanowaneId;
    }

    public void setWizytyZaplanowaneId(BigInteger wizytyZaplanowaneId) {
        this.wizytyZaplanowaneId = wizytyZaplanowaneId;
    }

    public Character getStatusRealizacji() {
        return statusRealizacji;
    }

    public void setStatusRealizacji(Character statusRealizacji) {
        this.statusRealizacji = statusRealizacji;
    }

    public BigInteger getZarajestrowaniPacjenciId() {
        return zarajestrowaniPacjenciId;
    }

    public void setZarajestrowaniPacjenciId(BigInteger zarajestrowaniPacjenciId) {
        this.zarajestrowaniPacjenciId = zarajestrowaniPacjenciId;
    }

    public Collection<Recepty> getReceptyCollection() {
        return receptyCollection;
    }

    public void setReceptyCollection(Collection<Recepty> receptyCollection) {
        this.receptyCollection = receptyCollection;
    }

    public Choroby getChorobyId() {
        return chorobyId;
    }

    public void setChorobyId(Choroby chorobyId) {
        this.chorobyId = chorobyId;
    }

    public Terminy getTerminyId() {
        return terminyId;
    }

    public void setTerminyId(Terminy terminyId) {
        this.terminyId = terminyId;
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
        if (!(object instanceof Wizyty)) {
            return false;
        }
        Wizyty other = (Wizyty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.przychodnia.Wizyty[ id=" + id + " ]";
    }
    
}
