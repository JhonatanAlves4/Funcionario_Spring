package br.com.sistema.controller;

import br.com.sistema.model.Cargo;
import br.com.sistema.model.Projeto;
import br.com.sistema.service.CargoService;
import br.com.sistema.service.CargoServiceImpl;
import br.com.sistema.service.FuncionarioServiceImpl;
import br.com.sistema.service.ProjetoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProjetoController {

    @Autowired
    ProjetoServiceImpl projetoService;

    @Autowired
    FuncionarioServiceImpl funcionarioService;

    @Autowired
    CargoServiceImpl cargoService;

    @GetMapping("/projeto/list")
    public String list(Model model){
        model.addAttribute("projetos", projetoService.findAll());

        return "projeto/list";
    }

    @GetMapping("projeto/add")
    public String add(Model model){
        model.addAttribute("projeto", new Projeto());
        Cargo cargo = cargoService.findByNome("Gerente");
        //primeiro
        List<Cargo> cargos = cargoService.findByNomeNot("Gerente");
        model.addAttribute("gerentes", funcionarioService.findByCargo(cargo));
        model.addAttribute("funcionarios", funcionarioService.findByCargoIn(cargos));
        return "projeto/add";
    }

    @PostMapping("/projeto/save")
    public String save(Projeto projeto, Model model){

        //TODO:Fazer validação

        if (projetoService.save(projeto)){
            return "redirect:/projeto/list";
        } else {
            //TODO:fazer validação
            //model.addAttribute("projeto", projeto);
            //model.addAttribute("erro", true);
            //model.addAttribute("erroMsg", "Erro ao salvar o projeto");
            return "redirect:/projeto/list";
        }
    }

    @GetMapping("/projeto/edit/{id}")
    public String add(@PathVariable Long id, Model model) {
        model.addAttribute("projeto", projetoService.findById(id));
        Cargo cargo = cargoService.findByNome("Gerente");
        List<Cargo> cargos = cargoService.findByNomeNot("Gerente");
        model.addAttribute("gerentes", funcionarioService.findByCargo(cargo));
        model.addAttribute("funcionarios", funcionarioService.findByCargoIn(cargos));
        return "projeto/edit";
    }

    @GetMapping("/projeto/delete/{id}")
    public String delete(@PathVariable Long id){
        projetoService.deleteById((id));
        return "projeto/list";
    }

}
