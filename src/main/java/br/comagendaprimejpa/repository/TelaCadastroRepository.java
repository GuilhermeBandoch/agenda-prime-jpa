package br.comagendaprimejpa.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.comagendaprimejpa.model.TelaCadastro;

public class TelaCadastroRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
	
	public TelaCadastro salvar(TelaCadastro telaCadastro) {
		return entityManager.merge(telaCadastro);
	}
	
	public List<TelaCadastro> ListarTudo(){
		return entityManager.createQuery("from tela_cadastro",TelaCadastro.class).getResultList();
	}
	
	public TelaCadastro porId(Long id) {
		return entityManager.find(TelaCadastro.class,  id);
	}
	
	public void remover(TelaCadastro telaCadastro) {
	telaCadastro = porId(telaCadastro.getCpf());
	entityManager.remove(telaCadastro);
	}
}
