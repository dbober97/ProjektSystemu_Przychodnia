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
@Table(name = "U\u017bYTKOWNICY")
@NamedQueries({
    @NamedQuery(name = "Uzytkownicy.findAll", query = "SELECT u FROM Uzytkownicy u"),
    @NamedQuery(name = "Uzytkownicy.findById", query = "SELECT u FROM Uzytkownicy u WHERE u.id = :id"),
    @NamedQuery(name = "Uzytkownicy.findByImie", query = "SELECT u FROM Uzytkownicy u WHERE u.imie = :imie"),
    @NamedQuery(name = "Uzytkownicy.findByNazwisko", query = "SELECT u FROM Uzytkownicy u WHERE u.nazwisko = :nazwisko"),
    @NamedQuery(name = "Uzytkownicy.findByLogin", query = "SELECT u FROM Uzytkownicy u WHERE u.login = :login"),
    @NamedQuery(name = "Uzytkownicy.findByHaslo", query = "SELECT u FROM Uzytkownicy u WHERE u.haslo = :haslo"),
    @NamedQuery(name = "Uzytkownicy.findByEmail", query = "SELECT u FROM Uzytkownicy u WHERE u.email = :email"),
    @NamedQuery(name = "Uzytkownicy.findByTelefon", query = "SELECT u FROM Uzytkownicy u WHERE u.telefon = :telefon")})
public class Uzytkownicy implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IMIE")
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "HASLO")
    private String haslo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TELEFON")
    private String telefon;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Role roleId;
    @JoinColumn(name = "SPECJALIZACJE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Specjalizacje specjalizacjeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "u\u017cytkownicyId")
    private Collection<Terminarze> terminarzeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "u\u017cytkownicyId")
    private Collection<AsocRolaUser> asocRolaUserCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "u\u017cytkownicyId")
    private Collection<AsocSpecUser> asocSpecUserCollection;

    public Uzytkownicy() {
    }

    public Uzytkownicy(BigDecimal id) {
        this.id = id;
    }

    public Uzytkownicy(BigDecimal id, String imie, String nazwisko, String login, String haslo, String email, String telefon) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.haslo = haslo;
        this.email = email;
        this.telefon = telefon;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Specjalizacje getSpecjalizacjeId() {
        return specjalizacjeId;
    }

    public void setSpecjalizacjeId(Specjalizacje specjalizacjeId) {
        this.specjalizacjeId = specjalizacjeId;
    }

    public Collection<Terminarze> getTerminarzeCollection() {
        return terminarzeCollection;
    }

    public void setTerminarzeCollection(Collection<Terminarze> terminarzeCollection) {
        this.terminarzeCollection = terminarzeCollection;
    }

    public Collection<AsocRolaUser> getAsocRolaUserCollection() {
        return asocRolaUserCollection;
    }

    public void setAsocRolaUserCollection(Collection<AsocRolaUser> asocRolaUserCollection) {
        this.asocRolaUserCollection = asocRolaUserCollection;
    }

    public Collection<AsocSpecUser> getAsocSpecUserCollection() {
        return asocSpecUserCollection;
    }

    public void setAsocSpecUserCollection(Collection<AsocSpecUser> asocSpecUserCollection) {
        this.asocSpecUserCollection = asocSpecUserCollection;
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
        if (!(object instanceof Uzytkownicy)) {
            return false;
        }
        Uzytkownicy other = (Uzytkownicy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.przychodnia.Uzytkownicy[ id=" + id + " ]";
    }
    
}
