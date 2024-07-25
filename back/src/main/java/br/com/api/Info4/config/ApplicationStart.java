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
	private ItemsRepository skillRepository;
	@Autowired
	private ItemsService skillService;

	@PostConstruct
	public void carregarDadosIniciais() {
		if (skillRepository.count() == 0) {
			ItemsRequisicaoDTO novoSkill = new ItemsRequisicaoDTO();

			novoSkill.setNome("Criar um componente de formulário para cadastro de usuários.");
			novoSkill.setDescricao("Desenvolver um componente reutilizável para coletar dados de novos usuários, incluindo validação de campos e envio dos dados para a API.");
			skillService.salvar(novoSkill);

			novoSkill.setNome("Desenvolver uma API REST para um sistema de e-commerce");
			novoSkill.setDescricao("Criar uma interface de programação de aplicativos (API) RESTful para permitir que outros sistemas se conectem e interajam ");
			skillService.salvar(novoSkill);
		}
	}

}
