/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Intervention implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subject;
    private String description;
    private Date beginning;
    private Date ending;
    
    @OneToMany(mappedBy="Intervention")
    private Collection<Mark>Mark;
    
    @ManyToOne
    @JoinColumn(name="speaker_fk")
    private Speaker speaker;
    
    @ManyToOne
    @JoinColumn(name="campus_fk")
    private Campus campus;
    
    
    public Intervention() {
    }
    
    public Intervention(String subject, Campus campus, Date beginning, Date ending, String description, Speaker speaker){
        this.subject = subject;
        this.campus = campus;
        this.beginning = beginning;
        this.ending = ending;
        this.description = description;
        this.speaker = speaker;
    }
    
    public Date getBeginning() {
        return beginning;
    }

    public void setBeginning(Date beginning) {
        this.beginning = beginning;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEnding() {
        return ending;
    }

    public void setEnding(Date ending) {
        this.ending = ending;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
        if (!(object instanceof Intervention)) {
            return false;
        }
        Intervention other = (Intervention) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simon.entity.Intervention[ id=" + id + " ]";
    }
    
}
