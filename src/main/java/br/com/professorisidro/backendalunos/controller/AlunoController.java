package br.com.professorisidro.backendalunos.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.professorisidro.backendalunos.model.Aluno;
import br.com.professorisidro.backendalunos.security.Autenticator;

@RestController
@CrossOrigin("*")
public class AlunoController {
	
	@GetMapping("/aluno/todos")
	public ResponseEntity<ArrayList<Aluno>> getAllAlunos(@RequestParam String token){
		if (Autenticator.isValid(token)) {
			/* este trecho é simulando uma consulta ao banco de dados */
			ArrayList<Aluno> lista = new ArrayList<Aluno>();
			for (int i=0;i<20;i++) {
				Aluno a = new Aluno();
				a.setRa((i+1)*100);
				a.setNome("Aluno "+(i+1));
				a.setTelefone("91111-00"+(i+1));
				a.setEmail("aluno"+(i+1)+"@escola.com.br");
				a.setCurso("Java JR Developer Genereites Full Stack pro plus");
				
				lista.add(a);
			}
			return ResponseEntity.ok(lista);
		}
		else {
			return ResponseEntity.status(403).build();
		}
		
	}

}
