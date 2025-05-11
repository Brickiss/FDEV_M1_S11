package br.futurodev.meioambiente.acoessustentaveisapplication.controladores;

import br.futurodev.meioambiente.acoessustentaveisapplication.entidades.Organizacao;
import br.futurodev.meioambiente.acoessustentaveisapplication.servicos.OrganizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizacaoController {

    @Autowired
    private OrganizacaoService organizacaoService;

    // Consultas permitidas para ADMIN e USER
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Organizacao> findAll() {
        return organizacaoService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Organizacao findById(@PathVariable Long id) {
        return organizacaoService.findById(id);
    }

    // Cadastro permitido apenas para ADMIN
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public Organizacao create(@RequestBody Organizacao organizacao) {
        return organizacaoService.save(organizacao);
    }

    // Atualização permitido apenas para ADMIN
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Organizacao update(@PathVariable Long id, @RequestBody Organizacao organizacao) {
        organizacao.setId(id);
        return organizacaoService.save(organizacao);
    }

    // Exclusão permitida apenas para ADMIN
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) {
        organizacaoService.deleteById(id);
    }
}
