
public class No {
	Integer valor;
	No proximoNo;
	
	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public No getProximoNo() {
		return proximoNo;
	}

	public void setProximoNo(No proximoNo) {
		this.proximoNo = proximoNo;
	}

	public No(int valor) {
		this.valor = valor;
	}

}
