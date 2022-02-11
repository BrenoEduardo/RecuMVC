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
@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/alunos")
    public String mostraTodosUsuarios(Model model) {
        List <Aluno> listaAluno = alunoRepository.buscaTodos(null);
        model.addAttribute("lista", listaAluno);
        return "alunos";
    }
    
    @GetMapping(value = "novo-aluno")
    public String exibeFormNovo(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "form-aluno";
    }
    
    @PostMapping(value = "novo-aluno")
    public String cadastraNovo(Aluno aluno) {
        alunoRepository.grava(aluno);
       return "redirect:/alunos";
    }
    
    @GetMapping(value = "excluir-aluno")
    public String excluirAluno(@RequestParam(name = "id", required = true) Integer cod) {
        alunoRepository.excluir(cod);
        return "redirect:/alunos";
    }
}
