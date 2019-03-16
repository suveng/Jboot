package my.suveng.common;

import io.jboot.codegen.model.JbootModelGenerator;
import io.jboot.codegen.service.JbootServiceGenerator;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/3/15
 * description:
 **/
public class CodeGenerator {

    public static void main(String args[]){
        //依赖model的包名
        String modelPackage = "my.suveng.model";
        //生成service 的包名
        String basePackage = "my.suveng.service";

        JbootModelGenerator.run(modelPackage);
        JbootServiceGenerator.run(basePackage, modelPackage);

    }
}
