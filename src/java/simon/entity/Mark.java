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

@Entity
public class Mark implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer idBooster;
    private String comments;
    private Integer mark1;
    private Integer mark2;
    private Integer mark3;
    private Integer mark4;
    private Integer mark5;
    private Integer mark6;
    
    @ManyToOne
    @JoinColumn(name="intervention_fk")
    private Intervention intervention;
    
    public Mark() {
    }
    
    public Mark(Integer idBooster, String comments, Integer mark1, Integer mark2, Integer mark3, Integer mark4, Integer mark5, Integer mark6, Intervention intervention){
        this.idBooster = idBooster;
        this.comments = comments;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.mark4 = mark4;
        this.mark5 = mark5;
        this.mark6 = mark6;
        this.intervention = intervention;
    }

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    public Integer getMark1() {
        return mark1;
    }

    public void setMark1(Integer mark1) {
        this.mark1 = mark1;
    }

    public Integer getMark2() {
        return mark2;
    }

    public void setMark2(Integer mark2) {
        this.mark2 = mark2;
    }

    public Integer getMark3() {
        return mark3;
    }

    public void setMark3(Integer mark3) {
        this.mark3 = mark3;
    }

    public Integer getMark4() {
        return mark4;
    }

    public void setMark4(Integer mark4) {
        this.mark4 = mark4;
    }

    public Integer getMark5() {
        return mark5;
    }

    public void setMark5(Integer mark5) {
        this.mark5 = mark5;
    }

    public Integer getMark6() {
        return mark6;
    }

    public void setMark6(Integer mark6) {
        this.mark6 = mark6;
    }

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
