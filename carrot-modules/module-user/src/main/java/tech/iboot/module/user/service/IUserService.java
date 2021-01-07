package tech.iboot.module.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import tech.iboot.module.user.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author luohong
 * @date 2021/1/4
 * @remark
 * @email luohong_studio@163.com
 * @url https://iboot.tech
 **/
public interface IUserService {
    public List<User> findUserList();
    public List<Map> findUserList2();
    Map getUser2();
    User getUser();
    IPage<Map> selectPage2();
    IPage<User> selectPage();
    void saveUser();
    void updateUser(String name);
}
