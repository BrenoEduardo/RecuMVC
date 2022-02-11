/* package br.edu.iftm.professores.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.iftm.professores.model.Aluno;
import br.edu.iftm.professores.model.disciplinasAluno;

@Repository
public class disciplinasAlunoRepository {

        @Autowired
        JdbcTemplate jdbc;

        public void gravar(disciplinasAluno disciplinasAluno){
                disciplinasAluno disciplinaFeita = buscaPorIdAluno(disciplinasAluno.getAluno());

                for(Integer IdDisciplina : disciplinasAluno.getDisciplina()){
                        if(disciplinaFeita.getDisciplina().contains(IdDisciplina)){
                                String consulta = "insert into disciplinasAluno(disciplina,aluno) values(?,?)";
                                jdbc.update(consulta, disciplinasAluno.getAluno(),IdDisciplina);
                        }
                }
        }
        public List<disciplinasAlunoRepository> buscaTodosDisc(disciplinasAlunoRepository disciplinasAluno) {
                String consulta = "SELECT * FROM disciplinasAluno where ID_aluno = ?;";
                return jdbc.query(consulta,
                                 (res, linha) -> res.getInt("id_Disciplina"), ID);
                                return new disciplinasAluno(consulta,id);
        }
        public int grava(Aluno aluno) {
                String consulta = "insert into aluno(nome,email,cpf) values(?,?,?)";
                return jdbc.update(consulta, aluno.getNome(), aluno.getEmail(), aluno.getCpf());
        }
} */