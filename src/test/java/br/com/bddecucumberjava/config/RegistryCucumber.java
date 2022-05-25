package br.com.bddecucumberjava.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;

public class RegistryCucumber implements TypeRegistryConfigurer {

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	@Override
	public void configureTypeRegistry(TypeRegistry registry) {

		registry.defineParameterType(new ParameterType<>("data", ".*", Date.class, (String s) -> {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date retorno = format.parse(s);
				return retorno;
			} catch (ParseException e) {
				e.printStackTrace();
				throw new IllegalArgumentException("Formato de data inválido!");
			}
		}));
	}
}
