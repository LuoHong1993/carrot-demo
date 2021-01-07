package tech.iboot.sample.evil.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import tech.iboot.commons.database.mybatis.core.BaseModel;

import java.util.Date;

/**
 * @author luohong
 * @date 2021/1/6
 * @remark
 * @email luohong_studio@163.com
 * @url https://iboot.tech
 **/
@Data
@TableName("evil_movie")
public class EvilMovie extends BaseModel<EvilMovie> {
    /**
     * 番号
     */
    private String code;

    /**
     * 标题
     */
    private String title;

    /**
     * 上映时间
     */
    private String date;

    /**
     * 链接
     */
    private String link;

    /**
     * 海报
     */
    private String icon;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
