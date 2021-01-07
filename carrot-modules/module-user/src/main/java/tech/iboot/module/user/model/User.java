package tech.iboot.module.user.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import tech.iboot.commons.database.mybatis.core.BaseModel;
import java.util.Date;

/**
 * @author luohong
 * @date 2021/1/4
 * @remark
 * @email luohong_studio@163.com
 * @url https://iboot.tech
 **/
@Data
@TableName("sys_user")
public class User extends BaseModel<User> {
    /**
     * 存在
     */
    public final static String EXIST = "0";

    /**
     * 已删除
     */
    public final static String NOTEXIST = "1";
    /**
     * 姓名
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 联系方式
     */
    private String mobile;

    /**
     * 是否存在,0-存在，1-删除
     */
    private String flag;

    /**
     * 邮件
     */
    private String email;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
