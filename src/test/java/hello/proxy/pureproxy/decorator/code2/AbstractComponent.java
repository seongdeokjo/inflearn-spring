package hello.proxy.pureproxy.decorator.code2;

abstract class AbstractComponent implements Component {
    private Component component;

    public AbstractComponent(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        return component.operation();
    }
}
