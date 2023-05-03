package cn.soe.script.ac;

import cn.soe.boot.core.util.SoeUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiezhenxiang 2023/4/28
 */
//@SpringBootApplication
public abstract class ScriptDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScriptDemoApplication.class, args);
        String[] beanNames = SoeUtils.getApplicationContext().getBeanNamesForType(ScriptDemoApplication.class);
        ScriptDemoApplication sa = SoeUtils.getBean(beanNames[1], ScriptDemoApplication.class);
        sa.exec(args);
    }

    @Override
    public void run(String... args) {
    }

    protected abstract void exec(String... args);
}
