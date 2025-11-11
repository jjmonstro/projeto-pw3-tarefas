package br.com.etechas.tarefas.entity;

import br.com.etechas.tarefas.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioBusiness implements UserDetailsService {

    UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String usuario){
        return usuarioRepository.findByUsername(usuario)
                .orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado com username: " + usuario));
    }
}
