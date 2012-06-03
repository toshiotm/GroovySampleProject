/**
 * Created with IntelliJ IDEA.
 * User: toshi
 * Date: 12/06/02
 * Time: 16:30
 * To change this template use File | Settings | File Templates.
 */
public class Juice {

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    Integer stock;

    Integer price;

    String name;


}
