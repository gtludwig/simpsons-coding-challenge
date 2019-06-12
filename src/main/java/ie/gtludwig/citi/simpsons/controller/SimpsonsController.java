package ie.gtludwig.citi.simpsons.controller;

import ie.gtludwig.citi.simpsons.persistence.model.Character;
import ie.gtludwig.citi.simpsons.service.SimpsonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SimpsonsController {

    @Autowired
    private SimpsonsService simpsonsService;

    @RequestMapping(value = {"/", "/characters"}, method = RequestMethod.GET)
    public String listCharacters(ModelMap modelMap, @RequestParam(value = "lastName", required = false) String lastName, RedirectAttributes redirectAttributes) {
        modelMap.addAttribute("pojoList", lastName == null ? simpsonsService.findAll() : simpsonsService.findAllByLastName(lastName));
        return "characters";
    }

    @RequestMapping(value = "/listPhrases", method = RequestMethod.GET)
    public String listCharactersByLastName(ModelMap modelMap, @RequestParam(value = "id") String id) {
        Character character = simpsonsService.retrieve(id);
        modelMap.addAttribute("character", character);
        modelMap.addAttribute("pojoList", simpsonsService.findAllByCharacter(character));
        return "phrases";
    }

}
