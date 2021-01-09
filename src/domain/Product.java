package domain;

import java.util.Date;

public class Product {
    private String pid;
    private String pname;
    private double market_price;
    private double good_price;
    private String pimages;
    private Date pdate;
    private int is_hot;
    private Integer pflag;
    private String pdesc;
    private String cid;
    private Category category;

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", market_price=" + market_price +
                ", good_price=" + good_price +
                ", pimages='" + pimages + '\'' +
                ", pdate=" + pdate +
                ", is_hot=" + is_hot +
                ", pflag=" + pflag +
                ", pdesc='" + pdesc + '\'' +
                ", cid='" + cid + '\'' +
                ", category=" + category +
                '}';
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(double market_price) {
        this.market_price = market_price;
    }

    public double getGood_price() {
        return good_price;
    }

    public void setGood_price(double good_price) {
        this.good_price = good_price;
    }

    public String getPimages() {
        return pimages;
    }

    public void setPimages(String pimages) {
        this.pimages = pimages;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public int getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }

    public Integer getPflag() {
        return pflag;
    }

    public void setPflag(Integer pflag) {
        this.pflag = pflag;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String gdesc) {
        this.pdesc = gdesc;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
