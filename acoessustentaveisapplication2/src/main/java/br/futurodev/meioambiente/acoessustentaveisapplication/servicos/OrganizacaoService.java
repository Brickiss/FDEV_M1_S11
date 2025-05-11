package br.futurodev.meioambiente.acoessustentaveisapplication.servicos;

import br.futurodev.meioambiente.acoessustentaveisapplication.entidades.Organizacao;
import br.futurodev.meioambiente.acoessustentaveisapplication.repositorios.OrganizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizacaoService {

    @Autowired
    private OrganizacaoRepository repository;

    public List<Organizacao> findAll() {
        return repository.findAll();
    }

    public Organizacao findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    /** Insert or update */
    public Organizacao save(Organizacao organizacao) {
        if (organizacao.getId() != null) {
            Organizacao old = findById(organizacao.getId());
            if (old == null) {
                organizacao.setId(null);
            }
        }
        return repository.save(organizacao);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
