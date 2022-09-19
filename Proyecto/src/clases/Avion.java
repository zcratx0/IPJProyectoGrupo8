package clases;

public class Avion extends Vehiculo{
		private double longitud;
		private int cantPasajeros;
		
		//constructor super
		public Avion(int idVehiculo, String nomVehiculo, String colorVehiculo, int idDueño) {
			super(idVehiculo, nomVehiculo, colorVehiculo, idDueño);
		}

		//constructor fields
		public Avion(int idVehiculo, String nomVehiculo, String colorVehiculo, double longitud, int cantPasajeros, int idDueño) {
			super(idVehiculo, nomVehiculo, colorVehiculo,idDueño);
			this.longitud = longitud;
			this.cantPasajeros = cantPasajeros;
			
		}

		
		//get & set
		public double getLongitud() {
			return longitud;
		}

		public void setLongitud(double longitud) {
			this.longitud = longitud;
		}

		public int getCantPasajeros() {
			return cantPasajeros;
		}

		public void setCantPasajeros(int cantPasajeros) {
			this.cantPasajeros = cantPasajeros;
		}
		
		
		//toString
		@Override
		public String toString() {
			return "Avion [longitud=" + longitud + ", cantPasajeros=" + cantPasajeros + "]";
		}
}
