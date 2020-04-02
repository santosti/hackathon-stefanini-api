package com.stefanini.servico;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.validation.constraints.NotNull;

public class CepServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public String getEnderecoPorCep(@NotNull String cep) {
		String json;
	
		try {
			URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			StringBuilder jsonSb = new StringBuilder();

			br.lines().forEach(l -> jsonSb.append(l.trim()));

			json = jsonSb.toString();

		} catch (Exception e) {
			throw new RuntimeException();
		}

		return json;

	}

}
