package br.edu.iftm.professores.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.iftm.professores.model.Matricula;

@Repository
public class MatriculaRepository {
<<<<<<< HEAD
        @Autowired
        private JdbcTemplate jdbc;

        public void grava(Matricula matricula){
            Matricula matriculaRealizada = buscaPorAlunoId(matricula.getIdAluno());
            for(Integer idDisciplinaNova : matricula.getDisciplinas()){
                if(!matriculaRealizada.getDisciplinas().contains(idDisciplinaNova)){
                    String consulta = "insert into matricula(id_aluno, id_disciplina) values (?,?)";
                    jdbc.update(consulta, matricula.getIdAluno(), idDisciplinaNova);
                }
            }
            for(Integer idDisciplina : matriculaRealizada.getDisciplinas()){
                if(!matricula.getDisciplinas().contains(idDisciplina)){
                    String consulta = "delete from matricula where id_aluno = ? and id_disciplina = ?";
                    jdbc.update(consulta, matricula.getIdAluno(), idDisciplina);
                }
            }
        }

        public Matricula buscaPorAlunoId(Integer id) {
            String consulta = "SELECT * FROM matricula where id_aluno = ?;";
            List<Integer> listaDeDisciplinas = jdbc.query(consulta,
            (res, numeroDaLinha) -> res.getInt("id_disciplina"), id);
            return new Matricula(listaDeDisciplinas, id);
        }
        public List<Matricula> buscaMatriculas(){
            List<Matricula> matriculas = new ArrayList<Matricula>();
            String consultaAlunosMatriculados = "select distinct id_aluno from matricula;";
            List<Integer> alunosMatriculados = jdbc.query(consultaAlunosMatriculados,
             (res,numeroDaLinha) -> res.getInt("id_aluno"));
             for(Integer idAluno : alunosMatriculados){
                 matriculas.add(buscaPorAlunoId(idAluno));
             }
             return matriculas;
        }
=======

    @Autowired
    private JdbcTemplate jdbc;

    public void grava(Matricula matricula) {
        Matricula matriculaRealizada = buscaPorAlunoId(matricula.getIdAluno());
        // inserir as novas disciplinas
        for (Integer idDisciplinaNova : matricula.getDisciplinas()) {
            if (!matriculaRealizada.getDisciplinas().contains(idDisciplinaNova)) {
                String consulta = "insert into matricula(id_aluno, id_disciplina) values (?,?)";
                jdbc.update(consulta, matricula.getIdAluno(), idDisciplinaNova);
            }
        }
        // excluir as disciplinas descartadas
        for (Integer idDisciplina : matriculaRealizada.getDisciplinas()) {
            if (!matricula.getDisciplinas().contains(idDisciplina)) {
                String consulta = "delete from matricula where id_aluno = ? and id_disciplina = ?";
                jdbc.update(consulta, matricula.getIdAluno(), idDisciplina);
            }
        }
    }

    public Matricula buscaPorAlunoId(Integer id) {
        String consulta = "SELECT * FROM matricula where id_aluno = ?;";
        List<Integer> listaDeDisciplinas = jdbc.query(consulta,
                (res, numeroDaLinha) -> res.getInt("id_disciplina"), id);
        return new Matricula(listaDeDisciplinas, id);
    }

    public List<Matricula> buscaMatriculas() {
        List<Matricula> matriculas = new ArrayList<Matricula>();
        String consultaAlunosMatriculados = "select distinct id_aluno from matricula;";
        List<Integer> alunosMatriculados = jdbc.query(consultaAlunosMatriculados,
                (res, numeroDaLinha) -> res.getInt("id_aluno"));
        for (Integer idAluno : alunosMatriculados) {
            matriculas.add(buscaPorAlunoId(idAluno));
        }
        return matriculas;
    }

>>>>>>> 9475e3244daa4cd37cc9654d70683699ae4acaf0
}
