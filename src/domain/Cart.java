package domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Cart {
    private Map<String ,CartItem> itemMap=new HashMap<String,CartItem>();
    private Double total=0.0;

    /**
     * 获取所有购物项
     * @return
     */
    public Collection<CartItem> getCartItems(){
        return itemMap.values();
    }

    public Map<String, CartItem> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<String, CartItem> itemMap) {
        this.itemMap = itemMap;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * 加入购物车
     * @param item
     */
    public void add2Cart(CartItem item){
        String pid=item.getProduct().getPid();

        if(itemMap.containsKey((pid))){
            CartItem oItem =itemMap.get(pid);
            oItem.setCount(oItem.getCount()+item.getCount());
        }else {
            itemMap.put(pid,item);
        }

        total+=item.getSubtotal();
    }
    /**
     * 移除购物车
     * @param pid
     */
    public void removeFromCart(String pid){
        //map中移除购物项
        CartItem item = itemMap.remove(pid);

        total-=item.getSubtotal();
    }
    /**
     * 清空购物车
     */
    public void cleanCart(){
        itemMap.clear();
        total=0.0;
    }
}
