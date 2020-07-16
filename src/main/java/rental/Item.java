package rental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Item_table")
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String itemName;
    private Integer amount;
    private Integer price;

    @PostPersist
    public void onPostPersist(){
        ItemCreated itemCreated = new ItemCreated();
        BeanUtils.copyProperties(this, itemCreated);
        itemCreated.publishAfterCommit();


    }


    @PostUpdate
    public void onPostUpdate(){
        ItemProduced itemProduced = new ItemProduced();
        BeanUtils.copyProperties(this, itemProduced);
        itemProduced.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }




}
