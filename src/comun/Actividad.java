package comun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import comun.interfaces.Destino;


public class Actividad {
	
	private String tipo;
	private Destino destino;
	private Date fechaYHoraDate;
	private Collection<Plaza> numeroPlazas;
	private int limitePlazas = 0;
	
	public String getTipo() {
		return tipo;
	}

	public Destino getDestino() {
		return destino;
	}
	
	public Date getFechaYHoraDate() {
		return fechaYHoraDate;
	}
	public void setFechaYHoraDate(Date fechaYHoraDate) {
		this.fechaYHoraDate = fechaYHoraDate;
	}
	
	public int getNumeroPlazas() {
		return this.numeroPlazas.size();
	}
	
	public int getLimitePlazas() {
		return limitePlazas;
	}
	
	public void setLimitePlazas(int limitePlazas) {
		this.limitePlazas = limitePlazas;
	}

	public Actividad(String tipo, Destino destino, Date fechaYHoraDate, int limitePlazas) {
		
		this.tipo = tipo;
		this.destino = destino;
		this.fechaYHoraDate = fechaYHoraDate;
		this.numeroPlazas = new ArrayList<>();
		while(numeroPlazas.size() <= limitePlazas) {
			numeroPlazas.add(new Plaza(this , null, " "));
		}
	}
	
	
	
	
	

}
