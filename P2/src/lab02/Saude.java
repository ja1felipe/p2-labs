package lab02;

public class Saude {
	private String mental = "boa";
	private String fisica = "boa";
	
	public Saude() {
		this.mental = mental;
		this.fisica = fisica;
	}
	public void defineSaudeMental(String mente) {
		this.mental = mente;
	}
	public void defineSaudeFisica(String fisic) {
		this.fisica = fisic;
	}
	public String getStatusGeral() {
		if(this.mental.equals("boa")&& this.fisica.equals("boa")) {
			return "boa";
		}else if (this.mental.equals("fraca") && this.fisica.equals("fraca")) {
			return "fraca";
		}else {
			return "ok";
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
