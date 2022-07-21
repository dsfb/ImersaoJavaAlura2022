package br.com.alura.linguagens.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinguagemController {

    private List<Linguagem> linguagens =
            List.of(
                    new Linguagem("Java", "https://github.com/abrahamcalf/programming-languages-logos/raw/master/src/java/java_256x256.png", 1),
                    new Linguagem("PHP", "https://github.com/abrahamcalf/programming-languages-logos/raw/master/src/php/php_256x256.png", 2)
            );

    @GetMapping(value="/linguagem-preferida")
    public String processaLinguagemPreferida() {
        return "Oi, Java!";
    }

    @GetMapping(value="/linguagens")
    public List<Linguagem> obterLinguagens() {
        return this.linguagens;
    }
}
