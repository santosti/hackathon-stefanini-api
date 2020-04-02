package com.stefanini.resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import com.stefanini.model.Pessoa;
import com.stefanini.servico.PessoaServico;

@Path("pessoas/{id}/imagem")
public class PessoaUploadImagemResource {

	@Inject
	private PessoaServico pessoaServico;

	@POST
	@Path("upload")
	@Consumes("multipart/form-data")
	public Response uploadFile(@PathParam("id") Long id, MultipartFormDataInput input) {

		try {
			String caminhoImagem = salvarImagem(input);
			Pessoa pessoa = pessoaServico.atualizarCaminhoImagemPessoa(id, caminhoImagem);
			return Response.status(200).entity(pessoa).build();
		} catch (IOException e) {
			return Response.status(400).entity("Erro ao salvar arquivo: " + e.getMessage()).build();
		}
	}

	private String salvarImagem(MultipartFormDataInput input) throws IOException {

		InputPart inputPart = recuperarInputPart(input);
		byte[] bytesArquivo = recuperarBytesArquivo(inputPart);
		String caminhoImagem = recuperarNomeArquivo(inputPart);

		caminhoImagem = System.getProperty("user.home") + File.separator + caminhoImagem;

		// Salva o arquivo
		File file = new File(caminhoImagem);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fop = new FileOutputStream(file);
		fop.write(bytesArquivo);
		fop.flush();
		fop.close();
		return caminhoImagem;
	}

	private InputPart recuperarInputPart(MultipartFormDataInput input) {
		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		return uploadForm.get("uploadFile").get(0);
	}

	private byte[] recuperarBytesArquivo(InputPart inputPart) throws IOException {
		InputStream inputStream = inputPart.getBody(InputStream.class, null);
		return IOUtils.toByteArray(inputStream);
	}

	private String recuperarNomeArquivo(InputPart inputPart) {

		MultivaluedMap<String, String> header = inputPart.getHeaders();
		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith(("filename")))) {
				String[] name = filename.split("=");
				return name[1].trim().replaceAll("\"", "");
			}
		}
		return "arquivo";
	}

}
