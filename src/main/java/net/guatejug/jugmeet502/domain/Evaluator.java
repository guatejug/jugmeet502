/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.guatejug.jugmeet502.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shaka
 */
@Entity
@Table(name = "evaluator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluator.findAll", query = "SELECT e FROM Evaluator e"),
    @NamedQuery(name = "Evaluator.findByEvaluatorId", query = "SELECT e FROM Evaluator e WHERE e.evaluatorId = :evaluatorId")})
public class Evaluator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "evaluator_id")
    private Integer evaluatorId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "evaluator")
    private EvaluatorHistorial evaluatorHistorial;
    @JoinColumn(name = "lecture_id", referencedColumnName = "lecture_id")
    @ManyToOne(optional = false)
    private Lecture lectureId;
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    @ManyToOne(optional = false)
    private Users usersId;

    public Evaluator() {
    }

    public Evaluator(Integer evaluatorId) {
        this.evaluatorId = evaluatorId;
    }

    public Integer getEvaluatorId() {
        return evaluatorId;
    }

    public void setEvaluatorId(Integer evaluatorId) {
        this.evaluatorId = evaluatorId;
    }

    public EvaluatorHistorial getEvaluatorHistorial() {
        return evaluatorHistorial;
    }

    public void setEvaluatorHistorial(EvaluatorHistorial evaluatorHistorial) {
        this.evaluatorHistorial = evaluatorHistorial;
    }

    public Lecture getLectureId() {
        return lectureId;
    }

    public void setLectureId(Lecture lectureId) {
        this.lectureId = lectureId;
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
        hash += (evaluatorId != null ? evaluatorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluator)) {
            return false;
        }
        Evaluator other = (Evaluator) object;
        if ((this.evaluatorId == null && other.evaluatorId != null) || (this.evaluatorId != null && !this.evaluatorId.equals(other.evaluatorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.guatejug.jugmeet502.domain.Evaluator[ evaluatorId=" + evaluatorId + " ]";
    }
    
}
