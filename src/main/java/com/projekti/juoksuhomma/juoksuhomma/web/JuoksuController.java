package com.projekti.juoksuhomma.juoksuhomma.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Optional;
import org.springframework.security.access.prepost.PreAuthorize;
import com.projekti.juoksuhomma.juoksuhomma.domain.*;

@Controller
public class JuoksuController {
	@Autowired
	private JuoksuhommaRepository jrepository;
	@Autowired
	private CategoryRepository crepository;
	@Autowired
	private NimiRepository nrepository;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// Kaikkien tulosten listaus ja osittainen omien tulosten listaus josta puuttuu
	// kirjautuneena olevan tietojen vertailu
	// querystä saatuun listaan
	@RequestMapping(value = { "/", "/juoksutlist" })
	public String listJuoksuhomma(Model model) {
		model.addAttribute("juoksut", jrepository.findAll());
		List<Juoksuhomma> omatjuoksut = nrepository.findAllNimet();
		model.addAttribute("omatjuoksut", omatjuoksut);
		return "juoksutlist";
	}

	// lisäys
	@RequestMapping(value = "/addjuoksu")
	public String addJuoksuhomma(Model model) {
		model.addAttribute("juoksuhomma", new Juoksuhomma());
		model.addAttribute("categories", crepository.findAll());
		return "addjuoksu";
	}

	// muokkauksen tallennus tietokantaan
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Juoksuhomma juoksuhomma) {
		jrepository.save(juoksuhomma);
		return "redirect:juoksutlist";
	}

	// poistaminen
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteJuoksuhomma(@PathVariable("id") Long juoksuhommaId, Model model) {
		jrepository.deleteById(juoksuhommaId);
		return "redirect:../juoksutlist";
	}

	// muokkaus
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/edit/{id}")
	public String addJuoksuhomma(@PathVariable("id") Long juoksuhommaId, Model model) {
		model.addAttribute("juoksuhomma", jrepository.findById(juoksuhommaId));
		model.addAttribute("categories", crepository.findAll());
		return "editjuoksu";
	}

	// muokkaus käyttäjälle
	@RequestMapping(value = "/editu/{id}")
	public String addJuoksuhommaUser(@PathVariable("id") Long juoksuhommaId, Model model) {
		model.addAttribute("juoksuhomma", jrepository.findById(juoksuhommaId));
		model.addAttribute("categories", crepository.findAll());
		return "editjuoksu";
	}

	// poistaminen käyttäjälle
	@RequestMapping(value = "/deleteu/{id}", method = RequestMethod.GET)
	public String deleteJuoksuhommaUser(@PathVariable("id") Long juoksuhommaId, Model model) {
		jrepository.deleteById(juoksuhommaId);
		return "redirect:../juoksutlist";
	}

	// restillä kaikki juoksutulokset
	@RequestMapping(value = "/juoksut", method = RequestMethod.GET)
	public @ResponseBody List<Juoksuhomma> juoksutListRest() {
		return (List<Juoksuhomma>) jrepository.findAll();
	}

	// restillä id:n mukaan
	@RequestMapping(value = "/juoksu/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Juoksuhomma> findjuoksutRest(@PathVariable("id") Long juoksuhommaId) {
		return jrepository.findById(juoksuhommaId);
	}

}