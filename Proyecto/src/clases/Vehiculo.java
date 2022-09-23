package clases;

public class Vehiculo {
		private int idVehiculo;
		private String nombreVehiculo;
		private String colorVehiculo;
		private int idDueño;
		//constructor 
		public Vehiculo(int idVehiculo, String nomVehiculo, String colorVehiculo, int idDueño) {
			super();
			this.idVehiculo = idVehiculo;
			this.nombreVehiculo = nomVehiculo;
			this.colorVehiculo = colorVehiculo;
			this.idDueño = idDueño;
		}

		
		//get & set
		public int getIdVehiculo() {
			return idVehiculo;
		}

		public void setIdVehiculo(int idVehiculo) {
			this.idVehiculo = idVehiculo;
		}

		public String getNombreVehiculo() {
			return nombreVehiculo;
		}

		public void setNombreVehiculo(String nomVehiculo) {
			this.nombreVehiculo = nomVehiculo;
		}

		public String getColorVehiculo() {
			return colorVehiculo;
		}

		public void setColorVehiculo(String colorVehiculo) {
			this.colorVehiculo = colorVehiculo;
		}

		//toString
		@Override
		public String toString() {
			return "Vehiculo [idVehiculo=" + idVehiculo + ", nomVehiculo=" + nombreVehiculo + ", colorVehiculo="
					+ colorVehiculo + "]";
		}


		public int getIdDueño() {
			return idDueño;
		}


		public void setIdDueño(int idDueño) {
			this.idDueño = idDueño;
		}	
}
