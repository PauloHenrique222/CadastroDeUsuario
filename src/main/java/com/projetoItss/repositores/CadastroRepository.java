package com.projetoItss.repositores;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.projetoItss.models.Pessoa;

public interface CadastroRepository extends CrudRepository<Pessoa, String>{
	
	List<Pessoa> findByNome(String nome);

}
