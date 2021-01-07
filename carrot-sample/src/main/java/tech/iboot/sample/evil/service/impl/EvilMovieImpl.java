package tech.iboot.sample.evil.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import tech.iboot.sample.evil.mapper.EvilMovieMapper;
import tech.iboot.sample.evil.model.EvilMovie;
import tech.iboot.sample.evil.service.IEvilMovieService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author luohong
 * @date 2021/1/6
 * @remark
 * @email luohong_studio@163.com
 * @url https://iboot.tech
 **/
@Service("EvilMovieImpl")
public class EvilMovieImpl implements IEvilMovieService {
    @Resource
    private EvilMovieMapper evilMovieMapper;
    @Override
    public void saveMovie(String title, String code, String link, String icon, String date) {
        EvilMovie evilMovie = new EvilMovie();
        evilMovie.setCode(code);
        evilMovie.setTitle(title);
        evilMovie.setDate(date);
        evilMovie.setIcon(icon);
        evilMovie.setLink(link);
        evilMovieMapper.insert(evilMovie);
    }

    @Override
    public IPage<EvilMovie> findPage(int page, int pageSize) {
        Page<EvilMovie> p = new Page<>(page,pageSize);
        QueryWrapper<EvilMovie> queryWrapper  = new QueryWrapper<>();
        queryWrapper.orderByDesc("date");
        IPage<EvilMovie> pages = evilMovieMapper.selectPage(p, queryWrapper);
        return pages;
    }
}
