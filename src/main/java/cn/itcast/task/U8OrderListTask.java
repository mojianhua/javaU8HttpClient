package cn.itcast.task;

import cn.itcast.pojo.U8OrdersList;
import cn.itcast.service.U8OrderListService;
import cn.itcast.util.HttpUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class U8OrderListTask {
    @Autowired
    private HttpUtils httpUtils;
    @Autowired
    private U8OrderListService u8OrderListService;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    //当下载任务完成后，间隔多长进行下一次任务
    @Scheduled(fixedDelay = 5000)
    public void U8OrderListTask() throws Exception{
//        //获取token
//        String tokenUrl = "https://api.yonyouup.com/system/token";
//        URIBuilder uriBuilder = new URIBuilder(tokenUrl);
//        uriBuilder.setParameter("from_account","xxx").
//                setParameter("app_key","xxx").
//                setParameter("app_secret","xxx");
//
//        String html = httpUtils.doGetHtml(uriBuilder.build().toString());
//        System.out.println(html);
        for (int i = 1;i <= 1 ;i++){
            //获取订单呢列表
            String orderUrl = "https://api.yonyouup.com/api/saleorderlist/batch_get";
            URIBuilder uriBuilder2 = new URIBuilder(orderUrl);
            uriBuilder2.setParameter("from_account","xxx").
                    setParameter("to_account","xxx").
                    setParameter("app_key","xxx").
                    setParameter("token","xxx").
                    setParameter("page_index",  Integer.toString(i)).
                    setParameter("rows_per_page","20");
            String orderList = null;
            orderList = httpUtils.doGetHtml(uriBuilder2.build().toString());

            JSONTokener orderListtokener = new JSONTokener(orderList);
            JSONObject orderListObject = (JSONObject) orderListtokener.nextValue();
            for(int j= 0; j < orderListObject.getJSONArray("saleorderlist").length();j++){
                String OrderListInfo = orderListObject.getJSONArray("saleorderlist").get(j).toString();
                JSONTokener listInfoTokener = new JSONTokener(OrderListInfo);
                JSONObject listInfoObject = (JSONObject) listInfoTokener.nextValue();
//                System.out.println(listInfoObject);

                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
                U8OrdersList u8OrdersList = new U8OrdersList();
                String code = null;
                code = listInfoObject.getString("code");
                u8OrdersList.setCode(code);
                //根据sku查询商品数据
                List<U8OrdersList> list = u8OrderListService.findAll(u8OrdersList);
                System.out.println(code);

                if (list.size() > 0) {
                    continue;
                }

                if(listInfoObject.has("date")){
                    u8OrdersList.setDate(sdf.parse(listInfoObject.getString("date")));
                }

                if(listInfoObject.has("businesstype")){
                    u8OrdersList.setBusinesstype(listInfoObject.getString("businesstype"));
                }

                if(listInfoObject.has("typecode")){
                    u8OrdersList.setTypecode(listInfoObject.getString("typecode"));
                }

                if(listInfoObject.has("typename")){
                    u8OrdersList.setTypename(listInfoObject.getString("typename"));
                }

                if(listInfoObject.has("state")){
                    u8OrdersList.setState(listInfoObject.getString("state"));
                }

                if(listInfoObject.has("custcode")){
                   u8OrdersList.setCustcode(listInfoObject.getString("custcode"));
                }

                if(listInfoObject.has("cusname")){
                    u8OrdersList.setCusname(listInfoObject.getString("cusname"));
                }

                if(listInfoObject.has("cusabbname")){
                   u8OrdersList.setCusname(listInfoObject.getString("cusabbname"));
                }

                if(listInfoObject.has("deptcode")){
                    u8OrdersList.setDeptcode(listInfoObject.getString("deptcode"));
                }

                if(listInfoObject.has("deptname")){
                    u8OrdersList.setDeptname(listInfoObject.getString("deptname"));
                }

                if(listInfoObject.has("personcode")){
                    u8OrdersList.setPersoncode(listInfoObject.getString("personcode"));
                }

                if(listInfoObject.has("personname")){
                    u8OrdersList.setPersonname(listInfoObject.getString("personname"));
                }

                if(listInfoObject.has("dpremodatebt")){
                    u8OrdersList.setDpredatebt(sdf.parse(listInfoObject.getString("dpremodatebt")));
                }

                if(listInfoObject.has("dpredatebt")){
                    u8OrdersList.setDpredatebt(sdf.parse(listInfoObject.getString("dpredatebt")));
                }

                if(listInfoObject.has("sendaddress")){
                    u8OrdersList.setSendaddress(listInfoObject.getString("sendaddress"));
                }

                if(listInfoObject.has("ccusperson")){
                    u8OrdersList.setCcusperson(listInfoObject.getString("ccusperson"));
                }

                if(listInfoObject.has("ccuspersoncode")){
                    u8OrdersList.setCcuspersoncode(listInfoObject.getString("ccuspersoncode"));
                }

                if(listInfoObject.has("caddcode")){
                    u8OrdersList.setCaddcode(listInfoObject.getString("caddcode"));
                }

                if(listInfoObject.has("memo")){
                    u8OrdersList.setMemo(listInfoObject.getString("memo"));
                }

                if(listInfoObject.has("money")){
                    u8OrdersList.setMoney(listInfoObject.getString("money"));
                }

                if(listInfoObject.has("sum")){
                    u8OrdersList.setSum(listInfoObject.getString("sum"));
                }

                if(listInfoObject.has("maker")){
                    u8OrdersList.setMaker(listInfoObject.getString("maker"));
                }

                if(listInfoObject.has("verifier")){
                    u8OrdersList.setVerifier(listInfoObject.getString("verifier"));
                }

                if(listInfoObject.has("closer")){
                    u8OrdersList.setCloser(listInfoObject.getString("closer"));
                }

                u8OrdersList.setCreate_at(new Date());
                u8OrderListService.save(u8OrdersList);
                System.out.println("------------------------------------------");
            }
        }
    }
}
