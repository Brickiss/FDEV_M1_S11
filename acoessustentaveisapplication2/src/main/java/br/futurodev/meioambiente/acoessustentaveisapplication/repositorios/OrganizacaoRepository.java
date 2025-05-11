package br.futurodev.meioambiente.acoessustentaveisapplication.repositorios;

import br.futurodev.meioambiente.acoessustentaveisapplication.entidades.Organizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizacaoRepository extends JpaRepository<Organizacao, Long> {
}
