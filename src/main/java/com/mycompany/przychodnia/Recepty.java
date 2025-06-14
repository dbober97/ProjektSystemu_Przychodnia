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
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Dorota
 */
@Entity
@Table(name = "RECEPTY")
@NamedQueries({
    @NamedQuery(name = "Recepty.findAll", query = "SELECT r FROM Recepty r"),
    @NamedQuery(name = "Recepty.findById", query = "SELECT r FROM Recepty r WHERE r.id = :id"),
    @NamedQuery(name = "Recepty.findByDataWystawienia", query = "SELECT r FROM Recepty r WHERE r.dataWystawienia = :dataWystawienia")})
public class Recepty implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_WYSTAWIENIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataWystawienia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receptyId")
    private Collection<AsocReceptaLek> asocReceptaLekCollection;
    @JoinColumn(name = "WIZYTY_ZREALIZOWANE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Wizyty wizytyZrealizowaneId;

    public Recepty() {
    }

    public Recepty(BigDecimal id) {
        this.id = id;
    }

    public Recepty(BigDecimal id, Date dataWystawienia) {
        this.id = id;
        this.dataWystawienia = dataWystawienia;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getDataWystawienia() {
        return dataWystawienia;
    }

    public void setDataWystawienia(Date dataWystawienia) {
        this.dataWystawienia = dataWystawienia;
    }

    public Collection<AsocReceptaLek> getAsocReceptaLekCollection() {
        return asocReceptaLekCollection;
    }

    public void setAsocReceptaLekCollection(Collection<AsocReceptaLek> asocReceptaLekCollection) {
        this.asocReceptaLekCollection = asocReceptaLekCollection;
    }

    public Wizyty getWizytyZrealizowaneId() {
        return wizytyZrealizowaneId;
    }

    public void setWizytyZrealizowaneId(Wizyty wizytyZrealizowaneId) {
        this.wizytyZrealizowaneId = wizytyZrealizowaneId;
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
        if (!(object instanceof Recepty)) {
            return false;
        }
        Recepty other = (Recepty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.przychodnia.Recepty[ id=" + id + " ]";
    }
    
}
