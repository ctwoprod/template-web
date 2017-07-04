package org.rf.template.core.report.command.workbook;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.rf.template.core.report.GeneralReportUtil;

public final class DecodeData {
	// constants
	private static final String ROWNUM = "ROWNUM";
	private static final Log LOG = LogFactory.getLog(DecodeData.class);

	/**
	 * Inner interface used to create decoder objects.
	 * 
	 * 
	 */
	private interface Decoder {
		Object[] decode(Object object);
	}

	/**
	 * Map containing decoder objects.
	 */
	private static final Map<String, Decoder> DECODER_MAP = new HashMap<String, Decoder>();

	// Put Decoder objects and their corresponding reportType here.
	static {
		DECODER_MAP.put(GeneralReportUtil.RPT_TEST_CETAK_XLS.toLowerCase(),
				new Decoder() {
					public Object[] decode(Object object) {
						return decodeTestSaja(object);
					}
				});
	}

	public static Object[] decodeObject(Object object, String reportType) {
		if (reportType == null) {
			LOG.debug("reportType is null");
			return new Object[] {};
		}
		Decoder decoder = DECODER_MAP.get(reportType.toLowerCase());
		if (decoder != null) {
			return decoder.decode(object);
		} else {
			LOG.debug("Decoder object for reportType '" + reportType
					+ "' is not found");
			return new Object[] {};
		}
	}

	protected static Object[] decodeTestSaja(Object object) {
		return new Object[] { ROWNUM, "", "", };
	}

}
