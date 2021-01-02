package com.ecommerce.theHashed.JWTConfiguration;

import java.util.Collection;

import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ecommerce.theHashed.model.CustomerAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserPrincipal  implements UserDetails {
	   private String id;

		    @JsonIgnore
	    private String mobile;

	    @JsonIgnore
	    private String password;

	    private Collection<? extends GrantedAuthority> authorities;

	    public UserPrincipal(String id, String mobile, String password) {
	        this.id = id;
	   
	        this.mobile = mobile;
	        this.password = password;
	    }

	    public static UserPrincipal create(CustomerAccount user) {
	     

	        return new UserPrincipal(
	                user.getId(),
	                user.getEmailId(),
	                user.getPassword()
	              
	        );
	    }

	    public String getId() {
	        return id;
	    }

	    

	    
	  
	    @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
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

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        UserPrincipal that = (UserPrincipal) o;
	        return Objects.equals(id, that.id);
	    }

	    @Override
	    public int hashCode() {

	        return Objects.hash(id);
	    }

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getMobile() {
			return mobile;
		}
	

}
