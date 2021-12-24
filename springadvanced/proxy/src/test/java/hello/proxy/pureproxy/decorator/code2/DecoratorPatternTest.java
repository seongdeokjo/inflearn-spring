package hello.proxy.pureproxy.decorator.code2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class DecoratorPatternTest {

    /**
     * client -> timedecorator -> messagedecorator -> realdecorator
     */
    @Test
    void decorator2(){
        Component realComponent = new RealComponent();
        Component timeDecorator = new TimeDecorator(realComponent);
        Component messageDecorator = new MessageDecorator(timeDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }
}
