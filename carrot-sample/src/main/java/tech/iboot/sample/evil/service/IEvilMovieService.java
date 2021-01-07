package tech.iboot.sample.evil.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import tech.iboot.sample.evil.model.EvilMovie;

/**
 * @author luohong
 * @date 2021/1/6
 * @remark
 * @email luohong_studio@163.com
 * @url https://iboot.tech
 **/
public interface IEvilMovieService {
    void saveMovie(String title, String code, String link, String icon, String date);
    IPage<EvilMovie> findPage(int page, int pageSize);
}
