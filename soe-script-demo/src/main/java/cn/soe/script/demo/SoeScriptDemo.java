package cn.soe.script.demo;

import cn.soe.script.autoconfigure.SoeCommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiezhenxiang 2023/4/28
 */
@SpringBootApplication
public class SoeScriptDemo extends SoeCommandLineRunner {

    @Override
    protected void exec(String... args) {
        System.out.println("hello, world!");
    }
}
