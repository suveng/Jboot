package my.suveng.common;

import io.jboot.web.directive.JbootPaginateDirective;
import io.jboot.web.directive.annotation.JFinalDirective;

/**
 * @author suwenguang
 * suveng@163.com
 * since 2019/3/16
 * description:
 **/
@JFinalDirective("myPaginate")
public class MyPaginateDirective extends JbootPaginateDirective {

    @Override
    protected String getPageAttrName() {
        return "pageData"; //这个值要和Controller里setAttr的第一个参数值相同
    }
}
