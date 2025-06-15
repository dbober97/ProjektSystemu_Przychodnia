/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.przychodnia;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Dorota
 */
@Entity
@Table(name = "ZARAJESTROWANI_PACJENCI")
@NamedQueries({
    @NamedQuery(name = "ZarajestrowaniPacjenci.findAll", query = "SELECT z FROM ZarajestrowaniPacjenci z"),
    @NamedQuery(name = "ZarajestrowaniPacjenci.findById", query = "SELECT z FROM ZarajestrowaniPacjenci z WHERE z.id = :id"),
    @NamedQuery(name = "ZarajestrowaniPacjenci.findByImie", query = "SELECT z FROM ZarajestrowaniPacjenci z WHERE z.imie = :imie"),
    @NamedQuery(name = "ZarajestrowaniPacjenci.findByNazwisko", query = "SELECT z FROM ZarajestrowaniPacjenci z WHERE z.nazwisko = :nazwisko"),
    @NamedQuery(name = "ZarajestrowaniPacjenci.findByPesel", query = "SELECT z FROM ZarajestrowaniPacjenci z WHERE z.pesel = :pesel"),
    @NamedQuery(name = "ZarajestrowaniPacjenci.findByAdres", query = "SELECT z FROM ZarajestrowaniPacjenci z WHERE z.adres = :adres"),
    @NamedQuery(name = "ZarajestrowaniPacjenci.findByTelefon", query = "SELECT z FROM ZarajestrowaniPacjenci z WHERE z.telefon = :telefon"),
    @NamedQuery(name = "ZarajestrowaniPacjenci.findByDataUrodzenia", query = "SELECT z FROM ZarajestrowaniPacjenci z WHERE z.dataUrodzenia = :dataUrodzenia"),
    @NamedQuery(name = "ZarajestrowaniPacjenci.findByEmail", query = "SELECT z FROM ZarajestrowaniPacjenci z WHERE z.email = :email"),
    @NamedQuery(name = "ZarajestrowaniPacjenci.findByHaslo", query = "SELECT z FROM ZarajestrowaniPacjenci z WHERE z.haslo = :haslo")})
public class ZarajestrowaniPacjenci implements Serializable {

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
    @Size(min = 11, max = 11)
    @Column(name = "PESEL")
    private String pesel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ADRES")
    private String adres;
    @Size(max = 15)
    @Column(name = "TELEFON")
    private String telefon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_URODZENIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUrodzenia;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 100)
    @Column(name = "HASLO")
    private String haslo;

    public ZarajestrowaniPacjenci() {
    }

    public ZarajestrowaniPacjenci(BigDecimal id) {
        this.id = id;
    }

    public ZarajestrowaniPacjenci(BigDecimal id, String imie, String nazwisko, String pesel, String adres, Date dataUrodzenia) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.adres = adres;
        this.dataUrodzenia = dataUrodzenia;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
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
        if (!(object instanceof ZarajestrowaniPacjenci)) {
            return false;
        }
        ZarajestrowaniPacjenci other = (ZarajestrowaniPacjenci) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.przychodnia.ZarajestrowaniPacjenci[ id=" + id + " ]";
    }
    
}
