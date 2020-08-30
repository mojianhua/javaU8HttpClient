package cn.itcast.task;

import cn.itcast.pojo.Item;
import cn.itcast.service.ItemService;
import cn.itcast.util.HttpUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class itemTask {
    @Autowired
    private HttpUtils httpUtils;
    @Autowired
    private ItemService itemService;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    //当下载任务完成后，间隔多长进行下一次任务
    //@Scheduled(fixedDelay = 5000)
    public void itemTask() throws Exception{
        String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&wq=%E6%89%8B%E6%9C%BA&s=105&click=1&page=";

        for (int i = 1; i < 10 ; i = i + 2) {
            //解析页面
            String html = httpUtils.doGetHtml(url + i);

            //获取Html解析Document
            Document doc = Jsoup.parse(html);

            //获取spu信息
            Elements spuEles = doc.select("div#J_goodsList > ul > li");
            for (Element spuEle : spuEles) {
                //获取spu
                String data_spu = spuEle.attr("data-spu");
                if (data_spu.isEmpty()){
                    continue;
                }else{
                    System.out.println(data_spu);
                    long spu = Long.parseLong(data_spu);
                    //获取sku信息
                    Elements skuEls = spuEle.select("li.ps-item");

                    for (Element skuEle : skuEls) {
                        //获取sku
                        long sku = Long.parseLong(skuEle.select("[data-sku]").attr("data-sku"));
                        Item item = new Item();

                        item.setSku(sku);
                        //根据sku查询商品数据
                        List<Item> list = this.itemService.findAll(item);
                        if (list.size() > 0) {
                            continue;
                        }

                        //设置商品的spu
                        item.setSpu(spu);

                        //获取商品的详细url
                        String itemUrl = "https://item.jd.com/" + sku + ".html";
                        item.setUrl(itemUrl);

                        //获取图片
                        String picUrl = skuEle.select("img[data-sku]").first().attr("data-lazy-img");
                        picUrl = picUrl.replace("/n9/", "/n1/");
                        String picName = this.httpUtils.doGetImage(picUrl);
                        item.setPic(picName);

                        //获取价格
                        String priceJson = this.httpUtils.doGetHtml("https://p.3.cn/prices/mgets?skuIds=J_" + sku);
                        double price = 1.2;
                        item.setPrice(price);

                        //获取产品名称
                        String itemInfo = this.httpUtils.doGetHtml(itemUrl);
                        String title = Jsoup.parse(itemInfo).select("div.sku-name").text();
                        item.setTitle(title);

                        item.setCreated(new Date());
                        item.setCreated(new Date());

                        itemService.save(item);
                    }
                }
            }

            System.out.println("Success");
        }
    }
}
