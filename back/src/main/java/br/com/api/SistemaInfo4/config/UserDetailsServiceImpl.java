package br.com.api.SistemaInfo4.config;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.api.SistemaInfo4.entities.Usuario;
import br.com.api.SistemaInfo4.repositories.UsuarioRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> userRes = userRepo.findByEmail(email);
		if (userRes.isEmpty()) {
			throw new UsernameNotFoundException("Não foi possível encontrar usuário com o email = " + email);
		}
		return new org.springframework.security.core.userdetails.User(email, userRes.get().getPassword(),
				Collections.emptyList());
	}
}