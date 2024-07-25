package br.com.api.Info4.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.Info4.dtos.ItemsRequisicaoDTO;
import br.com.api.Info4.dtos.ItemsRespostaDTO;
import br.com.api.Info4.entities.Items;
import br.com.api.Info4.repositories.ItemsRepository;

@Service
public class ItemsService {

	@Autowired
	ItemsRepository itemsRepository;

	public Items parseDeItemRequisicao(ItemsRequisicaoDTO objeto) {
		Items itemNovo = new Items();

		itemNovo.setNome(objeto.getNome());
		itemNovo.setDescricao(objeto.getDescricao());
		itemNovo.setData(LocalDateTime.now());

		return itemNovo;
	}

	public ItemsRespostaDTO parseDeItemsResposta(Items objeto) {
		ItemsRespostaDTO itemNovo = new ItemsRespostaDTO();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		itemNovo.setNome(objeto.getNome());
		itemNovo.setDescricao(objeto.getDescricao());
		itemNovo.setId(objeto.getId());
		itemNovo.setData(objeto.getData().format(formatter));

		return itemNovo;
	}

	public void salvar(ItemsRequisicaoDTO item) {

		Items ItemNovo = parseDeItemRequisicao(item);
		itemsRepository.save(ItemNovo);

	}

	public ItemsRespostaDTO acharId(Integer id) {
		if (itemsRepository.findById(id).get() == null) {

			throw new EntityNotFoundException("Esse produto não existe");
		} else {
			ItemsRespostaDTO produtoResposta = parseDeItemsResposta(itemsRepository.findById(id).get());
			return produtoResposta;
		}
	}

	public List<ItemsRespostaDTO> listar() {
		List<ItemsRespostaDTO> skillsResposta = new ArrayList<>();
		List<Items> items = itemsRepository.findAll();
		for (Items item : items) {
			skillsResposta.add(parseDeItemsResposta(item));
		}
		return skillsResposta;
	}

	public void deletar(Integer id) {
		itemsRepository.deleteById(id);
	}
}
