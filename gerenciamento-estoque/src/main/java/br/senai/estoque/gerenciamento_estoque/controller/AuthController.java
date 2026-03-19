package br.senai.estoque.gerenciamento_estoque.controller;

import java.util.Optional;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.senai.estoque.gerenciamento_estoque.model.Funcionario;
import br.senai.estoque.gerenciamento_estoque.repository.FuncionarioAutenticadoRepository;
import br.senai.estoque.gerenciamento_estoque.repository.FuncionarioRepository;

@Controller
public class AuthController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioAutenticadoRepository funcionarioAutenticadoRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String nif,
                        @RequestParam String senha,
                        HttpSession session,
                        Model model) {

        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findByNif(nif);

        boolean credenciaisOk = false;

        if (funcionarioOpt.isPresent()) {
            Funcionario funcionario = funcionarioOpt.get();

            if (funcionario.isAtivo() && funcionario.getSenha().equals(senha)) {
                credenciaisOk = true;
            }
        }

        if (!credenciaisOk) {
            model.addAttribute("erro", "NIF ou senha inválidos.");
            return "auth/login";
        }

        session.setAttribute("usuarioLogado", true);
        session.setAttribute("nif", nif);

        return "redirect:/app";
    }

    @GetMapping("/cadastro")
    public String cadastroPage() {
        return "auth/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastro(@RequestParam String nome,
                           @RequestParam String nif,
                           @RequestParam String senha,
                           Model model) {

       boolean autorizado = funcionarioAutenticadoRepository.existsByNifAndAtivoTrue(nif);

        if (!autorizado) {
            model.addAttribute("erro", "NIF e nome não estão autorizados para cadastro.");
            return "auth/cadastro";
        }

        boolean jaExiste = funcionarioRepository.existsByNif(nif);

        if (jaExiste) {
            model.addAttribute("erro", "Já existe um funcionário cadastrado com esse NIF.");
            return "auth/cadastro";
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setNif(nif);
        funcionario.setSenha(senha);
        funcionario.setAtivo(true);

        funcionarioRepository.save(funcionario);

        model.addAttribute("sucesso", "Cadastro realizado com sucesso. Faça login.");
        return "auth/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}