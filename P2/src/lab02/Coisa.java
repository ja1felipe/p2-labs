package lab02;

public class Coisa {

	public static void main(String[] args) {
		Saude saude = new Saude();

        System.out.println(saude.getStatusGeral());

        saude.defineSaudeMental("boa");

        saude.defineSaudeFisica("boa");

        System.out.println(saude.getStatusGeral());

        saude.defineSaudeMental("fraca");

        saude.defineSaudeFisica("fraca");

        System.out.println(saude.getStatusGeral());

        saude.defineSaudeMental("boa");

        saude.defineSaudeFisica("fraca");

        System.out.println(saude.getStatusGeral());

	}

}
