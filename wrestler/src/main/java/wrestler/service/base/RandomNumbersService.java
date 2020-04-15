package wrestler.service.base;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class RandomNumbersService {
    public int getRandom(){
        return (int)(Math.random() * 1000);
    }
}
