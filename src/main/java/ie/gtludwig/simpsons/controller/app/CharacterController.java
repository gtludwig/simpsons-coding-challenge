package ie.gtludwig.simpsons.controller.app;

import ie.gtludwig.simpsons.persistence.model.Character;
import ie.gtludwig.simpsons.persistence.model.Phrase;
import ie.gtludwig.simpsons.service.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class CharacterController {

    private static final Logger logger = LoggerFactory.getLogger(CharacterController.class);

    @Autowired
    private CharacterService characterService;

    @Autowired
    private ApplicationContext context;

    private String lastAction;

    private String buildLastAction(String message, Object[] params) {
        return context.getMessage(message, params, Locale.US);
    }

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listCharacters(ModelMap modelMap, @RequestParam(value = "lastName", required = false) String lastName, RedirectAttributes redirectAttributes) {
        List<Character> pojoList;
        if (lastName != null) {
            modelMap.addAttribute("initial", false);
            pojoList = characterService.findAllCharactersByLastName(lastName);
        } else {
            modelMap.addAttribute("initial", true);
            pojoList = characterService.findAllCharacters();
        }
        modelMap.addAttribute("pojoList", pojoList);
        modelMap.addAttribute("character", new Character());
        return "characters";
    }

    @SuppressWarnings("Duplicates")
    @RequestMapping(value = "/createCharacter", method = RequestMethod.POST)
    public String createCharacter(ModelMap modelMap,
                                  @Valid @ModelAttribute(value = "character") Character character,
                                  Errors errors,
                                  final RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                logger.error(error.getObjectName());
            }
            return "redirect:list";
        }
        lastAction = buildLastAction("createFail", new Object[]{"character", character.getFirstName()});
        try {
            characterService.createCharacter(character.getFirstName(), character.getLastName(), character.getPicture(), new ArrayList<Phrase>(), character.getAge());
            lastAction = buildLastAction("createSuccess", new Object[]{"character", character.getFirstName()});
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            logger.error(e.toString());
        }
        logger.info(lastAction);
        redirectAttributes.addFlashAttribute("lastAction", lastAction);
        return "redirect:list";
    }

    @SuppressWarnings("Duplicates")
    @RequestMapping(value = "/editCharacter", method = RequestMethod.POST)
    public String editCharacter(ModelMap modelMap,
                                @Valid @ModelAttribute(value = "character") Character character,
                                  Errors errors,
                                  final RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                logger.error(error.getObjectName());
            }
            return "/list";
        }
        Object[] params = new Object[] {"character", character.getFirstName()};
        lastAction = buildLastAction("editFail", params);
        try {
            characterService.updateCharacter(character.getId(), character.getFirstName(), character.getLastName(), character.getPicture(), new ArrayList<Phrase>(), character.getAge());
            lastAction = buildLastAction("editSuccess", params);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            logger.error(e.toString());
        }
        logger.info(lastAction);
        redirectAttributes.addFlashAttribute("lastAction", lastAction);
        return "redirect:list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCharacter(ModelMap modelMap,
                                  @RequestParam(value = "characterId") String characterId,
                                  final RedirectAttributes redirectAttributes) {
        Character character = characterService.retrieveCharacter(characterId);
        Object[] params = new Object[] {"character", character.getFirstName()};
        lastAction = buildLastAction("removeFail", params);
        try {
            characterService.deleteCharacter(characterId);
            lastAction = buildLastAction("removeSuccess", params);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            logger.error(e.toString());
        }
        logger.info(lastAction);
        redirectAttributes.addFlashAttribute("lastAction", lastAction);
        return "redirect:list";
    }
}
