package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "wardrobe")
public class Wardrobe extends Model {

    private static final long serialVersionUID = 3829403741018341731L;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "wardrobe", fetch = FetchType.LAZY)
    private Set<Item> items = new HashSet<Item>();

    public Wardrobe() {
    }

    public Wardrobe(Long id) {
        super(id);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
