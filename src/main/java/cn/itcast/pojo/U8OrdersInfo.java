package cn.itcast.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "u8_orders_info")
public class U8OrdersInfo {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String code;
    private String inventorycode;
    private String inventoryname;
    private String invstd;
    private String unitcode;
    private String unitname;
    private String unitrate;
    private String quantity;
    private String num;
    private String unitprice;
    private String quotedprice;
    private String taxunitprice;
    private String money;
    private String taxrate;
    private String sum;
    private String discount;
    private String natdiscount;
    private String discountrate;
    private String discountrate2;
    private String natmoney;
    private String natunitprice;
    private String tax;
    private String nattax;
    private String natsum;
    private String ccontractid;
    private String bgift;
    private String rowno;
    private Date create_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInventorycode() {
        return inventorycode;
    }

    public void setInventorycode(String inventorycode) {
        this.inventorycode = inventorycode;
    }

    public String getInventoryname() {
        return inventoryname;
    }

    public void setInventoryname(String inventoryname) {
        this.inventoryname = inventoryname;
    }

    public String getInvstd() {
        return invstd;
    }

    public void setInvstd(String invstd) {
        this.invstd = invstd;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getUnitrate() {
        return unitrate;
    }

    public void setUnitrate(String unitrate) {
        this.unitrate = unitrate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

    public String getQuotedprice() {
        return quotedprice;
    }

    public void setQuotedprice(String quotedprice) {
        this.quotedprice = quotedprice;
    }

    public String getTaxunitprice() {
        return taxunitprice;
    }

    public void setTaxunitprice(String taxunitprice) {
        this.taxunitprice = taxunitprice;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(String taxrate) {
        this.taxrate = taxrate;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getNatdiscount() {
        return natdiscount;
    }

    public void setNatdiscount(String natdiscount) {
        this.natdiscount = natdiscount;
    }

    public String getDiscountrate() {
        return discountrate;
    }

    public void setDiscountrate(String discountrate) {
        this.discountrate = discountrate;
    }

    public String getDiscountrate2() {
        return discountrate2;
    }

    public void setDiscountrate2(String discountrate2) {
        this.discountrate2 = discountrate2;
    }

    public String getNatmoney() {
        return natmoney;
    }

    public void setNatmoney(String natmoney) {
        this.natmoney = natmoney;
    }

    public String getNatunitprice() {
        return natunitprice;
    }

    public void setNatunitprice(String natunitprice) {
        this.natunitprice = natunitprice;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getNattax() {
        return nattax;
    }

    public void setNattax(String nattax) {
        this.nattax = nattax;
    }

    public String getNatsum() {
        return natsum;
    }

    public void setNatsum(String natsum) {
        this.natsum = natsum;
    }

    public String getCcontractid() {
        return ccontractid;
    }

    public void setCcontractid(String ccontractid) {
        this.ccontractid = ccontractid;
    }

    public String getBgift() {
        return bgift;
    }

    public void setBgift(String bgift) {
        this.bgift = bgift;
    }

    public String getRowno() {
        return rowno;
    }

    public void setRowno(String rowno) {
        this.rowno = rowno;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
}
