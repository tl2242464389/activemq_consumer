import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Author: tl
 * @Date: 2019-06-08 13:13
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
    }
}
