package br.edu.iftm.professores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ProfessoresApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ProfessoresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jdbcTemplate.execute("CREATE TABLE professor(id SERIAL, nome VARCHAR(255), PRIMARY KEY (id))");	
		jdbcTemplate.execute("CREATE TABLE disciplina(id SERIAL, id_professor float, nome VARCHAR(255), PRIMARY KEY (id),FOREIGN KEY (id_professor) REFERENCES professor(id));");
		jdbcTemplate.execute("CREATE TABLE aluno(id SERIAL, nome VARCHAR(255),  cpf VARCHAR(255), email VARCHAR(200), PRIMARY KEY (id))");	
 		jdbcTemplate.execute("CREATE TABLE matricula(idAluno, disciplinas, PRIMARY KEY (idAluno, disciplinas),foreign key(id_aluno) references aluno(id),foreing key(disciplinas) references disciplina(id);)");
		jdbcTemplate.update("INSERT INTO professor (nome) VALUES (?)", "Edson Angoti Júnior");
		jdbcTemplate.update("INSERT INTO professor(nome) VALUES (?)", "Clarimundo Machado");
		jdbcTemplate.update("INSERT INTO professor(nome) VALUES (?)", "Rodrigo Cavanha");
		jdbcTemplate.update("INSERT INTO professor(nome) VALUES (?)", "Bruno Queiroz");
	}}
