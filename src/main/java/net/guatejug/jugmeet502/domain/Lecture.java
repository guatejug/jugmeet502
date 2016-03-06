/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.guatejug.jugmeet502.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shaka
 */
@Entity
@Table(name = "lecture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lecture.findAll", query = "SELECT l FROM Lecture l"),
    @NamedQuery(name = "Lecture.findByLectureId", query = "SELECT l FROM Lecture l WHERE l.lectureId = :lectureId"),
    @NamedQuery(name = "Lecture.findByName", query = "SELECT l FROM Lecture l WHERE l.name = :name"),
    @NamedQuery(name = "Lecture.findByDescription", query = "SELECT l FROM Lecture l WHERE l.description = :description"),
    @NamedQuery(name = "Lecture.findByLevel", query = "SELECT l FROM Lecture l WHERE l.level = :level"),
    @NamedQuery(name = "Lecture.findByDuration", query = "SELECT l FROM Lecture l WHERE l.duration = :duration"),
    @NamedQuery(name = "Lecture.findByApproved", query = "SELECT l FROM Lecture l WHERE l.approved = :approved")})
public class Lecture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lecture_id")
    private Integer lectureId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "name")
    private String name;
    @Size(max = 4000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "level")
    private short level;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duration")
    private short duration;
    @Basic(optional = false)
    @NotNull
    @Column(name = "approved")
    private boolean approved;
    @ManyToMany(mappedBy = "lectureList")
    private List<Expositor> expositorList;
    @ManyToMany(mappedBy = "lectureList")
    private List<Attendee> attendeeList;
    @ManyToMany(mappedBy = "lectureList")
    private List<Category> categoryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lecture")
    private List<Schedule> scheduleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lectureId")
    private List<Evaluator> evaluatorList;

    public Lecture() {
    }

    public Lecture(Integer lectureId) {
        this.lectureId = lectureId;
    }

    public Lecture(Integer lectureId, String name, short level, short duration, boolean approved) {
        this.lectureId = lectureId;
        this.name = name;
        this.level = level;
        this.duration = duration;
        this.approved = approved;
    }

    public Integer getLectureId() {
        return lectureId;
    }

    public void setLectureId(Integer lectureId) {
        this.lectureId = lectureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public boolean getApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @XmlTransient
    public List<Expositor> getExpositorList() {
        return expositorList;
    }

    public void setExpositorList(List<Expositor> expositorList) {
        this.expositorList = expositorList;
    }

    @XmlTransient
    public List<Attendee> getAttendeeList() {
        return attendeeList;
    }

    public void setAttendeeList(List<Attendee> attendeeList) {
        this.attendeeList = attendeeList;
    }

    @XmlTransient
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @XmlTransient
    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @XmlTransient
    public List<Evaluator> getEvaluatorList() {
        return evaluatorList;
    }

    public void setEvaluatorList(List<Evaluator> evaluatorList) {
        this.evaluatorList = evaluatorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lectureId != null ? lectureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecture)) {
            return false;
        }
        Lecture other = (Lecture) object;
        if ((this.lectureId == null && other.lectureId != null) || (this.lectureId != null && !this.lectureId.equals(other.lectureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.guatejug.jugmeet502.domain.Lecture[ lectureId=" + lectureId + " ]";
    }
    
}
