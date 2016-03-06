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
@Table(name = "attendee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendee.findAll", query = "SELECT a FROM Attendee a"),
    @NamedQuery(name = "Attendee.findByAttendeeId", query = "SELECT a FROM Attendee a WHERE a.attendeeId = :attendeeId"),
    @NamedQuery(name = "Attendee.findByName", query = "SELECT a FROM Attendee a WHERE a.name = :name"),
    @NamedQuery(name = "Attendee.findByLastName", query = "SELECT a FROM Attendee a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "Attendee.findByDpi", query = "SELECT a FROM Attendee a WHERE a.dpi = :dpi"),
    @NamedQuery(name = "Attendee.findByGender", query = "SELECT a FROM Attendee a WHERE a.gender = :gender"),
    @NamedQuery(name = "Attendee.findByBirthday", query = "SELECT a FROM Attendee a WHERE a.birthday = :birthday"),
    @NamedQuery(name = "Attendee.findByEmail", query = "SELECT a FROM Attendee a WHERE a.email = :email"),
    @NamedQuery(name = "Attendee.findByTelephones", query = "SELECT a FROM Attendee a WHERE a.telephones = :telephones"),
    @NamedQuery(name = "Attendee.findByCompany", query = "SELECT a FROM Attendee a WHERE a.company = :company"),
    @NamedQuery(name = "Attendee.findByCompanySector", query = "SELECT a FROM Attendee a WHERE a.companySector = :companySector"),
    @NamedQuery(name = "Attendee.findByPosition", query = "SELECT a FROM Attendee a WHERE a.position = :position")})
public class Attendee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "attendee_id")
    private Integer attendeeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "dpi")
    private String dpi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "telephones")
    private String telephones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "company_sector")
    private String companySector;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "position")
    private String position;
    @JoinTable(name = "attendee_lecture", joinColumns = {
        @JoinColumn(name = "attendee_id", referencedColumnName = "attendee_id")}, inverseJoinColumns = {
        @JoinColumn(name = "lecture_id", referencedColumnName = "lecture_id")})
    @ManyToMany
    private List<Lecture> lectureList;

    public Attendee() {
    }

    public Attendee(Integer attendeeId) {
        this.attendeeId = attendeeId;
    }

    public Attendee(Integer attendeeId, String name, String lastName, String dpi, String gender, Date birthday, String email, String telephones, String company, String companySector, String position) {
        this.attendeeId = attendeeId;
        this.name = name;
        this.lastName = lastName;
        this.dpi = dpi;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.telephones = telephones;
        this.company = company;
        this.companySector = companySector;
        this.position = position;
    }

    public Integer getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(Integer attendeeId) {
        this.attendeeId = attendeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephones() {
        return telephones;
    }

    public void setTelephones(String telephones) {
        this.telephones = telephones;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanySector() {
        return companySector;
    }

    public void setCompanySector(String companySector) {
        this.companySector = companySector;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @XmlTransient
    public List<Lecture> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<Lecture> lectureList) {
        this.lectureList = lectureList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attendeeId != null ? attendeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendee)) {
            return false;
        }
        Attendee other = (Attendee) object;
        if ((this.attendeeId == null && other.attendeeId != null) || (this.attendeeId != null && !this.attendeeId.equals(other.attendeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.guatejug.jugmeet502.domain.Attendee[ attendeeId=" + attendeeId + " ]";
    }
    
}
