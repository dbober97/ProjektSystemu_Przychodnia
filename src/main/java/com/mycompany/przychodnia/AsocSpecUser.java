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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Dorota
 */
@Entity
@Table(name = "ASOC_SPEC_USER")
@NamedQueries({
    @NamedQuery(name = "AsocSpecUser.findAll", query = "SELECT a FROM AsocSpecUser a"),
    @NamedQuery(name = "AsocSpecUser.findByIdAsoc", query = "SELECT a FROM AsocSpecUser a WHERE a.idAsoc = :idAsoc"),
    @NamedQuery(name = "AsocSpecUser.findBySpecjalizacjeId", query = "SELECT a FROM AsocSpecUser a WHERE a.specjalizacjeId = :specjalizacjeId")})
public class AsocSpecUser implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ASOC")
    private BigDecimal idAsoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SPECJALIZACJE_ID")
    private BigInteger specjalizacjeId;
    @JoinColumn(name = "U\u017bYTKOWNICY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Uzytkownicy użytkownicyId;

    public AsocSpecUser() {
    }

    public AsocSpecUser(BigDecimal idAsoc) {
        this.idAsoc = idAsoc;
    }

    public AsocSpecUser(BigDecimal idAsoc, BigInteger specjalizacjeId) {
        this.idAsoc = idAsoc;
        this.specjalizacjeId = specjalizacjeId;
    }

    public BigDecimal getIdAsoc() {
        return idAsoc;
    }

    public void setIdAsoc(BigDecimal idAsoc) {
        this.idAsoc = idAsoc;
    }

    public BigInteger getSpecjalizacjeId() {
        return specjalizacjeId;
    }

    public void setSpecjalizacjeId(BigInteger specjalizacjeId) {
        this.specjalizacjeId = specjalizacjeId;
    }

    public Uzytkownicy getUżytkownicyId() {
        return użytkownicyId;
    }

    public void setUżytkownicyId(Uzytkownicy użytkownicyId) {
        this.użytkownicyId = użytkownicyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsoc != null ? idAsoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsocSpecUser)) {
            return false;
        }
        AsocSpecUser other = (AsocSpecUser) object;
        if ((this.idAsoc == null && other.idAsoc != null) || (this.idAsoc != null && !this.idAsoc.equals(other.idAsoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.przychodnia.AsocSpecUser[ idAsoc=" + idAsoc + " ]";
    }
    
}
