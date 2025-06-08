package controller;

import java.util.ArrayList;
import java.util.Random;

import entity.Usuario;

public class ControladorUsuarios {
	
	public static double calcularPromedioEdad(ArrayList<Usuario> usuarios) {
		int suma = 0;
		for (Usuario u : usuarios) {
			suma += u.getEdad();
		}
		return usuarios.size() > 0 ? (double) suma / usuarios.size() : 0;
	}

	public static Usuario buscarUsuario(ArrayList<Usuario> usuarios, String nombre) {
		for (Usuario u : usuarios) {
			if (u.getNombre().equalsIgnoreCase(nombre)) {
				return u;
			}
		}
		return null;
	}

	public static Usuario buscarUsuario(ArrayList<Usuario> usuarios, String ciudad, boolean porCiudad) {
		for (Usuario u : usuarios) {
			if (u.getCiudad().equalsIgnoreCase(ciudad)) {
				return u;
			}
		}
		return null;
	}

	public static Usuario elegirUsuarioDestacado(ArrayList<Usuario> usuarios) {
		if (usuarios.isEmpty())
			return null;
		Random random = new Random();
		int indice = random.nextInt(usuarios.size());
		return usuarios.get(indice);
	}

	public static class MensajeDecorativo {
		public static void mostrarMensaje(String mensaje) {
			System.out.println("***************");
			System.out.println(mensaje);
			System.out.println("***************");
		}
	}
}
