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
import jakarta.persistence.Lob;
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
@Table(name = "ASOC_RECEPTA_LEK")
@NamedQueries({
    @NamedQuery(name = "AsocReceptaLek.findAll", query = "SELECT a FROM AsocReceptaLek a"),
    @NamedQuery(name = "AsocReceptaLek.findById", query = "SELECT a FROM AsocReceptaLek a WHERE a.id = :id"),
    @NamedQuery(name = "AsocReceptaLek.findByRefundacja", query = "SELECT a FROM AsocReceptaLek a WHERE a.refundacja = :refundacja")})
public class AsocReceptaLek implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "DAWKOWANIE_USTALONE")
    private String dawkowanieUstalone;
    @Column(name = "REFUNDACJA")
    private BigInteger refundacja;
    @JoinColumn(name = "LEKI_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Leki lekiId;
    @JoinColumn(name = "RECEPTY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Recepty receptyId;

    public AsocReceptaLek() {
    }

    public AsocReceptaLek(BigDecimal id) {
        this.id = id;
    }

    public AsocReceptaLek(BigDecimal id, String dawkowanieUstalone) {
        this.id = id;
        this.dawkowanieUstalone = dawkowanieUstalone;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDawkowanieUstalone() {
        return dawkowanieUstalone;
    }

    public void setDawkowanieUstalone(String dawkowanieUstalone) {
        this.dawkowanieUstalone = dawkowanieUstalone;
    }

    public BigInteger getRefundacja() {
        return refundacja;
    }

    public void setRefundacja(BigInteger refundacja) {
        this.refundacja = refundacja;
    }

    public Leki getLekiId() {
        return lekiId;
    }

    public void setLekiId(Leki lekiId) {
        this.lekiId = lekiId;
    }

    public Recepty getReceptyId() {
        return receptyId;
    }

    public void setReceptyId(Recepty receptyId) {
        this.receptyId = receptyId;
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
        if (!(object instanceof AsocReceptaLek)) {
            return false;
        }
        AsocReceptaLek other = (AsocReceptaLek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.przychodnia.AsocReceptaLek[ id=" + id + " ]";
    }
    
}
