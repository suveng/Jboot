package my.suveng.controller;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.Jboot;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import my.suveng.model.User;
import my.suveng.service.UserService;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/3/15
 * description:
 **/
@RequestMapping("/")
public class IndexController extends JbootController {
    @Inject
    UserService userService;
    public void index() {
        renderText("Hello World Jboot");
    }

    public void dbtest() {
        List<Record> records = Db.find("select * from user");
        renderText(Arrays.toString(records.toArray()));
    }
    public void users() {
        // 这里用到了 userService 的查询方法
        List<User> users = userService.findAll();
        renderText(Arrays.toString(users.toArray()));
    }

    public static void main(String[] args) {
        Jboot.run(args);
    }
}
