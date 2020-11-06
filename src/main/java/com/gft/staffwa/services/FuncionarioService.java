package com.gft.staffwa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gft.staffwa.models.Funcionario;
import com.gft.staffwa.repositories.Filter;
import com.gft.staffwa.repositories.Funcionarios;
import com.gft.staffwa.utils.TerminoWa;

@Service
public class FuncionarioService {

	@Autowired
	private Funcionarios funcionarios;

	public List<Funcionario> filtrar(Filter filtro) {
		final String nomeFuncionario = (filtro).getNomeFuncionario() == null ? "" : filtro.getNomeFuncionario();
		return this.funcionarios.findByNomeContaining(nomeFuncionario);
	}

	public void salvar(Funcionario funcionario) throws DataIntegrityViolationException {
		try {
			funcionario.setTerminoWa(TerminoWa.calcularData(funcionario.getInicioWa(), 15));
			this.funcionarios.save(funcionario);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Matrícula já registrada");
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

}
