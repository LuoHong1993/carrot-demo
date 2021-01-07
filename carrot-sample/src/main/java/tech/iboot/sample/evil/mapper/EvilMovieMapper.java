package tech.iboot.sample.evil.mapper;

import tech.iboot.commons.database.mybatis.annotation.Mapper;
import tech.iboot.commons.database.mybatis.core.IDefaultMapper;
import tech.iboot.sample.evil.model.EvilMovie;

/**
 * @author luohong
 * @date 2021/1/6
 * @remark
 * @email luohong_studio@163.com
 * @url https://iboot.tech
 **/
@Mapper
public interface EvilMovieMapper extends IDefaultMapper<EvilMovie> {
}
