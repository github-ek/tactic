package com.tacticlogistics.integrador.services;

import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.tacticlogistics.integrador.dto.ErrorArchivoDTO;
import com.tacticlogistics.integrador.dto.ArchivoDTO;
import com.tacticlogistics.integrador.model.etl.archivo.Archivo;
import com.tacticlogistics.integrador.model.etl.archivo.ArchivoRepository;
import com.tacticlogistics.integrador.model.etl.tipoarchivo.TipoArchivo;

import lombok.val;

@Service
public class ArchivosService {

	@Autowired
	private ArchivoRepository repository;

	@Transactional
	public <T> ArchivoDTO<T> crearArchivo(Path pathArchivo, TipoArchivo tipoArchivo) {
		Assert.notNull(pathArchivo);
		Assert.notNull(tipoArchivo);

		Archivo archivo = Archivo.crear(tipoArchivo.getId(), pathArchivo);

		archivo = repository.save(archivo);

		// @formatter:off
		val result = ArchivoDTO.<T>builder()
			.pathArchivo(pathArchivo)
			.tipoArchivo(tipoArchivo)
			.archivo(archivo)
			.build();
		// @formatter:on

		return result;
	}

	@Transactional
	public Archivo marcarValidoPorEstructura(Archivo archivo) {
		Assert.notNull(archivo);
		archivo.marcarValidoPorEstructura();

		val result = repository.save(archivo);
		return result;
	}

	@Transactional
	public Archivo marcarNoValidoPorEstructura(Archivo archivo, List<ErrorArchivoDTO> errores) {
		Assert.notNull(archivo);
		archivo.marcarNoValidoPorEstructura(errores);

		val result = repository.save(archivo);
		return result;
	}

	@Transactional
	public Archivo marcarHomologado(Archivo archivo, List<ErrorArchivoDTO> errores) {
		Assert.notNull(archivo);
		archivo.marcarHomologado(errores);

		val result = repository.save(archivo);
		return result;
	}

	@Transactional
	public Archivo marcarEnriquecido(Archivo archivo, List<ErrorArchivoDTO> errores) {
		Assert.notNull(archivo);
		archivo.marcarEnriquecido(errores);

		val result = repository.save(archivo);
		return result;
	}

	@Transactional
	public Archivo marcarValidadoPorNegocio(Archivo archivo, List<ErrorArchivoDTO> errores) {
		Assert.notNull(archivo);
		archivo.marcarValidadoPorNegocio(errores);

		val result = repository.save(archivo);
		return result;
	}

	@Transactional
	public Archivo marcarProcesado(Archivo archivo, List<ErrorArchivoDTO> errores) {
		Assert.notNull(archivo);
		archivo.marcarProcesado(errores);

		val result = repository.save(archivo);
		return result;
	}

	@Transactional
	public Archivo marcarNoValidoPorExcepcion(Archivo archivo, Throwable e) {
		Assert.notNull(archivo);
		archivo.marcarNoValidoPorExcepcion(e);

		val result = repository.save(archivo);
		return result;
	}
}