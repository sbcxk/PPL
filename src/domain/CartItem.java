package domain;

public class CartItem {
    private Product product;    //商品
    private Double subtotal;    //小计
    private Integer count;      //数量

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * 获取商品小计
     * @return
     */
    public Double getSubtotal() {
        return product.getGood_price()*count;
    }

    /*public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }*/

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public CartItem(Product product, Integer count) {
        super();
        this.product = product;
        this.count = count;
    }
}
