package br.edu.iftm.professores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iftm.professores.model.Aluno;
import br.edu.iftm.professores.repository.AlunoRepository;
import br.edu.iftm.professores.repository.DisciplinaRepository;
import br.edu.iftm.professores.repository.MatriculaRepository;

@Controller
public class AlunoController {

    @Autowired
    AlunoRepository repo;

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Autowired
    MatriculaRepository matriculaRepository;

    @GetMapping("novo-aluno")
    public String criarAluno(Model modelo) {
        modelo.addAttribute("aluno", new Aluno());
        return "aluno-form";
    }

    @PostMapping("novo-aluno")
    public String gravarAluno(Aluno aluno) {
        repo.grava(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("alunos")
    public String todosAlunos(Model modelo) {
        List<Aluno> lista = repo.buscaTodos();
        modelo.addAttribute("alunos", lista);
        modelo.addAttribute("matriculas", matriculaRepository.buscaMatriculas());
        modelo.addAttribute("disciplinas",disciplinaRepository.buscaTodos());
        return "alunos";
    }

    @GetMapping("editar-aluno")
    public String editar(@RequestParam(name = "id", required = true) Integer cod) {
        return "redirect:/alunos";
    }

    @GetMapping("excluir-aluno")
    public String excluir(@RequestParam(name = "id", required = true) Integer cod) {
        return "redirect:/alunos";
    }
}
