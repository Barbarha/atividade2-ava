package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Repository.CategoriaRepository;
import Repository.TarefaRepository;

import java.util.Date;
import java.util.List;

@Controller
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/tarefas")
    public String listarTarefas(Model model) {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        model.addAttribute("tarefas", tarefas);
        return "tarefas"; 
    }

    @GetMapping("/tarefas/nova")
    public String novaTarefaForm(Model model) {
        model.addAttribute("tarefa", new Tarefa());
        model.addAttribute("categorias", categoriaRepository.findAll()); 
        return "tarefaForm"; 
    }
    @PostMapping("/tarefas")
    public String salvarTarefa(Tarefa tarefa) {
        tarefa.setDataCriacao(new Date()); 
        tarefaRepository.save(tarefa);
        return "redirect:/tarefas"; 
    }
}
