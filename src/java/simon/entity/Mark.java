/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author patrice
 */
@Entity
public class Mark implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer idBooster;
    private String comments;
    private Integer mark11;
    private Integer mark12;
    private Integer mark13;
    private Integer mark21;
    private Integer mark22;
    private Integer mark23;
    
    @ManyToOne
    @JoinColumn(name="intervention_fk")
    private Intervention intervention;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getIdBooster() {
        return idBooster;
    }

    public void setIdBooster(Integer idBooster) {
        this.idBooster = idBooster;
    }

    public Integer getMark11() {
        return mark11;
    }

    public void setMark11(Integer mark11) {
        this.mark11 = mark11;
    }

    public Integer getMark12() {
        return mark12;
    }

    public void setMark12(Integer mark12) {
        this.mark12 = mark12;
    }

    public Integer getMark13() {
        return mark13;
    }

    public void setMark13(Integer mark13) {
        this.mark13 = mark13;
    }

    public Integer getMark21() {
        return mark21;
    }

    public void setMark21(Integer mark21) {
        this.mark21 = mark21;
    }

    public Integer getMark22() {
        return mark22;
    }

    public void setMark22(Integer mark22) {
        this.mark22 = mark22;
    }

    public Integer getMark23() {
        return mark23;
    }

    public void setMark23(Integer mark23) {
        this.mark23 = mark23;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Mark)) {
            return false;
        }
        Mark other = (Mark) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simon.entity.Mark[ id=" + id + " ]";
    }
    
}
