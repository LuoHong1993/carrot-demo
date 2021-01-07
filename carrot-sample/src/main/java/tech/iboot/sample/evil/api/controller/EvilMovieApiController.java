package tech.iboot.sample.evil.api.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.iboot.sample.evil.model.EvilMovie;
import tech.iboot.sample.evil.pipeline.EvilMoviePipeline;
import tech.iboot.sample.evil.processor.EvilMovieProcessor;
import tech.iboot.sample.evil.service.IEvilMovieService;
import us.codecraft.webmagic.Spider;

import java.util.List;
import java.util.Map;

/**
 * @author luohong
 * @date 2021/1/6
 * @remark
 * @email luohong_studio@163.com
 * @url https://iboot.tech
 **/
@RestController
@RequestMapping("/api/sample/evil/movie")
public class EvilMovieApiController {
    @Autowired
    private IEvilMovieService iEvilMovieService;
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public void get() {
        Spider.create(new EvilMovieProcessor()).addUrl(EvilMovieProcessor.HOST + "1.htm").addPipeline(new EvilMoviePipeline()).thread(20).run();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/page")
    public IPage<EvilMovie> page(@RequestParam(value = "page") int page,@RequestParam(value = "pageSize") int pageSize) {
        return iEvilMovieService.findPage(page,pageSize);
    }
}
