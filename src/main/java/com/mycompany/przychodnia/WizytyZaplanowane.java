/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.przychodnia;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Dorota
 */
@Entity
@Table(name = "WIZYTY_ZAPLANOWANE")
@NamedQueries({
    @NamedQuery(name = "WizytyZaplanowane.findAll", query = "SELECT w FROM WizytyZaplanowane w"),
    @NamedQuery(name = "WizytyZaplanowane.findById", query = "SELECT w FROM WizytyZaplanowane w WHERE w.id = :id"),
    @NamedQuery(name = "WizytyZaplanowane.findByData", query = "SELECT w FROM WizytyZaplanowane w WHERE w.data = :data"),
    @NamedQuery(name = "WizytyZaplanowane.findByZarajestrowaniPacjenciId", query = "SELECT w FROM WizytyZaplanowane w WHERE w.zarajestrowaniPacjenciId = :zarajestrowaniPacjenciId")})
public class WizytyZaplanowane implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZARAJESTROWANI_PACJENCI_ID")
    private BigInteger zarajestrowaniPacjenciId;
    @JoinColumn(name = "TERMINY_ID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private Terminy terminyId;

    public WizytyZaplanowane() {
    }

    public WizytyZaplanowane(BigDecimal id) {
        this.id = id;
    }

    public WizytyZaplanowane(BigDecimal id, Date data, BigInteger zarajestrowaniPacjenciId) {
        this.id = id;
        this.data = data;
        this.zarajestrowaniPacjenciId = zarajestrowaniPacjenciId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigInteger getZarajestrowaniPacjenciId() {
        return zarajestrowaniPacjenciId;
    }

    public void setZarajestrowaniPacjenciId(BigInteger zarajestrowaniPacjenciId) {
        this.zarajestrowaniPacjenciId = zarajestrowaniPacjenciId;
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
        if (!(object instanceof WizytyZaplanowane)) {
            return false;
        }
        WizytyZaplanowane other = (WizytyZaplanowane) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.przychodnia.WizytyZaplanowane[ id=" + id + " ]";
    }
    
}
