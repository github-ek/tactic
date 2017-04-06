package com.tacticlogistics.integrador.etl.model.oms;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(catalog = "oms", name = "salidas")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Salida extends EtlEntidadBase {

	private static final long serialVersionUID = 1L;

	public static final String CLIENTE_CODIGO = "CLIENTE_CODIGO";
	public static final String SERVICIO_CODIGO = "SERVICIO_CODIGO";
	public static final String NUMERO_ORDEN = "NUMERO_ORDEN";

	public static final String CANAL_CODIGO = "CANAL_CODIGO";
	public static final String TERCERO_IDENTIFICACION = "TERCERO_IDENTIFICACION";
	public static final String TERCERO_SUCURSAL = "TERCERO_SUCURSAL";
	public static final String TERCERO_NOMBRE = "TERCERO_NOMBRE";

	public static final String CIUDAD_CODIGO = "CIUDAD_CODIGO";
	public static final String DIRECCION = "DIRECCION";
	public static final String PUNTO_CODIGO = "PUNTO_CODIGO";
	public static final String PUNTO_NOMBRE = "PUNTO_NOMBRE";

	public static final String FEMI = "FEMI";
	public static final String FEMA = "FEMA";
	public static final String HOMI = "HOMI";
	public static final String HOMA = "HOMA";

	public static final String CONTACTO_NOMBRES = "CONTACTO_NOMBRES";
	public static final String CONTACTO_TELEFONOS = "CONTACTO_TELEFONOS";
	public static final String CONTACTO_EMAIL = "CONTACTO_EMAIL";
	public static final String NOTAS = "NOTAS";

	public static final String REQUIERE_TRANSPORTE = "REQUIERE_TRANSPORTE";
	public static final String AUTORIZADO_IDENTIFICACION = "AUTORIZADO_IDENTIFICACION";
	public static final String AUTORIZADO_NOMBRES = "AUTORIZADO_NOMBRES";

	public static final String REQUIERE_RECAUDO = "REQUIERE_RECAUDO";
	public static final String VALOR_RECAUDAR = "VALOR_RECAUDAR";

	public static final String REQUIERE_AGENDAMIENTO = "REQUIERE_AGENDAMIENTO";

	public static final String PRODUCTO_CODIGO = "PRODUCTO_CODIGO";
	public static final String PRODUCTO_CODIGO_ALTERNO = "PRODUCTO_CODIGO_ALTERNO";
	public static final String PRODUCTO_NOMBRE = "PRODUCTO_NOMBRE";
	public static final String CANTIDAD = "CANTIDAD";
	public static final String BODEGA_ORIGEN_CODIGO = "BODEGA_ORIGEN_CODIGO";
	public static final String BODEGA_DESTINO_CODIGO = "BODEGA_DESTINO_CODIGO";
	public static final String VALOR_UNITARIO_DECLARADO = "VALOR_UNITARIO_DECLARADO";
	public static final String VALOR_VENTA_LINEA = "VALOR_VENTA_LINEA";
	public static final String LOTE = "LOTE";
	public static final String PREDISTRIBUCION_CROSSDOCK = "PREDISTRIBUCION_CROSSDOCK";
	public static final String PREDISTRIBUCION_EVENTO = "PREDISTRIBUCION_EVENTO";

	public static final String PREFIJO_ORDEN = "PREFIJO_ORDEN";
	public static final String NUMERO_ORDEN_SIN_PREFIJO = "NUMERO_ORDEN_SIN_PREFIJO";
	public static final String FECHA_ORDEN = "FECHA_ORDEN";

	public static final String DOCUMENTO_CLIENTE = "DOCUMENTO_CLIENTE";
	public static final String FECHA_DOCUMENTO_CLIENTE = "FECHA_DOCUMENTO_CLIENTE";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_salida")
	private Long id;

	@Column(length = 20, nullable = false)
	@NotEmpty
	private String clienteCodigo;

	@Column(length = 50, nullable = false)
	@NotEmpty
	private String servicioCodigo;

	@Column(length = 20, nullable = false)
	@NotEmpty
	private String numeroOrden;

	@Column(length = 50, nullable = false)
	@NotNull
	private String canalCodigo;

	@Column(length = 20, nullable = false)
	@NotEmpty
	private String terceroIdentificacion;

	@Column(length = 50, nullable = false)
	@NotNull
	private String terceroSucursal;

	@Column(length = 100, nullable = false)
	@NotNull
	private String terceroNombre;

	@Column(length = 50, nullable = false)
	@NotNull
	private String ciudadCodigo;

	@Column(length = 150, nullable = false)
	@NotNull
	private String direccion;

	@Column(length = 50, nullable = false)
	@NotNull
	private String puntoCodigo;

	@Column(length = 100, nullable = false)
	@NotNull
	private String puntoNombre;

	private LocalDate femi;
	private LocalDate fema;
	private LocalTime homi;
	private LocalTime homa;

	@Column(length = 100, nullable = false)
	@NotNull
	private String contactoNombres;

	@Column(length = 50, nullable = false)
	@NotNull
	private String contactoTelefonos;

	@Column(length = 100, nullable = false)
	@NotNull
	private String contactoEmail;

	@Column(length = 200, nullable = false)
	@NotNull
	private String notas;

	@Column(length = 1, nullable = false)
	@NotEmpty
	private String requiereTransporte;

	@Column(length = 20, nullable = false)
	@NotNull
	private String autorizadoIdentificacion;

	@Column(length = 100, nullable = false)
	@NotNull
	private String autorizadoNombres;

	@Column(length = 1, nullable = false)
	@NotNull
	private String requiereRecaudo;
	private Integer valorRecaudar;

	@Column(length = 1, nullable = false)
	@NotNull
	private String requiereAgendamiento;

	@Column(length = 50, nullable = false)
	@NotNull
	private String productoCodigo;

	@Column(length = 50, nullable = false)
	@NotNull
	private String productoCodigoAlterno;

	@Column(length = 200, nullable = false)
	@NotNull
	private String productoNombre;

	private int cantidad;

	@Column(length = 50, nullable = false)
	@NotEmpty
	private String bodegaOrigenCodigo;

	@Column(length = 50, nullable = false)
	@NotNull
	private String bodegaDestinoCodigo;

	private BigDecimal valorUnitarioDeclarado;
	private BigDecimal valorVentaLinea;

	@Column(length = 30, nullable = false)
	@NotNull
	private String lote;

	@Column(length = 200, nullable = false)
	@NotNull
	private String predistribucionCrossdock;

	@Column(length = 200, nullable = false)
	@NotNull
	private String predistribucionEvento;

	@Column(length = 20, nullable = false)
	@NotNull
	private String prefijoOrden;

	@Column(length = 20, nullable = false)
	@NotNull
	private String numeroOrdenSinPrefijo;

	private LocalDate fechaOrden;

	@Column(length = 20, nullable = false)
	@NotNull
	private String documentoCliente;
	private LocalDate fechaDocumentoCliente;

	@Builder
	public Salida(Long id, String clienteCodigo, String servicioCodigo, String numeroOrden, String canalCodigo,
			String terceroIdentificacion, String terceroSucursal, String terceroNombre, String ciudadCodigo,
			String direccion, String puntoCodigo, String puntoNombre, LocalDate femi, LocalDate fema, LocalTime homi,
			LocalTime homa, String contactoNombres, String contactoTelefonos, String contactoEmail, String notas,
			String requiereTransporte, String autorizadoIdentificacion, String autorizadoNombres,
			String requiereRecaudo, Integer valorRecaudar, String requiereAgendamiento, String productoCodigo,
			String productoCodigoAlterno, String productoNombre, int cantidad, String bodegaOrigenCodigo,
			String bodegaDestinoCodigo, BigDecimal valorUnitarioDeclarado, BigDecimal valorVentaLinea, String lote,
			String predistribucionCrossdock, String predistribucionEvento, String prefijoOrden,
			String numeroOrdenSinPrefijo, LocalDate fechaOrden, String documentoCliente,
			LocalDate fechaDocumentoCliente, Long idArchivo, String linea, LocalDateTime fechaCreacion,
			String usuarioCreacion) {
		super(idArchivo, linea, fechaCreacion, usuarioCreacion);
		this.id = id;
		this.clienteCodigo = clienteCodigo;
		this.servicioCodigo = servicioCodigo;
		this.numeroOrden = numeroOrden;
		this.canalCodigo = canalCodigo;
		this.terceroIdentificacion = terceroIdentificacion;
		this.terceroSucursal = terceroSucursal;
		this.terceroNombre = terceroNombre;
		this.ciudadCodigo = ciudadCodigo;
		this.direccion = direccion;
		this.puntoCodigo = puntoCodigo;
		this.puntoNombre = puntoNombre;
		this.femi = femi;
		this.fema = fema;
		this.homi = homi;
		this.homa = homa;
		this.contactoNombres = contactoNombres;
		this.contactoTelefonos = contactoTelefonos;
		this.contactoEmail = contactoEmail;
		this.notas = notas;
		this.requiereTransporte = requiereTransporte;
		this.autorizadoIdentificacion = autorizadoIdentificacion;
		this.autorizadoNombres = autorizadoNombres;
		this.requiereRecaudo = requiereRecaudo;
		this.valorRecaudar = valorRecaudar;
		this.requiereAgendamiento = requiereAgendamiento;
		this.productoCodigo = productoCodigo;
		this.productoCodigoAlterno = productoCodigoAlterno;
		this.productoNombre = productoNombre;
		this.cantidad = cantidad;
		this.bodegaOrigenCodigo = bodegaOrigenCodigo;
		this.bodegaDestinoCodigo = bodegaDestinoCodigo;
		this.valorUnitarioDeclarado = valorUnitarioDeclarado;
		this.valorVentaLinea = valorVentaLinea;
		this.lote = lote;
		this.predistribucionCrossdock = predistribucionCrossdock;
		this.predistribucionEvento = predistribucionEvento;
		this.prefijoOrden = prefijoOrden;
		this.numeroOrdenSinPrefijo = numeroOrdenSinPrefijo;
		this.fechaOrden = fechaOrden;
		this.documentoCliente = documentoCliente;
		this.fechaDocumentoCliente = fechaDocumentoCliente;
	}

}
