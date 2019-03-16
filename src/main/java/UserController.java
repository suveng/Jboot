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
        render("/add.html");
    }

    public void doSave() {
        String username = getPara("username");
        String password = getPara("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        user.save();

        redirect("/user");
    }

}
