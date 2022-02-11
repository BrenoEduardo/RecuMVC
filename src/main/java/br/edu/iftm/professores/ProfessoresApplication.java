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
<<<<<<< HEAD
		jdbcTemplate.execute("CREATE TABLE professor(id SERIAL, nome VARCHAR(255), PRIMARY KEY (id))");	
		jdbcTemplate.execute("CREATE TABLE disciplina(id SERIAL, id_professor float, nome VARCHAR(255), PRIMARY KEY (id),FOREIGN KEY (id_professor) REFERENCES professor(id));");
		jdbcTemplate.execute("CREATE TABLE aluno(id SERIAL, nome VARCHAR(255),  cpf VARCHAR(255), email VARCHAR(200), PRIMARY KEY (id))");	
 		jdbcTemplate.execute("CREATE TABLE matricula(idAluno, disciplinas, PRIMARY KEY (idAluno, disciplinas),foreign key(id_aluno) references aluno(id),foreing key(disciplinas) references disciplina(id);)");
		jdbcTemplate.update("INSERT INTO professor (nome) VALUES (?)", "Edson Angoti Júnior");
		jdbcTemplate.update("INSERT INTO professor(nome) VALUES (?)", "Clarimundo Machado");
		jdbcTemplate.update("INSERT INTO professor(nome) VALUES (?)", "Rodrigo Cavanha");
		jdbcTemplate.update("INSERT INTO professor(nome) VALUES (?)", "Bruno Queiroz");
	}}
=======
		jdbcTemplate.execute("CREATE TABLE professor(id SERIAL, nome VARCHAR(255), PRIMARY KEY (id))");
		jdbcTemplate.execute("""
					CREATE TABLE disciplina(
						id SERIAL,
						id_professor int,
						nome VARCHAR(255),
						PRIMARY KEY (id),
						FOREIGN KEY (id_professor) REFERENCES professor(id));
				""");

		jdbcTemplate.execute("CREATE TABLE aluno(id SERIAL, nome VARCHAR(255), cpf VARCHAR(255), email VARCHAR(255));");

		jdbcTemplate.execute("""
				CREATE TABLE matricula (
					id_aluno INT UNSIGNED NOT NULL,
					id_disciplina INT UNSIGNED NOT NULL,
					PRIMARY KEY (id_aluno, id_disciplina),
					CONSTRAINT matricula_aluno_fk
						FOREIGN KEY (id_aluno) REFERENCES aluno(id)
					    ON DELETE CASCADE ON UPDATE CASCADE,
					CONSTRAINT matricula_disciplina_fk
					    FOREIGN KEY (id_disciplina) REFERENCES disciplina(id)
					    ON DELETE CASCADE ON UPDATE CASCADE);
					""");

		jdbcTemplate.update("INSERT INTO professor(nome) VALUES (?)", "Edson Angoti Júnior");
		jdbcTemplate.update("INSERT INTO professor(nome) VALUES (?)", "Clarimundo Machado");
		jdbcTemplate.update("INSERT INTO professor(nome) VALUES (?)", "Rodrigo Cavanha");
		jdbcTemplate.update("INSERT INTO professor(nome) VALUES (?)", "Bruno Queiroz");

		jdbcTemplate.update("INSERT INTO aluno(ID, NOME, CPF, EMAIL) VALUES (?,?,?,?)", 1, "Edson Angoti Jr",
				"79628893655", "angoti@iftm.edu.br");

		jdbcTemplate.update("INSERT INTO DISCIPLINA(ID, ID_PROFESSOR, NOME) VALUES(?,?,?)", 1, 1,
				"Sistema Web MVC SQL");
		jdbcTemplate.update("INSERT INTO DISCIPLINA(ID, ID_PROFESSOR, NOME) VALUES(?,?,?)", 2, 3, "Banco de dados");
		jdbcTemplate.update("INSERT INTO DISCIPLINA(ID, ID_PROFESSOR, NOME) VALUES(?,?,?)", 3, 1, "Requisitos");
		jdbcTemplate.update("INSERT INTO DISCIPLINA(ID, ID_PROFESSOR, NOME) VALUES(?,?,?)", 4, 3, "Web Design");
	}

}
>>>>>>> 9475e3244daa4cd37cc9654d70683699ae4acaf0
