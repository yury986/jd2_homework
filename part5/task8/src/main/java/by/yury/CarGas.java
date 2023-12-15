package by.yury;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:/some.properties")
@Component
public class CarGas {
    private IEngine engine;

    private String model;

    public CarGas(@Autowired IEngine engine,
                  @Value("${default.component.model}")String model) {
        this.engine = engine;
        this.model = model;
    }

    public IEngine getEngine() {
        return engine;
    }
}
