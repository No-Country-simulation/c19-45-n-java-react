package com.noCountry.petConnect.infra.security;

import com.noCountry.petConnect.infra.errores.ApplicationException;
import com.noCountry.petConnect.model.Usuario;
import com.noCountry.petConnect.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ApplicationException("Usuario o contraseña incorrectas, vuelva a intentarlo"));

        if (!usuario.isEmail_confirmado()) {
            throw new ApplicationException("Tu correo no ha sido verificado, por favor revisa tu email.");
        }

        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new ApplicationException("Usuario o contraseña incorrectas, vuelva a intentarlo");
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(usuario);
        return new UsernamePasswordAuthenticationToken(customUserDetails, password, customUserDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
