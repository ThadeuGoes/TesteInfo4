package br.com.api.Info4.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.Info4.dtos.ItemsRequisicaoDTO;
import br.com.api.Info4.repositories.ItemsRepository;
import br.com.api.Info4.service.ItemsService;

@Component
public class ApplicationStart {

	@Autowired
	private ItemsRepository itemRepository;
	@Autowired
	private ItemsService itemService;

	@PostConstruct
	public void carregarDadosIniciais() {
		if (itemRepository.count() == 0) {
			ItemsRequisicaoDTO novoItem = new ItemsRequisicaoDTO();

			novoItem.setNome("Criar um componente de formulário para cadastro de usuários.");
			novoItem.setDescricao("Desenvolver um componente reutilizável para coletar dados de novos usuários, incluindo validação de campos e envio dos dados para a API.");
			itemService.salvar(novoItem);

			novoItem.setNome("Desenvolver uma API REST para um sistema de e-commerce");
			novoItem.setDescricao("Criar uma interface de programação de aplicativos (API) RESTful para permitir que outros sistemas se conectem e interajam ");
			itemService.salvar(novoItem);
			
			
		}
	}

}
