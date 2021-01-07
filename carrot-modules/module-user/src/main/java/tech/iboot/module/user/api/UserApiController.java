package tech.iboot.module.user.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.iboot.module.user.model.User;
import tech.iboot.module.user.service.IUserService;

import java.util.List;
import java.util.Map;

/**
 * @author luohong
 * @date 2021/1/4
 * @remark
 * @email luohong_studio@163.com
 * @url https://iboot.tech
 **/
@RestController
@RequestMapping("/api/user")
public class UserApiController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public List<User> list() {
        return iUserService.findUserList();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/list2")
    public List<Map> list2() {
        return iUserService.findUserList2();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/page")
    public IPage<User> page() {
        return iUserService.selectPage();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/page2")
    public IPage<Map> page2() {
        return iUserService.selectPage2();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public User user() {
        return iUserService.getUser();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/user2")
    public Map user2() {
        return iUserService.getUser2();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/save")
    public void save() {
        iUserService.saveUser();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/update")
    public void update(@RequestParam(value = "name") String name) {
        iUserService.updateUser(name);
    }
}
