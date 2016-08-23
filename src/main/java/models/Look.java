package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "look")
public class Look extends Model {
    private static final long serialVersionUID = -1941002753527301264L;

    @Column(name = "name", nullable = false)
    private String name;
    @ManyToMany(mappedBy = "dayLook")
    private Set<Day> days = new HashSet<Day>();
    @ManyToMany(mappedBy = "itemLook")
    private Set<Item> items = new HashSet<Item>();

    public Look() {

    }

    public Look(Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Day> getDays() {
        return days;
    }

    public void setDays(Set<Day> days) {
        this.days = days;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
