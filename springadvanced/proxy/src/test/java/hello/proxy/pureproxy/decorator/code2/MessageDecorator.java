package hello.proxy.pureproxy.decorator.code2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator extends AbstractComponent {

    public MessageDecorator(Component component) {
        super(component);
    }

    public String addStar(){
        return "*****";
    }

    @Override
    public String operation() {
        log.info("MessageDecorator 실행");
        String result = super.operation();
        log.info("MessageDecorator 꾸미기 적용 전 ={}, 적용 후 ={}",result, addStar() + result + addStar());
        return addStar() + result + addStar();
    }
}
