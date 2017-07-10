package com.tacticlogistics.integrador.files.clientes.heinz.cadenas;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.tacticlogistics.ClienteCodigoType;
import com.tacticlogistics.integrador.files.clientes.tactic.oms.salidas.MapEntidadSalidaDecorator;
import com.tacticlogistics.integrador.files.handlers.ArchivoPlanoHandler;
import com.tacticlogistics.integrador.files.handlers.decorators.CamposSplitterDecorator;
import com.tacticlogistics.integrador.files.handlers.decorators.CheckArchivoVacioDecorator;
import com.tacticlogistics.integrador.files.handlers.decorators.CheckNumeroDeColumnasDecorator;
import com.tacticlogistics.integrador.files.handlers.decorators.CheckRegistrosDuplicadosDecorator;
import com.tacticlogistics.integrador.files.handlers.decorators.CheckRestriccionesDeCamposDecorator;
import com.tacticlogistics.integrador.files.handlers.decorators.Decorator;
import com.tacticlogistics.integrador.files.handlers.decorators.IncluirCamposDecorator;
import com.tacticlogistics.integrador.files.handlers.decorators.LineasSplitterDecorator;
import com.tacticlogistics.integrador.files.handlers.decorators.MayusculasDecorator;
import com.tacticlogistics.integrador.files.handlers.decorators.NormalizarSeparadoresDeRegistroDecorator;
import com.tacticlogistics.integrador.model.oms.Salida;
import com.tacticlogistics.integrador.model.oms.SalidaRepository;

@Component
public abstract class SalidasCadenasArchivoHandler extends ArchivoPlanoHandler<Salida,Long> {
	private static final String CODIGO_TIPO_ARCHIVO = "HEINZ_SALIDAS_CADENAS";

	private static final String SUBDIRECTORIO_RELATIVO = "ORDENES\\SALIDAS\\CADENAS";

	@Autowired
	private SalidaRepository repository;

	// ----------------------------------------------------------------------------------------------------------------
	//
	// ----------------------------------------------------------------------------------------------------------------
	@Override
	protected String getClienteCodigo() {
		return ClienteCodigoType.HEINZ.toString();
	}

	@Override
	protected String getCodigoTipoArchivo() {
		return CODIGO_TIPO_ARCHIVO;
	}
	
	@Override
	protected String getDirectorioRelativo() {
		return SUBDIRECTORIO_RELATIVO;
	}
	
	@Override
	protected Pattern getFileNamePattern() {
		return PATTERN_XLS;
	}

	// ----------------------------------------------------------------------------------------------------------------
	//
	// ----------------------------------------------------------------------------------------------------------------
	@Override
	protected JpaRepository<Salida, Long> getRepository() {
		return repository;
	}

	@Override
	protected Decorator<Salida> getTransformador() {
		// @formatter:off
		return new MapEntidadSalidaDecorator(
				new CheckRegistrosDuplicadosDecorator<Salida>(
					new CheckRestriccionesDeCamposDecorator<Salida>(		
						new IncluirCamposDecorator<Salida>(
							new CamposSplitterDecorator<Salida>(
								new CheckNumeroDeColumnasDecorator<Salida>(
									new LimpiarFuncionTDecorator<Salida>(
										new CheckArchivoVacioDecorator<Salida>(
											new LineasSplitterDecorator<Salida>(
												new NormalizarSeparadoresDeRegistroDecorator<Salida>(
													new MayusculasDecorator<Salida>(
		)))))))))));
		// @formatter:on
	}
}