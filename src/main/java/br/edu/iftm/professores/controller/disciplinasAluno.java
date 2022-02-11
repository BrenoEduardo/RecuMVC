/* 

TUDO RELACIONA A DISCIPLINASALUNO FOI O JEITO QUE EU TENTEI FAZER, POREM 
NÃO TAVA DANDO CERTO, PREFERI DEIXAR AQUI PRA VC DAR UMA OLHADAE VER QUE 
EU TAVA TENTANDO FAZER

package br.edu.iftm.professores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.iftm.professores.model.Aluno;
@Controller
public class disciplinasAluno {

    @Autowired
    disciplinasAluno disciplinasAluno;

    @GetMapping("/disciplinasAluno")
    public String mostraTodosUsuarios(Model model) {
        List <Aluno> listaDisciplina = disciplinasAluno.buscaTodosDisc();
        model.addAttribute("lista", listaDisciplina);
        return "disciplinasAluno";
    }
}
    /* 
    @GetMapping(value = "novo-aluno")
    public String exibeFormNovo(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "form-aluno";
    }
    
    @PostMapping(value = "novo-aluno")
    public String cadastraNovo(Aluno aluno) {
        alunoRepository.grava(aluno);
       return "redirect:/alunos";
    } */ 