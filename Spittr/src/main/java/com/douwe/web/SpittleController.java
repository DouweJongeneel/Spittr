package com.douwe.web;

import com.douwe.Spittle;
import com.douwe.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by Milan_Verheij on 03-08-16.
 *
 * Controller voor /spittles
 */

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Spittle> spittles(
            @RequestParam(value = "max",
                            defaultValue=MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count",
                            defaultValue="20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value="/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId,
            Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }


//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model) {
//        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//        return "spittles";
//    }
}
