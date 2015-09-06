package cl.facele.promix.promix_nc;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


public class Transforma {

	public static void toTXT57(DTEBean bean) throws Exception {
		String txt = "";

		Document XMLdom = null;
		try {
			SAXReader saxReader = new SAXReader();
			XMLdom = saxReader.read(new StringReader(bean.getContenido()));

			// Variables Libres
			String varLibre = "";
			varLibre += "A0;";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += "\n";

			// Se asigna a folio
			bean.setRutEmisor(XMLdom.valueOf("//Encabezado/Emisor/RUTEmisor"));
			bean.setTipoDTE(XMLdom.valueOf("//Encabezado/IdDoc/TipoDTE"));
			bean.setFolioDTE(XMLdom.valueOf("//Encabezado/IdDoc/Folio"));
			bean.setSucursalEmisorDTE(XMLdom
					.valueOf("//Encabezado/Emisor/Sucursal"));

			String encabezado = "";
			encabezado += "A;";
			
			//TODO 
			encabezado += "61;"; // pos_1_Tipo
																				// de
																				// Documento
																				// Tributario
																				// Electrï¿½nico
			encabezado += ";"; // pos_2_Tipo Impresiï¿½n
			encabezado += "0" + ";"; // pos_3_FOLIO-Documento
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = formatter.format(new Date());
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/FchEmis") + ";"; // pos_4_Fecha
																				// de
																				// Emisiï¿½n
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndNoRebaja")
					+ ";"; // pos_5_Indicador de No Rebaja
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TipoDespacho")
					+ ";"; // pos_6_Tipo Despacho
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndTraslado")
					+ ";"; // pos_7_Indicador Tipo de Translado de bienes
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndServicio")
					+ ";"; // pos_8_Indicador Servicio
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/MntBruto") + ";"; // pos_9_Indicador
																				// Montos
																				// Brutos
			encabezado += ";"; // pos_10_Forma
																				// de
																				// Pago
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/FchCancel") + ";"; // pos_11_Fecha
																				// de
																				// Cancelaciï¿½n
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/PeriodoDesde")
					+ ";"; // pos_12_Periodo desde
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/PeriodoHasta")
					+ ";"; // pos_13_Periodo hasta
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/MedioPago") + ";"; // pos_14_Medio
																				// de
																				// Pago
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TermPagoCdg")
					+ ";"; // pos_15_Tï¿½rmino de Pago, cï¿½digo
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TermPagoDias")
					+ ";"; // pos_16_Tï¿½rmino de Pago, dï¿½as
			encabezado += ";"; // pos_17_Fecha
																				// de
																				// Vencimiento

			encabezado += XMLdom.valueOf("//Encabezado/Emisor/RUTEmisor") + ";"; // pos_18_RUT
																					// Emisor
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/RznSoc") + ";"; // pos_19_Nombre
																				// o
																				// Razï¿½n
																				// Social
																				// Emisor
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/GiroEmis") + ";"; // pos_20_Giro
																				// del
																				// Negocio
																				// del
																				// Emisor
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/Sucursal") + ";"; // pos_21_Sucursal
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CdgSIISucur")
					+ ";"; // pos_22_Cï¿½digo Sucursal
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/DirOrigen") + ";"; // pos_23_Direcciï¿½n
																					// Origen
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CmnaOrigen")
					+ ";"; // pos_24_Comuna Origen
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CiudadOrigen")
					+ ";"; // pos_25_Ciuidad Origen
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/CdgVendedor")
					+ ";"; // pos_26_Cï¿½digo del Vendedor

			encabezado += XMLdom.valueOf("//Encabezado/RUTMandante") + ";"; // pos_27_RUT
																			// Mandante

			encabezado += XMLdom.valueOf("//Encabezado/Receptor/RUTRecep")
					+ ";"; // pos_28_RUT Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CdgIntRecep")
					+ ";"; // pos_29_Cï¿½digo Interno del Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/RznSocRecep")
					+ ";"; // pos_30_Nombre o Razï¿½n Social Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/GiroRecep")
					+ ";"; // pos_31_Giro del Negocio del Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/Contacto")
					+ ";"; // pos_32_Contacto receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/DirRecep")
					+ ";"; // pos_33_Direcciï¿½n Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CmnaRecep")
					+ ";"; // pos_34_Comuna Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CiudadRecep")
					+ ";"; // pos_35_Ciudad Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/DirPostal")
					+ ";"; // pos_36_Direcciï¿½n Postal
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CmnaPostal")
					+ ";"; // pos_37_Comuna Postal
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CiudadPostal")
					+ ";"; // pos_38_Ciudad Postal

			encabezado += XMLdom.valueOf("//Encabezado/RUTSolicita") + ";"; // pos_39_RUT
																			// de
																			// Solicitante
																			// de
																			// Factura

			encabezado += XMLdom.valueOf("//Encabezado/Transporte/Patente")
					+ ";"; // pos_40_Informaciï¿½n Transporte (Patente)
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/RUTTrans")
					+ ";"; // pos_41_RUT Transportista
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/DirDest")
					+ ";"; // pos_42_Direcciï¿½n Destino
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/CmnaDest")
					+ ";"; // pos_43_Comuna Destino
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/CiudadDest")
					+ ";"; // pos_44_Ciudad Destino

			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntNeto") + ";"; // pos_45_Monto
																				// Neto
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntExe") + ";"; // pos_46_Monto
																				// No
																				// Afecto
																				// o
																				// Exento
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntBase") + ";"; // pos_47_Monto
																				// base
																				// faenamiento
																				// carne
			encabezado += XMLdom.valueOf("//Encabezado/Totales/TasaIVA") + ";"; // pos_48_Tasa
																				// IVA
			encabezado += XMLdom.valueOf("//Encabezado/Totales/IVA") + ";"; // pos_49_IVA
			encabezado += XMLdom.valueOf("//Encabezado/Totales/IVANoRet") + ";"; // pos_50_IVA
																					// no
																					// Retenido
			encabezado += XMLdom.valueOf("//Encabezado/Totales/CredEC") + ";"; // pos_51_Crï¿½dito
																				// especial
																				// 65%
																				// Empresas
																				// Contructoras
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MontoPeriodo")
					+ ";"; // pos_52_Monto Perï¿½odo
			encabezado += XMLdom.valueOf("//Encabezado/Totales/GrntDep") + ";"; // pos_53_Garantia
																				// por
																				// deposito
																				// o
																				// envases
																				// o
																				// embalajes
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MontoNF") + ";"; // pos_54_Monto
																				// No
																				// Facturable
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntTotal") + ";"; // pos_55_Monto
																					// Total
			encabezado += XMLdom.valueOf("//Encabezado/Totales/SaldoAnterior")
					+ ";"; // pos_56_Saldo Anterior
			encabezado += XMLdom.valueOf("//Encabezado/Totales/VlrPagar") + ";"; // pos_57_Valor
																					// a
																					// pagar
			encabezado += "\n";

			// ACTECO
			encabezado += "A1;";
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/Acteco") + ";";
			encabezado += "\n";
            //Impuestos adicionales            
			List<Node> a2List = XMLdom.selectNodes("//Encabezado/Totales/ImptoReten");
			for (Node detalle : a2List) {
			encabezado += "A2;";
			encabezado += detalle.valueOf("TipoImp") + ";";
            encabezado += detalle.valueOf("TasaImp") + ";";
            encabezado += detalle.valueOf("MontoImp") + ";";
			encabezado += "\n";
			}
			String detalles = "";

			int nroLinDet = 0;
			@SuppressWarnings("unchecked")
			List<Node> detalleList = XMLdom.selectNodes("//Detalle");
			for (Node detalle : detalleList) {
//				if (detalle.valueOf("IndExe").contains("2"))
//					continue;
				
				nroLinDet++;
				detalles += "B;";
				detalles += nroLinDet + ";"; // pos_1_Nï¿½ de
																// Lï¿½nea o Nï¿½
																// Secuencial
				detalles += detalle.valueOf("IndExe") + ";"; // pos_2_Indicador
																// de
																// facturaciï¿½n/
																// exenciï¿½n
				detalles += detalle.valueOf("NmbItem") + ";"; // pos_3_Nombre
																// del ï¿½tem
				detalles += detalle.valueOf("DscItem") + ";"; // pos_4_Descripciï¿½n
																// Adicional
				detalles += detalle.valueOf("QtyRef") + ";"; // pos_5_Cantidad
																// de Referencia
				detalles += detalle.valueOf("UnmdRef") + ";"; // pos_6_Unidad de
																// Medida de
																// Referencia
				detalles += detalle.valueOf("PrcRef") + ";"; // pos_7_Precio de
																// Referencia
				detalles += detalle.valueOf("QtyItem") + ";"; // pos_8_Cantidad
																// del ï¿½tem
				detalles += detalle.valueOf("FchElabor") + ";"; // pos_9_Fecha
																// Eleboraciï¿½n
				detalles += detalle.valueOf("FchVencim") + ";"; // pos_10_Fecha
																// Vencimiento
				detalles += detalle.valueOf("UnmdItem") + ";"; // pos_11_Unidad
																// de Medida
				detalles += detalle.valueOf("PrcItem") + ";"; // pos_12_Precio
																// Unitario del
																// ï¿½tem
				detalles += ";"; // pos_13_Precio Unitario en Otra Moneda
				detalles += ";"; // pos_14_Cï¿½digo de Otra Moneda
				detalles += ";"; // pos_15_Factor de Conversiï¿½n
				detalles += detalle.valueOf("DescuentoPct") + ";"; // pos_16_Descuento
																	// en %
				detalles += detalle.valueOf("DescuentoMonto") + ";"; // pos_17_Monto
																		// Descuento
				detalles += detalle.valueOf("RecargoPct") + ";"; // pos_18_Recargo
																	// en %
				detalles += detalle.valueOf("RecargoMonto") + ";"; // pos_19_Monto
																	// de
																	// Recargo
				detalles += detalle.valueOf("CodImpAdic") + ";"; // pos_20_Cï¿½digo
																	// Impuesto
																	// o
																	// Retenciones
				detalles += detalle.valueOf("MontoItem") + ";"; // pos_21_Monto
																// de ï¿½tem
				detalles += "\n";

				if (detalle.valueOf("CdgItem/VlrCodigo") != null
						&& !detalle.valueOf("CdgItem/TpoCodigo").trim()
								.isEmpty()) {
					detalles += "B2" + ";";
					detalles += detalle.valueOf("CdgItem/TpoCodigo") + ";";
					detalles += detalle.valueOf("CdgItem/VlrCodigo") + ";";
					detalles += "\n";
				}
			}

			String recargosDescuentos = "";
			@SuppressWarnings("unchecked")
			List<Node> descRecaList = XMLdom.selectNodes("//DscRcgGlobal");
			for (Node descReca : descRecaList) {
				recargosDescuentos += "C;";
				recargosDescuentos += descReca.valueOf("NroLinDR") + ";"; // pos_1_Nï¿½
																			// de
																			// Lï¿½nea
																			// o
																			// Nï¿½
																			// Secuencial
				recargosDescuentos += descReca.valueOf("TpoMov") + ";"; // pos_2_Tipo
																		// de
																		// Movimiento
				recargosDescuentos += descReca.valueOf("GlosaDR") + ";"; // pos_3_Glosa
				recargosDescuentos += descReca.valueOf("TpoValor") + ";"; // pos_4_Tipo
																			// de
																			// Valor
				recargosDescuentos += descReca.valueOf("ValorDR") + ";"; // pos_5_Valor
				recargosDescuentos += descReca.valueOf("IndExeDR") + ";"; // pos_6_Indicador
																			// de
																			// facturaciï¿½n/
																			// exenciï¿½n
				recargosDescuentos += "\n";
			}

			String referencias = "";
			referencias += "D;";
			referencias += "1;"; // pos_1_Nï¿½ de Lï¿½nea 
			referencias += XMLdom.valueOf("//Encabezado/IdDoc/TipoDTE") + ";"; // pos_2_Tipo
															// Documento de
															// referencia
			referencias += ";"; // pos_3_Indicador
															// de Referencia
															// Global
			referencias += XMLdom.valueOf("//Encabezado/IdDoc/Folio") + ";"; // pos_4_FOLIO-
															// de referencia
			referencias += ";"; // pos_5_RUT Otro
															// contribuyente
			referencias += XMLdom.valueOf("//Encabezado/IdDoc/FchEmis") + ";"; // pos_6_FECHA de
															// la Referencia
			referencias += "1;"; // pos_7_Cï¿½digo de
															// referencia
			referencias += "ANULA NOTA DE CREDITO REPETIDA;"; // pos_8_Razï¿½n
															// referencia
			referencias += "\n";
		

			txt = varLibre + encabezado + detalles + recargosDescuentos
					+ referencias;

		} catch (Exception e) {
			throw new Exception("ERROR al parserar XML: " + e.getMessage(), e);
		}

		bean.setTXT(txt);
	}

	public static void toTXT57BOLETA(DTEBean bean) throws Exception {
		String txt = "";

		Document XMLdom = null;
		try {
			SAXReader saxReader = new SAXReader();
			XMLdom = saxReader.read(new StringReader(bean.getContenido()));

			// Variables Libres
			String varLibre = "";
			varLibre += "A0;";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += "\n";

			// Se asigna a folio
			bean.setRutEmisor(XMLdom.valueOf("//Encabezado/Emisor/RUTEmisor"));
			bean.setTipoDTE(XMLdom.valueOf("//Encabezado/IdDoc/TipoDTE"));
			bean.setFolioDTE(XMLdom.valueOf("//Encabezado/IdDoc/Folio"));
			bean.setSucursalEmisorDTE(XMLdom
					.valueOf("//Encabezado/Emisor/Sucursal"));

			String encabezado = "";
			encabezado += "A;";
			
			//TODO 
			encabezado += "61;"; // pos_1_Tipo
																				// de
																				// Documento
																				// Tributario
																				// Electrï¿½nico
			encabezado += ";"; // pos_2_Tipo Impresiï¿½n
			encabezado += "0" + ";"; // pos_3_FOLIO-Documento
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = formatter.format(new Date());
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/FchEmis") + ";"; // pos_4_Fecha
																				// de
																				// Emisiï¿½n
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndNoRebaja")
					+ ";"; // pos_5_Indicador de No Rebaja
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TipoDespacho")
					+ ";"; // pos_6_Tipo Despacho
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndTraslado")
					+ ";"; // pos_7_Indicador Tipo de Translado de bienes
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndServicio")
					+ ";"; // pos_8_Indicador Servicio
			encabezado += "1" + ";"; // pos_9_Indicador
																				// Montos
																				// Brutos
			encabezado += ";"; // pos_10_Forma
																				// de
																				// Pago
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/FchCancel") + ";"; // pos_11_Fecha
																				// de
																				// Cancelaciï¿½n
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/PeriodoDesde")
					+ ";"; // pos_12_Periodo desde
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/PeriodoHasta")
					+ ";"; // pos_13_Periodo hasta
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/MedioPago") + ";"; // pos_14_Medio
																				// de
																				// Pago
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TermPagoCdg")
					+ ";"; // pos_15_Tï¿½rmino de Pago, cï¿½digo
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TermPagoDias")
					+ ";"; // pos_16_Tï¿½rmino de Pago, dï¿½as
			encabezado += ";"; // pos_17_Fecha
																				// de
																				// Vencimiento

			encabezado += XMLdom.valueOf("//Encabezado/Emisor/RUTEmisor") + ";"; // pos_18_RUT
																					// Emisor
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/RznSocEmisor") + ";"; // pos_19_Nombre
																				// o
																				// Razï¿½n
																				// Social
																				// Emisor
			encabezado += "COMPRA VENTA IMPORT Y EXPORT ARTS ELE..." + ";"; // pos_20_Giro
																				// del
																				// Negocio
																				// del
																				// Emisor
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/Sucursal") + ";"; // pos_21_Sucursal
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CdgSIISucur")
					+ ";"; // pos_22_Cï¿½digo Sucursal
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/DirOrigen") + ";"; // pos_23_Direcciï¿½n
																					// Origen
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CmnaOrigen")
					+ ";"; // pos_24_Comuna Origen
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CiudadOrigen")
					+ ";"; // pos_25_Ciuidad Origen
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/CdgVendedor")
					+ ";"; // pos_26_Cï¿½digo del Vendedor

			encabezado += XMLdom.valueOf("//Encabezado/RUTMandante") + ";"; // pos_27_RUT
																			// Mandante

			encabezado += XMLdom.valueOf("//Encabezado/Receptor/RUTRecep")
					+ ";"; // pos_28_RUT Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CdgIntRecep")
					+ ";"; // pos_29_Cï¿½digo Interno del Receptor
			encabezado += "no informado"
					+ ";"; // pos_30_Nombre o Razï¿½n Social Receptor
			encabezado += "no informado"
					+ ";"; // pos_31_Giro del Negocio del Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/Contacto")
					+ ";"; // pos_32_Contacto receptor
			encabezado +="no informado"
					+ ";"; // pos_33_Direcciï¿½n Receptor
			encabezado += "no informado"
					+ ";"; // pos_34_Comuna Receptor
			encabezado += "no informado"
					+ ";"; // pos_35_Ciudad Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/DirPostal")
					+ ";"; // pos_36_Direcciï¿½n Postal
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CmnaPostal")
					+ ";"; // pos_37_Comuna Postal
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CiudadPostal")
					+ ";"; // pos_38_Ciudad Postal

			encabezado += XMLdom.valueOf("//Encabezado/RUTSolicita") + ";"; // pos_39_RUT
																			// de
																			// Solicitante
																			// de
																			// Factura

			encabezado += XMLdom.valueOf("//Encabezado/Transporte/Patente")
					+ ";"; // pos_40_Informaciï¿½n Transporte (Patente)
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/RUTTrans")
					+ ";"; // pos_41_RUT Transportista
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/DirDest")
					+ ";"; // pos_42_Direcciï¿½n Destino
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/CmnaDest")
					+ ";"; // pos_43_Comuna Destino
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/CiudadDest")
					+ ";"; // pos_44_Ciudad Destino
			double netito= Math.round(Integer.parseInt(XMLdom.valueOf("//Encabezado/Totales/MntTotal"))/1.19);
			encabezado += (int)netito + ";"; // pos_45_Monto
																				// Neto
			encabezado += "0" + ";"; // pos_46_Monto
																				// No
																				// Afecto
																				// o
																				// Exento
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntBase") + ";"; // pos_47_Monto
																				// base
																				// faenamiento
																				// carne
			encabezado += "19" + ";"; // pos_48_Tasa
																				// IVA
			encabezado += (int)(Integer.parseInt(XMLdom.valueOf("//Encabezado/Totales/MntTotal"))-netito) + ";"; // pos_49_IVA
			encabezado += XMLdom.valueOf("//Encabezado/Totales/IVANoRet") + ";"; // pos_50_IVA
																					// no
																					// Retenido
			encabezado += XMLdom.valueOf("//Encabezado/Totales/CredEC") + ";"; // pos_51_Crï¿½dito
																				// especial
																				// 65%
																				// Empresas
																				// Contructoras
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MontoPeriodo")
					+ ";"; // pos_52_Monto Perï¿½odo
			encabezado += XMLdom.valueOf("//Encabezado/Totales/GrntDep") + ";"; // pos_53_Garantia
																				// por
																				// deposito
																				// o
																				// envases
																				// o
																				// embalajes
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MontoNF") + ";"; // pos_54_Monto
																				// No
																				// Facturable
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntTotal") + ";"; // pos_55_Monto
																					// Total
			encabezado += XMLdom.valueOf("//Encabezado/Totales/SaldoAnterior")
					+ ";"; // pos_56_Saldo Anterior
			encabezado += XMLdom.valueOf("//Encabezado/Totales/VlrPagar") + ";"; // pos_57_Valor
																					// a
																					// pagar
			encabezado += "\n";

			// ACTECO
			encabezado += "A1;222200;";
			encabezado += "\n";


			String detalles = "";

			int nroLinDet = 0;
			@SuppressWarnings("unchecked")
			List<Node> detalleList = XMLdom.selectNodes("//Detalle");
			for (Node detalle : detalleList) {
//				if (detalle.valueOf("IndExe").contains("2"))
//					continue;
				
				nroLinDet++;
				detalles += "B;";
				detalles += nroLinDet + ";"; // pos_1_Nï¿½ de
																// Lï¿½nea o Nï¿½
																// Secuencial
				detalles += detalle.valueOf("IndExe") + ";"; // pos_2_Indicador
																// de
																// facturaciï¿½n/
																// exenciï¿½n
				detalles += detalle.valueOf("NmbItem") + ";"; // pos_3_Nombre
																// del ï¿½tem
				detalles += detalle.valueOf("DscItem") + ";"; // pos_4_Descripciï¿½n
																// Adicional
				detalles += detalle.valueOf("QtyRef") + ";"; // pos_5_Cantidad
																// de Referencia
				detalles += detalle.valueOf("UnmdRef") + ";"; // pos_6_Unidad de
																// Medida de
																// Referencia
				detalles += detalle.valueOf("PrcRef") + ";"; // pos_7_Precio de
																// Referencia
				detalles += detalle.valueOf("QtyItem") + ";"; // pos_8_Cantidad
																// del ï¿½tem
				detalles += detalle.valueOf("FchElabor") + ";"; // pos_9_Fecha
																// Eleboraciï¿½n
				detalles += detalle.valueOf("FchVencim") + ";"; // pos_10_Fecha
																// Vencimiento
				detalles += detalle.valueOf("UnmdItem") + ";"; // pos_11_Unidad
																// de Medida
				detalles += detalle.valueOf("PrcItem") + ";"; // pos_12_Precio
																// Unitario del
																// ï¿½tem
				detalles += ";"; // pos_13_Precio Unitario en Otra Moneda
				detalles += ";"; // pos_14_Cï¿½digo de Otra Moneda
				detalles += ";"; // pos_15_Factor de Conversiï¿½n
				detalles += detalle.valueOf("DescuentoPct") + ";"; // pos_16_Descuento
																	// en %
				detalles += detalle.valueOf("DescuentoMonto") + ";"; // pos_17_Monto
																		// Descuento
				detalles += detalle.valueOf("RecargoPct") + ";"; // pos_18_Recargo
																	// en %
				detalles += detalle.valueOf("RecargoMonto") + ";"; // pos_19_Monto
																	// de
																	// Recargo
				detalles += detalle.valueOf("CodImpAdic") + ";"; // pos_20_Cï¿½digo
																	// Impuesto
																	// o
																	// Retenciones
				detalles += detalle.valueOf("MontoItem") + ";"; // pos_21_Monto
																// de ï¿½tem
				detalles += "\n";

				if (detalle.valueOf("CdgItem/VlrCodigo") != null
						&& !detalle.valueOf("CdgItem/TpoCodigo").trim()
								.isEmpty()) {
					detalles += "B2" + ";";
					detalles += detalle.valueOf("CdgItem/TpoCodigo") + ";";
					detalles += detalle.valueOf("CdgItem/VlrCodigo") + ";";
					detalles += "\n";
				}
			}

			String recargosDescuentos = "";
			@SuppressWarnings("unchecked")
			List<Node> descRecaList = XMLdom.selectNodes("//DscRcgGlobal");
			for (Node descReca : descRecaList) {
				recargosDescuentos += "C;";
				recargosDescuentos += descReca.valueOf("NroLinDR") + ";"; // pos_1_Nï¿½
																			// de
																			// Lï¿½nea
																			// o
																			// Nï¿½
																			// Secuencial
				recargosDescuentos += descReca.valueOf("TpoMov") + ";"; // pos_2_Tipo
																		// de
																		// Movimiento
				recargosDescuentos += descReca.valueOf("GlosaDR") + ";"; // pos_3_Glosa
				recargosDescuentos += descReca.valueOf("TpoValor") + ";"; // pos_4_Tipo
																			// de
																			// Valor
				recargosDescuentos += descReca.valueOf("ValorDR") + ";"; // pos_5_Valor
				recargosDescuentos += descReca.valueOf("IndExeDR") + ";"; // pos_6_Indicador
																			// de
																			// facturaciï¿½n/
																			// exenciï¿½n
				recargosDescuentos += "\n";
			}

			String referencias = "";
			referencias += "D;";
			referencias += "1;"; // pos_1_Nï¿½ de Lï¿½nea 
			referencias += XMLdom.valueOf("//Encabezado/IdDoc/TipoDTE") + ";"; // pos_2_Tipo
															// Documento de
															// referencia
			referencias += ";"; // pos_3_Indicador
															// de Referencia
															// Global
			referencias += XMLdom.valueOf("//Encabezado/IdDoc/Folio") + ";"; // pos_4_FOLIO-
															// de referencia
			referencias += ";"; // pos_5_RUT Otro
															// contribuyente
			referencias += XMLdom.valueOf("//Encabezado/IdDoc/FchEmis") + ";"; // pos_6_FECHA de
															// la Referencia
			referencias += "1;"; // pos_7_Cï¿½digo de
															// referencia
			referencias += "ANULA BOLETA POR MALA EMISION;"; // pos_8_Razï¿½n
															// referencia
			referencias += "\n";
		

			txt = varLibre + encabezado + detalles + recargosDescuentos
					+ referencias;

		} catch (Exception e) {
			throw new Exception("ERROR al parserar XML: " + e.getMessage(), e);
		}

		bean.setTXT(txt);
	}

	
	public static void toTXT34(DTEBean bean) throws Exception {
		String txt = "";

		Document XMLdom = null;
		try {
			SAXReader saxReader = new SAXReader();
			XMLdom = saxReader.read(bean.getFile());

			// Variables Libres
			String varLibre = "";
			varLibre += "A0;";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += "\n";

			// Se asigna a folio
			bean.setRutEmisor(XMLdom.valueOf("//Encabezado/Emisor/RUTEmisor"));
			bean.setTipoDTE(XMLdom.valueOf("//Encabezado/IdDoc/TipoDTE"));
			bean.setFolioDTE("0");
			bean.setSucursalEmisorDTE(XMLdom
					.valueOf("//Encabezado/Emisor/Sucursal"));

			String encabezado = "";
			encabezado += "ENC;";
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TipoDTE") + ";"; // 1
																				// Tipo
																				// de
																				// Documento
			encabezado += "1.0" + ";"; // 2 VERSION (1.0)
			encabezado += "0" + ";"; // 3 FOLIO-Documento
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/FchEmis") + ";"; // 4
																				// Emisiï¿½n
																				// Contable
			encabezado += "3" + ";"; // 5 Indicador Servicio
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndMntNeto") + ";"; // 6
																					// Indicador
																					// Montos
																					// Netos
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/PeriodoDesde")
					+ ";"; // 7 Periodo Desde
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/PeriodoHasta")
					+ ";"; // 8 Periodo Hasta
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/FchVenc") + ";"; // 9
																				// Fecha
																				// de
																				// vencimiento
																				// (pago)
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/RUTEmisor") + ";"; // 10
																					// Rut
																					// Emisor
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/RznSoc") + ";"; // 11
																				// Nombre
																				// o
																				// Razï¿½n
																				// Social
																				// Emisor
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/GiroEmis") + ";"; // 12
																				// Giro
																				// del
																				// negocio
																				// del
																				// Emisor1
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CdgSIISucur")
					+ ";"; // 13 Cï¿½digo sucursal
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/DirOrigen") + ";"; // 14
																					// Direcciï¿½n
																					// Origen
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CmnaOrigen")
					+ ";"; // 15 Comuna Origen
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CiudadOrigen")
					+ ";"; // 16 Ciudad Origen
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/RUTRecep")
					+ ";"; // 17 Rut Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor//CdgIntRecep")
					+ ";"; // 18 Cï¿½digo Interno del Cliente
			encabezado += XMLdom.valueOf("//Encabezado/Receptor//RznSocRecep")
					+ ";"; // 19 Nombre Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor//Contacto")
					+ ";"; // 20 Contacto Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor//DirRecep")
					+ ";"; // 21 Direcciï¿½n Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor//CmnaRecep")
					+ ";"; // 22 Comuna Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor//CiudadRecep")
					+ ";"; // 23 Ciudad Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor//DirPostal")
					+ ";"; // 24 Direcciï¿½n postal
			encabezado += XMLdom.valueOf("//Encabezado/Receptor//CmnaPostal")
					+ ";"; // 25 Comuna Postal
			encabezado += XMLdom.valueOf("//Encabezado/Receptor//CiudadPostal")
					+ ";"; // 26 Ciudad Postal
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntNeto") + ";"; // 27
																				// Monto
																				// neto
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntExe") + ";"; // 28
																				// Monto
																				// exento
			encabezado += XMLdom.valueOf("//Encabezado/Totales/IVA") + ";"; // 29
																			// Monto
																			// IVA
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntTotal") + ";"; // 30
																					// Monto
																					// Total
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MontoNF") + ";"; // 31
																				// Monto
																				// no
																				// Facturable
			encabezado += XMLdom.valueOf("//Encabezado/Totales/TotalPeriodo")
					+ ";"; // 32 Total perï¿½odo
			encabezado += XMLdom.valueOf("//Encabezado/Totales/SaldoAnterior")
					+ ";"; // 33 Saldo anterior
			encabezado += XMLdom.valueOf("//Encabezado/Totales/VlrPagar") + ";"; // 34
																					// Valor
																					// a
																					// pagar
			encabezado += "\n";

			String detalles = "";
			@SuppressWarnings("unchecked")
			List<Node> detalleList = XMLdom.selectNodes("//Detalle");
			for (Node detalle : detalleList) {
				// Detalle de Producto o Servicio [1..1000] nombre de lï¿½nea DET
				detalles += "DET;";
				detalles += detalle.valueOf("NroLinDet") + ";"; // 1 Nï¿½ de Lï¿½nea
				detalles += detalle.valueOf("IndExe") + ";"; // 2 Indicador
																// exenciï¿½n
				detalles += detalle.valueOf("NmbItem") + ";"; // 3 Nombre del
																// ï¿½tem
				detalles += detalle.valueOf("DscItem") + ";"; // 4 Descripciï¿½n
																// Adicional
				detalles += detalle.valueOf("QtyItem") + ";"; // 5 Cantidad
				detalles += detalle.valueOf("UnmdItem") + ";"; // 6 Unidad de
																// Medida
				detalles += detalle.valueOf("PrcItem") + ";"; // 7 Precio
																// Unitario
				detalles += detalle.valueOf("MontoItem") + ";"; // 8 Valor por
																// lï¿½nea de
																// detalle
				detalles += "\n";

				if (detalle.valueOf("CdgItem/VlrCodigo") != null
						&& !detalle.valueOf("CdgItem/TpoCodigo").trim()
								.isEmpty()) {
					// Cï¿½digo ï¿½tem Detalle [0..5] nombre lï¿½nea ITCOD
					detalles += "ITCOD" + ";";
					detalles += detalle.valueOf("CdgItem/TpoCodigo") + ";"; // 1
																			// Tipo
																			// cï¿½digo
					detalles += detalle.valueOf("CdgItem/VlrCodigo") + ";"; // 2
																			// Cï¿½digo
																			// del
																			// ï¿½tem
					detalles += "\n";
				}
			}

			String recargosDescuentos = "";
			@SuppressWarnings("unchecked")
			List<Node> descRecaList = XMLdom.selectNodes("//DscRcgGlobal");
			for (Node descReca : descRecaList) {
				// Informaciï¿½n de Descuentos o Recargos [0..20] nombre lï¿½nea
				// DESCREC
				recargosDescuentos += "DESCREC;";
				recargosDescuentos += descReca.valueOf("NroLinDR") + ";"; // 1
																			// Nï¿½
																			// de
																			// Lï¿½nea
				recargosDescuentos += descReca.valueOf("TpoMov") + ";"; // 2
																		// Tipo
																		// de
																		// movimiento
				recargosDescuentos += descReca.valueOf("GlosaDR") + ";"; // 3
																			// Glosa
				recargosDescuentos += descReca.valueOf("TpoValor") + ";"; // 4
																			// Tipo
																			// de
																			// valor
				recargosDescuentos += descReca.valueOf("ValorDR") + ";"; // 5
																			// Valor
				recargosDescuentos += descReca.valueOf("IndExeDR") + ";"; // 6
																			// Indicador
																			// exenciï¿½n
				recargosDescuentos += "\n";
			}

			String referencias = "";
			int numeLineaReferencia = 0;
			@SuppressWarnings("unchecked")
			List<Node> referenciasList = XMLdom.selectNodes("//Referencia");
			for (Node refe : referenciasList) {
				numeLineaReferencia++;
				// Datos de Referencia [0..40] nombre lï¿½nea REF
				referencias += "REF;";
				referencias += numeLineaReferencia + ";"; // 1 Nï¿½ de Lï¿½nea
				referencias += refe.valueOf("CodRef") + ";"; // 2 Cï¿½digo
																// referencia
				referencias += refe.valueOf("RazonRef") + ";"; // 3 Razï¿½n
																// referencia
				referencias += "\n";
			}

			txt = varLibre + encabezado + detalles + recargosDescuentos
					+ referencias;

		} catch (Exception e) {
			throw new Exception("ERROR al parserar XML: " + e.getMessage(), e);
		}

		bean.setTXT(txt);
	}

	public static void toTXT123Liquidacion(DTEBean bean) throws Exception {
		String txt = "";

		Document XMLdom = null;
		try {
			SAXReader saxReader = new SAXReader();
			XMLdom = saxReader.read(new StringReader(bean.getContenido()));

			// Variables Libres
			String varLibre = "";
			varLibre += "A0;";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += "\n";

			// Se asigna a folio
			bean.setRutEmisor(XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Emisor/RUTEmisor"));
			bean.setTipoDTE(XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/TipoDTE"));
			bean.setFolioDTE(XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/Folio"));
			bean.setSucursalEmisorDTE(XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Emisor/CdgSIISucur"));

			String encabezado = "";
			
			encabezado += "ENC;";
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/TipoDTE") + ";";		//	1	TipoDTE
			//encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/Folio") + ";";		//	2	Folio
                        encabezado += 0 + ";";
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/FchEmis") + ";";		//	3	Fecha de EmisiÃ³n
			encabezado += ";";		//	4	Indicador de No Rebaja
			encabezado += ";";		//	5	Tipo de Despacho
			encabezado += ";";		//	6	Indicador Tipo de traslado de bienes
			encabezado += ";";		//	7	Tipo de impresiÃ³n
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/IndServicio") + ";";		//	8	Indicador Servicio
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/MntBruto") + ";";		//	9	Indicador Montos Brutos
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/FmaPago") + ";";		//	10	Forma de Pago
			encabezado += ";";		//	11	Forma de Pago ExportaciÃ³n
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/FchCancel") + ";";		//	12	Fecha de cancelaciÃ³n
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/MntCancel") + ";";		//	13	Monto Cancelado
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/SaldoInsol") + ";";		//	14	Saldo Insoluto
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/PeriodoDesde") + ";";		//	15	PerÃ­odo desde
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/PeriodoHasta") + ";";		//	16	PerÃ­odo hasta
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/MedioPago") + ";";		//	17	Medio de Pago
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/TpoCtaPago") + ";";		//	18	Tipo Cuenta de Pago
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/NumCtaPago") + ";";		//	19	Cuenta de Pago
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/BcoPago") + ";";		//	20	Banco de Pago
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/TermPagoCdg") + ";";		//	21	TÃ©rminos del pago-CÃ³dig
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/TermPagoGlosa") + ";";		//	22	TÃ©rminos del Pagoâ€“Glosa
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/TermPagoDias") + ";";		//	23	TÃ©rminos del Pago-DÃ­as
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/FchVenc") + ";";		//	24	Fecha de vencimiento (pago)
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Emisor/RUTEmisor") + ";";		//	25	Rut Emisor
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Emisor/RznSoc") + ";";		//	26	Nombre o RazÃ³n Social Emisor
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Emisor/GiroEmis") + ";";		//	27	Giro del negocio del Emisor
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Emisor/Telefono") + ";";		//	28	TelÃ©fono Emisor
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Emisor/CorreoEmisor") + ";";		//	29	Correo Emisor
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Emisor/Acteco") + ";";		//	30	ACTECO
			encabezado += ";";		//	31	ACTECO 2
			encabezado += ";";		//	32	ACTECO 3
			encabezado += ";";		//	33	ACTECO 4
			encabezado += ";";		//	34	CÃ³digo Emisor Traslado Excepcional
			encabezado += ";";		//	35	Folio AutorizaciÃ³n
			encabezado += ";";		//	36	Fecha AutorizaciÃ³n
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Emisor/Sucursal") + ";";		//	37	Sucursal
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Emisor/CdgSIISucur") + ";";		//	38	CÃ³digo sucursal
			encabezado += ";";		//	39	CÃ³digo Adicional de Sucursal
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Emisor/DirOrigen") + ";";		//	40	DirecciÃ³n Origen
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Emisor/CmnaOrigen") + ";";		//	41	Comuna Origen
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Emisor/CiudadOrigen") + ";";		//	42	Ciudad Origen
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Emisor/CdgVendedor") + ";";		//	43	CÃ³digo del Vendedor
			encabezado += ";";		//	44	Identificador Adicional del Emisor
			encabezado += ";";		//	45	Rut Mandante
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Receptor/RUTRecep") + ";";		//	46	Rut Receptor
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Receptor/CdgIntRecep") + ";";		//	47	CÃ³digo Interno del Receptor
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Receptor/RznSocRecep") + ";";		//	48	Nombre o RazÃ³n Social Receptor
			encabezado += ";";		//	49	NÃºmero identificador del Receptor extranjero
			encabezado += ";";		//	50	Nacionalidad del Receptor Extranjero
			encabezado += ";";		//	51	Identificador Adicional del Receptor Extranjero
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Receptor/GiroRecep") + ";";		//	52	Giro del negocio del Receptor
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Receptor/Contacto") + ";";		//	53	Contacto receptor
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Receptor/CorreoRecep") + ";";		//	54	Correo Contacto receptor
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Receptor/DirRecep") + ";";		//	55	DirecciÃ³n Receptor
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Receptor/CmnaRecep") + ";";		//	56	Comuna Receptor
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Receptor/CiudadRecep") + ";";		//	57	Ciudad Receptor
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Receptor/DirPostal") + ";";		//	58	DirecciÃ³n Postal Receptor
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Receptor/CmnaPostal") + ";";		//	59	Comuna Postal
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Receptor/CiudadPostal") + ";";		//	60	Ciudad Postal
			encabezado += ";";		//	61	Rut de Solicitante de factura
			encabezado += ";";		//	62	InformaciÃ³n Transporte
			encabezado += ";";		//	63	Rut transportista
			encabezado += ";";		//	64	RUT Chofer
			encabezado += ";";		//	65	Nombre del Chofer
			encabezado += ";";		//	66	DirecciÃ³n Destino
			encabezado += ";";		//	67	Comuna Destino
			encabezado += ";";		//	68	Ciudad Destino
			encabezado += ";";		//	69	Modalidad de Venta
			encabezado += ";";		//	70	ClÃ¡usula de venta ExportaciÃ³n
			encabezado += ";";		//	71	Total ClÃ¡usula de venta ExportaciÃ³n
			encabezado += ";";		//	72	VÃ­a de Transporte
			encabezado += ";";		//	73	Nombre o IdentificaciÃ³n del Medio de Transporte
			encabezado += ";";		//	74	Rut CÃ­a. Transportadora
			encabezado += ";";		//	75	Nombre CÃ­a. Transportadora
			encabezado += ";";		//	76	Identificador Adicional CÃ­a. Transportadora
			encabezado += ";";		//	77	Booking
			encabezado += ";";		//	78	Operador
			encabezado += ";";		//	79	Puerto de Embarque
			encabezado += ";";		//	80	Identificador Adicional Puerto de Embarque.
			encabezado += ";";		//	81	Puerto Desembarque
			encabezado += ";";		//	82	Identificador Adicional Puerto de Desembarque.
			encabezado += ";";		//	83	Tara
			encabezado += ";";		//	84	Unidad de medida de la Tara
			encabezado += ";";		//	85	Total Peso Bruto
			encabezado += ";";		//	86	Unidad Peso Bruto
			encabezado += ";";		//	87	Total peso Neto
			encabezado += ";";		//	88	Unidad peso neto
			encabezado += ";";		//	89	Total Ã�tems
			encabezado += ";";		//	90	Total Bultos
			encabezado += ";";		//	91	Flete
			encabezado += ";";		//	92	Seguro
			encabezado += ";";		//	93	CÃ³digo PaÃ­s Receptor
			encabezado += ";";		//	94	CÃ³digo PaÃ­s Destino
			encabezado += ";";		//	95	Tipo Moneda TransacciÃ³n
			encabezado += "-"+XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Totales/MntNeto") + ";";		//	96	Monto neto
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Totales/MntExe") + ";";		//	97	Monto no afecto o exento
			encabezado += ";";		//	98	Monto base faenamiento carne
			encabezado += ";";		//	99	Monto Base de MÃ¡rgenes de ComercializaciÃ³n
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Totales/TasaIVA") + ";";		//	100	Tasa IVA
			encabezado += "-"+XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Totales/IVA") + ";";		//	101	IVA
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Totales/IVAProp") + ";";		//	102	IVA propio
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Totales/IVATerc") + ";";		//	103	IVA terceros
			encabezado += ";";		//	104	IVA no retenido
			encabezado += ";";		//	105	CrÃ©dito especial 65% Empresas Constructoras
			encabezado += ";";		//	106	GarantÃ­a por depÃ³sito de envases o embalajes (no afecto)
			encabezado += "-"+XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Totales/Comisiones/ValComNeto") + ";";		//	107	Valor Neto Comisiones y Otros Cargos
			encabezado += ";";		//	108	Valor Comisiones y Otros Cargos No Afectos o Exentos
			encabezado += "-"+XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Totales/Comisiones/ValComIVA") + ";";		//	109	IVA Comisiones y Otros Cargos
			encabezado += "-"+XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Totales/MntTotal") + ";";		//	110	Monto Total
			encabezado += ";";		//	111	Monto no Facturable
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Totales/MontoPeriodo") + ";";		//	112	Monto PerÃ­odo
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Totales/SaldoAnterior") + ";";		//	113	Saldo Anterior
			encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/Totales/VlrPagar") + ";";		//	114	Valor a pagar
			encabezado += ";";		//	115	CÃ³digo Otra moneda
			encabezado += ";";		//	116	Tipo de Cambio
			encabezado += ";";		//	117	Monto neto Otra Moneda
			encabezado += ";";		//	118	Monto no afecto o exento en Otra Moneda
			encabezado += ";";		//	119	Monto base faenamiento carne Otra Moneda
			encabezado += ";";		//	120	Monto Base de MÃ¡rgenes de ComercializaciÃ³n Otra Moneda
			encabezado += ";";		//	121	IVA en otra moneda
			encabezado += ";";		//	122	IVA no retenido Otra Moneda
			encabezado += ";";		//	123	Monto Total en Otra Moneda
			encabezado += "\n";

			//	TABLA de Montos de Pago [0..30] nombre lÃ­nea ENC-2	
			@SuppressWarnings("unchecked")
			List<Node> montoPagos = XMLdom.selectNodes("//DTE/Liquidacion/Encabezado/IdDoc/MntPagos");
			for (Node montoPago: montoPagos) {
				encabezado += "ENC-2";		//		
				encabezado += montoPago.valueOf("FchPago") + ";";		//	1	Fecha de Pago
				encabezado += montoPago.valueOf("MntPago") + ";";		//	2	Monto de Pago
				encabezado += montoPago.valueOf("GlosaPagos") + ";";		//	3	Glosa descripciÃ³n Pago
				encabezado += "\n";
			}

			//	TABLA de Impuestos Adicionales o Retencion [0..20] nombre lÃ­nea ENC-4	
			@SuppressWarnings("unchecked")
			List<Node> imptoRetenes = XMLdom.selectNodes("//DTE/Liquidacion/Encabezado/Receptor/Totales/ImptoReten");
			for (Node imptoReten: imptoRetenes) {
				encabezado += "ENC-4";		//		
				encabezado += imptoReten.valueOf("TipoImp") + ";";		//	1	CÃ³digo de Impuesto adicional o RetenciÃ³n
				encabezado += imptoReten.valueOf("TasaImp") + ";";		//	2	Tasa de Impuesto o RetenciÃ³n
				encabezado += imptoReten.valueOf("MontoImp") + ";";		//	3	Valor del Impuesto o RetenciÃ³n.
				encabezado += "\n";
			}	

			//	TABLA de Impuestos Adicionales o Retencion en Otras Monedas [0..20] nombre lÃ­nea ENC-5	
			@SuppressWarnings("unchecked")
			List<Node> comisionesEncabezado = XMLdom.selectNodes("//DTE/Liquidacion/Encabezado/Receptor/Totales/Comisiones");
			for (Node comisione: comisionesEncabezado) {
				encabezado += "ENC-5;";		//		
				encabezado += comisione.valueOf("ValComNeto") + ";";		//	1	CÃ³digo de Impuesto adicional o RetenciÃ³n
				encabezado += comisione.valueOf("ValComExe") + ";";		//	2	Tasa de Impuesto o RetenciÃ³n
				encabezado += comisione.valueOf("ValComIVA") + ";";		//	3	Valor del Impuesto o RetenciÃ³n.
				encabezado += "\n";
			}

			String detalles = "";

			@SuppressWarnings("unchecked")
			List<Node> detalleList = XMLdom.selectNodes("//DTE/Liquidacion/Detalle");
			for (Node detalle : detalleList) {
				//	DETALLE [1..60] nombre lÃ­nea DET	
				detalles += "DET;";		//
				detalles += detalle.valueOf("NroLinDet") + ";";		//	1	NÂ° de LÃ­nea
				detalles += detalle.valueOf("TpoDocLiq") + ";";		//	2	Tipo Documento que se Liquida
				detalles += detalle.valueOf("IndExe") + ";";		//	3	Indicador de facturaciÃ³n/exenciÃ³n
				detalles += ";";		//	4	Indicador Agente Retenedor
				detalles += ";";		//	5	Monto Base Faenamiento
				detalles += ";";		//	6	Monto Base MÃ¡rgenes de ComercializaciÃ³n
				detalles += ";";		//	7	Precio Unitario Neto Consumidor Final
				detalles += detalle.valueOf("NmbItem") + ";";		//	8	Nombre del Ã�tem
				detalles += detalle.valueOf("DscItem") + ";";		//	9	DescripciÃ³n Adicional
				detalles += detalle.valueOf("QtyRef") + ";";		//	10	Cantidad de referencia
				detalles += detalle.valueOf("UnmdRef") + ";";		//	11	Unidad de referencia
				detalles += detalle.valueOf("PrcRef") + ";";		//	12	Precio de referencia
				detalles += detalle.valueOf("QtyItem") + ";";		//	13	Cantidad
				detalles += detalle.valueOf("FchElabor") + ";";		//	14	Fecha elaboraciÃ³n
				detalles += detalle.valueOf("FchVencim") + ";";		//	15	Fecha vencimiento
				detalles += detalle.valueOf("UnmdItem") + ";";		//	16	Unidad de Medida
				detalles += detalle.valueOf("PrcItem") + ";";		//	17	Precio Unitario del Ã�tem
				detalles += ";";		//	18	Descuento en %
				detalles += ";";		//	19	Monto Descuento
				detalles += ";";		//	20	Recargo en %
				detalles += ";";		//	21	Monto Recargo
				detalles += "-"+detalle.valueOf("MontoItem") + ";";		//	22	Monto Item
				detalles += "\n";
				
				
				//	TABLA CÃ³digo Ã�tem [0..5] nombre lÃ­nea DET-2	
				@SuppressWarnings("unchecked")
				List<Node> codigos = detalle.selectNodes("CdgItem");
				for (Node codigo: codigos) {
					detalles += "DET-2;";		//		
					detalles += codigo.valueOf("TpoCodigo") + ";";		//	1	Tipo cÃ³digo
					detalles += codigo.valueOf("VlrCodigo") + ";";		//	2	CÃ³digo del Ã�tem
					detalles += "\n";
				}

				//	TABLA DistribuciÃ³n de Cantidad [0..5] nombre lÃ­nea DET-3
				@SuppressWarnings("unchecked")
				List<Node> subcantidades = detalle.selectNodes("Subcantidad");
				for (Node subcantidad: subcantidades) {
					detalles += "DET-3;";		//		
					detalles += subcantidad.valueOf("SubQty") + ";";		//	1	Subcantidad Distribuida
					detalles += subcantidad.valueOf("SubCod") + ";";		//	2	CÃ³digo subcantidad
					detalles += ";";		//	3	Tipo CÃ³digo Subcantidad
					detalles += "\n";
				}
			}

			String subTotales = "";
			//	Subtotales Informativos [0..20] nombre lÃ­nea SUBT
			@SuppressWarnings("unchecked")
			List<Node> sutotalList = XMLdom.selectNodes("//DTE/Liquidacion/SubTotInfo");
			for (Node subTotInfo: sutotalList) {		
				subTotales += subTotInfo.valueOf("NroSTI") + ";";		//	1	NÃºmero Subtotal
				subTotales += subTotInfo.valueOf("GlosaSTI") + ";";		//	2	Glosa
				subTotales += subTotInfo.valueOf("OrdenSTI") + ";";		//	3	Orden
				subTotales += subTotInfo.valueOf("SubTotNetoSTI") + ";";		//	4	Subtotal Neto
				subTotales += subTotInfo.valueOf("SubTotIVASTI") + ";";		//	5	Subtotal IVA
				subTotales += subTotInfo.valueOf("SubTotAdicSTI") + ";";		//	6	Subtotal Impuestos adicionales o especÃ­ficos
				subTotales += subTotInfo.valueOf("SubTotExeSTI") + ";";		//	7	Subtotal no Afecto o Exento
				subTotales += subTotInfo.valueOf("ValSubtotSTI") + ";";		//	8	Valor del Subtotal
				subTotales += "\n";
				
				//TODO termina
//				//	Subtotales Informativos [0..20] nombre lÃ­nea SUB-2	
//				List<Node> sutotalList = subTotInfo.selectNodes("LineasDeta");		
//				subTotales += subTotInfo.valueOf("-") + ";";		//	1	LINEAS
			}

			//	Informacion de Referencia [0..40] nombre lÃ­nea REF	
			String referencias = "";
			@SuppressWarnings("unchecked")
			List<Node> referenciasList = XMLdom.selectNodes("//Referencia");
			for (Node refe : referenciasList) {
				referencias += "REF;";				
				referencias += refe.valueOf("NroLinRef") + ";";		//	1	NÂ° LÃ­nea
				referencias += refe.valueOf("TpoDocRef") + ";";		//	2	Tipo Documento de referencia
				referencias += refe.valueOf("IndGlobal") + ";";		//	3	Indicador de Referencia Global
				referencias += refe.valueOf("FolioRef") + ";";		//	4	FOLIO- de referencia
				referencias += ";";		//	5	RUT Otro contribuyente
				referencias += ";";		//	6	Identificador Adicional de otro contribuyente
				referencias += refe.valueOf("FchRef") + ";";		//	7	FECHA de la Referencia
				referencias += refe.valueOf("CodRef") + ";";		//	8	CÃ³digo de referencia
				referencias += refe.valueOf("RazonRef") + ";";		//	9	RazÃ³n referencia
				referencias += "\n";
			}
			
			//	Comisiones y Otros Cargos [0..20] nombre lÃ­nea CMSNYO
			String comisiones = "";
			@SuppressWarnings("unchecked")
			List<Node> comisionesList = XMLdom.selectNodes("//DTE/Liquidacion/Comisiones");
			for (Node comision : comisionesList) {
				comisiones += "CMSNYO;";
				comisiones += comision.valueOf("NroLinCom") + ";";		//	1	NÂ° de LÃ­nea
				comisiones += comision.valueOf("TipoMovim") + ";";		//	2	Tipo de movimiento
				comisiones += comision.valueOf("Glosa") + ";";		//	3	Glosa
				comisiones += comision.valueOf("TasaComision") + ";";		//	4	Tasa comisiÃ³n u otro cargo
				comisiones += "-"+comision.valueOf("ValComNeto") + ";";		//	5	Valor ComisiÃ³n Neto
				comisiones += comision.valueOf("ValComExe") + ";";		//	6	Valor ComisiÃ³n Exento
				comisiones += "-"+comision.valueOf("ValComIVA") + ";";		//	7	Valor IVA ComisiÃ³n u Otro Cargo
				comisiones += "\n";
			}
			
			txt = varLibre + encabezado + detalles + subTotales + referencias + comisiones;
			txt = txt.replace("null", "");

		} catch (Exception e) {
			throw new Exception("ERROR al parserar XML: " + e.getMessage(), e);
		}

//		logger.debug("TXT: " + txt);
		bean.setTXT(txt);
	}

	public static void toTXT123Exportacion(DTEBean bean) throws Exception {
		// TODO Auto-generated method stub
		
		String txt = "";

		Document XMLdom = null;
		try {
			SAXReader saxReader = new SAXReader();
			XMLdom = saxReader.read(new StringReader(bean.getContenido()));

			// Variables Libres
			String varLibre = "";
			varLibre += "A0;";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += "\n";

			// Se asigna a folio
			bean.setRutEmisor(XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Emisor/RUTEmisor"));
			bean.setTipoDTE(XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/TipoDTE"));
			bean.setFolioDTE(XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/Folio"));
			bean.setSucursalEmisorDTE(XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Emisor/CdgSIISucur"));

			String encabezado = "";
			
			encabezado += "ENC;";
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/TipoDTE") + ";";		//	1	TipoDTE
			//encabezado += XMLdom.valueOf("//DTE/Liquidacion/Encabezado/IdDoc/Folio") + ";";		//	2	Folio
                        encabezado += 0 + ";";
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/FchEmis") + ";";		//	3	Fecha de EmisiÃ³n
			encabezado += ";";		//	4	Indicador de No Rebaja
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/TipoDespacho")+";";		//	5	Tipo de Despacho
			encabezado += ";";		//	6	Indicador Tipo de traslado de bienes
			encabezado += ";";		//	7	Tipo de impresiÃ³n
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/IndServicio") + ";";		//	8	Indicador Servicio
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/MntBruto") + ";";		//	9	Indicador Montos Brutos
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/FmaPago") + ";";		//	10	Forma de Pago
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/FmaPagExp")+";";		//	11	Forma de Pago ExportaciÃ³n
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/FchCancel") + ";";		//	12	Fecha de cancelaciÃ³n
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/MntCancel") + ";";		//	13	Monto Cancelado
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/SaldoInsol") + ";";		//	14	Saldo Insoluto
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/PeriodoDesde") + ";";		//	15	PerÃ­odo desde
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/PeriodoHasta") + ";";		//	16	PerÃ­odo hasta
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/MedioPago") + ";";		//	17	Medio de Pago
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/TpoCtaPago") + ";";		//	18	Tipo Cuenta de Pago
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/NumCtaPago") + ";";		//	19	Cuenta de Pago
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/BcoPago") + ";";		//	20	Banco de Pago
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/TermPagoCdg") + ";";		//	21	TÃ©rminos del pago-CÃ³dig
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/TermPagoGlosa") + ";";		//	22	TÃ©rminos del Pagoâ€“Glosa
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/TermPagoDias") + ";";		//	23	TÃ©rminos del Pago-DÃ­as
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/IdDoc/FchVenc") + ";";		//	24	Fecha de vencimiento (pago)
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Emisor/RUTEmisor") + ";";		//	25	Rut Emisor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Emisor/RznSoc") + ";";		//	26	Nombre o RazÃ³n Social Emisor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Emisor/GiroEmis") + ";";		//	27	Giro del negocio del Emisor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Emisor/Telefono") + ";";		//	28	TelÃ©fono Emisor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Emisor/CorreoEmisor") + ";";		//	29	Correo Emisor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Emisor/Acteco") + ";";		//	30	ACTECO
			encabezado += ";";		//	31	ACTECO 2
			encabezado += ";";		//	32	ACTECO 3
			encabezado += ";";		//	33	ACTECO 4
			encabezado += ";";		//	34	CÃ³digo Emisor Traslado Excepcional
			encabezado += ";";		//	35	Folio AutorizaciÃ³n
			encabezado += ";";		//	36	Fecha AutorizaciÃ³n
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Emisor/Sucursal") + ";";		//	37	Sucursal
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Emisor/CdgSIISucur") + ";";		//	38	CÃ³digo sucursal
			encabezado += ";";		//	39	CÃ³digo Adicional de Sucursal
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Emisor/DirOrigen") + ";";		//	40	DirecciÃ³n Origen
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Emisor/CmnaOrigen") + ";";		//	41	Comuna Origen
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Emisor/CiudadOrigen") + ";";		//	42	Ciudad Origen
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Emisor/CdgVendedor") + ";";		//	43	CÃ³digo del Vendedor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Emisor/IdAdicEmisor")+";";		//	44	Identificador Adicional del Emisor
			encabezado += ";";		//	45	Rut Mandante
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Receptor/RUTRecep") + ";";		//	46	Rut Receptor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Receptor/CdgIntRecep") + ";";		//	47	CÃ³digo Interno del Receptor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Receptor/RznSocRecep") + ";";		//	48	Nombre o RazÃ³n Social Receptor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Receptor/Extranjero/NumId")+";";		//	49	NÃºmero identificador del Receptor extranjero
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Receptor/Extranjero/Nacionalidad")+";";		//	50	Nacionalidad del Receptor Extranjero
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Receptor/Extranjero/IdAdicRecep")+";";		//	51	Identificador Adicional del Receptor Extranjero
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Receptor/GiroRecep") + ";";		//	52	Giro del negocio del Receptor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Receptor/Contacto") + ";";		//	53	Contacto receptor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Receptor/CorreoRecep") + ";";		//	54	Correo Contacto receptor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Receptor/DirRecep") + ";";		//	55	DirecciÃ³n Receptor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Receptor/CmnaRecep") + ";";		//	56	Comuna Receptor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Receptor/CiudadRecep") + ";";		//	57	Ciudad Receptor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Receptor/DirPostal") + ";";		//	58	DirecciÃ³n Postal Receptor
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Receptor/CmnaPostal") + ";";		//	59	Comuna Postal
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Receptor/CiudadPostal") + ";";		//	60	Ciudad Postal
			encabezado += ";";		//	61	Rut de Solicitante de factura
			encabezado += ";";		//	62	InformaciÃ³n Transporte
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/RUTTrans")+";";		//	63	Rut transportista
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Chofer/RUTChofer")+";";		//	64	RUT Chofer
			encabezado +=XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Chofer/NombreChofer")+";";		//	65	Nombre del Chofer
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/DirDest")+";";		//	66	DirecciÃ³n Destino
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/CmnaDest")+";";		//	67	Comuna Destino
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/CiudadDest")+";";		//	68	Ciudad Destino
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/CodModVenta")+";";		//	69	Modalidad de Venta
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/CodClauVenta")+";";		//	70	ClÃ¡usula de venta ExportaciÃ³n
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/TotClauVenta")+";";		//	71	Total ClÃ¡usula de venta ExportaciÃ³n
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/CodViaTransp")+";";		//	72	VÃ­a de Transporte
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/NombreTransp")+";";		//	73	Nombre o IdentificaciÃ³n del Medio de Transporte
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/RUTCiaTransp")+";";		//	74	Rut CÃ­a. Transportadora
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/NomCiaTransp")+";";		//	75	Nombre CÃ­a. Transportadora
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/IdAdicTransp")+";";		//	76	Identificador Adicional CÃ­a. Transportadora
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/Booking")+";";		//	77	Booking
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/Operador")+";";		//	78	Operador
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/CodPtoEmbarque")+";";		//	79	Puerto de Embarque
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/IdAdicPtoEmb")+";";		//	80	Identificador Adicional Puerto de Embarque.
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/CodPtoDesemb")+";";		//	81	Puerto Desembarque
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/IdAdicPtoDesemb")+";";		//	82	Identificador Adicional Puerto de Desembarque.
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/Tara")+";";		//	83	Tara
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/CodUnidMedTara")+";";		//	84	Unidad de medida de la Tara
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/PesoBruto")+";";		//	85	Total Peso Bruto
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/CodUnidPesoBruto")+";";		//	86	Unidad Peso Bruto
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/PesoNeto")+";";		//	87	Total peso Neto
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/CodUnidPesoNeto")+";";		//	88	Unidad peso neto
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/TotItems")+";";		//	89	Total Ã�tems
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Transporte/Aduana/TotBultos")+";";		//	90	Total Bultos
			encabezado += ";";		//	91	Flete
			encabezado += ";";		//	92	Seguro
			encabezado += ";";		//	93	CÃ³digo PaÃ­s Receptor
			encabezado += ";";		//	94	CÃ³digo PaÃ­s Destino
			encabezado += ";";		//	95	Tipo Moneda TransacciÃ³n
			encabezado += "-"+XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Totales/MntNeto") + ";";		//	96	Monto neto
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Totales/MntExe") + ";";		//	97	Monto no afecto o exento
			encabezado += ";";		//	98	Monto base faenamiento carne
			encabezado += ";";		//	99	Monto Base de MÃ¡rgenes de ComercializaciÃ³n
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Totales/TasaIVA") + ";";		//	100	Tasa IVA
			encabezado += "-"+XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Totales/IVA") + ";";		//	101	IVA
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Totales/IVAProp") + ";";		//	102	IVA propio
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Totales/IVATerc") + ";";		//	103	IVA terceros
			encabezado += ";";		//	104	IVA no retenido
			encabezado += ";";		//	105	CrÃ©dito especial 65% Empresas Constructoras
			encabezado += ";";		//	106	GarantÃ­a por depÃ³sito de envases o embalajes (no afecto)
			encabezado += "-"+XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Totales/Comisiones/ValComNeto") + ";";		//	107	Valor Neto Comisiones y Otros Cargos
			encabezado += ";";		//	108	Valor Comisiones y Otros Cargos No Afectos o Exentos
			encabezado += "-"+XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Totales/Comisiones/ValComIVA") + ";";		//	109	IVA Comisiones y Otros Cargos
			encabezado += "-"+XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Totales/MntTotal") + ";";		//	110	Monto Total
			encabezado += ";";		//	111	Monto no Facturable
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Totales/MontoPeriodo") + ";";		//	112	Monto PerÃ­odo
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Totales/SaldoAnterior") + ";";		//	113	Saldo Anterior
			encabezado += XMLdom.valueOf("//DTE/Exportaciones/Encabezado/Totales/VlrPagar") + ";";		//	114	Valor a pagar
			encabezado += ";";		//	115	CÃ³digo Otra moneda
			encabezado += ";";		//	116	Tipo de Cambio
			encabezado += ";";		//	117	Monto neto Otra Moneda
			encabezado += ";";		//	118	Monto no afecto o exento en Otra Moneda
			encabezado += ";";		//	119	Monto base faenamiento carne Otra Moneda
			encabezado += ";";		//	120	Monto Base de MÃ¡rgenes de ComercializaciÃ³n Otra Moneda
			encabezado += ";";		//	121	IVA en otra moneda
			encabezado += ";";		//	122	IVA no retenido Otra Moneda
			encabezado += ";";		//	123	Monto Total en Otra Moneda
			encabezado += "\n";

			//	TABLA de Montos de Pago [0..30] nombre lÃ­nea ENC-2	
			@SuppressWarnings("unchecked")
			List<Node> montoPagos = XMLdom.selectNodes("//DTE/Exportaciones/Encabezado/IdDoc/MntPagos");
			for (Node montoPago: montoPagos) {
				encabezado += "ENC-2;";		//		
				encabezado += montoPago.valueOf("FchPago") + ";";		//	1	Fecha de Pago
				encabezado += montoPago.valueOf("MntPago") + ";";		//	2	Monto de Pago
				encabezado += montoPago.valueOf("GlosaPagos") + ";";		//	3	Glosa descripciÃ³n Pago
				encabezado += "\n";
			}
                        
                        //	TABLA Secuencia de Tipo de Bultos [0..10] nombre línea ENC-3	
			@SuppressWarnings("unchecked")
			List<Node> bultos = XMLdom.selectNodes("//DTE/Exportaciones/Encabezado/Transporte/Aduana/TipoBultos");
			for (Node bulto: bultos) {
				encabezado += "ENC-3;";		//		
				encabezado += bulto.valueOf("CodTpoBultos") + ";";		//	1	Codigo Tipo de bulto
				encabezado += bulto.valueOf("CantBultos") + ";";		//	2	Cantidad de Bultos
				encabezado += bulto.valueOf("Marcas") + ";";	//	3	Marcas
                                encabezado += bulto.valueOf("IdContainer") + ";";		//	4	Id. Container
				encabezado += bulto.valueOf("Sello") + ";";		//	5	Sello
				encabezado += bulto.valueOf("EmisorSello") + ";";	//	6	Emisor Sello
				encabezado += "\n";
			}

			//	TABLA de Impuestos Adicionales o Retencion [0..20] nombre lÃ­nea ENC-4	
			@SuppressWarnings("unchecked")
			List<Node> imptoRetenes = XMLdom.selectNodes("//DTE/Exportaciones/Encabezado/Receptor/Totales/ImptoReten");
			for (Node imptoReten: imptoRetenes) {
				encabezado += "ENC-4";		//		
				encabezado += imptoReten.valueOf("TipoImp") + ";";		//	1	CÃ³digo de Impuesto adicional o RetenciÃ³n
				encabezado += imptoReten.valueOf("TasaImp") + ";";		//	2	Tasa de Impuesto o RetenciÃ³n
				encabezado += imptoReten.valueOf("MontoImp") + ";";		//	3	Valor del Impuesto o RetenciÃ³n.
				encabezado += "\n";
			}	

			//	TABLA de Impuestos Adicionales o Retencion en Otras Monedas [0..20] nombre lÃ­nea ENC-5	
			@SuppressWarnings("unchecked")
			List<Node> comisionesEncabezado = XMLdom.selectNodes("//DTE/Exportaciones/Encabezado/Receptor/Totales/Comisiones");
			for (Node comisione: comisionesEncabezado) {
				encabezado += "ENC-5;";		//		
				encabezado += comisione.valueOf("ValComNeto") + ";";		//	1	CÃ³digo de Impuesto adicional o RetenciÃ³n
				encabezado += comisione.valueOf("ValComExe") + ";";		//	2	Tasa de Impuesto o RetenciÃ³n
				encabezado += comisione.valueOf("ValComIVA") + ";";		//	3	Valor del Impuesto o RetenciÃ³n.
				encabezado += "\n";
			}

			String detalles = "";

			@SuppressWarnings("unchecked")
			List<Node> detalleList = XMLdom.selectNodes("//DTE/Exportaciones/Detalle");
			for (Node detalle : detalleList) {
				//	DETALLE [1..60] nombre lÃ­nea DET	
				detalles += "DET;";		//
				detalles += detalle.valueOf("NroLinDet") + ";";		//	1	NÂ° de LÃ­nea
				detalles += detalle.valueOf("TpoDocLiq") + ";";		//	2	Tipo Documento que se Liquida
				detalles += detalle.valueOf("IndExe") + ";";		//	3	Indicador de facturaciÃ³n/exenciÃ³n
				detalles += ";";		//	4	Indicador Agente Retenedor
				detalles += ";";		//	5	Monto Base Faenamiento
				detalles += ";";		//	6	Monto Base MÃ¡rgenes de ComercializaciÃ³n
				detalles += ";";		//	7	Precio Unitario Neto Consumidor Final
				detalles += detalle.valueOf("NmbItem") + ";";		//	8	Nombre del Ã�tem
				detalles += detalle.valueOf("DscItem") + ";";		//	9	DescripciÃ³n Adicional
				detalles += detalle.valueOf("QtyRef") + ";";		//	10	Cantidad de referencia
				detalles += detalle.valueOf("UnmdRef") + ";";		//	11	Unidad de referencia
				detalles += detalle.valueOf("PrcRef") + ";";		//	12	Precio de referencia
				detalles += detalle.valueOf("QtyItem") + ";";		//	13	Cantidad
				detalles += detalle.valueOf("FchElabor") + ";";		//	14	Fecha elaboraciÃ³n
				detalles += detalle.valueOf("FchVencim") + ";";		//	15	Fecha vencimiento
				detalles += detalle.valueOf("UnmdItem") + ";";		//	16	Unidad de Medida
				detalles += detalle.valueOf("PrcItem") + ";";		//	17	Precio Unitario del Ã�tem
				detalles += ";";		//	18	Descuento en %
				detalles += ";";		//	19	Monto Descuento
				detalles += ";";		//	20	Recargo en %
				detalles += ";";		//	21	Monto Recargo
				detalles += "-"+detalle.valueOf("MontoItem") + ";";		//	22	Monto Item
				detalles += "\n";
				
				
				//	TABLA CÃ³digo Ã�tem [0..5] nombre lÃ­nea DET-2	
				@SuppressWarnings("unchecked")
				List<Node> codigos = detalle.selectNodes("CdgItem");
				for (Node codigo: codigos) {
					detalles += "DET-2;";		//		
					detalles += codigo.valueOf("TpoCodigo") + ";";		//	1	Tipo cÃ³digo
					detalles += codigo.valueOf("VlrCodigo") + ";";		//	2	CÃ³digo del Ã�tem
					detalles += "\n";
				}

				//	TABLA DistribuciÃ³n de Cantidad [0..5] nombre lÃ­nea DET-3
				@SuppressWarnings("unchecked")
				List<Node> subcantidades = detalle.selectNodes("Subcantidad");
				for (Node subcantidad: subcantidades) {
					detalles += "DET-3;";		//		
					detalles += subcantidad.valueOf("SubQty") + ";";		//	1	Subcantidad Distribuida
					detalles += subcantidad.valueOf("SubCod") + ";";		//	2	CÃ³digo subcantidad
					detalles += subcantidad.valueOf("TipCodSubQty")+";";		//	3	Tipo CÃ³digo Subcantidad
					detalles += "\n";
				}
			}

			String subTotales = "";
			//	Subtotales Informativos [0..20] nombre lÃ­nea SUBT
			@SuppressWarnings("unchecked")
			List<Node> sutotalList = XMLdom.selectNodes("//DTE/Exportaciones    /SubTotInfo");
			for (Node subTotInfo: sutotalList) {		
				subTotales += subTotInfo.valueOf("NroSTI") + ";";		//	1	NÃºmero Subtotal
				subTotales += subTotInfo.valueOf("GlosaSTI") + ";";		//	2	Glosa
				subTotales += subTotInfo.valueOf("OrdenSTI") + ";";		//	3	Orden
				subTotales += subTotInfo.valueOf("SubTotNetoSTI") + ";";		//	4	Subtotal Neto
				subTotales += subTotInfo.valueOf("SubTotIVASTI") + ";";		//	5	Subtotal IVA
				subTotales += subTotInfo.valueOf("SubTotAdicSTI") + ";";		//	6	Subtotal Impuestos adicionales o especÃ­ficos
				subTotales += subTotInfo.valueOf("SubTotExeSTI") + ";";		//	7	Subtotal no Afecto o Exento
				subTotales += subTotInfo.valueOf("ValSubtotSTI") + ";";		//	8	Valor del Subtotal
				subTotales += "\n";
				
				//TODO termina
//				//	Subtotales Informativos [0..20] nombre lÃ­nea SUB-2	
//				List<Node> sutotalList = subTotInfo.selectNodes("LineasDeta");		
//				subTotales += subTotInfo.valueOf("-") + ";";		//	1	LINEAS
			}

			//	Informacion de Referencia [0..40] nombre lÃ­nea REF	
			String referencias = "";
			@SuppressWarnings("unchecked")
			List<Node> referenciasList = XMLdom.selectNodes("//Referencia");
			for (Node refe : referenciasList) {
				referencias += "REF;";				
				referencias += refe.valueOf("NroLinRef") + ";";		//	1	NÂ° LÃ­nea
				referencias += refe.valueOf("TpoDocRef") + ";";		//	2	Tipo Documento de referencia
				referencias += refe.valueOf("IndGlobal") + ";";		//	3	Indicador de Referencia Global
				referencias += refe.valueOf("FolioRef") + ";";		//	4	FOLIO- de referencia
				referencias += ";";		//	5	RUT Otro contribuyente
				referencias += ";";		//	6	Identificador Adicional de otro contribuyente
				referencias += refe.valueOf("FchRef") + ";";		//	7	FECHA de la Referencia
				referencias += refe.valueOf("CodRef") + ";";		//	8	CÃ³digo de referencia
				referencias += refe.valueOf("RazonRef") + ";";		//	9	RazÃ³n referencia
				referencias += "\n";
			}
			
			//	Comisiones y Otros Cargos [0..20] nombre lÃ­nea CMSNYO
			
			
			
			txt = varLibre + encabezado + detalles + subTotales + referencias;
			txt = txt.replace("null", "");

		} catch (Exception e) {
			throw new Exception("ERROR al parserar XML: " + e.getMessage(), e);
		}

//		logger.debug("TXT: " + txt);
		bean.setTXT(txt);
		
	}

	public static void toTXTtextual(DTEBean bean) throws Exception {
		String txt = "";

		Document XMLdom = null;
		try {
			SAXReader saxReader = new SAXReader();
			XMLdom = saxReader.read(new StringReader(bean.getContenido()));

			// Variables Libres
			String varLibre = "";
			varLibre += "A0;";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += "\n";

			// Se asigna a folio
			bean.setRutEmisor(XMLdom.valueOf("//Encabezado/Emisor/RUTEmisor"));
			bean.setTipoDTE(XMLdom.valueOf("//Encabezado/IdDoc/TipoDTE"));
			bean.setFolioDTE(XMLdom.valueOf("//Encabezado/IdDoc/Folio"));
			bean.setSucursalEmisorDTE(XMLdom
					.valueOf("//Encabezado/Emisor/Sucursal"));

			String encabezado = "";
			encabezado += "A;";
			
			//TODO 
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TipoDTE") + ";"; // pos_1_Tipo
																				// de
																				// Documento
																				// Tributario
																				// Electrï¿½nico
			encabezado += ";"; // pos_2_Tipo Impresiï¿½n
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/Folio") + ";"; // pos_3_FOLIO-Documento
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = formatter.format(new Date());
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/FchEmis") + ";"; // pos_4_Fecha
																				// de
																				// Emisiï¿½n
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndNoRebaja")
					+ ";"; // pos_5_Indicador de No Rebaja
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TipoDespacho")
					+ ";"; // pos_6_Tipo Despacho
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndTraslado")
					+ ";"; // pos_7_Indicador Tipo de Translado de bienes
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndServicio")
					+ ";"; // pos_8_Indicador Servicio
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/MntBruto") + ";"; // pos_9_Indicador
																				// Montos
																				// Brutos
			encabezado += ";"; // pos_10_Forma
																				// de
																				// Pago
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/FchCancel") + ";"; // pos_11_Fecha
																				// de
																				// Cancelaciï¿½n
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/PeriodoDesde")
					+ ";"; // pos_12_Periodo desde
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/PeriodoHasta")
					+ ";"; // pos_13_Periodo hasta
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/MedioPago") + ";"; // pos_14_Medio
																				// de
																				// Pago
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TermPagoCdg")
					+ ";"; // pos_15_Tï¿½rmino de Pago, cï¿½digo
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TermPagoDias")
					+ ";"; // pos_16_Tï¿½rmino de Pago, dï¿½as
			encabezado += ";"; // pos_17_Fecha
																				// de
																				// Vencimiento

			encabezado += XMLdom.valueOf("//Encabezado/Emisor/RUTEmisor") + ";"; // pos_18_RUT
																					// Emisor
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/RznSoc") + ";"; // pos_19_Nombre
																				// o
																				// Razï¿½n
																				// Social
																				// Emisor
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/GiroEmis") + ";"; // pos_20_Giro
																				// del
																				// Negocio
																				// del
																				// Emisor
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/Sucursal") + ";"; // pos_21_Sucursal
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CdgSIISucur")
					+ ";"; // pos_22_Cï¿½digo Sucursal
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/DirOrigen") + ";"; // pos_23_Direcciï¿½n
																					// Origen
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CmnaOrigen")
					+ ";"; // pos_24_Comuna Origen
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CiudadOrigen")
					+ ";"; // pos_25_Ciuidad Origen
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/CdgVendedor")
					+ ";"; // pos_26_Cï¿½digo del Vendedor

			encabezado += XMLdom.valueOf("//Encabezado/RUTMandante") + ";"; // pos_27_RUT
																			// Mandante

			encabezado += XMLdom.valueOf("//Encabezado/Receptor/RUTRecep")
					+ ";"; // pos_28_RUT Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CdgIntRecep")
					+ ";"; // pos_29_Cï¿½digo Interno del Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/RznSocRecep")
					+ ";"; // pos_30_Nombre o Razï¿½n Social Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/GiroRecep")
					+ ";"; // pos_31_Giro del Negocio del Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/Contacto")
					+ ";"; // pos_32_Contacto receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/DirRecep")
					+ ";"; // pos_33_Direcciï¿½n Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CmnaRecep")
					+ ";"; // pos_34_Comuna Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CiudadRecep")
					+ ";"; // pos_35_Ciudad Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/DirPostal")
					+ ";"; // pos_36_Direcciï¿½n Postal
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CmnaPostal")
					+ ";"; // pos_37_Comuna Postal
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CiudadPostal")
					+ ";"; // pos_38_Ciudad Postal

			encabezado += XMLdom.valueOf("//Encabezado/RUTSolicita") + ";"; // pos_39_RUT
																			// de
																			// Solicitante
																			// de
																			// Factura

			encabezado += XMLdom.valueOf("//Encabezado/Transporte/Patente")
					+ ";"; // pos_40_Informaciï¿½n Transporte (Patente)
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/RUTTrans")
					+ ";"; // pos_41_RUT Transportista
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/DirDest")
					+ ";"; // pos_42_Direcciï¿½n Destino
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/CmnaDest")
					+ ";"; // pos_43_Comuna Destino
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/CiudadDest")
					+ ";"; // pos_44_Ciudad Destino

			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntNeto") + ";"; // pos_45_Monto
																				// Neto
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntExe") + ";"; // pos_46_Monto
																				// No
																				// Afecto
																				// o
																				// Exento
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntBase") + ";"; // pos_47_Monto
																				// base
																				// faenamiento
																				// carne
			encabezado += XMLdom.valueOf("//Encabezado/Totales/TasaIVA") + ";"; // pos_48_Tasa
																				// IVA
			encabezado += XMLdom.valueOf("//Encabezado/Totales/IVA") + ";"; // pos_49_IVA
			encabezado += XMLdom.valueOf("//Encabezado/Totales/IVANoRet") + ";"; // pos_50_IVA
																					// no
																					// Retenido
			encabezado += XMLdom.valueOf("//Encabezado/Totales/CredEC") + ";"; // pos_51_Crï¿½dito
																				// especial
																				// 65%
																				// Empresas
																				// Contructoras
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MontoPeriodo")
					+ ";"; // pos_52_Monto Perï¿½odo
			encabezado += XMLdom.valueOf("//Encabezado/Totales/GrntDep") + ";"; // pos_53_Garantia
																				// por
																				// deposito
																				// o
																				// envases
																				// o
																				// embalajes
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MontoNF") + ";"; // pos_54_Monto
																				// No
																				// Facturable
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntTotal") + ";"; // pos_55_Monto
																					// Total
			encabezado += XMLdom.valueOf("//Encabezado/Totales/SaldoAnterior")
					+ ";"; // pos_56_Saldo Anterior
			encabezado += XMLdom.valueOf("//Encabezado/Totales/VlrPagar") + ";"; // pos_57_Valor
																					// a
																					// pagar
			encabezado += "\n";

			// ACTECO
			encabezado += "A1;";
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/Acteco") + ";";
			encabezado += "\n";
			
			List<Node> a2List = XMLdom.selectNodes("//Encabezado/Totales/ImptoReten");
			for (Node detalle : a2List) {
			encabezado += "A2;";
			encabezado += detalle.valueOf("TipoImp") + ";";
            encabezado += detalle.valueOf("TasaImp") + ";";
            encabezado += detalle.valueOf("MontoImp") + ";";
			encabezado += "\n";
			}

			String detalles = "";

			int nroLinDet = 0;
			@SuppressWarnings("unchecked")
			List<Node> detalleList = XMLdom.selectNodes("//Detalle");
			for (Node detalle : detalleList) {
//				if (detalle.valueOf("IndExe").contains("2"))
//					continue;
				
				nroLinDet++;
				detalles += "B;";
				detalles += nroLinDet + ";"; // pos_1_Nï¿½ de
																// Lï¿½nea o Nï¿½
																// Secuencial
				detalles += detalle.valueOf("IndExe") + ";"; // pos_2_Indicador
																// de
																// facturaciï¿½n/
																// exenciï¿½n
				detalles += detalle.valueOf("NmbItem") + ";"; // pos_3_Nombre
																// del ï¿½tem
				detalles += detalle.valueOf("DscItem") + ";"; // pos_4_Descripciï¿½n
																// Adicional
				detalles += detalle.valueOf("QtyRef") + ";"; // pos_5_Cantidad
																// de Referencia
				detalles += detalle.valueOf("UnmdRef") + ";"; // pos_6_Unidad de
																// Medida de
																// Referencia
				detalles += detalle.valueOf("PrcRef") + ";"; // pos_7_Precio de
																// Referencia
				detalles += detalle.valueOf("QtyItem") + ";"; // pos_8_Cantidad
																// del ï¿½tem
				detalles += detalle.valueOf("FchElabor") + ";"; // pos_9_Fecha
																// Eleboraciï¿½n
				detalles += detalle.valueOf("FchVencim") + ";"; // pos_10_Fecha
																// Vencimiento
				detalles += detalle.valueOf("UnmdItem") + ";"; // pos_11_Unidad
																// de Medida
				detalles += detalle.valueOf("PrcItem") + ";"; // pos_12_Precio
																// Unitario del
																// ï¿½tem
				detalles += ";"; // pos_13_Precio Unitario en Otra Moneda
				detalles += ";"; // pos_14_Cï¿½digo de Otra Moneda
				detalles += ";"; // pos_15_Factor de Conversiï¿½n
				detalles += detalle.valueOf("DescuentoPct") + ";"; // pos_16_Descuento
																	// en %
				detalles += detalle.valueOf("DescuentoMonto") + ";"; // pos_17_Monto
																		// Descuento
				detalles += detalle.valueOf("RecargoPct") + ";"; // pos_18_Recargo
																	// en %
				detalles += detalle.valueOf("RecargoMonto") + ";"; // pos_19_Monto
																	// de
																	// Recargo
				detalles += detalle.valueOf("CodImpAdic") + ";"; // pos_20_Cï¿½digo
																	// Impuesto
																	// o
																	// Retenciones
				detalles += detalle.valueOf("MontoItem") + ";"; // pos_21_Monto
																// de ï¿½tem
				detalles += "\n";

				if (detalle.valueOf("CdgItem/VlrCodigo") != null
						&& !detalle.valueOf("CdgItem/TpoCodigo").trim()
								.isEmpty()) {
					detalles += "B2" + ";";
					detalles += detalle.valueOf("CdgItem/TpoCodigo") + ";";
					detalles += detalle.valueOf("CdgItem/VlrCodigo") + ";";
					detalles += "\n";
				}
			}

			String recargosDescuentos = "";
			@SuppressWarnings("unchecked")
			List<Node> descRecaList = XMLdom.selectNodes("//DscRcgGlobal");
			for (Node descReca : descRecaList) {
				recargosDescuentos += "C;";
				recargosDescuentos += descReca.valueOf("NroLinDR") + ";"; // pos_1_Nï¿½
																			// de
																			// Lï¿½nea
																			// o
																			// Nï¿½
																			// Secuencial
				recargosDescuentos += descReca.valueOf("TpoMov") + ";"; // pos_2_Tipo
																		// de
																		// Movimiento
				recargosDescuentos += descReca.valueOf("GlosaDR") + ";"; // pos_3_Glosa
				recargosDescuentos += descReca.valueOf("TpoValor") + ";"; // pos_4_Tipo
																			// de
																			// Valor
				recargosDescuentos += descReca.valueOf("ValorDR") + ";"; // pos_5_Valor
				recargosDescuentos += descReca.valueOf("IndExeDR") + ";"; // pos_6_Indicador
																			// de
																			// facturaciï¿½n/
																			// exenciï¿½n
				recargosDescuentos += "\n";
			}

			String referencias = "";
                        @SuppressWarnings("unchecked")
			List<Node> refe = XMLdom.selectNodes("//Referencia");
                        for (Node descReca : refe) {
			referencias += "D;";
			referencias += descReca.valueOf("NroLinRef")+";"; // pos_1_Nï¿½ de Lï¿½nea 
			referencias += descReca.valueOf("TpoDocRef") + ";"; // pos_2_Tipo
															// Documento de
															// referencia
			referencias += ";"; // pos_3_Indicador
															// de Referencia
															// Global
                        
                        if (descReca.valueOf("FolioRef").contains("NV/")){
                            referencias += descReca.valueOf("FolioRef").replace("NV/", "") + ";";
                        } else if (descReca.valueOf("FolioRef").contains("SRV-PDL-")){
                            referencias += descReca.valueOf("FolioRef").replace("SRV-PDL-", "") + ";";
                        }else if (descReca.valueOf("FolioRef").contains("NV-")){
                            referencias += descReca.valueOf("FolioRef").replace("NV-", "") + ";";
                        }else
			referencias += descReca.valueOf("FolioRef") + ";"; // pos_4_FOLIO-
															// de referencia
			referencias += ";"; // pos_5_RUT Otro
															// contribuyente
			referencias += descReca.valueOf("FchRef") + ";"; // pos_6_FECHA de
															// la Referencia                                             
			referencias += descReca.valueOf("CodRef") + ";";// pos_7_Cï¿½digo de
															// referencia
			referencias += descReca.valueOf("RazonRef") + ";"; // pos_8_Razï¿½n
															// referencia
			referencias += "\n";
                        }

			txt = varLibre + encabezado + detalles + recargosDescuentos
					+ referencias;

		} catch (Exception e) {
			throw new Exception("ERROR al parserar XML: " + e.getMessage(), e);
		}

		bean.setTXT(txt);
	}

	
	public static void toBOLETA(DTEBean bean) throws Exception {
		String txt = "";

		Document XMLdom = null;
		try {
			SAXReader saxReader = new SAXReader();
			XMLdom = saxReader.read(new StringReader(bean.getContenido()));

			// Variables Libres
			String varLibre = "";
			varLibre += "A0;";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += "\n";

			// Se asigna a folio
			bean.setRutEmisor(XMLdom.valueOf("//Encabezado/Emisor/RUTEmisor"));
			System.out.println("chupala con: "+XMLdom.valueOf("//Encabezado/Emisor/RUTEmisor"));
			bean.setTipoDTE(XMLdom.valueOf("//Encabezado/IdDoc/TipoDTE"));
			

			String encabezado = "";
			encabezado += "ENC;";
			
			//TODO 
			encabezado += "39;"; // pos_1_Tipo de Documento
			encabezado += ";"; // pos_2_VERSION (1.0)
			encabezado += bean.getFolioDTE()+ ";"; // pos_3_FOLIO-Documento
			bean.setFolioDTE(XMLdom.valueOf("//Encabezado/IdDoc/Folio"));
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = formatter.format(new Date());
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/FchEmis") + ";"; // pos_4_Fecha
																				// de
																				// Emisiï¿½n
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndServicio")
					+ ";"; // pos_5_Indicador Servicio
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TipoDespacho")
					+ ";"; // pos_6_Indicador Montos Netos
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndTraslado")
					+ ";"; // pos_7_Periodo Desde
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndServsicio")
					+ ";"; // pos_8_Periodo Hasta

			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/MntBruto") + ";"; // pos_9_Fecha de vencimiento
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/RUTEmisor")+";"; // pos_10_Rut Emisor

			encabezado += XMLdom.valueOf("//Encabezado/Emisor/RznSocEmisor") + ";"; // pos_11_Nombre o Razón Social
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/GiroEmisor")
					+ ";"; // pos_12_Giro del negocio del Emisor
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CdgSIISucur")
					+ ";"; // pos_13_Código sucursal

			encabezado += XMLdom.valueOf("//Encabezado/Emisor/DirOrigen") + ";"; // pos_14_Dirección Origen

			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CmnaOrigen")
					+ ";"; // pos_15_Comuna Origen

			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CmnaOrigen")
					+ ";"; // pos_16_Ciudad Origen

			encabezado += XMLdom.valueOf("//Encabezado/Receptor/RUTRecep") +";"; // pos_17_Rut Receptor


			encabezado += XMLdom.valueOf("//Encabezado/Emisor/RUTEmisor") + ";"; // pos_18_Código Interno del Cliente

			encabezado += XMLdom.valueOf("//Encabezado/Emisor/RznSoc") + ";"; // pos_19_Nombre Receptor

			encabezado += XMLdom.valueOf("//Encabezado/Emisor/GiroEmis") + ";"; // pos_20_Contacto Receptor

			encabezado += XMLdom.valueOf("//Encabezado/Emisor/Sucursal") + ";"; // pos_21_Dirección Receptor

			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CdgSIISucur")
					+ ";"; // pos_22_Comuna Receptor

			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CmnaOrigen") + ";"; // pos_23_Ciudad Receptor

			encabezado += XMLdom.valueOf("//Encabezado/Emisor/DirOrigen")
					+ ";"; // pos_24_Dirección postal

			encabezado += ""
					+ ";"; // pos_25_Comuna Postal

			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/CdgVendedor")
					+ ";"; // pos_26_Ciudad Postal


			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntNeto") + ";"; // pos_27_Monto neto


			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntExe")
					+ ";"; // pos_28_Monto exento

			encabezado += XMLdom.valueOf("//Encabezado/Totales/CdgIntRecep")
					+ ";"; // pos_29_Monto IVA

			if(XMLdom.valueOf("//Encabezado/Totales/MntTotal").equals("1")){
                            encabezado += 0 + ";"; // pos_55_Monto
                        }else
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntTotal") + ";"; // pos_55_Monto
				

			encabezado += XMLdom.valueOf("//Encabezado/Totales/GiroRecep")
					+ ";"; // pos_31_Monto no Facturable

			encabezado += XMLdom.valueOf("//Encabezado/Totales/Contacto")
					+ ";"; // pos_32_Total período

			encabezado += XMLdom.valueOf("//Encabezado/Totales/DirRecep")
					+ ";"; // pos_33_Saldo anterior

			encabezado += XMLdom.valueOf("//Encabezado/Totales/CmnaRecep")
					+ ";"; // pos_34_Valor a pagar

	
			encabezado += "\n";

			String detalles = "";

			int nroLinDet = 0;
			@SuppressWarnings("unchecked")
			List<Node> detalleList = XMLdom.selectNodes("//Detalle");
			for (Node detalle : detalleList) {
//				if (detalle.valueOf("IndExe").contains("2"))
//					continue;
				
				nroLinDet++;
				detalles += "DET;";
				detalles += nroLinDet + ";"; // pos_1_N° de Línea

				detalles += detalle.valueOf("IndExe") + ";"; // pos_2_Indicador exención

				detalles += detalle.valueOf("NmbItem") + ";"; // pos_3_Nombre del ítem

				detalles += detalle.valueOf("DscItem") + ";"; // pos_4_Descripción Adicional

				detalles += detalle.valueOf("QtyItem") + ";"; // pos_5_Cantidad

				detalles += detalle.valueOf("UnmdRef") + ";"; // pos_6_Unidad de Medida

				detalles += detalle.valueOf("PrcItem") + ";"; // pos_7_Precio Unitario

				detalles += detalle.valueOf("MontoItem") + ";"; // pos_8_Valor por línea de detalle

				detalles += "\n";

				if (detalle.valueOf("CdgItem/VlrCodigo") != null
						&& !detalle.valueOf("CdgItem/TpoCodigo").trim()
								.isEmpty()) {
					detalles += "ITCOD" + ";";
					detalles += detalle.valueOf("CdgItem/TpoCodigo") + ";";
					detalles += detalle.valueOf("CdgItem/VlrCodigo") + ";";
					detalles += "\n";
				}
			}

			String recargosDescuentos = "";
			@SuppressWarnings("unchecked")
			List<Node> descRecaList = XMLdom.selectNodes("//DscRcgGlobal");
			for (Node descReca : descRecaList) {
				recargosDescuentos += "DESCREC;";
				recargosDescuentos += descReca.valueOf("NroLinDR") + ";"; // pos_1_Nï¿½
																			// de
																			// Lï¿½nea
																			// o
																			// Nï¿½
																			// Secuencial
				recargosDescuentos += descReca.valueOf("TpoMov") + ";"; // pos_2_Tipo
																		// de
																		// Movimiento
				recargosDescuentos += descReca.valueOf("GlosaDR") + ";"; // pos_3_Glosa
				recargosDescuentos += descReca.valueOf("TpoValor") + ";"; // pos_4_Tipo
																			// de
																			// Valor
				recargosDescuentos += descReca.valueOf("ValorDR") + ";"; // pos_5_Valor
				recargosDescuentos += descReca.valueOf("IndExeDR") + ";"; // pos_6_Indicador
																			// de
																			// facturaciï¿½n/
																			// exenciï¿½n
				recargosDescuentos += "\n";
                                bean.setDescuento("si");
			}

			
		

			txt = varLibre + encabezado + detalles + recargosDescuentos;

		} catch (Exception e) {
			throw new Exception("ERROR al parserar XML: " + e.getMessage(), e);
		}

		bean.setTXT(txt);
	}

	public static void toEmotions(DTEBean bean) throws Exception {
		String txt = "";

		Document XMLdom = null;
		try {
			SAXReader saxReader = new SAXReader();
			XMLdom = saxReader.read(new StringReader(bean.getContenido()));

			// Variables Libres
			String varLibre = "";
			varLibre += "A0;";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += ";";
			varLibre += "\n";

			// Se asigna a folio
			bean.setRutEmisor(XMLdom.valueOf("//Encabezado/Emisor/RUTEmisor"));
			bean.setTipoDTE(XMLdom.valueOf("//Encabezado/IdDoc/TipoDTE"));
			bean.setFolioDTE(XMLdom.valueOf("//Encabezado/IdDoc/Folio"));
			bean.setSucursalEmisorDTE(XMLdom
					.valueOf("//Encabezado/Emisor/Sucursal"));

			String encabezado = "";
			encabezado += "A;";
			
			//TODO 
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TipoDTE") + ";"; // pos_1_Tipo
																				// de
																				// Documento
																				// Tributario
																				// Electrï¿½nico
			encabezado += ";"; // pos_2_Tipo Impresiï¿½n
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/Folio") + ";"; // pos_3_FOLIO-Documento
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = formatter.format(new Date());
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/FchEmis") + ";"; // pos_4_Fecha
																				// de
																				// Emisiï¿½n
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndNoRebaja")
					+ ";"; // pos_5_Indicador de No Rebaja
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TipoDespacho")
					+ ";"; // pos_6_Tipo Despacho
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndTraslado")
					+ ";"; // pos_7_Indicador Tipo de Translado de bienes
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/IndServicio")
					+ ";"; // pos_8_Indicador Servicio
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/MntBruto") + ";"; // pos_9_Indicador
																				// Montos
																				// Brutos
			encabezado += ";"; // pos_10_Forma
																				// de
																				// Pago
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/FchCancel") + ";"; // pos_11_Fecha
																				// de
																				// Cancelaciï¿½n
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/PeriodoDesde")
					+ ";"; // pos_12_Periodo desde
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/PeriodoHasta")
					+ ";"; // pos_13_Periodo hasta
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/MedioPago") + ";"; // pos_14_Medio
																				// de
																				// Pago
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TermPagoCdg")
					+ ";"; // pos_15_Tï¿½rmino de Pago, cï¿½digo
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/TermPagoDias")
					+ ";"; // pos_16_Tï¿½rmino de Pago, dï¿½as
			encabezado += ";"; // pos_17_Fecha
																				// de
																				// Vencimiento

			encabezado += XMLdom.valueOf("//Encabezado/Emisor/RUTEmisor") + ";"; // pos_18_RUT
																					// Emisor
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/RznSoc") + ";"; // pos_19_Nombre
																				// o
																				// Razï¿½n
																				// Social
																				// Emisor
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/GiroEmis") + ";"; // pos_20_Giro
																				// del
																				// Negocio
																				// del
																				// Emisor
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/Sucursal") + ";"; // pos_21_Sucursal
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CdgSIISucur")
					+ ";"; // pos_22_Cï¿½digo Sucursal
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/DirOrigen") + ";"; // pos_23_Direcciï¿½n
																					// Origen
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CmnaOrigen")
					+ ";"; // pos_24_Comuna Origen
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/CiudadOrigen")
					+ ";"; // pos_25_Ciuidad Origen
			encabezado += XMLdom.valueOf("//Encabezado/IdDoc/CdgVendedor")
					+ ";"; // pos_26_Cï¿½digo del Vendedor

			encabezado += XMLdom.valueOf("//Encabezado/RUTMandante") + ";"; // pos_27_RUT
																			// Mandante

			encabezado += XMLdom.valueOf("//Encabezado/Receptor/RUTRecep")
					+ ";"; // pos_28_RUT Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CdgIntRecep")
					+ ";"; // pos_29_Cï¿½digo Interno del Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/RznSocRecep")
					+ ";"; // pos_30_Nombre o Razï¿½n Social Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/GiroRecep")
					+ ";"; // pos_31_Giro del Negocio del Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/Contacto")
					+ ";"; // pos_32_Contacto receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/DirRecep")
					+ ";"; // pos_33_Direcciï¿½n Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CmnaRecep")
					+ ";"; // pos_34_Comuna Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CiudadRecep")
					+ ";"; // pos_35_Ciudad Receptor
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/DirPostal")
					+ ";"; // pos_36_Direcciï¿½n Postal
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CmnaPostal")
					+ ";"; // pos_37_Comuna Postal
			encabezado += XMLdom.valueOf("//Encabezado/Receptor/CiudadPostal")
					+ ";"; // pos_38_Ciudad Postal

			encabezado += XMLdom.valueOf("//Encabezado/RUTSolicita") + ";"; // pos_39_RUT
																			// de
																			// Solicitante
																			// de
																			// Factura

			encabezado += XMLdom.valueOf("//Encabezado/Transporte/Patente")
					+ ";"; // pos_40_Informaciï¿½n Transporte (Patente)
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/RUTTrans")
					+ ";"; // pos_41_RUT Transportista
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/DirDest")
					+ ";"; // pos_42_Direcciï¿½n Destino
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/CmnaDest")
					+ ";"; // pos_43_Comuna Destino
			encabezado += XMLdom.valueOf("//Encabezado/Transporte/CiudadDest")
					+ ";"; // pos_44_Ciudad Destino

			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntNeto") + ";"; // pos_45_Monto
																				// Neto
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntExe") + ";"; // pos_46_Monto
																				// No
																				// Afecto
																				// o
																				// Exento
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntBase") + ";"; // pos_47_Monto
																				// base
																				// faenamiento
																				// carne
			encabezado += XMLdom.valueOf("//Encabezado/Totales/TasaIVA") + ";"; // pos_48_Tasa
																				// IVA
			encabezado += XMLdom.valueOf("//Encabezado/Totales/IVA") + ";"; // pos_49_IVA
			encabezado += XMLdom.valueOf("//Encabezado/Totales/IVANoRet") + ";"; // pos_50_IVA
																					// no
																					// Retenido
			encabezado += XMLdom.valueOf("//Encabezado/Totales/CredEC") + ";"; // pos_51_Crï¿½dito
																				// especial
																				// 65%
																				// Empresas
																				// Contructoras
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MontoPeriodo")
					+ ";"; // pos_52_Monto Perï¿½odo
			encabezado += XMLdom.valueOf("//Encabezado/Totales/GrntDep") + ";"; // pos_53_Garantia
																				// por
																				// deposito
																				// o
																				// envases
																				// o
																				// embalajes
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MontoNF") + ";"; // pos_54_Monto
																				// No
																				// Facturable
			encabezado += XMLdom.valueOf("//Encabezado/Totales/MntTotal") + ";"; // pos_55_Monto
																					// Total
			encabezado += XMLdom.valueOf("//Encabezado/Totales/SaldoAnterior")
					+ ";"; // pos_56_Saldo Anterior
			encabezado += XMLdom.valueOf("//Encabezado/Totales/VlrPagar") + ";"; // pos_57_Valor
																					// a
																					// pagar
			encabezado += "\n";

			// ACTECO
			encabezado += "A1;";
			encabezado += XMLdom.valueOf("//Encabezado/Emisor/Acteco") + ";";
			encabezado += "\n";
			
			List<Node> a2List = XMLdom.selectNodes("//Encabezado/Totales/ImptoReten");
			for (Node detalle : a2List) {
			encabezado += "A2;";
			encabezado += detalle.valueOf("TipoImp") + ";";
            encabezado += detalle.valueOf("TasaImp") + ";";
            encabezado += detalle.valueOf("MontoImp") + ";";
			encabezado += "\n";
			}

			String detalles = "";

			int nroLinDet = 0;
			@SuppressWarnings("unchecked")
			List<Node> detalleList = XMLdom.selectNodes("//Detalle");
			for (Node detalle : detalleList) {
//				if (detalle.valueOf("IndExe").contains("2"))
//					continue;
				
				nroLinDet++;
				detalles += "B;";
				detalles += nroLinDet + ";"; // pos_1_Nï¿½ de
																// Lï¿½nea o Nï¿½
																// Secuencial
				detalles += detalle.valueOf("IndExe") + ";"; // pos_2_Indicador
																// de
																// facturaciï¿½n/
																// exenciï¿½n
				detalles += detalle.valueOf("NmbItem") + ";"; // pos_3_Nombre
																// del ï¿½tem
				detalles += detalle.valueOf("DscItem") + ";"; // pos_4_Descripciï¿½n
																// Adicional
				detalles += detalle.valueOf("QtyRef") + ";"; // pos_5_Cantidad
																// de Referencia
				detalles += detalle.valueOf("UnmdRef") + ";"; // pos_6_Unidad de
																// Medida de
																// Referencia
				detalles += detalle.valueOf("PrcRef") + ";"; // pos_7_Precio de
																// Referencia
				detalles += detalle.valueOf("QtyItem") + ";"; // pos_8_Cantidad
																// del ï¿½tem
				detalles += detalle.valueOf("FchElabor") + ";"; // pos_9_Fecha
																// Eleboraciï¿½n
				detalles += detalle.valueOf("FchVencim") + ";"; // pos_10_Fecha
																// Vencimiento
				detalles += detalle.valueOf("UnmdItem") + ";"; // pos_11_Unidad
																// de Medida
				detalles += detalle.valueOf("PrcItem") + ";"; // pos_12_Precio
																// Unitario del
																// ï¿½tem
				detalles += ";"; // pos_13_Precio Unitario en Otra Moneda
				detalles += ";"; // pos_14_Cï¿½digo de Otra Moneda
				detalles += ";"; // pos_15_Factor de Conversiï¿½n
				detalles += detalle.valueOf("DescuentoPct") + ";"; // pos_16_Descuento
																	// en %
				detalles += detalle.valueOf("DescuentoMonto") + ";"; // pos_17_Monto
																		// Descuento
				detalles += detalle.valueOf("RecargoPct") + ";"; // pos_18_Recargo
																	// en %
				detalles += detalle.valueOf("RecargoMonto") + ";"; // pos_19_Monto
																	// de
																	// Recargo
				detalles += detalle.valueOf("CodImpAdic") + ";"; // pos_20_Cï¿½digo
																	// Impuesto
																	// o
																	// Retenciones
				detalles += detalle.valueOf("MontoItem") + ";"; // pos_21_Monto
																// de ï¿½tem
				detalles += "\n";

				if (detalle.valueOf("CdgItem/VlrCodigo") != null
						&& !detalle.valueOf("CdgItem/TpoCodigo").trim()
								.isEmpty()) {
					detalles += "B2" + ";";
					detalles += detalle.valueOf("CdgItem/TpoCodigo") + ";";
					detalles += detalle.valueOf("CdgItem/VlrCodigo") + ";";
					detalles += "\n";
				}
			}

			String recargosDescuentos = "";
			@SuppressWarnings("unchecked")
			List<Node> descRecaList = XMLdom.selectNodes("//DscRcgGlobal");
			for (Node descReca : descRecaList) {
				recargosDescuentos += "C;";
				recargosDescuentos += descReca.valueOf("NroLinDR") + ";"; // pos_1_Nï¿½
																			// de
																			// Lï¿½nea
																			// o
																			// Nï¿½
																			// Secuencial
				recargosDescuentos += descReca.valueOf("TpoMov") + ";"; // pos_2_Tipo
																		// de
																		// Movimiento
				recargosDescuentos += descReca.valueOf("GlosaDR") + ";"; // pos_3_Glosa
				recargosDescuentos += descReca.valueOf("TpoValor") + ";"; // pos_4_Tipo
																			// de
																			// Valor
				recargosDescuentos += descReca.valueOf("ValorDR") + ";"; // pos_5_Valor
				recargosDescuentos += descReca.valueOf("IndExeDR") + ";"; // pos_6_Indicador
																			// de
																			// facturaciï¿½n/
																			// exenciï¿½n
				recargosDescuentos += "\n";
			}

			String referencias = "";
                        @SuppressWarnings("unchecked")
			List<Node> refe = XMLdom.selectNodes("//Referencia");
                        for (Node descReca : refe) {
			referencias += "D;";
			bean.setCodigoEmotions( descReca.valueOf("RazonRef"));
			referencias += descReca.valueOf("NroLinRef")+";"; // pos_1_Nï¿½ de Lï¿½nea 
			referencias += descReca.valueOf("TpoDocRef") + ";"; // pos_2_Tipo
															// Documento de
															// referencia
			referencias += ";"; // pos_3_Indicador
															// de Referencia
															// Global
                        
                        if (descReca.valueOf("FolioRef").contains("NV/")){
                            referencias += descReca.valueOf("FolioRef").replace("NV/", "") + ";";
                        } else if (descReca.valueOf("FolioRef").contains("SRV-PDL-")){
                            referencias += descReca.valueOf("FolioRef").replace("SRV-PDL-", "") + ";";
                        }else if (descReca.valueOf("FolioRef").contains("NV-")){
                            referencias += descReca.valueOf("FolioRef").replace("NV-", "") + ";";
                        }else
			referencias += descReca.valueOf("FolioRef") + ";"; // pos_4_FOLIO-
															// de referencia
			referencias += ";"; // pos_5_RUT Otro
															// contribuyente
			referencias += descReca.valueOf("FchRef") + ";"; // pos_6_FECHA de
															// la Referencia                                             
			referencias += descReca.valueOf("CodRef") + ";";// pos_7_Cï¿½digo de
															// referencia
			referencias += descReca.valueOf("RazonRef") + ";"; // pos_8_Razï¿½n
															// referencia
			referencias += "\n";
                        }

			txt = varLibre + encabezado + detalles + recargosDescuentos
					+ referencias;

		} catch (Exception e) {
			throw new Exception("ERROR al parserar XML: " + e.getMessage(), e);
		}

		bean.setTXT(txt);
	}


}
