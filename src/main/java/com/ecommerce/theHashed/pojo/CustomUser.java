package com.ecommerce.theHashed.pojo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,String id) {
	        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	        setId(id);
	    }
	}