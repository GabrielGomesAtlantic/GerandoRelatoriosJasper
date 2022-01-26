package br.com.main;

import java.io.File;
import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class GerarRelatorioNome {
	private static final String JRX = "relatorio/RelatorioNome.jrxml";
	
	public static void main(String[] args) throws JRException {
		File file = new File(JRX);
		System.out.println(file.exists());
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("Nome", "Gabriel");
		
		JasperReport compilado = JasperCompileManager.compileReport(JRX);
		JasperPrint print = JasperFillManager.fillReport(compilado, map, new JREmptyDataSource());
		JasperViewer.viewReport(print, true);
	}
}
