package br.com.api.SistemaInfo4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.SistemaInfo4.dto.SkillRequisicaoDTO;
import br.com.api.SistemaInfo4.dto.SkillRespostaDTO;
import br.com.api.SistemaInfo4.services.SkillService;

@RestController
@RequestMapping("/item")
public class SkillController {

	@Autowired
	SkillService skillService;

	@PostMapping("/salvar")
	public void salvar(@RequestBody SkillRequisicaoDTO objetoProduto) {
		skillService.salvar(objetoProduto);
	}

	@GetMapping("/{id}")
	public SkillRespostaDTO acharId(@PathVariable Integer id) {
		return skillService.acharId(id);
	}

	@GetMapping("/listar")
	public List<SkillRespostaDTO> listar() {
		return skillService.listar();
	}

}
