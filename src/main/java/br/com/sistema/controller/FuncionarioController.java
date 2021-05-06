package br.com.sistema.controller;

import br.com.sistema.model.Funcionario;
import br.com.sistema.service.FuncionarioService;
import br.com.sistema.service.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuncionarioController {

    @Autowired
    FuncionarioServiceImpl funcionarioService;

    @GetMapping("/funcionario/list")
    public String list(Model model) {
        model.addAttribute("funcionarios", funcionarioService.findAll());
        System.out.println(funcionarioService.findAll());
        return "funcionario/list";
    }

    @GetMapping("/funcionario/add")
    public String add(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "funcionario/add";
    }

    @PostMapping("/funcionario/save")
    public String save(Funcionario funcionario, Model model) {

        String msgErro = funcionarioService.validarFuncionario(funcionario);
        if(msgErro != null) {
            model.addAttribute("funcionario",funcionario);
            model.addAttribute("erro", true);
            model.addAttribute("erroMsg", msgErro);

            if (funcionario.getId() == null) return "funcionario/add";
            return "funcionario/edit";
        }

        if (funcionarioService.save(funcionario)){
            return "redirect:/funcionario/list";
        }else {
            model.addAttribute("funcionario", funcionario);
            return "redirect:/funcionario/add";
        }
    }

    @GetMapping("/funcionario/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("funcionario", funcionarioService.findById(id));
        return "funcionario/edit";
    }
}
