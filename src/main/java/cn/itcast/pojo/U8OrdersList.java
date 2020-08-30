package cn.itcast.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "u8_orders_list")
public class U8OrdersList {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String code;
    private String businesstype;
    private String typecode;
    private String typename;
    private String state;
    private String custcode;
    private String cusname;
    private String deptcode;
    private String cusabbname;
    private String personcode;
    private String deptname;
    private String personname;
    private String sendaddress;
    private String ccusperson;
    private String ccuspersoncode;
    private String memo;
    private String money;
    private String sum;
    private String maker;
    private String closer;
    private String verifier;
    private String caddcode;
    private Date dpremodatebt;
    private Date dpredatebt;
    private Date date;
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

    public String getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCustcode() {
        return custcode;
    }

    public void setCustcode(String custcode) {
        this.custcode = custcode;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getCusabbname() {
        return cusabbname;
    }

    public void setCusabbname(String cusabbname) {
        this.cusabbname = cusabbname;
    }

    public String getPersoncode() {
        return personcode;
    }

    public void setPersoncode(String personcode) {
        this.personcode = personcode;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public String getSendaddress() {
        return sendaddress;
    }

    public void setSendaddress(String sendaddress) {
        this.sendaddress = sendaddress;
    }

    public String getCcusperson() {
        return ccusperson;
    }

    public void setCcusperson(String ccusperson) {
        this.ccusperson = ccusperson;
    }

    public String getCcuspersoncode() {
        return ccuspersoncode;
    }

    public void setCcuspersoncode(String ccuspersoncode) {
        this.ccuspersoncode = ccuspersoncode;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getCloser() {
        return closer;
    }

    public void setCloser(String closer) {
        this.closer = closer;
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    public String getCaddcode() {
        return caddcode;
    }

    public void setCaddcode(String caddcode) {
        this.caddcode = caddcode;
    }

    public Date getDpremodatebt() {
        return dpremodatebt;
    }

    public void setDpremodatebt(Date dpremodatebt) {
        this.dpremodatebt = dpremodatebt;
    }

    public Date getDpredatebt() {
        return dpredatebt;
    }

    public void setDpredatebt(Date dpredatebt) {
        this.dpredatebt = dpredatebt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
}
