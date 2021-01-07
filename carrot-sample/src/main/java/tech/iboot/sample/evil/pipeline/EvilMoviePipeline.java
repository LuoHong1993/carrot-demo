package tech.iboot.sample.evil.pipeline;

import com.alibaba.fastjson.JSON;
import tech.iboot.core.utils.SpringContextUtil;
import tech.iboot.sample.evil.service.IEvilMovieService;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

/**
 * @author luohong
 * @date 2021/1/6
 * @remark
 * @email luohong_studio@163.com
 * @url https://iboot.tech
 **/
public class EvilMoviePipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        IEvilMovieService iEvilMovieService = SpringContextUtil.getInstance().getBean("EvilMovieImpl");
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            Map<String, String > map = JSON.parseObject(JSON.toJSONString(entry.getValue()), Map.class);
            String code = entry.getKey();
            String title = map.get("title");
            String icon = map.get("icon");
            String link = map.get("link");
            String date = map.get("date");
            iEvilMovieService.saveMovie(title,code,link,icon,date);
        }
    }
}
