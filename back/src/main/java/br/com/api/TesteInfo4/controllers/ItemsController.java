package br.com.api.TesteInfo4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.TesteInfo4.dtos.ItemsRequisicaoDTO;
import br.com.api.TesteInfo4.dtos.ItemsRespostaDTO;
import br.com.api.TesteInfo4.service.ItemsService;

@RestController
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	ItemsService itemsService;

	@PostMapping("/salvar")
	public void salvar(@RequestBody ItemsRequisicaoDTO item) {
		itemsService.salvar(item);
	}

	@GetMapping("/{id}")
	public ItemsRespostaDTO acharId(@PathVariable Integer id) {
		return itemsService.acharId(id);
	}
}
