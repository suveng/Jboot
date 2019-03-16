package my.suveng.controller;

import com.jfinal.plugin.activerecord.Page;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import my.suveng.model.User;
import my.suveng.service.impl.UserServiceImpl;

import javax.inject.Inject;

/**
 * @author suwenguang
 * suveng@163.com
 * since 2019/3/16
 * description:
 **/
@RequestMapping("/user")
public class UserController extends JbootController {

    @Inject
    private UserServiceImpl userService;

    public void index() {
        int page = getParaToInt("page", 1);
        Page<User> userPage = userService.paginate(page, 10);
        setAttr("pageData", userPage);
        render("/user.html");
    }

    public void add() {
        int id = getParaToInt("id", 0);
        if (id > 0) { //有id ，说明有数据提交过来，用来做修改的标识。
            setAttr("id", id);
        }
        render("/add.html");
    }

    public void doSave() {
        String username = getPara("username");
        String password = getPara("password");
        int id = getParaToInt("id", 0);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (id > 0) { //说明是更新
            user.setId(id);
            user.update();
        } else { //说明是新增
            user.save();
        }

        redirect("/user");
    }
    public void del() {
        long id = getParaToLong("id",0l);
        userService.deleteById(id);
        redirect("/user");
    }

}
