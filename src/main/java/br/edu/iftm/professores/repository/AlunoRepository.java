package br.edu.iftm.professores.repository;

import java.util.List;

import br.edu.iftm.professores.model.Aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AlunoRepository {

        @Autowired
        JdbcTemplate jdbc;

        public List<Aluno> buscaTodos(Integer id) {
                String consulta = "SELECT * FROM aluno;";
                return jdbc.query(consulta,
                                (res, linha) -> new Aluno(res.getString("nome"),
                                                res.getString("email"),
                                                res.getString("cpf")));
        }

        public int grava(Aluno aluno) {
                String consulta = "insert into aluno(nome,email,cpf) values(?,?,?)";
                return jdbc.update(consulta, aluno.getNome(), aluno.getEmail(), aluno.getCpf());
        }
        
        public int excluir(Integer id) {
                String consulta = "delete from aluno where id = ?";
                return jdbc.update(consulta, id);
        }
        /*
        public int atualiza(Aluno aluno) {
                String consulta = "update aluno set nome = ? where id = ?";
                return jdbc.update(consulta, aluno.getNome(), aluno.getID());
        }

        public Aluno buscaPorLogin(String login) {
                return jdbc.queryForObject(
                "select * from aluno where id = ?",
                (resultSet, rowNum) -> { return new Aluno(resultSet.getString("nome"),null, resultSet.getInt("id")); },
                login);
        } */
}
