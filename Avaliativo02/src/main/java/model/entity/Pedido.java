package model.entity;

public class Pedido {
	private int idpedidos;
    private String nomeCliente;
    private String enderecoEntrega;
    private double valor;
    private String descricao;
    
    public Pedido(int idpedidos, String nomeCliente, String enderecoEntrega, double valor, String descricao) {
    	setIdpedidos(idpedidos);
    	setNomeCliente(nomeCliente);
    	setEnderecoEntrega(enderecoEntrega);
    	setValor(valor);
    	setDescricao(descricao);
    }
    
    public int getIdpedidos() {
		return idpedidos;
	}
	public void setIdpedidos(int idpedidos) {
		this.idpedidos = idpedidos;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}
	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
