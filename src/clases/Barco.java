package clases;

public class Barco extends Vehiculo{
		private double eslora;
		private double manga;
		
		
		//constructor super 
		public Barco(int idVehiculo, String nomVehiculo, String colorVehiculo, int idDueño) {
			super(idVehiculo, nomVehiculo, colorVehiculo, idDueño);
		}

		//constructor fields
		public Barco(int idVehiculo, String nomVehiculo, String colorVehiculo, double eslora, double manga, int idDueño) {
			super(idVehiculo, nomVehiculo, colorVehiculo,idDueño);
			this.eslora = eslora;
			this.manga = manga;
		}

		
		//get & set
		public double getEslora() {
			return eslora;
		}

		public void setEslora(double eslora) {
			this.eslora = eslora;
		}

		public double getManga() {
			return manga;
		}

		public void setManga(double manga) {
			this.manga = manga;
		}

		//toString
		@Override
		public String toString() {
			return "Barco [eslora=" + eslora + ", manga=" + manga + "]";
		}	
}
