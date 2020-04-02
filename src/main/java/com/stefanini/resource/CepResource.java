package com.stefanini.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.servico.CepServico;

@Path("cep")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CepResource {
	
	@Inject
	private CepServico cepServico;
	
	@GET
	@Path("{cep}")
	public Response obterEnderecoPorCep(@PathParam("cep") String cep) {
		return Response.ok(cepServico.getEnderecoPorCep(cep)).build();
	}
}
