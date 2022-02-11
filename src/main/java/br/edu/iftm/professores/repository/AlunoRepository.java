package br.edu.iftm.professores.repository;

import java.util.List;

<<<<<<< HEAD
import br.edu.iftm.professores.model.Aluno;

=======
>>>>>>> 9475e3244daa4cd37cc9654d70683699ae4acaf0
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
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
=======
import br.edu.iftm.professores.model.Aluno;

@Repository
public class AlunoRepository {

    @Autowired
    JdbcTemplate jdbc;

    public void grava(Aluno aluno) {
        String sql = "insert into aluno(nome,cpf,email) values(?,?,?)";
        jdbc.update(sql, aluno.getNome(), aluno.getCpf(), aluno.getEmail());
    }

    public List<Aluno> buscaTodos() {
        String consulta = "SELECT * FROM aluno order by LOWER(nome);";
        return jdbc.query(consulta,
                (r, numeroDaLinha) -> new Aluno(r.getInt("id"), r.getString("nome"), r.getString("email"),
                        r.getString("cpf")));
    }

    public Aluno buscaPorId(Integer id) {
        String consulta = "SELECT * FROM aluno where id = ?;";
        return jdbc.queryForObject(
                consulta,
                (res, numeroDaLinha) -> {
                    return new Aluno(res.getInt("id"), res.getString("nome"), res.getString("email"),
                            res.getString("cpf"));
                },
                id);
    }

>>>>>>> 9475e3244daa4cd37cc9654d70683699ae4acaf0
}
