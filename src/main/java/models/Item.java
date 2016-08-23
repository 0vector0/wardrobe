package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "item")
public class Item extends Model {
    private static final long serialVersionUID = -1549762000349245707L;
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    @ManyToOne
    @JoinColumn(name = "wardrobe_id")
    private Wardrobe wardrobe;


    @ManyToMany
    @JoinTable(name = "item_category")
    private Set<Category> itemCategory = new HashSet<Category>();
    @ManyToMany
    @JoinTable(name = "item_look")
    private Set<Look> itemLook = new HashSet<Look>();

    public Item() {
    }

    public Item(Long id) {
        super(id);
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Wardrobe getWardrobe() {
        return wardrobe;
    }

    public void setWardrobe(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
    }

    public Set<Category> getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(Set<Category> itemCategory) {
        this.itemCategory = itemCategory;
    }

    public Set<Look> getItemLook() {
        return itemLook;
    }

    public void setItemLook(Set<Look> itemLook) {
        this.itemLook = itemLook;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
