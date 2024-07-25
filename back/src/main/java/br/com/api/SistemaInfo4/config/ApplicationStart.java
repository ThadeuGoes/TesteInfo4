package br.com.api.SistemaInfo4.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.SistemaInfo4.dto.SkillRequisicaoDTO;
import br.com.api.SistemaInfo4.repositories.SkillRepository;
import br.com.api.SistemaInfo4.services.SkillService;

@Component
public class ApplicationStart {

	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private SkillService skillService;

	@PostConstruct
	public void carregarDadosIniciais() {
		if (skillRepository.count() == 0) {
			SkillRequisicaoDTO novoSkill = new SkillRequisicaoDTO();

			novoSkill.setNome("Item 1");
			novoSkill.setDescricao("descrição do item 1 ");
			skillService.salvar(novoSkill);
			
			novoSkill.setNome("Item 2");
			novoSkill.setDescricao("descrição do item 2 ");
			skillService.salvar(novoSkill);
		}
	}

}
