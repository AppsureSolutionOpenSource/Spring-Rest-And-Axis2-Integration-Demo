package wrestler.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wrestler.service.base.RandomNumbersService;

@RestController
public class RandomNumbersRestController {
    public final static String PATH = "/api/rest/getRandom";

    @Autowired
    private RandomNumbersService randomNumbersService;

    @GetMapping(path = PATH, produces = "application/json")
    @ResponseBody
    public int getRandom(){
        return randomNumbersService.getRandom();
    }


}