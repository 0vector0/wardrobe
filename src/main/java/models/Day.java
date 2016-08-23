package models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "day")
public class Day extends Model {
    private static final long serialVersionUID = 5962880613281380386L;

    @Column(name = "day", nullable = false)
    @Type(type = "date")
    private Date day;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    @ManyToMany
    @JoinTable(name = "day_look")
    private Set<Look> dayLook = new HashSet<Look>();

    public Day() {

    }

    public Day(Long id) {
        super(id);
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }
}
