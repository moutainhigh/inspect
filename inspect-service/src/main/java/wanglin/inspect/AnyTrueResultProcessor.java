package wanglin.inspect;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async
public class AnyTrueResultProcessor implements RuleResultProcessor {

    @Override
    public void processResult(InspectContext context) {

        if (context.getRules().values().stream().filter(v -> (null != v.result && v.result instanceof Boolean && (Boolean) v.result)).count() > 0) {
            context.result = true;
        }
    }

}
