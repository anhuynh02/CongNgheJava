package tdtu.petshop.services;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import tdtu.petshop.models.User;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	private User user;
	
	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}
	
	public int getId() {
		return user.getId();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(user.getRole().getName()));
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	public int getId() {
		return user.getId();
	}
	
	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}