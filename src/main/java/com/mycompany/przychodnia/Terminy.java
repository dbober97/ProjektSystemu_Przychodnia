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
@Table(name = "TERMINY")
@NamedQueries({
    @NamedQuery(name = "Terminy.findAll", query = "SELECT t FROM Terminy t"),
    @NamedQuery(name = "Terminy.findById", query = "SELECT t FROM Terminy t WHERE t.id = :id"),
    @NamedQuery(name = "Terminy.findByGodzinaRozpoczenia", query = "SELECT t FROM Terminy t WHERE t.godzinaRozpoczenia = :godzinaRozpoczenia"),
    @NamedQuery(name = "Terminy.findByGodzinaZakonczenia", query = "SELECT t FROM Terminy t WHERE t.godzinaZakonczenia = :godzinaZakonczenia"),
    @NamedQuery(name = "Terminy.findByPrzedzialCzasu", query = "SELECT t FROM Terminy t WHERE t.przedzialCzasu = :przedzialCzasu")})
public class Terminy implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GODZINA_ROZPOCZENIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date godzinaRozpoczenia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GODZINA_ZAKONCZENIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date godzinaZakonczenia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRZEDZIAL_CZASU")
    private BigInteger przedzialCzasu;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "DOSTEPNOSC")
    private Serializable dostepnosc;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "terminyId")
    private Wizyty wizyty;
    @JoinColumn(name = "TERMINARZE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Terminarze terminarzeId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "terminyId")
    private WizytyZaplanowane wizytyZaplanowane;

    public Terminy() {
    }

    public Terminy(BigDecimal id) {
        this.id = id;
    }

    public Terminy(BigDecimal id, Date godzinaRozpoczenia, Date godzinaZakonczenia, BigInteger przedzialCzasu, Serializable dostepnosc) {
        this.id = id;
        this.godzinaRozpoczenia = godzinaRozpoczenia;
        this.godzinaZakonczenia = godzinaZakonczenia;
        this.przedzialCzasu = przedzialCzasu;
        this.dostepnosc = dostepnosc;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getGodzinaRozpoczenia() {
        return godzinaRozpoczenia;
    }

    public void setGodzinaRozpoczenia(Date godzinaRozpoczenia) {
        this.godzinaRozpoczenia = godzinaRozpoczenia;
    }

    public Date getGodzinaZakonczenia() {
        return godzinaZakonczenia;
    }

    public void setGodzinaZakonczenia(Date godzinaZakonczenia) {
        this.godzinaZakonczenia = godzinaZakonczenia;
    }

    public BigInteger getPrzedzialCzasu() {
        return przedzialCzasu;
    }

    public void setPrzedzialCzasu(BigInteger przedzialCzasu) {
        this.przedzialCzasu = przedzialCzasu;
    }

    public Serializable getDostepnosc() {
        return dostepnosc;
    }

    public void setDostepnosc(Serializable dostepnosc) {
        this.dostepnosc = dostepnosc;
    }

    public Wizyty getWizyty() {
        return wizyty;
    }

    public void setWizyty(Wizyty wizyty) {
        this.wizyty = wizyty;
    }

    public Terminarze getTerminarzeId() {
        return terminarzeId;
    }

    public void setTerminarzeId(Terminarze terminarzeId) {
        this.terminarzeId = terminarzeId;
    }

    public WizytyZaplanowane getWizytyZaplanowane() {
        return wizytyZaplanowane;
    }

    public void setWizytyZaplanowane(WizytyZaplanowane wizytyZaplanowane) {
        this.wizytyZaplanowane = wizytyZaplanowane;
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
        if (!(object instanceof Terminy)) {
            return false;
        }
        Terminy other = (Terminy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.przychodnia.Terminy[ id=" + id + " ]";
    }
    
}
