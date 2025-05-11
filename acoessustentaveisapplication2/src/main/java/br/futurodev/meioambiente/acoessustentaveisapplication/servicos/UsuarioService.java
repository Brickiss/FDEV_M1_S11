package br.futurodev.meioambiente.acoessustentaveisapplication.servicos;

import br.futurodev.meioambiente.acoessustentaveisapplication.entidades.Usuario;
import br.futurodev.meioambiente.acoessustentaveisapplication.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        if (usuario.getId() != null) {
            Usuario old = findById(usuario.getId());
            if (old == null) {
                usuario.setId(null);
            }
        }
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
