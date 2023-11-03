
public class No {
	Registro registro;
	No proximoNo;
	
	public Registro getRegistro() {
		return registro;
	}
	
	public No getProximoNo() {
		return proximoNo;
	}
	
	public void setProximoNo(No proximoNo) {
		this.proximoNo = proximoNo;
	}
	
	public No(Registro registro) {
		this.registro = registro;
	}
}
