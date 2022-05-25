package br.com.bddecucumberjava.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AprenderCucumberSteps {

	private int contador = 0;
//	LocalDate entrega = LocalDate.now();
	Date entrega = new Date();

	@Dado("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable {
		System.out.println("QualquerCoisa");
	}

	@Quando("^executá-lo$")
	public void executáLo() throws Throwable {

	}

	@Então("^a especificação deve finalizar com sucesso$")
	public void aEspecificaçãoDeveFinalizarComSucesso() throws Throwable {

	}

	@Dado("^que o valor do contador é (\\d+)$")
	public void queOValorDoContadorÉ(int arg1) throws Throwable {
		contador = arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable {
		contador += arg1;
	}

	@Então("^o valor do contador será (\\d+)$")
	public void oValorDoContadorSerá(int arg1) throws Throwable {
		Assert.assertEquals(arg1, contador);
	}

	@Dado("que o prazo é dia {data}")
	public void queOPrazoÉDia(Date data) throws Throwable {
//		this.entrega = LocalDate.of(ano, mes, dia);

//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.DAY_OF_MONTH, dia);
//		cal.set(Calendar.MONTH, mes - 1);
//		cal.set(Calendar.YEAR, ano);
//		entrega = cal.getTime();
		entrega = data;
		System.out.println(entrega);
	}

	@Quando("^a eentrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEentregaAtrasarEmDias(int quantidadeTempo, String tempo) throws Throwable {

		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		if (tempo.equals("dias")) {
			cal.add(Calendar.DAY_OF_MONTH, quantidadeTempo);
//			this.entrega.plusDays(quantidadeTempo);

		}
		if (tempo.equals("meses")) {
//			this.entrega.plusMonths(quantidadeTempo);
			cal.add(Calendar.MONTH, quantidadeTempo);
		}
		entrega = cal.getTime();
	}

	@Então("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeráEfetuadaEm(String data) throws Throwable {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		LocalDate dataEntrega = LocalDate.parse(data, formatter);
//		assertEquals(data, dataEntrega.format(formatter));

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(entrega);
		Assert.assertEquals(data, dataFormatada);
	}

	@Dado("^que o ticket( especial)? é (A.\\d{3})$")
	public void queOTicketÉAF(String tipo, String arg1) throws Throwable {

	}

	@Dado("^que o valor da passagem é R\\$ (.*)$")
	public void queOValorDaPassagemÉR$(Double numero) throws Throwable {
		System.out.println(numero);
	}

	@Dado("^que o nome do passageiro é \"(.{5,20})\"$")
	public void queONomeDoPassageiroÉ(String arg1) throws Throwable {

	}

	@Dado("^que o telefone do passageiro é (9\\d{3}-\\d{4})$")
	public void queOTelefoneDoPassageiroÉ(String telefone) throws Throwable {

	}

	@Quando("^criar os steps$")
	public void criarOsSteps() throws Throwable {

	}

	@Então("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {

	}
}
