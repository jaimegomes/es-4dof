package br.senai.sc.es4dof.controller;

import java.util.List;

import br.senai.sc.es4dof.abstracts.Entidade;
import br.senai.sc.es4dof.interfaces.IController;

public class EmpresaController implements IController {

	@Override
	public void salvar(Entidade entidade) throws Exception {

	}

	@Override
	public void excluir(Entidade entidade) throws Exception {

	}

	@Override
	public void editar(Entidade entidade) throws Exception {

	}

	@Override
	public List<Entidade> listar() throws Exception {
		return null;
	}

	@Override
	public Entidade getPorId(int id) throws Exception {
		return null;
	}
	
	public Entidade getPorRazaoSocial(String razaoSocial) throws Exception {
		return null;
	}

}
