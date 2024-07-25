package br.com.api.Info4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.Info4.dtos.ItemsRequisicaoDTO;
import br.com.api.Info4.dtos.ItemsRespostaDTO;
import br.com.api.Info4.service.ItemsService;

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
	
	@GetMapping("/listar")
	public List<ItemsRespostaDTO> listar() {
		return itemsService.listar();
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable Integer id) {
		itemsService.deletar(id);
	}
}
