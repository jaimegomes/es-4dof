package br.senai.sc.es4dof.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe que contém métodos de formatação de Strings.
 * 
 * @author Jaime Gomes
 *
 */
public class StringUtils {

	private static StringUtils stringUtils = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Construtor padrão
	 */
	public StringUtils() {
	}

	public final static StringUtils getInstance() {
		if (stringUtils == null) {
			stringUtils = new StringUtils();
		}
		return stringUtils;
	}

	/**
	 * Método que converte uma String data em Date data
	 * 
	 * @param String
	 *            data
	 * @return Date data (dd/MM/yyyy)
	 * @throws ParseException
	 */
	public Date stringToDate(String data) throws ParseException {
		return sdf.parse(data);
	}
	
	public String dateToString(Date data) throws ParseException {
		return sdf.format(data);
	}
	
}
