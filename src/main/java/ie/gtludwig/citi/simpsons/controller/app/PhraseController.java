package ie.gtludwig.citi.simpsons.controller.app;

import ie.gtludwig.citi.simpsons.persistence.model.Character;
import ie.gtludwig.citi.simpsons.service.CharacterService;
import ie.gtludwig.citi.simpsons.service.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "phrases")
public class PhraseController {
    @Autowired
    private CharacterService characterService;

    @Autowired
    private PhraseService phraseService;

    @RequestMapping(value = "/listByCharacter", method = RequestMethod.GET)
    public String listCharactersByLastName(ModelMap modelMap, @RequestParam(value = "id") String id) {
        Character character = characterService.retrieve(id);
        modelMap.addAttribute("character", character);
        modelMap.addAttribute("pojoList", phraseService.findAllPhrasesByCharacter(character));
        modelMap.addAttribute("newPhrase", new String());
        return "phrases";
    }
}
