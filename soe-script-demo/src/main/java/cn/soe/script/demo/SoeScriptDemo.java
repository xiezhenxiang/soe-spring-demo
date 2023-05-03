package cn.soe.script.demo;

import cn.soe.boot.core.util.SoeUtils;
import cn.soe.script.ac.Test1;
import cn.soe.script.autoconfigure.SoeCommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author xiezhenxiang 2023/4/28
 */
@SpringBootApplication(scanBasePackages = "cn.soe.script.ac", exclude = {DataSourceAutoConfiguration.class,
JpaRepositoriesAutoConfiguration.class})
public class SoeScriptDemo extends SoeCommandLineRunner {

    @Override
    protected void exec(String... args) {
        try {
            final List<Class<?>> allActionSubClass = getAllSubClass(SoeCommandLineRunner.class);
            System.out.println(11);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(SoeUtils.getBean(Test1.class));
        System.out.println(SoeUtils.getBean(Test2.class));
    }




    /**
     * 获取指定类的所有子类
     */
    private static List<Class<?>> getAllSubClass(Class<?> clazz)  {
        List<Class<?>> ls = new ArrayList<>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Class<?> classOfClassLoader = classLoader.getClass();
            while (classOfClassLoader != ClassLoader.class) {
                classOfClassLoader = classOfClassLoader.getSuperclass();
            }
            Field field = classOfClassLoader.getDeclaredField("classes");
            field.setAccessible(true);
            Vector<?> v = (Vector<?>) field.get(classLoader);
            for (Object o : v) {
                Class<?> c = (Class<?>) o;
                // 去掉代理类和自身
                if (!c.getName().contains("$") & clazz.isAssignableFrom(c) && !clazz.equals(c)) {
                    ls.add(c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
}
