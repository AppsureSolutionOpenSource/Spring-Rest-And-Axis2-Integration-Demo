package wrestler.service.soap;

import org.springframework.beans.factory.annotation.Autowired;
import wrestler.service.base.RandomNumbersService;

public class RandomNumbersSoapController {
   @Autowired
   private RandomNumbersService randomNumbersService;

   public int getRandom(){
       return randomNumbersService.getRandom();
   }
}
