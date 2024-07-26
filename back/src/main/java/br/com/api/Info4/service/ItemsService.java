package br.com.api.Info4.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public Items parseDeItemRequisicao(ItemsRequisicaoDTO item) {
		Items itemNovo = new Items();

		itemNovo.setNome(item.getNome());
		itemNovo.setDescricao(item.getDescricao());
		itemNovo.setData(LocalDateTime.now());

		return itemNovo;
	}

	public ItemsRespostaDTO parseDeItemsResposta(Items item) {
		ItemsRespostaDTO itemNovo = new ItemsRespostaDTO();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		itemNovo.setNome(item.getNome());
		itemNovo.setDescricao(item.getDescricao());
		itemNovo.setId(item.getId());
		itemNovo.setData(item.getData().format(formatter));

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
		List<ItemsRespostaDTO> itemsResposta = new ArrayList<>();
		List<Items> items = itemsRepository.findAll();
		
		for (Items item : items) {
			itemsResposta.add(parseDeItemsResposta(item));
		}
		return itemsResposta;
	}

	public void deletar(Integer id) {
		itemsRepository.deleteById(id);
	}

	public ItemsRespostaDTO atualizar(Integer id, ItemsRequisicaoDTO itemMuda) {

		if (itemsRepository.findById(id).get() == null) {
			throw new EntityNotFoundException("item nao existe");

		} else {
			Optional<Items> itemVelho = itemsRepository.findById(id);
			Items item = parseDeItemRequisicao(itemMuda);

			if (item.getNome() != null) {
				itemVelho.get().setNome(item.getNome());
			}
			if (item.getDescricao() != null) {
				itemVelho.get().setDescricao(item.getDescricao());
			}

			itemVelho.get().setId(id);

			return parseDeItemsResposta(itemsRepository.save(itemVelho.get()));

		}
	}
}
