import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.Jboot;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;

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

    public void index() {
        renderText("Hello World Jboot");
    }
    public void dbtest(){
        List<Record> records = Db.find("select * from user");
        renderText(Arrays.toString(records.toArray()));
    }

    public static void main(String[] args) {
        Jboot.run(args);
    }
}
