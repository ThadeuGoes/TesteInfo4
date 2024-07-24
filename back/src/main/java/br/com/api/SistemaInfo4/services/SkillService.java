package br.com.api.SistemaInfo4.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.SistemaInfo4.dto.SkillRequisicaoDTO;
import br.com.api.SistemaInfo4.dto.SkillRespostaDTO;
import br.com.api.SistemaInfo4.entities.Skill;
import br.com.api.SistemaInfo4.repositories.SkillRepository;

@Service
public class SkillService {

	@Autowired
	SkillRepository skillRepository;

	public Skill parseDeSkillRequisicao(SkillRequisicaoDTO objeto) {
		Skill skillNovo = new Skill();

		skillNovo.setNome(objeto.getNome());
		skillNovo.setDescricao(objeto.getDescricao());

		return skillNovo;
	}

	public SkillRespostaDTO parseDeSkillResposta(Skill objeto) {
		SkillRespostaDTO skillNovo = new SkillRespostaDTO();

		skillNovo.setNome(objeto.getNome());
		skillNovo.setDescricao(objeto.getDescricao());
		skillNovo.setId(objeto.getId());

		return skillNovo;
	}

	public Integer getCount() {
		return skillRepository.contar();
	}

	public void salvar(SkillRequisicaoDTO objeto) {
		Skill skillNovo = parseDeSkillRequisicao(objeto);
		skillRepository.save(skillNovo);
	}

	public SkillRespostaDTO acharId(Integer id) {
		if (skillRepository.findById(id).get() == null) {

			throw new EntityNotFoundException("Esse produto não existe");
		} else {
			SkillRespostaDTO produtoResposta = parseDeSkillResposta(skillRepository.findById(id).get());
			return produtoResposta;
		}
	}

	public List<SkillRespostaDTO> listar() {
		List<SkillRespostaDTO> skillsResposta = new ArrayList<>();
		List<Skill> skills = skillRepository.findAll();
		for (Skill skill : skills) {
			skillsResposta.add(parseDeSkillResposta(skill));
		}
		return skillsResposta;
	}
}