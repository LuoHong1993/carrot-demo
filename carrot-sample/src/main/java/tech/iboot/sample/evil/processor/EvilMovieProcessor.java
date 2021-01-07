package tech.iboot.sample.evil.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luohong
 * @date 2021/1/6
 * @remark
 * @email luohong_studio@163.com
 * @url https://iboot.tech
 **/
public class EvilMovieProcessor implements PageProcessor {
    public static final String HOST = "https://ww6548.com/serchinfo_censored/topicsbt/topicsbt_";
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1200).setTimeOut(1000000);
    @Override
    public void process(Page page) {
        List<Selectable> nodes = page.getHtml().xpath("//div[@id='PoShow_Box']/div[@class='Po_topic']").nodes();
        for(Selectable node: nodes) {
            String serial = node.xpath("//div[@class='Po_topic_Date_Serial']/font/text()").toString();
            String code = serial.substring(0, serial.indexOf("/"));
            String date = serial.substring(code.length()+1, serial.length());
            code = code.trim();
            date = date.trim();
            String link = node.xpath("//div[@class='Po_topicCG']/a/@href").toString();
            String title = node.xpath("//div[@class='Po_topic_title']/a/b/text()").toString();
            String icon = node.xpath("//div[@class='Po_topicCG']/a/img/@src").toString();
            Map<String,String> av = new HashMap<>();
            av.put("date", date);
            av.put("icon", icon);
            av.put("link", link);
            av.put("title", title);
            page.putField(code, av);
        }
        List<String> links = new ArrayList<>();
        int total = Integer.parseInt(page.getHtml().xpath("//span[@class='page_previous']/a/text()").toString());
        for (int i=2; i<total; i++) {
            String link = HOST + i + ".htm";
            links.add(link);
        }
        page.addTargetRequests(links);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
