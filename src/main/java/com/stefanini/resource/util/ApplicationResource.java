package com.stefanini.resource.util;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.stefanini.resource.CepResource;
import com.stefanini.resource.EnderecoResource;
import com.stefanini.resource.PerfilResource;
import com.stefanini.resource.PessoaResource;
import com.stefanini.resource.PessoaUploadImagemResource;

/*@ApplicationPath("api")
public class ApplicationResource extends Application{

}*/
@ApplicationPath("api")
public class ApplicationResource extends Application {
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(CepResource.class);
		s.add(EnderecoResource.class);
		s.add(PerfilResource.class);
		s.add(PessoaResource.class);
		s.add(PessoaUploadImagemResource.class);
		return s;
	}
	
}