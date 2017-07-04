package org.rf.template.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rf.template.constants.Constanta;

/**
 * The Class DownloadTemplateServlet. author : Roberto
 * 
 */
public class DownloadTemplateServlet extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3946679593286638024L;
	private static final int BYTES_DOWNLOAD = 2048; // maksimum template size

	private static final String MINYAK_NOMINASI = "MinyakNominasi";
	private static final String GAS_NOMINASI = "GasNominasi";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String template = "";
		if (request.getParameter("file").equalsIgnoreCase(MINYAK_NOMINASI)) {
			template = MINYAK_NOMINASI + Constanta.XLSX_EXTENSION;
		}  else if (request.getParameter("file").equalsIgnoreCase(GAS_NOMINASI)) {
			template = GAS_NOMINASI + Constanta.XLSX_EXTENSION;
		} 
		response.setContentType("text/plain");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ request.getParameter("file") + Constanta.XLSX_EXTENSION);
		ServletContext ctx = getServletContext();

		InputStream is = ctx.getResourceAsStream(Constanta.TEMPLATE_XLS_FOLDER
				+ template);

		int read = 0;
		byte[] bytes = new byte[BYTES_DOWNLOAD];
		OutputStream os = response.getOutputStream();

		while ((read = is.read(bytes)) != -1) {
			os.write(bytes, 0, read);
		}
		os.flush();
		os.close();
	}
}