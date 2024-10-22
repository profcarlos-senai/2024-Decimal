package br.senai.Decimal.control;

import br.senai.Decimal.model.Dados;
import br.senai.Decimal.repo.DadosRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/dados")
public class DadosControl {

    private final DadosRepository dadosRepository;

    public DadosControl(DadosRepository dadosRepository) {
        this.dadosRepository = dadosRepository;
    }

    @PostMapping("")
    @ResponseBody
    public Dados gravar(@RequestBody Dados dados) {
        return dadosRepository.save(dados);
    }

    @GetMapping("")
    @ResponseBody
    public List<Dados> pegaTudo(){
        return dadosRepository.findAll();
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Dados pegaUm(@PathVariable(value = "id") Long id){
        Optional<Dados> opt = dadosRepository.findById(id);
        if(opt.isPresent()) return opt.get();
        return null;
    }

}
