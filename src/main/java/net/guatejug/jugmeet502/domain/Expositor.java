/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.guatejug.jugmeet502.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shaka
 */
@Entity
@Table(name = "expositor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expositor.findAll", query = "SELECT e FROM Expositor e"),
    @NamedQuery(name = "Expositor.findByExpositorId", query = "SELECT e FROM Expositor e WHERE e.expositorId = :expositorId"),
    @NamedQuery(name = "Expositor.findByRegisterDate", query = "SELECT e FROM Expositor e WHERE e.registerDate = :registerDate"),
    @NamedQuery(name = "Expositor.findByBiography", query = "SELECT e FROM Expositor e WHERE e.biography = :biography"),
    @NamedQuery(name = "Expositor.findByTelephones", query = "SELECT e FROM Expositor e WHERE e.telephones = :telephones")})
public class Expositor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "expositor_id")
    private Integer expositorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "register_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3000)
    @Column(name = "biography")
    private String biography;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "telephones")
    private String telephones;
    @JoinTable(name = "expositor_lecture", joinColumns = {
        @JoinColumn(name = "expositor_id", referencedColumnName = "expositor_id")}, inverseJoinColumns = {
        @JoinColumn(name = "lecture_id", referencedColumnName = "lecture_id")})
    @ManyToMany
    private List<Lecture> lectureList;
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    @ManyToOne(optional = false)
    private Users usersId;

    public Expositor() {
    }

    public Expositor(Integer expositorId) {
        this.expositorId = expositorId;
    }

    public Expositor(Integer expositorId, Date registerDate, String biography, String telephones) {
        this.expositorId = expositorId;
        this.registerDate = registerDate;
        this.biography = biography;
        this.telephones = telephones;
    }

    public Integer getExpositorId() {
        return expositorId;
    }

    public void setExpositorId(Integer expositorId) {
        this.expositorId = expositorId;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getTelephones() {
        return telephones;
    }

    public void setTelephones(String telephones) {
        this.telephones = telephones;
    }

    @XmlTransient
    public List<Lecture> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<Lecture> lectureList) {
        this.lectureList = lectureList;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (expositorId != null ? expositorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expositor)) {
            return false;
        }
        Expositor other = (Expositor) object;
        if ((this.expositorId == null && other.expositorId != null) || (this.expositorId != null && !this.expositorId.equals(other.expositorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.guatejug.jugmeet502.domain.Expositor[ expositorId=" + expositorId + " ]";
    }
    
}
