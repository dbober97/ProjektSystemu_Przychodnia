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
@Table(name = "SPECJALIZACJE")
@NamedQueries({
    @NamedQuery(name = "Specjalizacje.findAll", query = "SELECT s FROM Specjalizacje s"),
    @NamedQuery(name = "Specjalizacje.findById", query = "SELECT s FROM Specjalizacje s WHERE s.id = :id"),
    @NamedQuery(name = "Specjalizacje.findByNazwa", query = "SELECT s FROM Specjalizacje s WHERE s.nazwa = :nazwa")})
public class Specjalizacje implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specjalizacjeId")
    private Collection<Uzytkownicy> uzytkownicyCollection;

    public Specjalizacje() {
    }

    public Specjalizacje(BigDecimal id) {
        this.id = id;
    }

    public Specjalizacje(BigDecimal id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
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

    public Collection<Uzytkownicy> getUzytkownicyCollection() {
        return uzytkownicyCollection;
    }

    public void setUzytkownicyCollection(Collection<Uzytkownicy> uzytkownicyCollection) {
        this.uzytkownicyCollection = uzytkownicyCollection;
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
        if (!(object instanceof Specjalizacje)) {
            return false;
        }
        Specjalizacje other = (Specjalizacje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.przychodnia.Specjalizacje[ id=" + id + " ]";
    }
    
}
