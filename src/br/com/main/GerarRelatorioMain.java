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

public class GerarRelatorioMain {
	
	private static final String JRX = "relatorio/Renan.jrxml";
//	private static final String JSP = "C:/Relatorio/Teste.jasper";
	
	public static void main(String[] args) throws JRException {
		File file = new File(JRX);
		System.out.println(file.exists());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("Renan", 1);
		map.put("Gabriel", 2);
						
		
//		Map<String,String> mapaValores = preencherRelatorioHistoricoFinanceiro(caminhoReal, controleCompensacaoVO, pagamentoConcessaoVO, listaPagamentosFluxoVO);
//			JRDataSource JRDS = new JRBeanCollectionDataSource(listaPagamentosFluxoVO);
//			JasperPrint impressao = JasperFillManager.fillReport(new File(caminhoReal + "/reports/comprev/HistoricoFinanceiroComprev.jasper").getPath(), mapaValores, JRDS);
//			return JasperExportManager.exportReportToPdf(impressao);
			
		JasperReport compilado = JasperCompileManager.compileReport(JRX);
		JasperPrint print = JasperFillManager.fillReport(compilado, map, new JREmptyDataSource());
			
//			JasperExportManager.exportReportToPdf(impressao);
		JasperViewer.viewReport(print, true);
			
	}
}
