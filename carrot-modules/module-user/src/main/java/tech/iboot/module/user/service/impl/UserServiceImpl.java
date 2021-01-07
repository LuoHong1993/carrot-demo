package tech.iboot.module.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import tech.iboot.module.user.mapper.UserMapper;
import tech.iboot.module.user.model.User;
import tech.iboot.module.user.service.IUserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author luohong
 * @date 2021/1/4
 * @remark
 * @email luohong_studio@163.com
 * @url https://iboot.tech
 **/
@Service("UserServiceImpl")
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> findUserList() {
        List<User> list = userMapper.selectList(null);
        return list;
    }

    @Override
    public List<Map> findUserList2() {
        return userMapper.findListBySql("select * from sys_user");
    }

    @Override
    public Map getUser2() {
        return userMapper.findBySql("select id, name from sys_user");
    }

    @Override
    public User getUser() {
        return userMapper.findEntityBySql("select * from sys_user");
    }

    @Override
    public IPage<Map> selectPage2() {
        LambdaQueryWrapper<Map> query = new LambdaQueryWrapper<>();
        Page<Map> p = new Page<>(1,1);
        String sql = "select id, name from sys_user";
        IPage<Map> page = userMapper.findListPageBySql(p, sql);
        return page;
    }


    @Override
    public IPage<User> selectPage() {
        // Page<User> page = new Page<>(1, 5);
        LambdaQueryWrapper<User> query = new LambdaQueryWrapper<>();
        Page<User> p = new Page<>(1,1);
        String sql = "select * from sys_user";
        IPage<User> page = userMapper.findListPageEntityBySql(p, sql);
        //return userMapper.selectPage(p, null);
        return page;
    }

    @Override
    public void saveUser() {
        User user = new User();
        user.setAccount("hehe");
        user.setName("哈哈");
        user.setPassword("22");
        user.setFlag("1");
        user.setEmail("ww@aa.com");
        userMapper.insert(user);
    }

    @Override
    public void updateUser(String name) {
        User user = userMapper.selectById("3553f90f7e241a31e858f09347f0784c");
        user.setName(name);
        userMapper.updateById(user);
    }
}
