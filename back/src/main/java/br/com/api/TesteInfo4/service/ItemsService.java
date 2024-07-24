package br.com.api.TesteInfo4.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.TesteInfo4.dtos.ItemsRequisicaoDTO;
import br.com.api.TesteInfo4.dtos.ItemsRespostaDTO;
import br.com.api.TesteInfo4.entities.Items;
import br.com.api.TesteInfo4.repositories.ItemsRepository;

@Service
public class ItemsService {

	@Autowired
	ItemsRepository itemsRepository;

	public Items parseDeItemRequisicao(ItemsRequisicaoDTO objeto) {
		Items skillNovo = new Items();

		skillNovo.setNome(objeto.getNome());
		skillNovo.setDescricao(objeto.getDescricao());

		return skillNovo;
	}

	public void salvar(ItemsRequisicaoDTO item) {

		Items ItemNovo = parseDeItemRequisicao(item);
		itemsRepository.save(ItemNovo);

	}

	public ItemsRespostaDTO parseDeItemsResposta(Items objeto) {
		ItemsRespostaDTO skillNovo = new ItemsRespostaDTO();

		skillNovo.setNome(objeto.getNome());
		skillNovo.setDescricao(objeto.getDescricao());
		skillNovo.setId(objeto.getId());

		return skillNovo;
	}

	public ItemsRespostaDTO acharId(Integer id) {
		if (itemsRepository.findById(id).get() == null) {

			throw new EntityNotFoundException("Esse produto não existe");
		} else {
			ItemsRespostaDTO produtoResposta = parseDeItemsResposta(itemsRepository.findById(id).get());
			return produtoResposta;
		}
	}

}
