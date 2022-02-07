package br.edu.iftm.professores.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

}
